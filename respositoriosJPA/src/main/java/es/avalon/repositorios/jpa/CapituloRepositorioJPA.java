//package es.avalon.repositorios.jpa;
//
//import java.util.List;
//import javax.persistence.TypedQuery;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import es.avalon.jpa.negocio.Capitulo;
//import es.avalon.jpa.negocio.Libro;
//import es.avalon.repositorios.CapituloRepositorio;
//import es.avalon.repositorios.jpa.generic.GenericRepositoryJPA;
//
////@Component
////@Service
//@Repository
//public class CapituloRepositorioJPA extends GenericRepositoryJPA<Capitulo, String>  implements CapituloRepositorio {
//
//
//
//	public CapituloRepositorioJPA() {
//		super(Capitulo.class);
//		// TODO Auto-generated constructor stub
//	}
//
//
//
///* TODO LO COMENTADO ESTA EN --> GenericRepositoryJPA
// * 
// * 	@PersistenceContext
//	EntityManager em;
//
//
//	public List<Capitulo> buscarTodos() {
//
//		TypedQuery<Capitulo> consulta = em.createQuery("select l from Capitulo l", Capitulo.class);
//		return consulta.getResultList();
//
//	}
//
//
//	@Transactional
//	public void insertar(Capitulo capitulo) {
//		em.persist(capitulo);
//	}
//
//
//	public Capitulo buscarUnCapitulo(String titulo) {
//		return em.find(Capitulo.class, titulo);
//
//	}
//
//	@Transactional
//	public void deleteCapitulo(Capitulo capitulo) {
//		em.remove(em.merge(capitulo));
//
//	}
//
//	@Transactional
//	public void salvarCapitulo(Capitulo capitu) {
//		em.merge(capitu);
//	}
//	
//*/	
//
//
//	public List<Capitulo> buscarTodosCapitulosConSusLibros() {
//		//para obtener el libro: fetch
//		TypedQuery<Capitulo> consulta = em.createQuery("select distinct c from Capitulo c join fetch c.libro", Capitulo.class);
//		return consulta.getResultList();
//
//	}
//
//
//	public List<Capitulo> buscarTodosParaUnLibro(Libro l) {
//		System.out.println("buscarTodosParaUnLibro llega el Libro: "+l.getTitulo());
//		//EntityManager em = emf.createEntityManager();
//		TypedQuery<Capitulo> consulta = em.createQuery("select c from Capitulo c where c.libro.titulo=:titulo", Capitulo.class);
//		consulta.setParameter("titulo", l.getTitulo());
//		return consulta.getResultList();
//
//	}
//	public List<Capitulo> searchCapitulo(String titulo, String libro) {
//
//		//	EntityManager em = emf.createEntityManager();
//		TypedQuery<Capitulo> consulta = null;
//
//		if(libro == null || libro.equals("")) {
//
//			consulta = em.createQuery("select c from Capitulo c where c.titulo=:titulo", Capitulo.class);
//			consulta.setParameter("titulo", titulo);
//		}else {
//
//			consulta = em.createQuery("select c from Capitulo c where c.titulo=:titulo and c.libro.titulo=:libro", Capitulo.class);
//			consulta.setParameter("titulo", titulo);
//			consulta.setParameter("libro", libro);
//		}
//		return consulta.getResultList();
//
//	}
//
//
//
//	public List<Capitulo> OrdenarCapitulosPorCampo(String campo, String libro) {
//
//		System.out.println(libro+" OrdenarCapitulosPorCampo: " + campo);
//
//
//		// Ejemplo 2, más correcto
//		//EntityManager em = emf.createEntityManager();
//		TypedQuery<Capitulo> consulta = null;
//
//
//		if(libro == null || libro.equals("")) {
//
//			if (campo.contentEquals("titulo")) {
//				// consulta.setParameter("campo", "titulo");
//				consulta =em.createQuery("select c from Capitulo c order by titulo", Capitulo.class);
//
//			} else if (campo.contentEquals("paginas")) {
//				// consulta.setParameter("campo", "autor");
//				consulta=em.createQuery("select c from Capitulo c order by paginas", Capitulo.class);
//
//			}
//
//		}else {
//
//
//			if (campo.contentEquals("titulo")) {
//				// consulta.setParameter("campo", "titulo");
//				consulta =em.createQuery("select c from Capitulo c where c.libro.titulo=:libro order by titulo", Capitulo.class);
//				consulta.setParameter("libro", libro);
//			} else if (campo.contentEquals("paginas")) {
//				// consulta.setParameter("campo", "autor");
//				consulta=em.createQuery("select c from Capitulo c where c.libro.titulo=:libro order by paginas", Capitulo.class);
//				consulta.setParameter("libro", libro);
//			}
//		}
//
//		return consulta.getResultList();
//	}
//}
