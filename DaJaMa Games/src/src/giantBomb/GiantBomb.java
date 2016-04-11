
package src.giantBomb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class GiantBomb {

    private String error;
    private Integer limit;
    private Integer offset;
    private Integer numberOfPageResults;
    private Integer numberOfTotalResults;
    private Integer statusCode;
    private List<Result> results = new ArrayList<Result>();
    private String version;

    /**
     * 
     * @return
     *     The error
     */
    public String getError() {
        return error;
    }

    /**
     * 
     * @param error
     *     The error
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * 
     * @return
     *     The limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * 
     * @param limit
     *     The limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * 
     * @return
     *     The offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 
     * @param offset
     *     The offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * 
     * @return
     *     The numberOfPageResults
     */
    public Integer getNumberOfPageResults() {
        return numberOfPageResults;
    }

    /**
     * 
     * @param numberOfPageResults
     *     The number_of_page_results
     */
    public void setNumberOfPageResults(Integer numberOfPageResults) {
        this.numberOfPageResults = numberOfPageResults;
    }

    /**
     * 
     * @return
     *     The numberOfTotalResults
     */
    public Integer getNumberOfTotalResults() {
        return numberOfTotalResults;
    }

    /**
     * 
     * @param numberOfTotalResults
     *     The number_of_total_results
     */
    public void setNumberOfTotalResults(Integer numberOfTotalResults) {
        this.numberOfTotalResults = numberOfTotalResults;
    }

    /**
     * 
     * @return
     *     The statusCode
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * 
     * @param statusCode
     *     The status_code
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * 
     * @return
     *     The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * 
     * @param results
     *     The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     * 
     * @return
     *     The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

}
