package exepctions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)

public class ExceptionHandle extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityVilationException( DataIntegrityViolationException e){
		
		String m = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
		
		String error = "Unable to add employee" + m;
		return buildEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
	}
	
	private ResponseEntity<Object> buildEntity(ErrorResponse e){
		return new ResponseEntity<Object>(e, e.getStat());
	}
	
}
