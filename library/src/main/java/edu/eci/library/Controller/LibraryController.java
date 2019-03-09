package edu.eci.library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.library.Model.Libreria;
import edu.eci.library.Model.Libro;
import edu.eci.library.Persistence.LibreriaException;
import edu.eci.library.Service.LibraryServices;


@RestController
@RequestMapping(value = "v1/librerias")

public class LibraryController {
	
	@Autowired
	LibraryServices services;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> ManejadorGetLibrerias(){
	    try {
	    	
	        return new ResponseEntity<>(services.getAllLibreria(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	    }
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> ManejadorGetLibreriasById(@PathVariable("id") int id){
	    try {
	    	
	        return new ResponseEntity<>(services.getLibreriaById(id),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	    }
	}
	
	@RequestMapping(value="{id}/libros",method = RequestMethod.GET)
	public ResponseEntity<?> ManejadorGetLibros(@PathVariable int id){
	    try {
	    	
	        return new ResponseEntity<>(services.getAllLibros(id),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@RequestMapping(method = RequestMethod.POST)	
	public ResponseEntity<?> ManejadorcrearLibreria(@RequestBody Libreria libreria){
	    try {
	    	services.addLibreria(libreria);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
	    }
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.POST)	
	public ResponseEntity<?> ManejadorcrearLibro(@RequestBody Libro libro, @PathVariable("id") int id ){
	    try {
	    	services.addLibro(id, libro);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
	    }
	}
	
	@RequestMapping(value="{id}/{email}",method = RequestMethod.POST)	
	public @ResponseBody ResponseEntity<?> ManejadorCrearLibroEmail(@PathVariable("id") int id,@PathVariable("email") String email, Libro libro  ){
	    try {
	    	services.addLibroConEmail(id, libro, email);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
	    }
	}
	
    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteLibreriaById(@PathVariable("id") int id) {
    	try {
    		if(services.getLibreriaById(id)==null)return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
    		services.deleteLibreriaById(id);
	        return new ResponseEntity<>(HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
	    }
    }

}
