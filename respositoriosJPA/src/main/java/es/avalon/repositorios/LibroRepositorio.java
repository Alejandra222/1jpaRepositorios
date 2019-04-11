package es.avalon.repositorios;

import java.util.List;
import es.avalon.jpa.negocio.Libro;

public interface LibroRepositorio extends GenericRepository<Libro, String> {

	//List<Libro> buscarTodos();

	//void insertar(Libro libro);

	// libro le recibo desde la web new , DETACHED
	//void delete(Libro l2);

	//Libro buscarUno(String titulo);

	//void salvar(Libro libro);

	List<Libro> searchLibro(String titulo);

	List<Libro> buscarTodosOrdenados(String campo);

}