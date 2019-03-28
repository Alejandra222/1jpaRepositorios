package es.avalon.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;

public class CapituloRepositorioJPA {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");

	public List<Capitulo> buscarTodos() {

		EntityManager em = emf.createEntityManager();
		//query que va a generar un problema de n+1 queries
		//solamente no lo generara si impriminos la información de los capitulos unicamiente
		TypedQuery<Capitulo> consulta = em.createQuery("select l from Capitulo l", Capitulo.class);
		return consulta.getResultList();

	}
	
	public List<Capitulo> buscarTodosCapitulosConSusLibros() {
		//para obtener el libro: fetch
		EntityManager em = emf.createEntityManager();
		TypedQuery<Capitulo> consulta = em.createQuery("select distinct c from Capitulo c join fetch c.libro", Capitulo.class);
		return consulta.getResultList();

	}
	
	
	public List<Capitulo> buscarTodosParaUnLibro(Libro l) {

		EntityManager em = emf.createEntityManager();
		TypedQuery<Capitulo> consulta = em.createQuery("select c from Capitulo c where c.libro.titulo=:titulo", Capitulo.class);
		consulta.setParameter("titulo", l.getTitulo());
		return consulta.getResultList();

	}
	
	public void insertar(Capitulo capitulo) {

		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("UnidadLibros");

		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(capitulo);
		t.commit();
		em.close();

	}
	
	public Capitulo buscarUnCapitulo(String titulo) {
		//para obtener el libro: fetch
		EntityManager em = emf.createEntityManager();
		return em.find(Capitulo.class, titulo);

	}
	
	public void deleteCapitulo(Capitulo capitulo) {

		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("UnidadLibros");

		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		//se hace el merge por si se crea un new capitulo, sino no haria falta
		em.remove(em.merge(capitulo));
		t.commit();
		em.close();

	}

	public void salvarCapitulo(Capitulo capitu) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(capitu);
		t.commit();
		em.close();
		
	}
}
