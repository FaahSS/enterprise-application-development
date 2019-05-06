package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_CARRO")
public class Carro extends Veiculo{

	@Column(name="nr_portas")
	private int portas;
	
	@Column(name="nr_roda")
	private int aroRodas;
	

	public Carro(double velocidade, String nome, int portas, int aroRodas) {
		super(velocidade, nome);
		this.portas = portas;
		this.aroRodas = aroRodas;
	}

	public Carro() {
		super();
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}

	public int getRodas() {
		return aroRodas;
	}

	public void setRodas(int aroRodas) {
		this.aroRodas = aroRodas;
	}
	
	
}
