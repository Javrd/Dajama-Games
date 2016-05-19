package src.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import src.domain.GameList;

public class MapGameListRepository implements GameListRepository{

	Map<String,GameList> gameListMap;
	
	public MapGameListRepository(){
		gameListMap = new HashMap<String,GameList>();
	}
	
	
	@Override
	public Collection<GameList> getAll() {
		// TODO Auto-generated method stub
		return gameListMap.values();
	}

	@Override
	public void put(GameList p) {
		// TODO Auto-generated method stub
		
		gameListMap.put(p.getName(), p);
	}

	@Override
	public GameList get(String name) {
		// TODO Auto-generated method stub
		return gameListMap.get(name);
	}

	@Override
	public void remove(GameList p) {
		// TODO Auto-generated method stub
		gameListMap.remove(p.getName());
	}
	
	public boolean contains(GameList p){
		return gameListMap.containsKey(p.getName());
	}

}
