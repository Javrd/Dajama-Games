
package src.shared.domain.giantBombGame;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class Image_ implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2520855890052059315L;
	public String icon_url;
    public String medium_url;
    public String screen_url;
    public String small_url;
    public String super_url;
    public String thumb_url;
    public String tiny_url;
    public String tags;

}
