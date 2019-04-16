package es.avalon.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;

//public interface CapituloRepositorio extends GenericRepository<Capitulo, String>{
public interface CapituloRepositorio extends JpaRepository<Capitulo, String>{

	//List<Capitulo> buscarTodos();

	//List<Capitulo> buscarTodosCapitulosConSusLibros();

	//void insertar(Capitulo capitulo);

	//Capitulo buscarUnCapitulo(String titulo);

	//void deleteCapitulo(Capitulo capitulo);

	//void salvarCapitulo(Capitulo capitu);
	
	
	
	
	//List<Capitulo> buscarTodosParaUnLibro(Libro l);
	//@Query("select l from Libro l join fetch l.categorias") 
	//List<Libro> buscarTodosParaUnLibro();
	
	//List<Capitulo> searchCapitulo(String titulo, String libro);

	//List<Capitulo> OrdenarCapitulosPorCampo(String campo, String libro);

}