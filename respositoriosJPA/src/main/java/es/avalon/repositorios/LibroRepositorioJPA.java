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
	
	public void insertar() {
		Libro libro = new Libro("RepositoryJPA", "Manuel", 450);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");

		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			// persist: inserta
			em.persist(libro);
			em.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			em.close();

		}
	}
	
	private static void update() {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("UnidadOrdenador");
		 
		 EntityManager em = emf.createEntityManager();
		 
		 //find: filtra
		 Libro l2=em.find(Libro.class, "RepositoryJPA");
		 
		 l2.setPaginas(1000);
		 
		 
		 try {
		 em.getTransaction().begin();
		 
		 //merge: update
		 em.merge(l2);
		 
		 em.getTransaction().commit();
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }finally {
		 em.close();
		 
		 }
	}
	
	private static void delete() {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("UnidadOrdenador");
		 
		 EntityManager em = emf.createEntityManager();
		 
		 //find: filtra
		 Libro l2=em.find(Libro.class, "RepositoryJPA");
		 
		 
		 try {
		 em.getTransaction().begin();
	
		 
		 //remove: delete
		 em.remove(l2);
		 
		 em.getTransaction().commit();
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }finally {
		 em.close();
		 
		 }
}

	
}
