package es.avalon.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.avalon.jpa.negocio.Libro;

public class LibroRepositorioJPA {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");
	
	public List<Libro>buscarTodos(){
		
		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta=em.createQuery("select l from Libro l", Libro.class);
		return consulta.getResultList();
		
		
	}
}
