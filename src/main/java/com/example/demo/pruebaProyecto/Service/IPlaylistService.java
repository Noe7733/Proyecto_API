package com.example.demo.pruebaProyecto.Service;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.example.demo.pruebaProyecto.Entity.Playlist;

public interface IPlaylistService {
	//este es para obtener una playlist por el id
	ResponseEntity<Playlist> consultarUnaPlay (int id_play);
	//este es para obtener todos las playlist
	List<Playlist> obtenerTodasPlay();
	//este es para eliminar una playlist
	ResponseEntity<?> eliminarUnaPlay(int id_play);
}
