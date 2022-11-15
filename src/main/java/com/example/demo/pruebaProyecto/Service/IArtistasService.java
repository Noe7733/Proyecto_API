package com.example.demo.pruebaProyecto.Service;
import java.util.List;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.example.demo.pruebaProyecto.Entity.Artistas;

public interface IArtistasService {

	//metodo para consultar un soo artista

	
	ResponseEntity<Artistas> consultarUnArtista (int id_art);
	List<Artistas> obtenerTodos();
}
