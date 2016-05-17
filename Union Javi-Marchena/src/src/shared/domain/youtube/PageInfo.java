
package src.shared.domain.youtube;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class PageInfo implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer totalResults;
    private Integer resultsPerPage;

    /**
     * 
     * @return
     *     The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * 
     * @param totalResults
     *     The totalResults
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * 
     * @return
     *     The resultsPerPage
     */
    public Integer getResultsPerPage() {
        return resultsPerPage;
    }

    /**
     * 
     * @param resultsPerPage
     *     The resultsPerPage
     */
    public void setResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

}
