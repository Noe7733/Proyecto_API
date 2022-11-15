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
import javax.persistence.OneToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cancion")

public class Cancion {

	//columnas o atributos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cancion")
	private int idCancion;
	
	@Column(name = "nombre_cn")
	private String nombreCn;
	
	@Column(name = "duracion")
	private int duracionCn;
	
	@Column(name = "genero_musical")
	private String generoMusicalCn;
	
	@Column(name = "anio_lanzaCn")
	private int anioLanzaCn;
	
	@JoinColumn(name = "id_cn", nullable = false)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Cancion> cn;
	
	//cardinalidad de la base de datos, de las tablas cancion-album
	@ManyToMany(mappedBy = "tracks")
	private List<Album> alb;

	//cardinalidad de la bd de muchos a muchos de las tablas Album-cancion
	@JoinTable(
	        name = "cancion_playlist",
	        joinColumns = @JoinColumn(name = "cancionL", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="playlistF", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Playlist> trackss;	
	
	//constructores de la clase
	
	public Cancion() {
		super();
	}

	public Cancion(String nombreCn, int duracionCn, String generoMusicalCn, int anioLanzaCn) {
		super();
		this.nombreCn = nombreCn;
		this.duracionCn = duracionCn;
		this.generoMusicalCn = generoMusicalCn;
		this.anioLanzaCn = anioLanzaCn;
	}

	//getters y setters
	
	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	public String getNombreCn() {
		return nombreCn;
	}

	public void setNombreCn(String nombreCn) {
		this.nombreCn = nombreCn;
	}

	public int getDuracionCn() {
		return duracionCn;
	}

	public void setDuracionCn(int duracionCn) {
		this.duracionCn = duracionCn;
	}

	public String getGeneroMusicalCn() {
		return generoMusicalCn;
	}

	public void setGeneroMusicalCn(String generoMusicalCn) {
		this.generoMusicalCn = generoMusicalCn;
	}

	public int getAnioLanzaCn() {
		return anioLanzaCn;
	}

	public void setAnioLanzaCn( int anioLanzaCn) {
		this.anioLanzaCn = anioLanzaCn;
	}
	
}