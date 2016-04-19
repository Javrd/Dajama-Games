package dajama.client;

import dajama.shared.domain.giantBomb.GiantBomb;
import dajama.shared.domain.youtube.YoutubeSearch;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void getGiantBomb(String juego, AsyncCallback<GiantBomb> callback);

	void getYoutubeSearch(String juego, AsyncCallback<YoutubeSearch> callback);
}
