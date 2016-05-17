
package src.shared.domain.giantBombGame;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class Results implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3506288370090148590L;
	public String deck;
    public Image image;
    public String name;
    public List<Platform> platforms = new ArrayList<Platform>();
    public List<Image_> images = new ArrayList<Image_>();
    public List<Genre> genres = new ArrayList<Genre>();
    public List<Similar_game> similar_games = new ArrayList<Similar_game>();

}
