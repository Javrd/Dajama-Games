package dajama.server;

import org.restlet.resource.ClientResource;

import dajama.shared.domain.youtube.YoutubeSearch;
import dajama.client.GreetingService;
import dajama.shared.domain.giantBomb.GiantBomb;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	@Override
	public GiantBomb getGiantBomb(String juego) {
		ClientResource cr = new ClientResource("http://www.giantbomb.com/api/search/?api_key=878eb07d37b3f10431cf81057b33390df26d8390&format=json&query=\""+juego+"\"&resources=game");
		GiantBomb res = cr.get(GiantBomb.class);
		return res;
	}
	
	public YoutubeSearch getYoutubeSearch(String juego){
		ClientResource cr = new ClientResource("https://www.googleapis.com/youtube/v3/search?part=snippet&key=AIzaSyD77694C-yaK1scKDrT2Oqx8SPh6Vhe2uM&q=Gameplay "+juego);
		YoutubeSearch res = cr.get(YoutubeSearch.class);
		return res;
	}
	
}
