package br.edu.ifs.academico.utils.enums;

import java.util.HashMap;
import java.util.Map;

public enum Post {

	NURSE ("NURSE") ,
	RECEPTIONIST ("RECEPTIONIST") ,
	ADMINISTRATOR ("ADMINISTRATOR") ;

	private final String post;
	
	private static final Map<String, Post> mapPost = new HashMap<>();
	
	static{
		for(Post postVar : Post.values()) {
			mapPost.put(postVar.get(), postVar);
		}
	}
	
	private Post(String post) {
		this.post = post;
	}

	public String get() {
	    return post;
	}
	
	public static Post find(String value){
		return mapPost.get(value);
	}
	
}
