package br.edu.ifs.academico.model.interfaces;

import java.util.List;

// Interface implementada por todas as entidades
// Ela permite com que metodos comuns que possuam uma estrutura especifica para cada entidade sejam executados pelo GenericOperations
public interface IEntity {

	public void setKey(String key);
    // O metodo getKey retorna a chave primaria da entidade
    public Object getKey();
    
	public void check();
    
    public List<String> summaryValues();

}