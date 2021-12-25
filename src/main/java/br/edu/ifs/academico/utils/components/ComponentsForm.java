package br.edu.ifs.academico.utils.components;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import br.edu.ifs.academico.utils.FriendlyName;
import br.edu.ifs.academico.utils.InputLineCustomContainer;

public class ComponentsForm {
	
	public static <T> LinkedHashMap<FriendlyName, InputLineCustomContainer> getListFieldCreation(Class<T> typeClass) {
		return (Arrays.asList(typeClass.getDeclaredFields()).stream()
				.filter(trinket -> trinket.isAnnotationPresent(FriendlyName.class) == true)
				.collect(
						LinkedHashMap<FriendlyName, InputLineCustomContainer>::new,
						(map, trinket)-> map.put(
							trinket.getAnnotation(FriendlyName.class),
							new InputLineCustomContainer(
									trinket.getAnnotation(FriendlyName.class).value())
						),
						Map::putAll))
				.entrySet()
				.stream()
				.sorted((i1, i2) -> Integer.compare(i1.getKey().order(), i2.getKey().order()))
				.collect(
					Collectors.toMap(
							Map.Entry::getKey, Map.Entry::getValue,
							(e1, e2) -> e1, 
							LinkedHashMap::new
						)
				);	
	}
	
	public static <T> Object getObject(Class<T> clz, LinkedHashMap<FriendlyName, InputLineCustomContainer> list) {
		Object obj = null;
		try {
			obj = clz.getDeclaredConstructor().newInstance();
			
			for (Map.Entry<FriendlyName, InputLineCustomContainer> entry : list.entrySet()) {
				FriendlyName annot = entry.getKey();
				Method method = obj.getClass().getDeclaredMethod(annot.methodToSave(), annot.nameClassInput());
				method.invoke(obj, entry.getValue().getInputLineText());
			}
				
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | 
				InstantiationException | IllegalAccessException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;

	}
	
}
