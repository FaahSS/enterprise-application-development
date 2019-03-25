package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_SISTEMA")
@SequenceGenerator(name="sistema", sequenceName="SQ_TAB_SISTEMA", allocationSize=1)
public class Sistema {
	@Id
	@Column(name="cd_sistema")
	@GeneratedValue(generator="sistema", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_sistema", nullable= false, length=100)
	private String nome;
	
	@OneToMany(mappedBy = "sistema", cascade = CascadeType.PERSIST)
	private List<CasoTeste> casosTestes = new ArrayList<CasoTeste>();
	
	public Sistema(String nome) {
		super();
		this.nome = nome;
	}

	public Sistema() {
		super();
	}

	public Sistema(int codigo, String nome) {
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
