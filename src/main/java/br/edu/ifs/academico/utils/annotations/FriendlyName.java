package br.edu.ifs.academico.utils.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(ElementType.FIELD)
public @interface FriendlyName{
	String value();
	String methodToSave();
	Class<?> nameClassInput();
	@SuppressWarnings("exports")
	int order();
}
