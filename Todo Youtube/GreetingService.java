package dajama.client;

import dajama.shared.domain.youtube.YoutubeSearch;
import dajama.shared.domain.giantBomb.GiantBomb;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	GiantBomb getGiantBomb(String juego);
	YoutubeSearch getYoutubeSearch(String juego);
}
