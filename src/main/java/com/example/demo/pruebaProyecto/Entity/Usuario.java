package com.example.demo.pruebaProyecto.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")

public class Usuario {

	//columnas o atributos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "nombre_usuario")
	private String nombreUsu;
	
	@Column(name = "apellidos_usu")
	private String apellidoUsu;
	
	@Column(name = "fecha_nac")
	private String fechaNac;
	
	@Column(name = "email")
	private String emailUsu;
	
	@Column(name = "pais_usu")
	private String paisUsu;
	
	@Column(name = "password")
	private String passwordUsu;
	
	@OneToMany(mappedBy = "usu")
	private List<Playlist> plays;
	
	//constructores de la clase
	
	public Usuario() {
		super();
	}

	public Usuario(String nombreUsu, String apellidoUsu, String fechaNac, String emailUsu, String paisUsu, String passwordUsu) {
		super();
		this.nombreUsu = nombreUsu;
		this.apellidoUsu = apellidoUsu;
		this.fechaNac = fechaNac;
		this.emailUsu = emailUsu;
		this.paisUsu = paisUsu;
		this.passwordUsu = passwordUsu;
	}

	//getters y setters
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsu() {
		return nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public String getApellidoUsu() {
		return apellidoUsu;
	}

	public void setApellidoUsu(String apellidoUsu) {
		this.apellidoUsu = apellidoUsu;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getEmailUsu() {
		return emailUsu;
	}

	public void setEmailUsu(String emailUsu) {
		this.emailUsu = emailUsu;
	}

	public String getPaisUsu() {
		return paisUsu;
	}

	public void setPaisUsu(String paisUsu) {
		this.paisUsu = paisUsu;
	}

	public String getPasswordUsu() {
		return passwordUsu;
	}

	public void setPasswordUsu(String passwordUsu) {
		this.passwordUsu = passwordUsu;
	}
}
