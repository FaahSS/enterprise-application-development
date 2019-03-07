package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PAGAMENTO")
@SequenceGenerator(name="pagamento", sequenceName="SQ_T_PAGAMENTO", allocationSize=1)
public class Pagamento {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pagamento")
	@Column(name="cd_pagamento")
	private int codigo;
	
	@Column(name="dt_pagamento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataPagamento;
	
	@Column(name="vl_pagamento", nullable=false)
	private float valorPagamento;
	
	@Column(name="ds_forma_pagamento", nullable=false)
	private FormaPagamento formaPagamento;

	public Pagamento(int codigo, Calendar dataPagamento, float valorPagamento, FormaPagamento formaPagamento) {
		super();
		this.codigo = codigo;
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.formaPagamento = formaPagamento;
	}

	public Pagamento(Calendar dataPagamento, float valorPagamento, FormaPagamento formaPagamento) {
		super();
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.formaPagamento = formaPagamento;
	}

	public Pagamento() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public float getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(float valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
}
