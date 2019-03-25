package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_USUARIO")
@SequenceGenerator(name="usuario", sequenceName="SQ_T_USUARIO", allocationSize=1)
public class Usuario {
	@Id
	@Column(name="cd_usuario")
	@GeneratedValue(generator= "usuario", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_usuario", nullable=false, length=100)
	private String nome;
	
	@ManyToMany(mappedBy="usuarios")
	private List<ItemTeste> itens = new ArrayList<ItemTeste>();

	
	
	public Usuario(String nome) {
		super();
		this.nome = nome;
	}

	public Usuario() {
		super();
	}

	public Usuario(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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
	
	

}
