package testeHibernate.testes;

import javax.persistence.EntityManager;

import dao.CategoriaDao;
import dao.ClienteDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import testeHibernate.modelo.Categoria;
import testeHibernate.modelo.Cliente;
import testeHibernate.modelo.ItemPedido;
import testeHibernate.modelo.Pedido;
import testeHibernate.modelo.Produto;
import testeHibernate.util.JPAUtil;

public class CadastroDePedido {
	
	public static void main(String[] args) {
		popularBancoDeDados();
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		ClienteDao clienteDao = new ClienteDao(entityManager);

		
		Produto produto = produtoDao.buscarPorId(1l);
		Cliente cliente = clienteDao.buscarPorId(1l);
		
		entityManager.getTransaction().begin();

		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, produto, pedido));
	
		PedidoDao pedidoDao = new PedidoDao(entityManager);
		pedidoDao.cadastrar(pedido);
		
		entityManager.getTransaction().commit();

	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("celular", "Redmi note 8", 1300.00, celulares); 
	
		Cliente cliente = new Cliente ("Daniel","123456");
	
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		CategoriaDao categoriaDao = new CategoriaDao(entityManager);
		ClienteDao clienteDao = new ClienteDao(entityManager);

		
		entityManager.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		clienteDao.cadastrar(cliente);

		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
}
