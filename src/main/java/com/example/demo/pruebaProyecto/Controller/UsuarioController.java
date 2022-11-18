package com.example.demo.pruebaProyecto.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.example.demo.Resource.ResourceNotFoudException;
import com.example.demo.pruebaProyecto.Entity.Usuario;
import com.example.demo.pruebaProyecto.Service.IUsuarioService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api")

public class UsuarioController {

	@Autowired
	private IUsuarioService logNegoUsu;
	
	//para obtener una lista de todos los usuarios
	@GetMapping("/usuario")
	public List<Usuario> mostrarTodosUsuarios(){
		return logNegoUsu.obtenerTodosU();
	}
	
	//obtener un usuario en especifico
	@GetMapping("/usuario/{id_usuario}")
	public ResponseEntity<Usuario> listaUsuarios(@PathVariable("id_usuario") int id_usuario){
		return logNegoUsu.consultarUnUsuario(id_usuario);
	}
	
	//eliminar un usuario
	@DeleteMapping("usuario/{id_usuario}")
	public ResponseEntity<?> eliminarU(@PathVariable("id_usuario") int id_usuario){
		return logNegoUsu.eliminarusuario(id_usuario);
	}
	
	
}
