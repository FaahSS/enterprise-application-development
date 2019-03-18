package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_FUNCIONARIO")
@SequenceGenerator(name="funcionario", sequenceName="SQ_T_FUNCIONARIO", allocationSize=1)
public class Funcionario {
	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(generator = "funcionario", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="cd_departamento")
	private Departamento departamento;
	
	@Column(name="nm_funcionario", nullable = false, length=100)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento", nullable = false)
	private Calendar dataNascimento;
	
	@Column(name="vl_salario", nullable = false)
	private float salario;
	
	

}
