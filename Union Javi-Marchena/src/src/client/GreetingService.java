package src.client;

import src.shared.domain.youtube.YoutubeSearch;
import src.shared.domain.giantBomb.GiantBombGame;
import src.shared.domain.giantBomb.GiantBombSearch;
import src.shared.domain.steam.SteamID;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	GiantBombSearch getGiantBomb(String juego);
	SteamID getSteamID();
	Double getSteamPrice(Integer id);
	 YoutubeSearch getYoutubeSearch(String juego);
	GiantBombGame getGiantBombGame(Integer idGB);
}
