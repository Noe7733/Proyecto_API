package com.example.demo.pruebaProyecto.Entity;

import java.util.*;

//import javax.persistence.ManyToOne;
import javax.persistence.*;

@Entity
@Table(name = "tb_playlist")

public class Playlist {
	
	//columnas o atributos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_play")
	private int idPlay;
	
	
	@Column(name = "nombre_play")
	private int nombrePlay;

	@Column(name = "fecha_crea")
	private Date fechaCreada;
	
	@OneToMany(mappedBy = "plays")
	private List<Usuario> usuario;
	
	//cardinalidad de la base de datos, de las tablas cancion-playlist
	@ManyToMany(mappedBy = "trackss")
	private List<Cancion> playss;
	
	public Playlist() {
		super();
	}

	public Playlist(int nombrePlay, Date fechaCreada) {
		super();
		this.nombrePlay = nombrePlay;
		this.fechaCreada = fechaCreada;
	}

	//getters y setters
	
	public int getIdPlay() {
		return idPlay;
	}

	public void setIdPlay(int idPlay) {
		this.idPlay = idPlay;
	}


	public int getNombrePlay() {
		return nombrePlay;
	}

	public void setNombrePlay(int nombrePlay) {
		this.nombrePlay = nombrePlay;
	}

	public Date getFechaCreada() {
		return fechaCreada;
	}

	public void setFechaCreada(Date fechaCreada) {
		this.fechaCreada = fechaCreada;
	}
	
}
