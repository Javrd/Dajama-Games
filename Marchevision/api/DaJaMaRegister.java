package src.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import src.api.resources.GameListResource;

public class DaJaMaRegister extends Application{

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public DaJaMaRegister(){
		singletons.add(new GameListResource());
	}
	
	public Set<Class<?>> getClasses(){
		return classes;
	}
	
	public Set<Object> getSingletons(){
		return singletons;
	}
}
