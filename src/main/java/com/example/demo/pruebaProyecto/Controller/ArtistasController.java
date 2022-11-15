package com.example.demo.pruebaProyecto.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.pruebaProyecto.Entity.Artistas;
import com.example.demo.pruebaProyecto.Service.IArtistasService;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET.DELETE, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api")

public class ArtistasController {
	
	@Autowired
	private IArtistasService logNegoArtis;
	
	@GetMapping("/artistas/{id_art}")
	public ResponseEntity<Artistas> obtenerArtista(@PathVariable("id_art") int id_art){
		return logNegoArtis.consultarUnArtista(id_art);
	}

}
