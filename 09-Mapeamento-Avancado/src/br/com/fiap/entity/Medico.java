package br.com.fiap.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_MEDICO")

@SecondaryTable(name="T_MEDICO_FINANCEIRO")
public class Medico {

	@Id
	@Column(name="nr_crm")
	private int crm;
	
	@Column(name="nm_medico", nullable=false)
	private String nome;
	
	@Column(name="vl_salario", table="T_MEDICO_FINANCEIRO")
	private float salario;
	
	@Column(name="nr_conta", table="T_MEDICO_FINANCEIRO")
	private int conta;

	public Medico(int crm, String nome) {
		super();
		this.crm = crm;
		this.nome = nome;
	}

	public Medico() {
		super();
	}
	

	public Medico(int crm, String nome, float salario, int conta) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.salario = salario;
		this.conta = conta;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}
	
	
}
