
package src.shared.domain.giantBombGame;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class Similar_game implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -6038392559306439687L;
	public String api_detail_url;
    public Integer id;
    public String name;
    public String site_detail_url;

}
