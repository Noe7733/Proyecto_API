package com.example.demo.pruebaProyecto.Service;
import java.util.List;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.example.demo.pruebaProyecto.Entity.Artistas;

public interface IArtistasService {

	//metodo para consultar un soo artista

	//este es para obtener un artista por el iid
	ResponseEntity<Artistas> consultarUnArtista (int id_art);
	//este es para obtener todos los artistas
	List<Artistas> obtenerTodos();
	
}
