package br.com.fiap.entity;

import java.io.Serializable;

public class ConsultaPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int codigo;
	
	private int medico;
	
	private int paciente;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getMedico() {
		return medico;
	}

	public void setMedico(int medico) {
		this.medico = medico;
	}

	public int getPaciente() {
		return paciente;
	}

	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + medico;
		result = prime * result + paciente;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaPK other = (ConsultaPK) obj;
		if (codigo != other.codigo)
			return false;
		if (medico != other.medico)
			return false;
		if (paciente != other.paciente)
			return false;
		return true;
	}
}
