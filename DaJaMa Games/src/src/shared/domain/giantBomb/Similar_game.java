
package src.shared.domain.giantBomb;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Similar_game implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8879470082636088472L;
	private String api_detail_url;
    private Integer id;
    private String name;
    private String site_detail_url;

    /**
     * 
     * @return
     *     The api_detail_url
     */
    public String getApi_detail_url() {
        return api_detail_url;
    }

    /**
     * 
     * @param api_detail_url
     *     The api_detail_url
     */
    public void setApi_detail_url(String api_detail_url) {
        this.api_detail_url = api_detail_url;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * 
     * @return
     *     The site_detail_url
     */
    public String getSite_detail_url() {
        return site_detail_url;
    }

    /**
     * 
     * @param site_detail_url
     *     The site_detail_url
     */
    public void setSite_detail_url(String site_detail_url) {
        this.site_detail_url = site_detail_url;
    }

}
