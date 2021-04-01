package tn.Dari.spring.controller;




	import org.springframework.messaging.handler.annotation.MessageMapping;
	import org.springframework.messaging.handler.annotation.SendTo;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.util.HtmlUtils;

import tn.Dari.spring.entity.Greeting;
import tn.Dari.spring.entity.NotificationMessage;

	@Controller
	public class GreetingController {


	  @MessageMapping("/hello")
	  @SendTo("/topic/greetings")
	  public Greeting greeting(NotificationMessage message) throws Exception {
	    Thread.sleep(1000); // simulated delay
	    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	  }

	}


