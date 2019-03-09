package edu.eci.library.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import edu.eci.library.Model.Libreria;
import edu.eci.library.Model.Libro;
import edu.eci.library.Persistence.LibreriaException;
import edu.eci.library.Persistence.LibreriaPersistence;

@Service
public class LibraryServices {
	@Qualifier("LibreriaBean")
	@Autowired
	
	LibreriaPersistence library;

	public List<Libreria> getAllLibreria() throws LibreriaException {
		return library.getAllLibrerias();
	}

	public Libreria getLibreriaById(int id) throws LibreriaException {
		return library.getLibreriaById(id);
	}

	public List<Libro> getAllLibros(int Id) throws LibreriaException {
		return library.getAllLibros(Id);
	}

	public void deleteLibreriaById(int id) throws LibreriaException {
		library.deleteLibreria(id);

	}
	
	public void addLibro(int id, Libro libro) throws LibreriaException {
		library.addLibro(id, libro);
		
	}
	public void addLibroConEmail(int id,Libro libro,String email) throws LibreriaException {
		library.addLibroConEmail(id, libro, email);	
	}
	public Libro getLibro(int id, List<Libro> libros) {
		for (Libro l : libros) {
			if (l.getId() == id)
				return l;
		}
		return null;

	}
	public void addLibreria(Libreria libreria) throws LibreriaException{
		library.addLibreria(libreria);
	}

	

}