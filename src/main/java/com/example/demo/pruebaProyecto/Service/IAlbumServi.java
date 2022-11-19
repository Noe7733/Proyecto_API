package com.example.demo.pruebaProyecto.Service;
import java.util.Map;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.example.demo.pruebaProyecto.Entity.Album;

public interface IAlbumServi {
	//este es para obtener un artista por el id
	ResponseEntity<Album> consultarUnAlbum (int id_alb);
	//este es para obtener todos los artistas
	List<Album> obtenerTodosA();
	//este es para eliminar un artista
	ResponseEntity<?> eliminarAlbum(int id_alb);
}
