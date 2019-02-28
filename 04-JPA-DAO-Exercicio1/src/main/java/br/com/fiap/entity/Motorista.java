package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** 
 * @author Fábio Salgarella dos Santos
 *
 * T_MOTORISTA
 *		*nr_carteira    (NUMBER)
 *		*nm_motorista   (VARCHAR2(150))
 *		 dt_nascimento  (DATE)
 *		 fl_carteira    (BLOB)
 *		 ds_genero		(VARCHAR2) ENUM
 */

@Entity
@Table(name = "T_MOTORISTA")
public class Motorista {
	
	@Id
	@Column(name = "nr_carteira")
	private int numeroCarteira;
	
	@Column(name = "nm_motorista", nullable = false, length=150)
	private String nome;
	
	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNacimento;
	
	@Lob
	@Column(name = "fl_carteira")
	private byte[] foto;
	
	@Column(name = "ds_genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;
	

}
