
package src.shared.domain.giantBomb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class Result implements Serializable{

    private String aliases;
    private String api_detail_url;
    private String date_added;
    private String date_last_updated;
    private String deck;
    private String description;
    private Integer expected_release_day;
    private Integer expected_release_month;
    private Integer expected_release_quarter;
    private Integer expected_release_year;
    private Integer id;
    private Image image;
    private String name;
    private Integer number_of_user_reviews;
    private List<Original_game_rating> original_game_rating = new ArrayList<Original_game_rating>();
    private String original_release_date;
    private List<Platform> platforms = new ArrayList<Platform>();
    private String site_detail_url;
    private String resource_type;

    /**
     * 
     * @return
     *     The aliases
     */
    public String getAliases() {
        return aliases;
    }

    /**
     * 
     * @param aliases
     *     The aliases
     */
    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

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
     *     The date_added
     */
    public String getDate_added() {
        return date_added;
    }

    /**
     * 
     * @param date_added
     *     The date_added
     */
    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    /**
     * 
     * @return
     *     The date_last_updated
     */
    public String getDate_last_updated() {
        return date_last_updated;
    }

    /**
     * 
     * @param date_last_updated
     *     The date_last_updated
     */
    public void setDate_last_updated(String date_last_updated) {
        this.date_last_updated = date_last_updated;
    }

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
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The expected_release_day
     */
    public Integer getExpected_release_day() {
        return expected_release_day;
    }

    /**
     * 
     * @param expected_release_day
     *     The expected_release_day
     */
    public void setExpected_release_day(Integer expected_release_day) {
        this.expected_release_day = expected_release_day;
    }

    /**
     * 
     * @return
     *     The expected_release_month
     */
    public Integer getExpected_release_month() {
        return expected_release_month;
    }

    /**
     * 
     * @param expected_release_month
     *     The expected_release_month
     */
    public void setExpected_release_month(Integer expected_release_month) {
        this.expected_release_month = expected_release_month;
    }

    /**
     * 
     * @return
     *     The expected_release_quarter
     */
    public Integer getExpected_release_quarter() {
        return expected_release_quarter;
    }

    /**
     * 
     * @param expected_release_quarter
     *     The expected_release_quarter
     */
    public void setExpected_release_quarter(Integer expected_release_quarter) {
        this.expected_release_quarter = expected_release_quarter;
    }

    /**
     * 
     * @return
     *     The expected_release_year
     */
    public Integer getExpected_release_year() {
        return expected_release_year;
    }

    /**
     * 
     * @param expected_release_year
     *     The expected_release_year
     */
    public void setExpected_release_year(Integer expected_release_year) {
        this.expected_release_year = expected_release_year;
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
     *     The number_of_user_reviews
     */
    public Integer getNumber_of_user_reviews() {
        return number_of_user_reviews;
    }

    /**
     * 
     * @param number_of_user_reviews
     *     The number_of_user_reviews
     */
    public void setNumber_of_user_reviews(Integer number_of_user_reviews) {
        this.number_of_user_reviews = number_of_user_reviews;
    }

    /**
     * 
     * @return
     *     The original_game_rating
     */
    public List<Original_game_rating> getOriginal_game_rating() {
        return original_game_rating;
    }

    /**
     * 
     * @param original_game_rating
     *     The original_game_rating
     */
    public void setOriginal_game_rating(List<Original_game_rating> original_game_rating) {
        this.original_game_rating = original_game_rating;
    }

    /**
     * 
     * @return
     *     The original_release_date
     */
    public String getOriginal_release_date() {
        return original_release_date;
    }

    /**
     * 
     * @param original_release_date
     *     The original_release_date
     */
    public void setOriginal_release_date(String original_release_date) {
        this.original_release_date = original_release_date;
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

    /**
     * 
     * @return
     *     The resource_type
     */
    public String getResource_type() {
        return resource_type;
    }

    /**
     * 
     * @param resource_type
     *     The resource_type
     */
    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

}
