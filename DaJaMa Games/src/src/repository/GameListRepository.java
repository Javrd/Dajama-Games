package src.repository;

import java.util.Collection;

import src.domain.GameList;


public interface GameListRepository {
	public Collection<GameList> getAll();
	public void put(GameList p);
	public GameList get(String name);
	public void remove(GameList p);
	public boolean contains(GameList p);
}
