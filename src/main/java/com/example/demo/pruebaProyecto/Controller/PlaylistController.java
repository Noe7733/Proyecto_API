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
import com.example.demo.pruebaProyecto.Entity.Playlist;
import com.example.demo.pruebaProyecto.Service.IPlaylistService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api")
public class PlaylistController {

	@Autowired
	private IPlaylistService logNegoPlay;
	
	//para obtener todas las playlist
	@GetMapping("/playlist")
	public List<Playlist> mostrarTodasPlay(){
		return logNegoPlay.obtenerTodasPlay();
	}
	
	//obtener una sola playlist por medio del id
	@GetMapping("/playlist/{id_play}")
	public ResponseEntity<Playlist> mostrarPlaylist(@PathVariable("id_play") int id_play){
		return logNegoPlay.consultarUnaPlay(id_play);
	}
	
	//eliminar una playlist
	@DeleteMapping("playlist/{id_play}")
	public ResponseEntity<?> eliminarP(@PathVariable("id_play") int id_play){
		return logNegoPlay.eliminarUnaPlay(id_play);
	}
	
	@PostMapping("/playlist")
	public String insertarPlay(@RequestBody Playlist objPlay) {
		logNegoPlay.insertarPlay(objPlay);
		return "La playlist fue agregada con exito";
	}
	
	@PutMapping("/playlist/{id_play}")
	public String actualizarPlay(@RequestBody Playlist obj, @PathVariable("id_play") int id_play) {
		logNegoPlay.actualizarPlay(obj, id_play);
		return "Los datos de la playlist fueron actualizados";
	}
}
