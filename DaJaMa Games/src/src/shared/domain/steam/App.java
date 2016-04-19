
package src.shared.domain.steam;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class App {

    private Integer appid;
    private String name;

    /**
     * 
     * @return
     *     The appid
     */
    public Integer getAppid() {
        return appid;
    }

    /**
     * 
     * @param appid
     *     The appid
     */
    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

}
