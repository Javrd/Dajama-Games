
package src.shared.domain.steam;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Applist {

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
