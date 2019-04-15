//package es.avalon.repositorios.jpa.generic;
//
//import javax.persistence.EntityManager;
//
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import es.avalon.repositorios.GenericRepository;
//
//public abstract class GenericRepositoryJPA<T, K> implements GenericRepository<T, K> {
//
//	//IMPORTANTE: clase abstract
//	
//	@PersistenceContext
//	protected EntityManager em;
//	private Class<T> type;
//	
//	public GenericRepositoryJPA(Class<T>type) {
//		this.type = type;
//	}
//	
//	public void insertar(T t) {
//		// TODO Auto-generated method stub
//		em.persist(t);
//	}
//
//	public void borrar(T t) {
//		// TODO Auto-generated method stub
//		em.remove(em.merge(t));
//	}
//
//	public T buscarUno(K t) {
//		// TODO Auto-generated method stub
//		return em.find(type, t);
//	}
//
//	public T salvar(T t) {
//		// TODO Auto-generated method stub
//		return em.merge(t);
//	}
//
//	public Iterable<T> buscarTodos() {
//		// TODO Auto-generated method stub
//		
//		//Select * from T
//		CriteriaBuilder cb = this.em.getCriteriaBuilder();
//		CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
//		Root<T> root = criteriaQuery.from(type);
//		criteriaQuery.select(root);
//		TypedQuery<T>query = em.createQuery(criteriaQuery);
//		return query.getResultList();
//	}
//
//}
