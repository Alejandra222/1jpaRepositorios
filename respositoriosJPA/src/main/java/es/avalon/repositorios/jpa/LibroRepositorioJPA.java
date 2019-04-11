package es.avalon.repositorios.jpa;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.LibroRepositorio;
import es.avalon.repositorios.jpa.generic.GenericRepositoryJPA;

//@Component
//public class LibroRepositorioJPA implements LibroRepositorio {
@Repository
public class LibroRepositorioJPA extends GenericRepositoryJPA<Libro,String> implements LibroRepositorio {


	public LibroRepositorioJPA() {
		super(Libro.class);
		// TODO Auto-generated constructor stub
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


	public List<Libro> searchLibro(String titulo) {
		System.out.println("searchLibro llega: "+titulo);

		//protected EntityManager em; -->GenericRepositoryJPA
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.titulo=:titulo", Libro.class);

		consulta.setParameter("titulo", titulo);
		return consulta.getResultList();

	}


	public List<Libro> buscarTodosOrdenados(String campo) {

		System.out.println("buscarTodosOrdenados llega: " + campo);

		TypedQuery<Libro> consulta = null;

		//protected EntityManager em; --> GenericRepositoryJPA
		if (campo.contentEquals("titulo")) {
			// consulta.setParameter("campo", "titulo");
			consulta =em.createQuery("select l from Libro l order by titulo", Libro.class);

		} else if (campo.contentEquals("autor")) {
			// consulta.setParameter("campo", "autor");
			consulta=em.createQuery("select l from Libro l order by autor", Libro.class);

		}
		if (campo.contentEquals("paginas")) {
			// consulta.setParameter("campo", "pagina");
			consulta=em.createQuery("select l from Libro l order by paginas", Libro.class);
		}

		return consulta.getResultList();
	}

}
