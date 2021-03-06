package br.edu.ifms.http;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Aluno {
	
	private Integer codigo;
	
	private String nome;
	
	private String ra;
		

	public Aluno() {
	}
	
	public Aluno(Integer codigo, String nome, String ra) {
		this.codigo = codigo;
		this.nome = nome;
		this.ra = ra;
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	
}
