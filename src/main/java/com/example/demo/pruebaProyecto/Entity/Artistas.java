package com.example.demo.pruebaProyecto.Entity;

import java.util.List;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_artistas")
public class Artistas {

	//columnas o atributos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_art")
	private int idArt;
	
	@Column(name = "nombre_art")
	private String nombreArt;
	
	@Column(name = "genero_musical")
	private String generoMusical;
	
	@Column(name = "edad")
	private int edadA;
	
	@Column(name = "popularidad")
	private String popularidadA;
	
	@Column(name= "url_facebook")
	private String urlFabeookA;
	
	@Column(name= "url_imagen")
	private String urlImagenA;
	
	@OneToMany(mappedBy = "artis")
	private List<Album> album;
	
	//constructores de la clase
	
	public Artistas() {
		super();
	}

	public Artistas(String nombreArt, String generoMusical, int edadA, String popularidadA, String urlFabeookA,
			String urlImagenA, List<Album> album) {
		super();
		this.nombreArt = nombreArt;
		this.generoMusical = generoMusical;
		this.edadA = edadA;
		this.popularidadA = popularidadA;
		this.urlFabeookA = urlFabeookA;
		this.urlImagenA = urlImagenA;
		this.album = album;
	}

	public int getIdArt() {
		return idArt;
	}

	public void setIdArt(int idArt) {
		this.idArt = idArt;
	}

	public String getNombreArt() {
		return nombreArt;
	}

	public void setNombreArt(String nombreArt) {
		this.nombreArt = nombreArt;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public int getEdadA() {
		return edadA;
	}

	public void setEdadA(int edadA) {
		this.edadA = edadA;
	}

	public String getPopularidadA() {
		return popularidadA;
	}

	public void setPopularidadA(String popularidadA) {
		this.popularidadA = popularidadA;
	}

	public String getUrlFabeookA() {
		return urlFabeookA;
	}

	public void setUrlFabeookA(String urlFabeookA) {
		this.urlFabeookA = urlFabeookA;
	}

	public String getUrlImagenA() {
		return urlImagenA;
	}

	public void setUrlImagenA(String urlImagenA) {
		this.urlImagenA = urlImagenA;
	}

	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}
	
	//metotos getters y setters

	
	
}