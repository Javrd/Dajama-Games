package src.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;





import com.google.api.server.spi.response.BadRequestException;

@Path("/lists")
public class GameListResource {

	GameListResource repository;
	
	private GameListResource(){
		repository = new MapGameListResource();
	}
	
	@GET
	@Produces("application/json");
	public Collection<GameList> getAll(){
		return repository.getAll();
	}
	
	@GET
	@Path("/{name}")
	@Produces("application/json")
	public GameList get(@PathParam("name") String name){
		
		GameList list = repository.get(name);
		if(list == null){
			throw new NotFoundException("The GameList" + name + "was not found");
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGameList(@Context UriInfo uriInfo, GameList gameList){
		if(gameList.getName() == null) || "".equals(gameList.getName()))
		throw new BadRequestException("The name of the GameList must not be null");
		
		repository.put(gameList);
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(),"get");
		Uri uri = ub.build(gameList.getName());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(gameList);
		return resp.build();
	}
	
	@PUT
	@Path("/{gameListName}")
	@Consumes("application/json")
	public Response updateGameList(@PathParam("gameListName") String name, GameList gameList){
		
		GameList oldGameList = repository.get(name);
		if(oldGameList == null){
			throw new NotFoundException("The playlist " + name + "was not found");
		}
		
		if(!oldGameList.getName().equals(gameList.getName())){
			return Response.status(javax.ws.rs.core.Response.Status.CONFLICT).build();
		}
		
		repository.put(gameList);
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{gameListName"})
	public void removeGameList(@PathParam("listName") String name){
		GameList toberemoved = repository.get(name);
		if(toberemoved == null)
			throw new NotFoundException("The GameList" + name + "was not found");
		else
			repository.removeGameList(toberemoved);
}
