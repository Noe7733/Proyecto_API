package com.example.demo.pruebaProyecto.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.pruebaProyecto.Entity.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
		
}
