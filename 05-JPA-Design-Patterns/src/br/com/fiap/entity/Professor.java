package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * T_PROFESSOR (SQ_T_PROFESSOR)
 * 		*cd_professor		(NUMBER) (PK)
 * 		*nm_professor		(VARCHAR2(100))
 * 		*fl_foto			LOB
 * 		*ds_cpf				(VARCHAR2(15))
 * 
 */

@Entity
@Table(name = "T_PROFESSOR")
@SequenceGenerator(name="professor", sequenceName="SQ_T_PROFESSOR", allocationSize=1)
public class Professor {
	
	@Id
	@Column(name="cd_professor")
	@GeneratedValue(generator = "professor", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_professor", nullable = false, length=100)
	private String nome;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="ds_cpf", nullable=false, length=15)
	private String cpf;
	

	public Professor() {
		super();
	}
	
	public Professor(String nome, byte[] foto, String cpf) {
		super();
		this.nome = nome;
		this.foto = foto;
		this.cpf = cpf;
	}
	
	public Professor(int codigo, String nome, byte[] foto, String cpf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.foto = foto;
		this.cpf = cpf;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
