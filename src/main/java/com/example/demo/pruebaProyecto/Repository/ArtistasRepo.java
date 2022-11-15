package com.example.demo.pruebaProyecto.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.pruebaProyecto.Entity.Artistas;


public interface ArtistasRepo extends JpaRepository<Artistas, Integer> {
	//selecciona un solo artista
	
	@Query ("select o from Artistas o where o.id_art like %?1")
	Artistas findById(String id_art);
}