package com.springboot.logger.controller;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

	Logger logger = LogManager.getLogger(LoggingController.class);

	@GetMapping("/")
	private String loggerMessage() {

		logger.trace("Log Level:TRACE");
		logger.info("Log Level:INFO");
		logger.debug("Log Level:DEBUG");
		logger.error("Log Level:ERROR");
		logger.fatal("Log Level:FATAL");
		logger.warn("Log Level:WARN");

		return "Hey!, You can check the log output's at Console & File";
	}

	@GetMapping("/message")
	private String loggerConditionMessage() {
		if (logger.isFatalEnabled()) {
			logger.fatal("Log Level:FATAL");
		}

		return "Hey!, You can check the log output at Console & File";
	}

//    Logger logger = LoggerFactory.getLogger(LoggingController.class); /* It is sl4j2 Example*/
//    
//    @RequestMapping("/message")
//     private String loggerMessage(){
//		
//	      logger.trace("Log Level:TRACE");
//        logger.info("Log Level:INFO");
//        logger.debug("Log Level:DEBUG");
//        logger.error("Log Level:ERROR");
//        logger.warn("Log Level:WARN");	
//      
//		  return "Hey!, You can check the log output's at Console & File";
//	}

}
