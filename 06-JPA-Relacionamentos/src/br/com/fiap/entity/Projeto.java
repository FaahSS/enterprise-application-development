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

@Entity
@Table(name="T_PROJETO")
@SequenceGenerator(name="projeto", sequenceName="SQ_T_PROJETO", allocationSize=1)
public class Projeto {
	@Id
	@Column(name="cd_projeto")
	@GeneratedValue(generator = "projeto", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_projeto", nullable = false, length=100)
	private String nome;
	
	@Column(name="ds_status", nullable=false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicio", nullable=false)
	private Calendar dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim", nullable=false)
	private Calendar dataFim;
}
