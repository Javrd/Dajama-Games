package src.server;

import org.restlet.resource.ClientResource;

import src.client.GreetingService;
import src.shared.domain.giantBomb.GiantBomb;
import src.shared.domain.steam.SteamID;

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
		//System.out.println(cr.get(String.class));
		GiantBomb res = cr.get(GiantBomb.class);
		return res;
	}

	@Override
	public SteamID getSteamID() {
		ClientResource cr = new ClientResource("http://api.steampowered.com/ISteamApps/GetAppList/v0001/");
		SteamID res = cr.get(SteamID.class);
		return res;
	}

	@Override
	public Double getSteamPrice(Integer id) {
		ClientResource cr = new ClientResource("http://store.steampowered.com/api/appdetails?appids="+id+"&filters=price_overview");
		String res = cr.get(String.class);
		Double res2 = Integer.parseInt(res.split(",")[3].split(":")[1])/100.;
		return res2;
	}
}
