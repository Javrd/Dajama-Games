package src.server;

import org.restlet.resource.ClientResource;

import src.client.GreetingService;
import src.shared.domain.giantBomb.GiantBombGame;
import src.shared.domain.giantBomb.GiantBombSearch;
import src.shared.domain.steam.SteamID;
import src.shared.domain.youtube.YoutubeSearch;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	@Override
	public GiantBombSearch getGiantBomb(String juego) {
		ClientResource cr = new ClientResource("http://www.giantbomb.com/api/search/?api_key=878eb07d37b3f10431cf81057b33390df26d8390&format=json&query=\""+juego+"\"&resources=game");
		//System.out.println(cr.get(String.class));
		GiantBombSearch res = cr.get(GiantBombSearch.class);
		return res;
	}

	@Override
	public SteamID getSteamID() {
		ClientResource cr = new ClientResource("http://api.steampowered.com/ISteamApps/GetAppList/v2/");
		SteamID res = cr.get(SteamID.class);
		return res;
	}

	@Override
	public Double getSteamPrice(Integer id) {
		Double res = null;
		ClientResource cr = new ClientResource("http://store.steampowered.com/api/appdetails?appids="+id+"&filters=price_overview");
		String str = cr.get(String.class);
		if (!str.equals("null"))
			res = Integer.parseInt(str.split(",")[3].split(":")[1])/100.;
		return res;
	}
	
	public YoutubeSearch getYoutubeSearch(String juego){
		ClientResource cr = new ClientResource("https://www.googleapis.com/youtube/v3/search?part=snippet&key=AIzaSyD77694C-yaK1scKDrT2Oqx8SPh6Vhe2uM&q=Gameplay "+juego);
		YoutubeSearch res = cr.get(YoutubeSearch.class);
		return res;
	}

	@Override
	public GiantBombGame getGiantBombGame(Integer idGB) {
		ClientResource cr = new ClientResource("http://www.giantbomb.com/api/game/"+idGB+"/?api_key=878eb07d37b3f10431cf81057b33390df26d8390&format=json&field_list=genres,name,deck,image,images,platforms,similar_games");
		GiantBombGame gb = cr.get(GiantBombGame.class);
		return gb;
	}
}
