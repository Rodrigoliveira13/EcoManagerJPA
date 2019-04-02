package br.com.ecomanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Predio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomePredio;
	
	@ManyToOne
	private Estabelecimento estabelecimento;

	public Predio() {
		
	}

	public Predio(Integer id, String nomePredio, Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.nomePredio = nomePredio;
		this.estabelecimento = estabelecimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomePredio() {
		return nomePredio;
	}

	public void setNomePredio(String nomePredio) {
		this.nomePredio = nomePredio;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	
	

}
