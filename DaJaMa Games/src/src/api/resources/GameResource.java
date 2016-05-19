package src.api.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import com.sun.corba.se.spi.activation.Repository;

import src.api.exceptions.AlreadyExistsException;
import src.domain.Game;
import src.domain.GameList;


@Path("lists/{GameListName}/games")
public class GameResource {

	public static GameResource _instance=null;
	
	private GameResource(){}
	
	public static GameResource getInstance(){
		
		if(_instance==null)
			_instance=new GameResource();
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public List<Game> getAllGames(@PathParam("GameListName") String gameListName){
		
		List<Game> result=null;
		GameList playlist = GameListResource.getInstance().get(gameListName);
		if(playlist!=null){
			result = playlist.getGames();
		}else{
			throw new NotFoundException("GameList " +gameListName + " not found");
		}
		
		return result;
		
	}
	
	@GET
	@Path("/{gameName}")
	@Produces("application/json")
	public Game getGame(@PathParam("GameListName") String gameListName, @PathParam("gameName")String gameName)
	{
		boolean hayResul = false;
		Game result = null;
		List<Game> pl = getAllGames(gameListName);
		if(pl!=null){
			for(Game s: pl){
				if(gameName.equalsIgnoreCase(s.getName())){
					hayResul = true;
					result = s;
					break;
				}
			}
		}else{
			throw new NotFoundException("GameList not found");
		}
		if(hayResul == false){
			throw new NotFoundException("Game not found");
		}
		return result;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGame(@Context UriInfo uriInfo,@PathParam("GameListName") String gameListName, Game game)
	{	GameList pl = null;
		if(game.getName()==null || game.getName().equals("")){
			throw new BadRequestException("The name of the Game must not be null");
		}else{
			pl = GameListResource.getInstance().get(gameListName);
			if(searchGame(pl, game.getName())==null){
				pl.getGames().add(game);
			}else{
				throw new AlreadyExistsException("Este juego ya está en la lista");
			}
		}
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(pl.getName());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(pl);		
		
		return resp.build();
	}
	
	@PUT
	@Path("/{gameName}")
	@Consumes("application/json")
	public Response updateSong(@Context UriInfo uriInfo,@PathParam("GameListName") String gameListName, @PathParam("gameName") String gameName,Game game)
	{
		GameList pl = GameListResource.getInstance().get(gameListName);
		Game g = searchGame(pl, game.getName());
		if(g==null){
			throw new NotFoundException("GameList not found");
		}else{
			g=game;
		}

		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{gameName}")
	public void removeSong(@PathParam("GameListName") String gameListName, @PathParam("gameName") String gameName) 
	{
		GameList gl = GameListResource.getInstance().get(gameListName);
		Game g = searchGame(gl, gameName);
		if(g==null){
			throw new NotFoundException("The game "+ gameName +"was not found.");
		}else{
			gl.removeGame(g);
		}	
		
	}
	
	private Game searchGame(GameList gl, String game){
		Game res = null;
		for(Game a: gl.getGames()){
			if(game.equalsIgnoreCase(a.getName())){
				res=a;
				break;
			}
		}
		return res;
	}
}
