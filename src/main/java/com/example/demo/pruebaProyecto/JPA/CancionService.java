package com.example.demo.pruebaProyecto.JPA;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.example.demo.pruebaProyecto.Entity.Cancion;
import com.example.demo.pruebaProyecto.Service.ICancionService;
import com.example.demo.pruebaProyecto.Repository.CancionRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Resource.ResourceNotFoudException;

@Service
public class CancionService implements ICancionService{
	
	@Autowired
	private CancionRepo repoCn;

	//para buscar una cancion por medio del id
	@Override
	public ResponseEntity<Cancion> consultarUnaCn(int id_cancion) {
		// TODO Auto-generated method stub
		Cancion cn = repoCn.findById(id_cancion).orElseThrow(() -> new ResourceNotFoudException("No existe la cancion con el ID ingresado!!"));
		return ResponseEntity.ok(cn);
	}

	//para obstener la lista de todas las canciones existentes
	@Override
	public List<Cancion> obtenerTodasCn() {
		// TODO Auto-generated method stub
		List<Cancion> result = repoCn.findAll();
		if(result.isEmpty())
			throw new ResourceNotFoudException("La base de datos no contiene canciones, proceda a registrarlas, de favor");
		return repoCn.findAll();
	}

	//para eliminar una cancion por medio de la playlist
	@Override
	public ResponseEntity<Map<String, String>> eliminarUnaCn(int id_cancion) {
		// TODO Auto-generated method stub
		
		//esta parte es la que se hace si hubo error
		Map<String, String> errorResponse = new HashMap<>();
		//imprime el mansaje de que el artista no fue encontrado
		errorResponse.put("message", "Esta cancion no existe en la base de datos");
		//imprime el status de Http
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		//esta parte es la que se hace si no hubo error
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "La cancion fue eliminada con exito!");
		okResponse.put("status", HttpStatus.OK.toString());
		
		return repoCn.findById(id_cancion).map( p -> {
			repoCn.deleteById(id_cancion);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}

	@Override
	public ResponseEntity<Map<String, String>> insertarCancion(Cancion insCn) {
		// TODO Auto-generated method stub
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "La cancion fue agregada con exito a la base de datos");
		okResponse.put("status", HttpStatus.CREATED.toString());
		repoCn.save(insCn);
		return new ResponseEntity<>(okResponse,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Map<String, String>> actualizarCn(Cancion obj, int id_cancion) {
		// TODO Auto-generated method stub
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Los datos de la cancion han sido actualizados coon exito");
		okResponse.put("status", HttpStatus.OK.toString());
		
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "No existe la cancion con el ID introducido");
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		
		return repoCn.findById(id_cancion).map( p -> {
			obj.setIdCancion(id_cancion);
			repoCn.save(obj);
			return new ResponseEntity<>(okResponse,HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}

}
