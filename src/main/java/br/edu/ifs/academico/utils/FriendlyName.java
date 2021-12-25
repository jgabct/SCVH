package br.edu.ifs.academico.utils;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import br.edu.ifs.academico.utils.enums.EmployeeType;
import br.edu.ifs.academico.utils.enums.FieldType;

@Retention(RUNTIME)
@Target(ElementType.FIELD)
public @interface FriendlyName{
	String value();
	String methodToSave();
	Class<?> nameClassInput();
	@SuppressWarnings("exports")
	FieldType fieldType();
	@SuppressWarnings("exports")
	EmployeeType[] listItens() default {};
	int order();
}
