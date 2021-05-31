package com.acme.stonks.resource;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveBankResource {

	@NotNull
	@NotBlank
	@Column(unique = true)
    @Size(max=30)
	private String name;
	
	@NotNull
	@Column(unique = true)
	@Digits(integer = 11,fraction = 0)
	@Min(value = 10000000000L)
	private Long ruc;
	
	@NotNull
	@NotBlank
	@Column(unique = true)
	@Size(max=50)
	private String webSite;
	
	public String getName() {
		return name;
	}
	public SaveBankResource setName(String name) {
		this.name = name;
		return this;
	}
	public Long getRuc() {
		return ruc;
	}
	public SaveBankResource setRuc(Long ruc) {
		this.ruc = ruc;
		return this;
	}
	public String getWebSite() {
		return webSite;
	}
	public SaveBankResource setWebSite(String webSite) {
		this.webSite = webSite;
		return this;
	}
	
}
