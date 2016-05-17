package src.domain;

import java.util.ArrayList;
import java.util.List;

import src.domain.Game;

public class GameList {

	private String name;
	private String description;
	private List<Game> games;
	
	public GameList() {games = new ArrayList<Game>();}
	
	protected void setGames(List<Game> list){
		games = list;
	}
	
	public GameList(String name){
		this.name = name;
		games = new ArrayList<Game>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Game> getGames() {
		return games;
	}
	
	public void addGame(Game s) {
		games.add(s);
	}
	
	public void removeGame(Game s) {
		games.remove(s);
	}
	
}
