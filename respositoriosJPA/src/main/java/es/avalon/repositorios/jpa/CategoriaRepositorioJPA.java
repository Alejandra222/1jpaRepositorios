package es.avalon.repositorios.jpa;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;



import es.avalon.jpa.negocio.Categoria;
import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.CategoriaRepositorio;
import es.avalon.repositorios.jpa.generic.GenericRepositoryJPA;

//@Component
//public class LibroRepositorioJPA implements LibroRepositorio {
@Repository
public class CategoriaRepositorioJPA extends GenericRepositoryJPA<Categoria,Integer> implements CategoriaRepositorio {


	

	public CategoriaRepositorioJPA() {
		super(Categoria.class);
		// TODO Auto-generated constructor stub
	}

	public Iterable<Libro> buscarLibrosPorCategoriaQuery(Categoria c){
	
		//LE PASO UNA CATEGORIA Y BUSCA EN LA CLASE LIBROS LA LISTA DE CATEGORIAS Y MIRA SI ESTA
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where :categoria member of l.categorias", Libro.class);
		consulta.setParameter("categoria", c);
		return consulta.getResultList();
	}

	/*
	 *  TODO LO COMENTADO ESTA EN --> GenericRepositoryJPA
	
	@PersistenceContext
	EntityManager em;


	public List<Libro> buscarTodos() {	
	TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);
	return consulta.getResultList();

	}


	public void insertar(Libro libro) {
		em.persist(libro);	
	}


	public void delete(Libro l2) {

		Libro libroGestionado = em.merge(l2);
		em.remove(libroGestionado);

	}

public Libro buscarUno(String titulo) {

	Libro libro = em.find(Libro.class, titulo);
	return libro;

}

	public void salvar(Libro libro) {

		em.merge(libro);

	}

*/



}
