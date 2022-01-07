package br.edu.ifs.academico.utils;

import java.util.List;
import java.util.stream.Collectors;

public class IdentityOfEnumerators {

	public static <E extends Enum <E>> List<E> foo(Class<E> elemType) {

		return java.util.EnumSet.allOf(elemType).stream().collect(Collectors.toList());

	 }
	
}
