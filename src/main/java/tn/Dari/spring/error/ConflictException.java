package tn.Dari.spring.error;

import org.springframework.http.HttpStatus;

/**
 * @author Khalid Elshafie <abolkog@gmail.com>
 * @Created 18/09/2018 10:43 PM.
 */
public class ConflictException extends ApiBaseException {

   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
