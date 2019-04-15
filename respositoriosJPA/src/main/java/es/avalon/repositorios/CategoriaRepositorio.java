package es.avalon.repositorios;



import org.springframework.data.jpa.repository.JpaRepository;

import es.avalon.jpa.negocio.Categoria;
import es.avalon.jpa.negocio.Libro;


//public interface CategoriaRepositorio extends GenericRepository<Categoria, Integer> {
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

	//List<Libro> buscarTodos();

	//void insertar(Libro libro);

	// libro le recibo desde la web new , DETACHED
	//void delete(Libro l2);

	//Libro buscarUno(String titulo);

	//void salvar(Libro libro);

	//List<Libro> searchLibro(String titulo);

	//List<Libro> buscarTodosOrdenados(String campo);
	
	
	
	//public Iterable<Libro> buscarLibrosPorCategoriaQuery(Categoria c);

}