package dao;

import java.util.List;

import javax.persistence.EntityManager;

import testeHibernate.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager entityManager;

	public ProdutoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar (Produto produto) {
		this.entityManager.persist(produto);
		
	}
	public Produto buscarPorId(Long id) {
		return entityManager.find(Produto.class, id);
		
	}
	
	public List<Produto> buscarTodos(){
		String jpql = "SELECT p FROM Produto p";
		return entityManager.createQuery(jpql, Produto.class).getResultList();
				
	}
	public List<Produto> buscarPorNome(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return entityManager.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
			
	}
	
	public List<Produto> buscarPorNomeDaCategoria(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return entityManager.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
			
	}
	
	public Double buscarDoProdutoComNome(String nome){
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
		return entityManager.createQuery(jpql, Double.class).setParameter("nome", nome).getSingleResult();
			
	}
}
