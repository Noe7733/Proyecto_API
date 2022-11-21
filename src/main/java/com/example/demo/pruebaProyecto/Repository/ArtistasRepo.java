package com.example.demo.pruebaProyecto.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.pruebaProyecto.Entity.Artistas;


public interface ArtistasRepo extends JpaRepository<Artistas, Integer> {

	//esta es la consulta que busca a partir de la letra inicial del nombre del artista
	@Query ("select o from Artistas o where o.nombreArt like :letra%") 
	List<Artistas> findByLetra(@Param("letra") String letra);
	
}