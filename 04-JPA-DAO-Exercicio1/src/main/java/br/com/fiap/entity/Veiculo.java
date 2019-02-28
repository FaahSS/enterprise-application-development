package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * T_VEICULO
 * 		*cd_veiculo (NUMBER) (PK)
 * 		*ds_placa   (VARCHAR2(9)) 
 * 		*ds_cor		(VARCHAR2(20)) 
 * 		 nr_ano 	(NUMBER)
 */

@Entity
@Table(name = "T_VEICULO")
@SequenceGenerator(name = "veiculo", sequenceName = "SQ_T_VEICULO", allocationSize = 1)
public class Veiculo {
	
	@Id
	@Column(name = "cd_veiculo")
	@GeneratedValue(generator = "veiculo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "ds_placa", nullable = false, length = 9)
	private String descricao;
	
	@Column(name = "ds_cor", nullable = false, length = 20)
	private String cor;
	
	@Column(name = "nr_ano")
	private int ano;

	public Veiculo() {
		super();
	}

	public Veiculo(String descricao, String cor, int ano) {
		super();
		this.descricao = descricao;
		this.cor = cor;
		this.ano = ano;
	}

	public Veiculo(int codigo, String descricao, String cor, int ano) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.cor = cor;
		this.ano = ano;
	}

	// Getters & Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
