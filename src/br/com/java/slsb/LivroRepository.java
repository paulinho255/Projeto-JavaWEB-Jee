package br.com.java.slsb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.java.entity.Livro;

@Stateless
public class LivroRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addBook(Livro livro) {
		this.entityManager.persist(livro);
	}
	
	public List<Livro> getBooks(){
		TypedQuery<Livro> query = this.entityManager.createQuery("select b from Livro b", Livro.class);
		return query.getResultList();
	}
}
