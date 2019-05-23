package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "books")
public class Book {

	@Id
	@GeneratedValue(generator = "book_id_book_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "book_id_book_seq", sequenceName =  "public.book_id_book_seq", allocationSize = 1)
	@Column(name = "book_id")
	private Integer bookid;

	@Column(name = "title")
	private String titlen;
	
	@Column(name = "author")
	private String authorn;
	
	@Column(name = "isbn")
	private String isbnn;
	
	@Column(name = "stock")
	private Integer stockn;

	public Book(Integer bookid, String titlen, String authorn, String isbnn, Integer stockn) {
		super();
		this.bookid = bookid;
		this.titlen = titlen;
		this.authorn = authorn;
		this.isbnn = isbnn;
		this.stockn = stockn;
	}

	public Book() {
		super();
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public String getTitlen() {
		return titlen;
	}

	public void setTitlen(String titlen) {
		this.titlen = titlen;
	}

	public String getAuthorn() {
		return authorn;
	}

	public void setAuthorn(String authorn) {
		this.authorn = authorn;
	}

	public String getIsbnn() {
		return isbnn;
	}

	public void setIsbnn(String isbnn) {
		this.isbnn = isbnn;
	}

	public Integer getStockn() {
		return stockn;
	}

	public void setStockn(Integer stockn) {
		this.stockn = stockn;
	}
	
	
	
	
	
	


	
}