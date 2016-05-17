
package src.shared.domain.giantBombGame;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class Image implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4098497484963743948L;
	public String icon_url;
    public String medium_url;
    public String screen_url;
    public String small_url;
    public String super_url;
    public String thumb_url;
    public String tiny_url;

}
