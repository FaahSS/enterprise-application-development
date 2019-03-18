package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@OneToOne
	@JoinColumn(name="cd_gerente")
	private Gerente gerente;
	
	@OneToMany(mappedBy="departamento")
	private List<Funcionario> funcionario;
	
	@Column(name="nm_departamento", nullable = false, length=100)
	private String nome;
	
	@Column(name="ds_status")
	@Enumerated(EnumType.STRING)
	private Status status;

}
