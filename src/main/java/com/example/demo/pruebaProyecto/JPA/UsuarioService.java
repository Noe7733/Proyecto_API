package com.example.demo.pruebaProyecto.JPA;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.example.demo.pruebaProyecto.Entity.Usuario;
import com.example.demo.pruebaProyecto.Service.IUsuarioService;
import com.example.demo.pruebaProyecto.Repository.UsuarioRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Resource.ResourceNotFoudException;

@Service

public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private UsuarioRepo repoUsuario;

	//para buscar un usuario por medio del id
	@Override
	public ResponseEntity<Usuario> consultarUnUsuario(int id_usuario) {
		// TODO Auto-generated method stub
		Usuario usu = repoUsuario.findById(id_usuario).orElseThrow(() -> new ResourceNotFoudException("No existe el usuario con el ID ingresado!!"));
		return ResponseEntity.ok(usu);
	}

	//para obtener la lista de todos los usuarios
	@Override
	public List<Usuario> obtenerTodosU() {
		// TODO Auto-generated method stub
		List<Usuario> result = repoUsuario.findAll();
		if(result.isEmpty())
			throw new ResourceNotFoudException("La base de datos no contiene usuarios, proceda a registrarlos, de favor");
		return repoUsuario.findAll();
	}

	//para eliminar un usuario por medio del id
	@Override
	public ResponseEntity<Map<String, String>> eliminarusuario(int id_usuario) {
		// TODO Auto-generated method stub
		
		//esta parte es la que se hace si hubo error
		Map<String, String> errorResponse = new HashMap<>();
		//imprime el mansaje de que el artista no fue encontrado
		errorResponse.put("message", "Este usuario no existe en la base de datos");
		//imprime el status de Http
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		//esta parte es la que se hace si no hubo error
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "El usuario fue eliminado con exito!");
		okResponse.put("status", HttpStatus.OK.toString());
		
		return repoUsuario.findById(id_usuario).map(p -> {
			repoUsuario.deleteById(id_usuario);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
	}

}
