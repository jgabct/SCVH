package br.edu.ifs.academico.controllers;

import br.edu.ifs.academico.utils.Iregister;

public interface Icontroller {

	public <E extends Iregister>void execute(E view);
	
}
