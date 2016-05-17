package src.client;

import src.shared.domain.youtube.YoutubeSearch;
import src.shared.domain.giantBomb.GiantBombGame;
import src.shared.domain.giantBomb.GiantBombSearch;
import src.shared.domain.steam.SteamID;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void getGiantBomb(String juego, AsyncCallback<GiantBombSearch> callback);

	void getSteamID(AsyncCallback<SteamID> callback);

	void getSteamPrice(Integer id, AsyncCallback<Double> callback);
	
	void getYoutubeSearch(String juego, AsyncCallback<YoutubeSearch> callback);

	void getGiantBombGame(Integer idGB, AsyncCallback<GiantBombGame> asyncCallback);
}
