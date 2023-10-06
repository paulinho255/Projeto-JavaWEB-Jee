package br.com.java.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.java.entity.Livro;
import br.com.java.slsb.LivroRepository;

@ManagedBean
public class LivroMB {
	@EJB
	private LivroRepository livroRepository;
	
	private Livro livro = new Livro();
	
	private List<Livro> livrosCache;
	
	public void addBooks() {
		this.livroRepository.addBook(this.livro);
		this.livro = new Livro();
		this.livrosCache = null;
	}
	
	public List<Livro> getBooks(){
		if (this.livrosCache == null ) {
			this.livrosCache = this.livroRepository.getBooks();
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
