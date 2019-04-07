package es.avalon.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;

public class LibroRepositorioJPA {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");

	public List<Libro> buscarTodos() {

		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);
		return consulta.getResultList();

	}

	public void insertar(Libro libro) {

		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("UnidadLibros");

		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(libro);
		t.commit();
		em.close();

	}

	// libro le recibo desde la web new , DETACHED
	public void delete(Libro l2) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Libro libroGestionado = em.merge(l2);
		em.remove(libroGestionado);
		t.commit();
		em.close();

	}

	public Libro buscarUno(String titulo) {

		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("UnidadLibros");

		EntityManager em = emf.createEntityManager();
		Libro libro = em.find(Libro.class, titulo);
		em.close();
		return libro;

	}

	public void salvar(Libro libro) {

		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("UnidadLibros");

		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(libro);
		t.commit();
		em.close();

	}
	
	public List<Libro> searchLibro(String titulo) {
		System.out.println("searchLibro llega: "+titulo);
		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.titulo=:titulo", Libro.class);
		
		consulta.setParameter("titulo", titulo);
		return consulta.getResultList();

	}

	public List<Libro> buscarTodosOrdenados(String campo) {

		System.out.println("hhhhhhhhhhhhhhhhhhhhh " + campo);

		// Ejemplo 1
//		EntityManager em = emf.createEntityManager();
//		TypedQuery<Libro> consulta=em.createQuery("select l from Libro l order by l."+campo, Libro.class);
//		return consulta.getResultList();
//		

		// Ejemplo 2, más correcto
		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta = null;

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
