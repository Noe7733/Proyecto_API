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
	private String nombrePlay;

	@Column(name = "fecha_crea")
	private String fechaCreada;
	

	
	//cardinalidad de la bd
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuario usu;
	
	//cardinalidad de la base de datos, de las tablas cancion-playlist
	@ManyToMany(mappedBy = "trackss")
	private List<Cancion> playss;
	
	public Playlist() {
		super();
	}

	public Playlist(String nombrePlay, String fechaCreada, Usuario usu, List<Cancion> playss) {
		super();
		this.nombrePlay = nombrePlay;
		this.fechaCreada = fechaCreada;
		this.usu = usu;
		this.playss = playss;
	}

	//getters y setters
	
	public int getIdPlay() {
		return idPlay;
	}

	public void setIdPlay(int idPlay) {
		this.idPlay = idPlay;
	}

	public String getNombrePlay() {
		return nombrePlay;
	}

	public void setNombrePlay(String nombrePlay) {
		this.nombrePlay = nombrePlay;
	}

	public String getFechaCreada() {
		return fechaCreada;
	}

	public void setFechaCreada(String fechaCreada) {
		this.fechaCreada = fechaCreada;
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public List<Cancion> getPlayss() {
		return playss;
	}

	public void setPlayss(List<Cancion> playss) {
		this.playss = playss;
	}
	
}
