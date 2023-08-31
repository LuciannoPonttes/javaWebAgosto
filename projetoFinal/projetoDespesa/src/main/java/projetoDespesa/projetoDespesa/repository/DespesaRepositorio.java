package projetoDespesa.projetoDespesa.repository;

import org.springframework.data.repository.CrudRepository;

import projetoDespesa.projetoDespesa.model.Despesa;

public interface DespesaRepositorio extends CrudRepository<Despesa, String> {
	
	Despesa findByCodigo(long Codigo);//Metodo para buscar Pelo Id
	
	
}
