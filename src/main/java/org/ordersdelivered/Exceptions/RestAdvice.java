package org.ordersdelivered.Exceptions;

import java.util.logging.Logger;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestAdvice {

	Logger logger = Logger.getLogger(RestAdvice.class.getName());

	@ExceptionHandler(EmptyResultDataAccessException.class) // search_By_Id (Order_ID Not Found )
	public ResponseEntity<ErrorDetails> resultNotFoundException(EmptyResultDataAccessException ex, WebRequest request) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "406",
				"Order id is not found in the database, Please Enter valid Order id", request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(DataIntegrityViolationException.class) // Delete Exception
	public ResponseEntity<ErrorDetails> deleteException(DataIntegrityViolationException ex, WebRequest request) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "405",
				"Cannot delete because You must delete the same Order id in the delivered_Updates(2nd domain) table, then you be deleted the same Order id(1st domain) in the Items_Booked table",
				request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(error, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(Exception.class) // All General Exception Handling
	public ResponseEntity<ErrorDetails> Exception(Exception ex, WebRequest request) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "500", "Some Thing Went Wrong",
				request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * @ExceptionHandler(NoHandlerFoundException.class) // Enter Wrong URl public
	 * ResponseEntity<ErrorDetails> NoHandlerFoundException(NoHandlerFoundException
	 * ex, WebRequest request){ ErrorDetails error = new
	 * ErrorDetails(ex.getMessage(), "404",
	 * "Page not found,This means the URL is not recognized,Please Enter Correct URl"
	 * , request.getDescription(false));
	 * 
	 * return new ResponseEntity<ErrorDetails>(error ,HttpStatus.NOT_FOUND); }
	 */

}
