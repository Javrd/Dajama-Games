package src.api.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.jboss.resteasy.spi.LoggableFailure;

public class AlreadyExistsException extends LoggableFailure{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5044830368218536690L;

	public AlreadyExistsException(String s) {
		super(s, 444);
		
	}

}
