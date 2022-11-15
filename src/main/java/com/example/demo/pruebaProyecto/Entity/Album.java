package com.example.demo.pruebaProyecto.Entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_album")

public class Album {

	//columnas o atributos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alb")
	private int idAlb;
	
	@Column(name = "nombre_alb")
	private String nombreAlb;
	
	@Column(name = "anio_lanza")
	private String anioLanza;
	
	@Column(name = "tipo")
	private String tipoAlb;
	
	@Column(name = "num_canciones")
	private int numCanciones;
	
	@Column(name = "productora")
	private String productoraAlb;
	
	@Column(name = "url_imagenAlb")
	private String urlImagenAlb;
	
	//cardinalidad de la bd de uno a muchos de las tablas Album-Artistas
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_art", referencedColumnName = "id_art")
	private Artistas artis;
	
	//cardinalidad de la bd de muchos a muchos de las tablas Album-cancion
	@JoinTable(
	        name = "album_cancion",
	        joinColumns = @JoinColumn(name = "AlbumL", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="CancionF", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Cancion> tracks;
	

	//constructores de la clase
	
	public Album() {
		super();
	}



	public Album(String nombreAlb, String anioLanza, String tipoAlb, int numCanciones, String productoraAlb, String urlImagenAlb, Artistas artis) {
		super();
		this.nombreAlb = nombreAlb;
		this.anioLanza = anioLanza;
		this.tipoAlb = tipoAlb;
		this.numCanciones = numCanciones;
		this.productoraAlb = productoraAlb;
		this.urlImagenAlb = urlImagenAlb;
		this.artis = artis;
	}



	//getters y setters de la clase

	public int getIdAlb() {
		return idAlb;
	}

	public void setIdAlb(int idAlb) {
		this.idAlb = idAlb;
	}



	public String getNombreAlb() {
		return nombreAlb;
	}

	public void setNombreAlb(String nombreAlb) {
		this.nombreAlb = nombreAlb;
	}

	public String getAnioLanza() {
		return anioLanza;
	}

	public void setAnioLanza(String anioLanza) {
		this.anioLanza = anioLanza;
	}

	public String getTipoAlb() {
		return tipoAlb;
	}

	public void setTipoAlb(String tipoAlb) {
		this.tipoAlb = tipoAlb;
	}

	public int getNumCanciones() {
		return numCanciones;
	}

	public void setNumCanciones(int numCanciones) {
		this.numCanciones = numCanciones;
	}

	public String getProductoraAlb() {
		return productoraAlb;
	}

	public void setProductoraAlb(String productoraAlb) {
		this.productoraAlb = productoraAlb;
	}

	public String getUrlImagenAlb() {
		return urlImagenAlb;
	}

	public void setUrlImagenAlb(String urlImagenAlb) {
		this.urlImagenAlb = urlImagenAlb;
	}
	
}
