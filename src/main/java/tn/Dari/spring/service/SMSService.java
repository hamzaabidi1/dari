package tn.Dari.spring.service;
import com.twilio.Twilio;
import com.twilio.exception.AuthenticationException;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class SMSService {
	 public static final String ACCOUNT_SID = "AC28611f25b9445969262b0c6ef59dedc4";
	    public static final String AUTH_TOKEN = "7122fface877d2a2dea0efb87c3a82ab";

	    static {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	     }

	    public static void send(String phoneNumber, String message) throws TwilioException {
	        Message.creator(new PhoneNumber("+216" + phoneNumber), new PhoneNumber("+1 760 624 3919"), message).create();
	    }

		
}
