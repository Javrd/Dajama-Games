package src.client;

import src.shared.domain.youtube.YoutubeSearch;
import src.shared.domain.giantBomb.GiantBomb;
import src.shared.domain.giantBombGame.GiantBombGame;
import src.shared.domain.steam.SteamID;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void getGiantBomb(String juego, AsyncCallback<GiantBomb> callback);

	void getSteamID(AsyncCallback<SteamID> callback);

	void getSteamPrice(Integer id, AsyncCallback<Double> callback);
	
	void getYoutubeSearch(String juego, AsyncCallback<YoutubeSearch> callback);

	void getGiantBombGame(Integer idGB, AsyncCallback<GiantBombGame> asyncCallback);
}
