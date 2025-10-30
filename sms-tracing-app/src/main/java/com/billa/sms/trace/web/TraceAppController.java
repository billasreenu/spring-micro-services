package com.billa.sms.trace.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraceAppController {
	private static final Log logger = LogFactory.getLog(TraceAppController.class);

	@RequestMapping("/")
	String home() {
		logger.info("index url has been called");
		return "Hello World!";
	}

}
