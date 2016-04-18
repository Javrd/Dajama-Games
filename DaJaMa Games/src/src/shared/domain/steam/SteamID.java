
package src.shared.domain.steam;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class SteamID implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
