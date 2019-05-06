package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@DiscriminatorValue("B")

@Entity
@Table(name="T_BARCO")
public class Barco extends Veiculo{


	@Column(name="nr_pes")
	private int pes;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo_barco")
	private TipoBarco tipo;
	

	public Barco(double velocidade, String nome, int pes, TipoBarco tipo) {
		super(velocidade, nome);
		this.pes = pes;
		this.tipo = tipo;
	}

	public Barco() {
		super();
	}


	public int getPes() {
		return pes;
	}


	public void setPes(int pes) {
		this.pes = pes;
	}


	public TipoBarco getTipo() {
		return tipo;
	}


	public void setTipo(TipoBarco tipo) {
		this.tipo = tipo;
	}
	
	
}
