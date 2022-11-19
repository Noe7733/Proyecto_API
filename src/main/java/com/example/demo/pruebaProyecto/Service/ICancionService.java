package com.example.demo.pruebaProyecto.Service;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.example.demo.pruebaProyecto.Entity.Cancion;
public interface ICancionService {
	//este es para obtener un artista por el id
	ResponseEntity<Cancion> consultarUnaCn (int id_cancion);
	//este es para obtener todos los artistas
	List<Cancion> obtenerTodasCn();
	//este es para eliminar un artista
	ResponseEntity<?> eliminarUnaCn(int id_cancion);
	//este es para insertar una cancion
	ResponseEntity<Map<String, String>> insertarCancion(Cancion insCn);
	//este es para actualizar un artista
	ResponseEntity<Map<String, String>>actualizarCn(Cancion obj, int id_cancion);
}
