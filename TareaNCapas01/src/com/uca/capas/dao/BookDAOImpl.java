package com.uca.capas.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.controller.MainController;
import com.uca.capas.domain.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	
	static Logger log = Logger.getLogger(MainController.class.getName());

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Book> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from book order by book_id");
		Query query = entityManager.createNativeQuery(sb.toString(),Book.class);
		List<Book> resulset= query.getResultList();
		
		return resulset;
	}

	@Override
	public List<Book> findOne(String booktext,String selector) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		if(selector.equals("0")) {
			sb.append("select * from book order by book_id");
		}
		if(selector.equals("1")) {
			sb.append("select * from book where lower(author) like '%"+booktext.toLowerCase()+"%'");
		}
		if(selector.equals("2")) {
			sb.append("select * from book where isbn like '%"+booktext+"%'");
		}
		
		Query query = entityManager.createNativeQuery(sb.toString(),Book.class);
		List<Book> resultset= query.getResultList();
		return resultset;
	}
	@Override
	public int countfilter(String booktext,String selector) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		if(selector.equals("0")) {
			sb.append("select * from book order by book_id");
		}
		if(selector.equals("1")) {
			sb.append("select Count(distinct author) from book where lower(author) like"+"'%"+booktext.toLowerCase()
			+"'");
		}
		if(selector.equals("2")) {
			sb.append("select Count(distinct isbn) from book where isbn like"+"'%"+booktext+"'");
		}
		
		Query query = entityManager.createNativeQuery(sb.toString());
		int resultset= ((Number) query.getSingleResult()).intValue();
		return resultset;
	}
	@Override
	public int countAllBooks() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select Count(book_id) from book");
		Query query = entityManager.createNativeQuery(sb.toString());
		int resulset= ((Number) query.getSingleResult()).intValue();
		return resulset;
	}
	@Override
	public int countAllAuthors() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select Count(distinct author) from book");
		Query query = entityManager.createNativeQuery(sb.toString());
		int resulset= ((Number) query.getSingleResult()).intValue();
		return resulset;
	}
}