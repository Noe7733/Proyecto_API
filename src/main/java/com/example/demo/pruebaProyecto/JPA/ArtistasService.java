package com.example.demo.pruebaProyecto.JPA;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.example.demo.pruebaProyecto.Entity.Artistas;
import com.example.demo.pruebaProyecto.Service.IArtistasService;
import com.example.demo.pruebaProyecto.Repository.ArtistasRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Resource.ResourceNotFoudException;
import com.example.demo.pruebaProyecto.Entity.Artistas;
@Service
public class ArtistasService implements IArtistasService{
	@Autowired
	private ArtistasRepo ArtsRepo;
	//consultar un artista
	@Override
	public ResponseEntity<Artistas> consultarUnArtista(int id_art) {
		// TODO Auto-generated method stub
		Artistas objA = ArtsRepo.findById(id_art).orElseThrow(() -> new ResourceNotFoudException("No existe el artista con el ID: "+ id_art));
		return ResponseEntity.ok(objA);
	}
	//consultar todos los artistas
	@Override
	public List<Artistas> obtenerTodos() {
		// TODO Auto-generated method stub
		List<Artistas> result = ArtsRepo.findAll();
		if(result.isEmpty()) throw new ResourceNotFoudException("No hay artistas registrados, proceda a registrarlos");
		
		return ArtsRepo.findAll();
	}
	//eliminar artista
	@Override
	public ResponseEntity<Map<String, String>> eliminarArtista(int id_art) {
		
		//esta parte es la que se hace si hubo error
		Map<String, String> errorResponse = new HashMap<>();
		//imprime el mansaje de que el artista no fue encontrado
		errorResponse.put("message", "Este artista no existe en la base de datos");
		//imprime el status de Http
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		//esta parte es la que se hace si no hubo error
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "El artista fue eliminado con exito!");
		okResponse.put("status", HttpStatus.OK.toString());
		
		return ArtsRepo.findById(id_art).map(p -> { 
			ArtsRepo.deleteById(id_art);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
				.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}
	
	//insertar artista
	@Override
	public ResponseEntity<Map<String, String>> insertarArtista(Artistas insArtis) {
		// TODO Auto-generated method stub
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "El artista fue agregado con exito a la base de datos");
		okResponse.put("status", HttpStatus.CREATED.toString());
		ArtsRepo.save(insArtis);
		return new ResponseEntity<>(okResponse,HttpStatus.CREATED);
	}
	
	//actualizar un artista
	@Override
	public ResponseEntity<Map<String, String>> actualizarArtista(Artistas obj, int id_art) {
		// TODO Auto-generated method stub
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Los datos del artista han sido actualizados coon exito");
		okResponse.put("status", HttpStatus.OK.toString());
		
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "No existe un artista con el ID introducido");
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		
		return ArtsRepo.findById(id_art).map(p -> {
			obj.setIdArt(id_art);
			ArtsRepo.save(obj);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}
	
}
