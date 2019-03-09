package edu.eci.library.Model;
import java.util.List;


public class Libreria {
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private List<Libro> libros;
	
	public Libreria(){
		
		
	}
	public Libreria(int id, String nombre, String direccion, String telefono,List<Libro> libros) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.libros= libros;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	public boolean vacio(){
		if(libros.size()==0) return true;
		return false;
	}
	public void addLibro(Libro libro){
		libros.add(libro);
	}
	
	@Override
	public String toString() {
		return "Libreria [Id=" + id + ", Nombre=" + nombre + ", Direccion=" + direccion + ", Telefono=" + telefono
				+ ", libros=" + libros + "]";
	}
	

	

}


