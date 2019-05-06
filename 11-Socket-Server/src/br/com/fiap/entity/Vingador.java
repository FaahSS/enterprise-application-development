package br.com.fiap.entity;

import java.io.Serializable;

public class Vingador implements Serializable{
	
	private static final long serialVersionUID = -6406149149377482910L;
	private String nome;
	private String nomeReal;
	private String poder;
	 
	public Vingador() {
		super();
	}
	
	public Vingador(String nome, String nomeReal, String poder) {
		super();
		this.nome = nome;
		this.nomeReal = nomeReal;
		this.poder = poder;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeReal() {
		return nomeReal;
	}
	public void setNomeReal(String nomeReal) {
		this.nomeReal = nomeReal;
	}
	public String getPoder() {
		return poder;
	}
	public void setPoder(String poder) {
		this.poder = poder;
	}
	
	

}
