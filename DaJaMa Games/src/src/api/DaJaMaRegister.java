package src.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import src.api.resources.GameListResource;
import src.api.resources.GameResource;

public class DaJaMaRegister extends Application{

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public DaJaMaRegister(){
		singletons.add(GameListResource.getInstance());
		singletons.add(GameResource.getInstance());
	}
	
	public Set<Class<?>> getClasses(){
		return classes;
	}
	
	public Set<Object> getSingletons(){
		return singletons;
	}
}
