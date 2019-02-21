package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * T_EMPRESA
 * 		*cd_empresa (NUMBER) (PK)
 * 		*nm_fantasia(VARCHAR(50))
 * 		dt_abertura (DATE)
 * 		ds_status (VARCHAR) (Enum)
 * 		*nr_cnpj (VARCHAR(18))
 * 
 */
@Entity
@Table(name = "T_EMPRESA")
@SequenceGenerator(name = "empresa", sequenceName = "SQ_T_EMPRESA", allocationSize = 1)
public class Empresa {
	
	@Id
	@Column(name = "cd_empresa")
	@GeneratedValue(generator = "empresa", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_fantasia", nullable = false, length = 50)
	private String nomeFantasia;
	
	@Column(name = "dt_abertura")
	@Temporal(TemporalType.DATE)
	private Calendar dataAbertura;
	
	@Column(name = "ds_status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "nr_cnpj", nullable = false, length = 18)
	private String cnpj;

	
	// Inserir Registro no Banco
	public Empresa(String nomeFantasia, Calendar dataAbertura, Status status, String cnpj) {
		super();
		this.nomeFantasia = nomeFantasia;
		this.dataAbertura = dataAbertura;
		this.status = status;
		this.cnpj = cnpj;
	}
	
	// Atualizar Registro no Banco
	public Empresa(int codigo, String nomeFantasia, Calendar dataAbertura, Status status, String cnpj) {
		super();
		this.codigo = codigo;
		this.nomeFantasia = nomeFantasia;
		this.dataAbertura = dataAbertura;
		this.status = status;
		this.cnpj = cnpj;
	}
	

	public Empresa() {
		super();
	}

	//Getters & Setters
	public int getCodigo() {
		return codigo;
	}

	

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
}
