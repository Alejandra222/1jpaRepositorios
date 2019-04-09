package es.avalon.repositorios.jpa;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.CapituloRepositorio;

//@Component
@Service
public class CapituloRepositorioJPA implements CapituloRepositorio {


	//EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");

	//En el proyecto webmaven fichero ConfiguracionSpring.java tenemos
	//EntityManagerFactory y EntityTransaction

@PersistenceContext
	EntityManager em;
	
	
	public List<Capitulo> buscarTodos() {

		//EntityManager em = emf.createEntityManager();
		//query que va a generar un problema de n+1 queries
		//solamente no lo generara si impriminos la información de los capitulos unicamiente
		TypedQuery<Capitulo> consulta = em.createQuery("select l from Capitulo l", Capitulo.class);
		return consulta.getResultList();

	}

	public List<Capitulo> buscarTodosCapitulosConSusLibros() {
		//para obtener el libro: fetch
		//EntityManager em = emf.createEntityManager();
		TypedQuery<Capitulo> consulta = em.createQuery("select distinct c from Capitulo c join fetch c.libro", Capitulo.class);
		return consulta.getResultList();

	}


	public List<Capitulo> buscarTodosParaUnLibro(Libro l) {
		System.out.println("buscarTodosParaUnLibro llega el Libro: "+l.getTitulo());
		//EntityManager em = emf.createEntityManager();
		TypedQuery<Capitulo> consulta = em.createQuery("select c from Capitulo c where c.libro.titulo=:titulo", Capitulo.class);
		consulta.setParameter("titulo", l.getTitulo());
		return consulta.getResultList();

	}

	@Transactional
	public void insertar(Capitulo capitulo) {

		
		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("UnidadLibros");

		//EntityManager em = emf.createEntityManager();
		//EntityTransaction t = em.getTransaction();
		//t.begin();
		em.persist(capitulo);
		//t.commit();
		//em.close();

	}

	
	public Capitulo buscarUnCapitulo(String titulo) {
		//para obtener el libro: fetch
		//EntityManager em = emf.createEntityManager();
		return em.find(Capitulo.class, titulo);

	}

@Transactional
	public void deleteCapitulo(Capitulo capitulo) {

		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("UnidadLibros");

		//EntityManager em = emf.createEntityManager();
		//EntityTransaction t = em.getTransaction();
		//t.begin();

		//se hace el merge por si se crea un new capitulo, sino no haria falta
		em.remove(em.merge(capitulo));
		//t.commit();
		//em.close();

	}

	@Transactional
	public void salvarCapitulo(Capitulo capitu) {

		//EntityManager em = emf.createEntityManager();
		//EntityTransaction t = em.getTransaction();
		//t.begin();
		em.merge(capitu);
		//t.commit();
		//em.close();

	}


	public List<Capitulo> searchCapitulo(String titulo, String libro) {

	//	EntityManager em = emf.createEntityManager();
		TypedQuery<Capitulo> consulta = null;
		
		if(libro == null || libro.equals("")) {
			
			 consulta = em.createQuery("select c from Capitulo c where c.titulo=:titulo", Capitulo.class);
			consulta.setParameter("titulo", titulo);
		}else {
			
		    consulta = em.createQuery("select c from Capitulo c where c.titulo=:titulo and c.libro.titulo=:libro", Capitulo.class);
			consulta.setParameter("titulo", titulo);
			consulta.setParameter("libro", libro);
		}
		return consulta.getResultList();

	}


	
	public List<Capitulo> OrdenarCapitulosPorCampo(String campo, String libro) {

		System.out.println(libro+"hhhhhhhhhhhhhhhhhhhhh " + campo);


		// Ejemplo 2, más correcto
		//EntityManager em = emf.createEntityManager();
		TypedQuery<Capitulo> consulta = null;


		if(libro == null || libro.equals("")) {

			if (campo.contentEquals("titulo")) {
				// consulta.setParameter("campo", "titulo");
				consulta =em.createQuery("select c from Capitulo c order by titulo", Capitulo.class);

			} else if (campo.contentEquals("paginas")) {
				// consulta.setParameter("campo", "autor");
				consulta=em.createQuery("select c from Capitulo c order by paginas", Capitulo.class);

			}

		}else {


			if (campo.contentEquals("titulo")) {
				// consulta.setParameter("campo", "titulo");
				consulta =em.createQuery("select c from Capitulo c where c.libro.titulo=:libro order by titulo", Capitulo.class);
				consulta.setParameter("libro", libro);
			} else if (campo.contentEquals("paginas")) {
				// consulta.setParameter("campo", "autor");
				consulta=em.createQuery("select c from Capitulo c where c.libro.titulo=:libro order by paginas", Capitulo.class);
				consulta.setParameter("libro", libro);
			}
		}

		return consulta.getResultList();
	}
}
