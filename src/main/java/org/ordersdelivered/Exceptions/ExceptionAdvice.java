package org.ordersdelivered.Exceptions;

import java.util.logging.Logger;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class ExceptionAdvice {

	Logger logger = Logger.getLogger(ExceptionAdvice.class.getName());

	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e, Model uiModel) {
		logger.info("error is" + e.getMessage());
		e.printStackTrace();
		return "error";
	}

	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public String resultNotFoundException(EmptyResultDataAccessException e, Model uiModel) {
		logger.info("error is" + e.getMessage());
		uiModel.addAttribute("exceptionOccurs",
				"Given Order-Id is not found in database,Please search your Id carefully.");
		return "error";
	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public String pageNotException(DataIntegrityViolationException e, Model uiModel) {
		logger.info("error is" + e.getMessage());
		uiModel.addAttribute("delete",
				"Cannot delete because You must delete the same Order id in the delivered_Updates table, then you be deleted the same Order id in the Orders table");
		return "error";
	}

}
