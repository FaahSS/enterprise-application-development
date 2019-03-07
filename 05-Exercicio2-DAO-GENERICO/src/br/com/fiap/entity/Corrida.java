package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CORRIDA")
@SequenceGenerator(name="corrida", sequenceName="SQ_T_CORRIDA")
public class Corrida {
	
	@Id
	@Column(name="cd_corrida")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="corrida")
	private int codigo;
	
	@Column(name="ds_origem")
	private String origem;
	
	@Column(name="ds_destino")
	private String destino;
	
	@Column(name="dt_corrida")
	private Calendar dataCorrida;	
	
	@Column(name="vl_corrida", nullable=false)
	private float valorCorrida;

	public Corrida(int codigo, String origem, String destino, Calendar dataCorrida, float valorCorrida) {
		super();
		this.codigo = codigo;
		this.origem = origem;
		this.destino = destino;
		this.dataCorrida = dataCorrida;
		this.valorCorrida = valorCorrida;
	}

	public Corrida(String origem, String destino, Calendar dataCorrida, float valorCorrida) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.dataCorrida = dataCorrida;
		this.valorCorrida = valorCorrida;
	}

	public Corrida() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Calendar getDataCorrida() {
		return dataCorrida;
	}

	public void setDataCorrida(Calendar dataCorrida) {
		this.dataCorrida = dataCorrida;
	}

	public float getValorCorrida() {
		return valorCorrida;
	}

	public void setValorCorrida(float valorCorrida) {
		this.valorCorrida = valorCorrida;
	}
	
	
	

}
