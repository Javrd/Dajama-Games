
package src.shared.domain.giantBomb;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class GiantBombGame implements Serializable{

    private String error;
    private Integer limit;
    private Integer offset;
    private Integer number_of_page_results;
    private Integer number_of_total_results;
    private Integer status_code;
    private Results results;
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
     *     The number_of_page_results
     */
    public Integer getNumber_of_page_results() {
        return number_of_page_results;
    }

    /**
     * 
     * @param number_of_page_results
     *     The number_of_page_results
     */
    public void setNumber_of_page_results(Integer number_of_page_results) {
        this.number_of_page_results = number_of_page_results;
    }

    /**
     * 
     * @return
     *     The number_of_total_results
     */
    public Integer getNumber_of_total_results() {
        return number_of_total_results;
    }

    /**
     * 
     * @param number_of_total_results
     *     The number_of_total_results
     */
    public void setNumber_of_total_results(Integer number_of_total_results) {
        this.number_of_total_results = number_of_total_results;
    }

    /**
     * 
     * @return
     *     The status_code
     */
    public Integer getStatus_code() {
        return status_code;
    }

    /**
     * 
     * @param status_code
     *     The status_code
     */
    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    /**
     * 
     * @return
     *     The results
     */
    public Results getResults() {
        return results;
    }

    /**
     * 
     * @param results
     *     The results
     */
    public void setResults(Results results) {
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
