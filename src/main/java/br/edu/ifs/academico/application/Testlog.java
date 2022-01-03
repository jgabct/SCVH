package br.edu.ifs.academico.application;

import com.google.common.reflect.TypeToken;

import br.edu.ifs.academico.model.entities.Employee;
import br.edu.ifs.academico.utils.enums.SystemObjects;

public class Testlog {
//	 try {
//         Class<? extends Object> clazz = obj1.getClass();
//         for (Method m : clazz.getDeclaredMethods()) {
//                if (m.isAnnotationPresent(Function.class)){
//                	Function fun = m.getAnnotation(Function.class);
//                	if(br.edu.ifs.academico.utils.annotations.Function.Method.SET == fun.method()){
//                		System.out.println(m.getName()+": "+m.getParameterTypes()[0]);
//                		if(String.class == m.getParameterTypes()[0]) {
//                			m.invoke(obj2, "test");
//                		}
//                	}
//               }
//         }
//   }

//	try {
//        Class<?> clazz = obj1.getClass();
//        for(Field f : clazz.getDeclaredFields()){
//             f.setAccessible(true);
//             String t = f.getName();
//             t = "get" + t.substring(0, 1).toUpperCase() + t.substring(1, t.length());
//             Method met = clazz.getDeclaredMethod(t);
//             System.out.println(met.invoke(obj1));
//        }
//  }
	
    public static void main(final String[] args)
    {
        StrawManParameterizedClass<Employee> smpc = new StrawManParameterizedClass<Employee>() {};
        smpc.get();
        System.out.println(SystemObjects.takeObjectByClass(smpc.type.getRawType()));
    }

    static abstract class StrawManParameterizedClass<T>
    {
    	final TypeToken<T> type = new TypeToken<T>(getClass()) {
			private static final long serialVersionUID = 1L;
		};
		
		public void get() {
			System.out.println(type.getRawType());
		}
			
    }
		
}
		
		
		
	
		
//		Bed b = new Bed("123456789", "01", "room#12");

//		System.out.println(b.toString());
//		System.out.println();
//		verDetalhesDoObjeto(b);
//		System.out.println();
//		System.out.println(b.toString());


	
	//+m.invoke(obj)+
//	public static void verDetalhesDoObjeto(Object obj1) {
//			try {
//			      Class<?> clazz = obj1.getClass();
//			      for(Field f : clazz.getDeclaredFields()){
//			           f.setAccessible(true);
//			           String t = f.getName();
//			           t = "get" + t.substring(0, 1).toUpperCase() + t.substring(1, t.length());
//			           Method met = clazz.getDeclaredMethod(t);
//			           System.out.println(met.invoke(obj1));
//			      }
//			}catch (Exception e) {
//	             e.printStackTrace();
//	       }
//	}

 