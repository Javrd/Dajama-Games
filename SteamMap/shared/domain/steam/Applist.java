
package dajama.shared.domain.steam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Applist implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4071939062274399430L;
	private List<App> apps = new ArrayList<App>();

    /**
     * 
     * @return
     *     The apps
     */
    public List<App> getApps() {
        return apps;
    }

    /**
     * 
     * @param apps
     *     The apps
     */
    public void setApps(List<App> apps) {
        this.apps = apps;
    }

}
