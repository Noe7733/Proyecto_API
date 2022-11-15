package com.example.demo.pruebaProyecto.JPA;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.example.demo.pruebaProyecto.Entity.Artistas;
import com.example.demo.pruebaProyecto.Service.IArtistasService;
import com.example.demo.pruebaProyecto.Repository.ArtistasRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Resource.*;
import com.example.demo.pruebaProyecto.Entity.Artistas;
@Service
public class ArtistasService implements IArtistasService{
	@Autowired
	private ArtistasRepo ArtsRepo;
	
	@Override
	public ResponseEntity<Artistas> consultarUnArtista(int id_art) {
		// TODO Auto-generated method stub
		Artistas objA = ArtsRepo.findById(id_art).orElseThrow(() -> new ResourceNotFoudException("No existe el artista con el ID: "+ id_art));
		return ResponseEntity.ok(objA);
	}

	@Override
	public List<Artistas> obtenerTodos() {
		// TODO Auto-generated method stub
		List<Artistas> result = ArtsRepo.findAll();
		if(result.isEmpty()) throw new ResourceNotFoudException("No hay artistas registrados, proceda a registrarlos");
		
		return ArtsRepo.findAll();
	}
}
