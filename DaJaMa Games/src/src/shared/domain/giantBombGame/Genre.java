
package src.shared.domain.giantBombGame;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class Genre implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4635446086190606428L;
	public String api_detail_url;
    public Integer id;
    public String name;
    public String site_detail_url;

}