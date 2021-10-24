package model.interfaces;

// Interface implementada por todas as entidades
// Ela permite com que metodos comuns que possuam uma estrutura especifica para cada entidade sejam executados pelo GenericOperations
public interface Ientity {

	// O metodo getKey retorna a chave primaria da entidade 
	public Object getKey();

}
