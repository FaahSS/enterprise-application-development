package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_VEICULO")
public class Veiculo {

	@Id
	@Column(name="cd_veiculo")
	private int codigo;
	
	@Column(name="ds_placa", nullable=false)
	private String placa;
	
	@Column(name="ds_cor", nullable=false)
	private String cor;
	
	@Column(name="nr_ano")
	private int ano;

	public Veiculo(int codigo, String placa, String cor, int ano) {
		super();
		this.codigo = codigo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}

	public Veiculo() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
}
