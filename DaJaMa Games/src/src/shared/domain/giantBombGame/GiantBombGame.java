
package src.shared.domain.giantBombGame;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class GiantBombGame implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7503631817738417507L;
	public String error;
    public Integer limit;
    public Integer offset;
    public Integer number_of_page_results;
    public Integer number_of_total_results;
    public Integer status_code;
    public Results results;
    public String version;

}
