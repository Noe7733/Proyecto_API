package com.example.demo.pruebaProyecto.JPA;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.example.demo.pruebaProyecto.Entity.Playlist;
import com.example.demo.pruebaProyecto.Service.IPlaylistService;
import com.example.demo.pruebaProyecto.Repository.PlaylistRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Resource.ResourceNotFoudException;

@Service

public class PlaylistService implements IPlaylistService{

	@Autowired
	private PlaylistRepo repoPlay;
	
	//para consultar una sola playlist
	@Override
	public ResponseEntity<Playlist> consultarUnaPlay(int id_play) {
		// TODO Auto-generated method stub
		Playlist play = repoPlay.findById(id_play).orElseThrow(() -> new ResourceNotFoudException("No existe la playlist con el ID ingresado!!"));
		return ResponseEntity.ok(play);
	}

	//para obtener la lista de las playlist existentes
	@Override
	public List<Playlist> obtenerTodasPlay() {
		// TODO Auto-generated method stub
		List<Playlist> result = repoPlay.findAll();
		if(result.isEmpty())
			throw new ResourceNotFoudException("La base de datos no contiene playlist, proceda a registrarlas, de favor");
		return repoPlay.findAll();
	}
	
	//para eliminar una playlist por medio del id
	@Override
	public ResponseEntity<Map<String, String>> eliminarUnaPlay(int id_play) {
		// TODO Auto-generated method stub
		//esta parte es la que se hace si hubo error
		Map<String, String> errorResponse = new HashMap<>();
		//imprime el mansaje de que el artista no fue encontrado
		errorResponse.put("message", "Esta playlist no existe en la base de datos");
		//imprime el status de Http
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		//esta parte es la que se hace si no hubo error
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "La playlist fue eliminada con exito!");
		okResponse.put("status", HttpStatus.OK.toString());
		
		return repoPlay.findById(id_play).map(p -> {
			repoPlay.deleteById(id_play);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}

}
