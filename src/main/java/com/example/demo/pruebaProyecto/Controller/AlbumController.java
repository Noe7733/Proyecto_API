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
import com.example.demo.pruebaProyecto.Entity.Album;
import com.example.demo.pruebaProyecto.Service.IAlbumServi;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api")

public class AlbumController {

	@Autowired
	private IAlbumServi logNegoAlb;
	
	@GetMapping("/album/{id_alb}")
	public ResponseEntity<Album> obtenerAlb(@PathVariable("id_alb") int id_alb){
		return logNegoAlb.consultarUnAlbum(id_alb);
	}
	
	@GetMapping("/albums")
	public List<Album> mostrarTodosAlbums(){
		return logNegoAlb.obtenerTodosA();
	}
	
	@DeleteMapping("/album/{id_alb}")
	public ResponseEntity<?> deleteAlb(@PathVariable("id_alb") int id_alb){
		return logNegoAlb.eliminarAlbum(id_alb);
	}
	
}
