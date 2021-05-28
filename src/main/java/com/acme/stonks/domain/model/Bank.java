package com.acme.stonks.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.sun.istack.NotNull;

@Entity
@Table(name="bank")
public class Bank {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(unique = true)
	@Size(max=30)
	private String name;
	
	@NotNull
	@Column(unique = true)
	private Long ruc;
	
	@NotNull
	@Column(unique = true)
	@Size(max=50)
	private String webSite;

	public Long getId() {
		return id;
	}

	public Bank setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Bank setName(String name) {
		this.name = name;
		return this;
	}

	public Long getRuc() {
		return ruc;
	}

	public Bank setRuc(Long ruc) {
		this.ruc = ruc;
		return this;
	}

	public String getWebSite() {
		return webSite;
	}

	public Bank setWebSite(String webSite) {
		this.webSite = webSite;
		return this;
	}
	
	
	
}
