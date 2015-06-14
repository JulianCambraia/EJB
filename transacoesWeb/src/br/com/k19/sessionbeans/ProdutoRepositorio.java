package br.com.k19.sessionbeans;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.k19.entidades.Produto;

@Stateless
public class ProdutoRepositorio {

	@PersistenceContext
	private EntityManager manager;
	
	@Resource
	private SessionContext contexto;
	
	public void adiciona(Produto produto) {
		this.manager.persist(produto);
		
		if (produto.getPreco() < 0) {
			this.contexto.setRollbackOnly();
		}
	}
	
	public List<Produto> getProdutos() {
		TypedQuery<Produto> query = this.manager.createQuery("SELECT x FROM Produto x", Produto.class);
		return query.getResultList();
	}
}
