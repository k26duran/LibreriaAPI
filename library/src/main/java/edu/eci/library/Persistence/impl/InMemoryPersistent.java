package edu.eci.library.Persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.library.Model.Libreria;
import edu.eci.library.Model.Libro;
import edu.eci.library.Persistence.LibreriaException;
import edu.eci.library.Persistence.LibreriaPersistence;
import edu.eci.library.Service.EmailService;

@Service("LibreriaBean")
public class InMemoryPersistent implements LibreriaPersistence{
	
	public List<Libreria> librerias;
	
	public InMemoryPersistent(){
		librerias= new ArrayList<>();
		
		List<Libro> libros1=new ArrayList<Libro>();
		libros1.add(new Libro(1, "Caperucita roja", "Charles Perrault","Es un libro interesante"));
		libros1.add(new Libro(1, "Crimen y castigo", "Fedor Dostoievski","Es un libro interesante"));
		libros1.add(new Libro(1, "100 años de Soledad", "Gabriel García Márquez","Es un libro interesante"));
		libros1.add(new Libro(1, "La casa de los espíritus", "Isabel Allende","Es un libro interesante"));
		
		List<Libro> libros2=new ArrayList<Libro>();
		libros2.add(new Libro(1, "Las almas muertas", "Nicolai Gogol","Es un libro interesante"));
		libros2.add(new Libro(1, "Preludio a la fundación", "Isaac Asimov","Es un libro interesante"));
		libros2.add(new Libro(1, "Crepúsculo", "Stephenie Meyer","Es un libro interesante"));
		libros2.add(new Libro(1, "Lo que el viento se llevó", "Margaret Mitchell","Es un libro interesante"));
		
		Libreria libreria1 = new Libreria(1, "Libreria Nacional", "Centro Comercial Santa Fe", "4788987", libros1);
		Libreria libreria2 = new Libreria(2, "Libreria Cristiana", "Cll 161 #90", "4768853", libros2);
		librerias = new ArrayList<Libreria>();
		librerias.add(libreria1);
		librerias.add(libreria2);
	}

	@Override
	public List<Libreria> getLibrerias() throws LibreriaException {
		return librerias;
	}

	@Override
	public void setLibrerias(List<Libreria> librerias) throws LibreriaException {
		this.librerias=librerias;
		
	}

	@Override
	public void addLibreria(Libreria libreria) throws LibreriaException {
		librerias.add(libreria);
		
	}

	@Override
	public List<Libreria> getAllLibrerias() throws LibreriaException {
		return librerias;
	}

	@Override
	public Libreria getLibreriaById(int id) throws LibreriaException {
		for(Libreria l: librerias) {
			if(l.getId()==id) {
				return l;}
		}
		throw new LibreriaException("La libreria no existe");
	
	}

	@Override
	public List<Libro> getAllLibros(int id) throws LibreriaException {
		Libreria l= getLibreriaById(id);
		return l.getLibros();
	}

	@Override
	public void addLibro(int id, Libro libro) throws LibreriaException {
		Libreria l= getLibreriaById(id);
		l.addLibro(libro);
	}

	@Override
	public void addLibroConEmail(int id, Libro libro, String email) throws LibreriaException {
		addLibro(id, libro);
		try{
			//un minuto
			Thread.sleep(60000);;
		}catch(InterruptedException e){
			e.printStackTrace();
			
		}
		System.out.println("Ok");
		EmailService.enviarEmail(email);
		
	}

	@Override
	public void deleteLibreria(int id) throws LibreriaException {
		List<Libreria> librerias = new ArrayList<>();
		for (Libreria l : getAllLibrerias()) {
			if (l.getId() == id) {
				if (l.getLibros().size() == 0)
					break;

			} else {
				librerias.add(l);
			}

		}
		setLibrerias(librerias);
	}
		
}
	
	
	


