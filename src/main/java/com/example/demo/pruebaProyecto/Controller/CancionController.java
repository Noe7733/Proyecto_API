package com.example.demo.pruebaProyecto.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.example.demo.Resource.ResourceNotFoudException;
import com.example.demo.pruebaProyecto.Entity.Cancion;
import com.example.demo.pruebaProyecto.Service.ICancionService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api")

public class CancionController {
	
	@Autowired
	private ICancionService logNegoCn;
	
	@GetMapping("/cancion/{id_cancion}")
	public ResponseEntity<Cancion> obtenerCn(@PathVariable("id_cancion") int id_cancion){
		return logNegoCn.consultarUnaCn(id_cancion);
	}
	
	@GetMapping("/cancion")
	public List<Cancion> mostrarTodasCanciones(){
		return logNegoCn.obtenerTodasCn();
	}

	@DeleteMapping("/cancion/{id_cancion}")
	public ResponseEntity<?> deleteCn(@PathVariable("id_cancion") int id_cancion){
		return logNegoCn.eliminarUnaCn(id_cancion);
	}
	
	@PostMapping("/cancion")
	public String insertarCn(@RequestBody Cancion objCn) {
		logNegoCn.insertarCancion(objCn);
		return "La cancion fue agregada con exito";
	}
	
	@PutMapping("/cancion/{id_cancion}")
	public String actualizarCan(@RequestBody Cancion obj, @PathVariable("id_cancion") int id_cancion) {
		logNegoCn.actualizarCn(obj, id_cancion);
		return "Los datos de la cancion fueron actualizados con exito";
	}
	
}
