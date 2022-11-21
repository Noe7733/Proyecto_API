package com.example.demo.pruebaProyecto.JPA;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.example.demo.pruebaProyecto.Entity.Album;
import com.example.demo.pruebaProyecto.Service.IAlbumServi;
import com.example.demo.pruebaProyecto.Repository.AlbumRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Resource.ResourceNotFoudException;

@Service
public class AlbumService implements IAlbumServi{

	@Autowired
	private AlbumRepo repoAlb;
	
	//consultar un album por medio del id
	@Override
	public ResponseEntity<Album> consultarUnAlbum(int id_alb) {
		// TODO Auto-generated method stub
		Album objAlb = repoAlb.findById(id_alb).orElseThrow(() -> new ResourceNotFoudException("No existe el album con el ID introducido: "+id_alb));
		return ResponseEntity.ok(objAlb);
	}

	//consultar todos los album´s existentes
	@Override
	public List<Album> obtenerTodosA() {
		// TODO Auto-generated method stub
		List<Album> result = repoAlb.findAll();
		if(result.isEmpty()) throw new ResourceNotFoudException("No hay album´s registrados, proceda a registrarlos");
		return repoAlb.findAll();
	}

	//eliminar un album
	@Override
	public ResponseEntity<Map<String, String>> eliminarAlbum(int id_alb) {
		// TODO Auto-generated method stub
		//esta parte es la que se hace si hubo error
		Map<String, String> errorResponse = new HashMap<>();
		//imprime el mansaje de que el artista no fue encontrado
		errorResponse.put("message", "Este album no existe en la base de datos");
		//imprime el status de Http
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		//esta parte es la que se hace si no hubo error
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "El album fue eliminado con exito!");
		okResponse.put("status", HttpStatus.OK.toString());
		return repoAlb.findById(id_alb).map( p ->{
			repoAlb.deleteById(id_alb);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}
	
	//insertar un album
	@Override
	public ResponseEntity<Map<String, String>> insertarAlbum(Album insAlb) {
		// TODO Auto-generated method stub
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "El album fue agregado con exito");
		okResponse.put("status", HttpStatus.CREATED.toString());
		repoAlb.save(insAlb);
		return new ResponseEntity<>(okResponse, HttpStatus.CREATED);
	}

	//actualizar un album
	@Override
	public ResponseEntity<Map<String, String>> actualizarAlbum(Album obj, int id_alb) {
		// TODO Auto-generated method stub
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Los datos del album han sido actualizados coon exito");
		okResponse.put("status", HttpStatus.OK.toString());
		
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "No existe un album con el ID introducido");
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		
		return repoAlb.findById(id_alb).map( p ->{
			obj.setIdAlb(id_alb);
			repoAlb.save(obj);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
		
	}

}
