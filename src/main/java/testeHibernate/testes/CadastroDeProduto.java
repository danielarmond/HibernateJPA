package testeHibernate.testes;

import java.util.List;

import javax.persistence.EntityManager;

import dao.CategoriaDao;
import dao.ProdutoDao;
import testeHibernate.modelo.Categoria;
import testeHibernate.modelo.Produto;
import testeHibernate.util.JPAUtil;


public class CadastroDeProduto {

	public static void main(String[] args) {
		
		cadastrarProduto();
		
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		 
		List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		todos.forEach(p -> System.out.println(p.getNome()));
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("celular", "Redmi note 8", 1300.00, celulares); 
	
	
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		CategoriaDao categoriaDao = new CategoriaDao(entityManager);
		
		entityManager.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
}
