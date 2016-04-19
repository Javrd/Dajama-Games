
package src.shared.domain.steam;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SteamID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1793668734967446373L;
	private Applist applist;

    /**
     * 
     * @return
     *     The applist
     */
    public Applist getApplist() {
        return applist;
    }

    /**
     * 
     * @param applist
     *     The applist
     */
    public void setApplist(Applist applist) {
        this.applist = applist;
    }

}
