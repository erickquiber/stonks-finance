package com.acme.stonks.resource;

public class BankResource {

	private Long id;
	private String name;
	private Long ruc;
	private String webSite;
	
	public Long getId() {
		return id;
	}
	public BankResource setId(Long id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public BankResource setName(String name) {
		this.name = name;
		return this;
	}
	public Long getRuc() {
		return ruc;
	}
	public BankResource setRuc(Long ruc) {
		this.ruc = ruc;
		return this;
	}
	public String getWebSite() {
		return webSite;
	}
	public BankResource setWebSite(String webSite) {
		this.webSite = webSite;
		return this;
	}
	
}
