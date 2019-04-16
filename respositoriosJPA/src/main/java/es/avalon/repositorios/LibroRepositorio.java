package es.avalon.repositorios;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.avalon.jpa.negocio.Libro;

//public interface LibroRepositorio extends GenericRepository<Libro, String> {
//JpaRepository NECESARIO PARA SPRING DATA
public interface LibroRepositorio extends JpaRepository<Libro, String>{
	//List<Libro> buscarTodos();

	//void insertar(Libro libro);

	// libro le recibo desde la web new , DETACHED
	//void delete(Libro l2);

	//Libro buscarUno(String titulo);

	//void salvar(Libro libro);
	
	

	//List<Libro> searchLibro(String titulo);
	List<Libro> findByTitulo(String titulo);

	//List<Libro> buscarTodosOrdenados(String campo);
	List<Libro> findAllByOrderByTituloAsc();
	List<Libro> findAllByOrderByAutorAsc();
	List<Libro> findAllByOrderByPaginasAsc();
	
	
	
	/*@Query("select l fom Libro l")
	List<Libro> findCustomQuery();*/
}