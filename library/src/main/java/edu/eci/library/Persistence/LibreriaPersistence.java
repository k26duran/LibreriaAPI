package edu.eci.library.Persistence;

import java.util.List;

import edu.eci.library.Model.Libreria;
import edu.eci.library.Model.Libro;

public interface LibreriaPersistence {
	
	/**
	 * 
	 * @return
	 * @throws LibreriaException
	 */
	public List<Libreria> getLibrerias() throws LibreriaException;
	/**
	 * 
	 * @param librerias
	 * @throws LibreriaException
	 */
	public void setLibrerias(List<Libreria> librerias) throws LibreriaException;
	
	/**
	 * 
	 * @param libreria
	 * @throws LibreriaException
	 */
	public void addLibreria(Libreria libreria)throws LibreriaException;
	
	/**
	 * 
	 * @return
	 * @throws LibreriaException
	 */
	public List<Libreria> getAllLibrerias() throws LibreriaException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws LibreriaException
	 */
	public Libreria getLibreriaById(int id)throws LibreriaException;
	
	/**
	 * 
	 * @param Id
	 * @return
	 * @throws LibreriaException
	 */
	public List<Libro> getAllLibros(int Id) throws LibreriaException;
	
	/**
	 * 
	 * @param id
	 * @param libro
	 * @throws LibreriaException
	 */
	public void addLibro(int id,Libro libro) throws LibreriaException;
	
	/**
	 * 
	 * @param id
	 * @param libro
	 * @param email
	 * @throws LibreriaException
	 */
	public void addLibroConEmail(int id,Libro libro,String email) throws LibreriaException;

	/**
	 * 
	 * @param id
	 * @throws LibreriaException
	 */
	public void deleteLibreria(int id) throws LibreriaException;
}
