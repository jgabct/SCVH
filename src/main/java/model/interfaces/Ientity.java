package br.edu.ifs.academico.model.interfaces;

// Interface implementada por todas as entidades
// Ela permite com que metodos comuns que possuam uma estrutura especifica para cada entidade sejam executados pelo GenericOperations
public interface Ientity {

	// O metodo getKey retorna a chave primaria da entidade 
	public Object getKey();

	// O metodo alter é responsavel por alterar os dados das entidades
	// OBS: Ele não altera a Primary Key (Por causa que não é recomendado em geral alterar uma chave primaria)
	public <E> void alter(E args);
	
}
