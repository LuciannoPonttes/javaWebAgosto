package projetoDespesa.projetoDespesa.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Indica que a classe é uma entidade no banco(tabela)
public class Despesa {

	@Id // Indica a chave primaria 
	@GeneratedValue(strategy = GenerationType.AUTO) // Incrementa automaticamente
	private Long codigo;
	
	private String descricao;
	
	private String observacoes;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
	
	
}
