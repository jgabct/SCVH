package br.edu.ifs.academico.application;

import br.edu.ifs.academico.model.entities.Employee;
import br.edu.ifs.academico.model.entities.Sector;
import br.edu.ifs.academico.model.services.EMFactory;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.enums.Post;

public class Testlog {

	public static void main(String[] args) {

		
		GenericOperations<Employee> go = new GenericOperations<>(Employee.class);

		Employee emp = new Employee();
		
		emp.setRegistration("A500");
		emp.setName("MARCOS");
		emp.setPassword("113355");
		emp.setPost(Post.ADMINISTRATOR);
		
		Sector sec = new Sector();
		sec.setKey("124");
		
		
		emp.setSector(sec );
		go.register(emp);
		
		go.endOperations();
	
		
		EMFactory.closeEntityManagerFactory();	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		//OBS: ESSA É UMA CLASSE FEITA SOMENTE PARA DEBUG
		// NA COMPILAÇÃO FINAL ELA SERÁ DELETAD
		
//		Object obj = Employee.class.getConstructor().newInstance();
//		
//		((Employee)obj).setPost(EmployeeType.NURSE);
//		
//		for (Iterator<EmployeeType> itr = List.of(EmployeeType.values()).iterator(); itr.hasNext(); ){
//			System.err.println(itr.next().toString());
//		}
//
//		for(Field field : Employee.class.getDeclaredFields()) {
//			
//			if(field.isAnnotationPresent(ItIsABox.class)) {
////				Class<?> clazz = Class.forName(field.getType().getName());
////				clazz.getMethod("summaryValues").invoke(clazz.getConstructor().newInstance());
//				
//				if(field.getType().isEnum()) {
//					
//					field.setAccessible(true);
//					
////					Enum<?> oldValue = (Enum<?>) ;
//					
//					System.out.println("//////");
//					for(Field interField : field.getType().getDeclaredFields()){
////						if(interField.isEnumConstant()) {
//							System.out.println(interField.getName());
////						}
//					}
//					
//					field.set(obj, EmployeeType.ADMINISTRATOR);
//					
//
//					
//				}
//				                           
//					
//			}
//
//		}

//		System.out.println(((Employee)obj).getPost());
		
	}

}
////	 try {
////         Class<? extends Object> clazz = obj1.getClass();
////         for (Method m : clazz.getDeclaredMethods()) {
////                if (m.isAnnotationPresent(Function.class)){
////                	Function fun = m.getAnnotation(Function.class);
////                	if(br.edu.ifs.academico.utils.annotations.Function.Method.SET == fun.method()){
////                		System.out.println(m.getName()+": "+m.getParameterTypes()[0]);
////                		if(String.class == m.getParameterTypes()[0]) {
////                			m.invoke(obj2, "test");
////                		}
////                	}
////               }
////         }
////   }
//
////	try {
////        Class<?> clazz = obj1.getClass();
////        for(Field f : clazz.getDeclaredFields()){
////             f.setAccessible(true);
////             String t = f.getName();
////             t = "get" + t.substring(0, 1).toUpperCase() + t.substring(1, t.length());
////             Method met = clazz.getDeclaredMethod(t);
////             System.out.println(met.invoke(obj1));
////        }
////  }
//	
//    public static void main(final String[] args)
//    {
//        StrawManParameterizedClass<Employee> smpc = new StrawManParameterizedClass<Employee>() {};
//        smpc.get();
//        System.out.println(SystemObjects.takeObjectByClass(smpc.type.getRawType()));
//    }
//
//    static abstract class StrawManParameterizedClass<T>
//    {
//    	final TypeToken<T> type = new TypeToken<T>(getClass()) {
//			private static final long serialVersionUID = 1L;
//		};
//		
//		public void get() {
//			System.out.println(type.getRawType());
//		}
//			
//    }
//		
//}
//		
//		
//		
//	
//		
////		Bed b = new Bed("123456789", "01", "room#12");
//
////		System.out.println(b.toString());
////		System.out.println();
////		verDetalhesDoObjeto(b);
////		System.out.println();
////		System.out.println(b.toString());
//
//
//	
//	//+m.invoke(obj)+
////	public static void verDetalhesDoObjeto(Object obj1) {
////			try {
////			      Class<?> clazz = obj1.getClass();
////			      for(Field f : clazz.getDeclaredFields()){
////			           f.setAccessible(true);
////			           String t = f.getName();
////			           t = "get" + t.substring(0, 1).toUpperCase() + t.substring(1, t.length());
////			           Method met = clazz.getDeclaredMethod(t);
////			           System.out.println(met.invoke(obj1));
////			      }
////			}catch (Exception e) {
////	             e.printStackTrace();
////	       }
////	}
//
// 