package es.avalon.repositorios;

import java.util.List;
import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;

public interface CapituloRepositorio extends GenericRepository<Capitulo, String>{

	//List<Capitulo> buscarTodos();

	//List<Capitulo> buscarTodosCapitulosConSusLibros();

	List<Capitulo> buscarTodosParaUnLibro(Libro l);

	//void insertar(Capitulo capitulo);

	//Capitulo buscarUnCapitulo(String titulo);

	//void deleteCapitulo(Capitulo capitulo);

	//void salvarCapitulo(Capitulo capitu);

	List<Capitulo> searchCapitulo(String titulo, String libro);

	List<Capitulo> OrdenarCapitulosPorCampo(String campo, String libro);

}