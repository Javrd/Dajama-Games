
package src.shared.domain.steam;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class Applist implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Apps apps;

    /**
     * 
     * @return
     *     The apps
     */
    public Apps getApps() {
        return apps;
    }

    /**
     * 
     * @param apps
     *     The apps
     */
    public void setApps(Apps apps) {
        this.apps = apps;
    }

}
