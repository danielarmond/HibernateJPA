package dao;

import javax.persistence.EntityManager;

import testeHibernate.modelo.Pedido;

public class PedidoDao {
	
	private EntityManager entityManager;

	public PedidoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar (Pedido pedido) {
		this.entityManager.persist(pedido);
		
	}
	public Pedido buscarPorId(Long id) {
		return entityManager.find(Pedido.class, id);
		
	}
		
}
