package dao;

import javax.persistence.EntityManager;

import testeHibernate.modelo.Categoria;

public class CategoriaDao {
	
	private EntityManager entityManager;

	public CategoriaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar (Categoria categoria) {
		this.entityManager.persist(categoria);
		
	}
	public void atualizar (Categoria categoria) {
		this.entityManager.merge(categoria);
		
	}
	
	public void remover (Categoria categoria) {
		categoria = entityManager.merge(categoria);
		this.entityManager.remove(categoria);
		
	}
}
