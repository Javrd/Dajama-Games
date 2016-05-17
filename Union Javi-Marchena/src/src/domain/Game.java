package src.domain;

public class Game {

	private String name;
	private Integer score;
	
	public Game(){}
	
	public Game(String name, Integer score){
		this.name = name;
		this.score = score;
	}
	
	public String getName(){
		return name;
	}
	
	public Integer getScore(){
		return score;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public void setScore(Integer s){
		this.score = s;
	}
	
	
}
