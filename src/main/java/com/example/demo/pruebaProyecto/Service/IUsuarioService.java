package com.example.demo.pruebaProyecto.Service;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.example.demo.pruebaProyecto.Entity.Usuario;

public interface IUsuarioService {
	//este es para obtener un artista por el id
	ResponseEntity<Usuario> consultarUnUsuario (int id_usuario);
	//este es para obtener todos los artistas
	List<Usuario> obtenerTodosU();
	//este es para eliminar un artista
	ResponseEntity<?> eliminarusuario(int id_usuario);
	//este es para insertar un usuario
	ResponseEntity<Map<String, String>> insertarUsu(Usuario insUsu);
	//este es para actualiazar un usuario
	ResponseEntity<Map<String, String>> actualizarUsu(Usuario obj, int id_usuario);
}
