package src.client;

import src.shared.domain.giantBomb.GiantBomb;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void getGiantBomb(String juego, AsyncCallback<GiantBomb> callback);
}
