package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_DEPARTAMENTO")
@SequenceGenerator(name="departamento", sequenceName="SQ_T_DEPARTAMENTO", allocationSize=1)
public class Departamento {
	@Id
	@Column(name="cd_departamento")
	@GeneratedValue(generator = "departamento", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="cd_gerente")
	private Gerente gerente;
	
	//mappedBy atributo que mapeia a FK na classe departamento
	@OneToMany(mappedBy="departamento", cascade = CascadeType.PERSIST)
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	@Column(name="nm_departamento", nullable = false, length=100)
	private String nome;
	
	@Column(name="ds_status")
	@Enumerated(EnumType.STRING)
	private Status status;

	public void addFuncionario(Funcionario funcionario) {
		//adicionar o funcionário na lista
		funcionarios.add(funcionario);
		//adicionar o departamento no funcionário
		funcionario.setDepartamento(this);
	}
	

	public Departamento() {
		super();
	}


	public Departamento(Gerente gerente, String nome, Status status) {
		super();
		this.gerente = gerente;
		this.nome = nome;
		this.status = status;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public List<Funcionario> getFuncionario() {
		return funcionarios;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionarios = funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	

}
