package com.example.demo.pruebaProyecto.Service;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.example.demo.pruebaProyecto.Entity.Artistas;

public interface IArtistasService {


	//este es para obtener un artista por el id
	ResponseEntity<Artistas> consultarUnArtista (int id_art);
	//este es para obtener todos los artistas
	List<Artistas> obtenerTodos();
	//este es para eliminar un artista
	ResponseEntity<?> eliminarArtista(int id_art);
	//este es para insertar un artista
	ResponseEntity<Map<String, String>> insertarArtista(Artistas insArtis );
	//este es para actualizar un artista
	ResponseEntity<Map<String, String>>actualizarArtista(Artistas obj, int id_art);
	//este es para buscar por letra
	List<Artistas> buscarXLetra(String letra);
}
