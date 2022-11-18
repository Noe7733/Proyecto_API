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
}
