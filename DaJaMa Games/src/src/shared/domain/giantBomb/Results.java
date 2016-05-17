
package src.shared.domain.giantBomb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Results implements Serializable{

    private String deck;
    private Image image;
    private String name;
    private List<Platform> platforms = new ArrayList<Platform>();
    private List<Image_> images = new ArrayList<Image_>();
    private List<Genre> genres = new ArrayList<Genre>();
    private List<Similar_game> similar_games = new ArrayList<Similar_game>();

    /**
     * 
     * @return
     *     The deck
     */
    public String getDeck() {
        return deck;
    }

    /**
     * 
     * @param deck
     *     The deck
     */
    public void setDeck(String deck) {
        this.deck = deck;
    }

    /**
     * 
     * @return
     *     The image
     */
    public Image getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(Image image) {
        this.image = image;
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
     *     The platforms
     */
    public List<Platform> getPlatforms() {
        return platforms;
    }

    /**
     * 
     * @param platforms
     *     The platforms
     */
    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    /**
     * 
     * @return
     *     The images
     */
    public List<Image_> getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(List<Image_> images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The genres
     */
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * 
     * @param genres
     *     The genres
     */
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
     * 
     * @return
     *     The similar_games
     */
    public List<Similar_game> getSimilar_games() {
        return similar_games;
    }

    /**
     * 
     * @param similar_games
     *     The similar_games
     */
    public void setSimilar_games(List<Similar_game> similar_games) {
        this.similar_games = similar_games;
    }

}
