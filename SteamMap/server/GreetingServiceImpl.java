package dajama.server;

import org.restlet.resource.ClientResource;

import dajama.client.GreetingService;
import dajama.shared.domain.giantBomb.GiantBomb;
import dajama.shared.domain.steam.SteamID;
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

	@Override
	public SteamID getSteamID() {
		ClientResource cr = new ClientResource("http://api.steampowered.com/ISteamApps/GetAppList/v2/");
		SteamID res = cr.get(SteamID.class);
		return res;
	}
	
}
