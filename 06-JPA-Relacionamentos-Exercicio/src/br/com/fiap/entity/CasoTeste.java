package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_CASO_TESTE")
@SequenceGenerator(name="casoteste", sequenceName="SQ_TAB_CASO_TESTE", allocationSize=1)
public class CasoTeste {
	@Id
	@Column(name="cd_caso_teste")
	@GeneratedValue(generator="casoteste", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_caso_teste", nullable = false, length=100)
	private String nome;
	
	@Column(name="ds_caso_teste", nullable = false, length=200)
	private String descricao;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch= FetchType.LAZY )
	@JoinColumn(name="cd_sistema")
	private Sistema sistema;
	
	@OneToMany(mappedBy = "casoTeste", cascade = CascadeType.PERSIST)
	private List<ItemTeste> itens = new ArrayList<ItemTeste>();
	

	public CasoTeste(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public CasoTeste(String nome, String descricao, Sistema sistema) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.sistema = sistema;
	}

	public CasoTeste(int codigo, String nome, String descricao, Sistema sistema) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.sistema = sistema;
	}

	public CasoTeste() {
		super();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	

}
