package br.com.k19.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.entidades.Livro;
import br.com.k19.sessionbeans.LivroRepository;

/**
 * Esta classe oferece algumas ações para as telas de interface através de métodos disponibilizados.
 * @author julian
 *
 */
@ManagedBean
public class LivroMB {

	@EJB
	private LivroRepository repositoryLivro;
	
	private Livro livro = new Livro();
	
	private List<Livro> livrosCache;
	
	public void adiciona() {
		this.repositoryLivro.adiciona(this.livro);
		this.livro = new Livro();
		this.livrosCache = null;
	}
	
	public List<Livro> getLivros() {
		if (this.livrosCache == null) {
			this.livrosCache = this.repositoryLivro.getLivros();
		}
		
		return this.livrosCache;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
