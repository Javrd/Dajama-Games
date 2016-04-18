
package src.shared.domain.steam;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class Apps implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<App> app = new ArrayList<App>();

    /**
     * 
     * @return
     *     The app
     */
    public List<App> getApp() {
        return app;
    }

    /**
     * 
     * @param app
     *     The app
     */
    public void setApp(List<App> app) {
        this.app = app;
    }

}
