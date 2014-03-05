package easyrec.poc.client;

import java.net.URI;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import easyrec.poc.client.entity.EasyrecResponse;

//TODO: refactor parameter parsing and validation

@Component
public class RestClientImpl implements RestClient {
	private static final Logger log = Logger.getLogger(RestClient.class);
	
	private String baseUrl;
	private String tenantId;
	private String login;
	private String password;
	private String itemId;
	private String description;
	private String itemUrl;
	private String action;
	private String userId;
	private String sessionId;
	private String apiKey;
	
	private Operation op;
	private Map<String, String> params = new HashMap<String, String>();
	RestTemplate template = new RestTemplate();

	
	@Override
	public void run(String[] args) {
		parseArgs(args);
		validateArgs();
		fillCallParameters();
		login();
		fillCallParameters();
		
		switch(op) {
			case VIEW: 
			case BUY: 
			case RATE:
			case SHARE:
					doAddAction();
					break;
			case RECOMMEND:
					doRecommendAction();
					break;
		}
	}

	private void doRecommendAction() {
		throw new UnsupportedOperationException();
	}

	private void doAddAction() {
		//TODO: test with failure!!!
		//TODO: parse complete response in case of success
		String url = baseUrl + "/api/1.0/sendaction?actiontype={action}&apikey={apiKey}&tenantid={tenantId}&sessionid={sessionId}&itemid={itemId}&itemdescription={description}&itemurl={itemUrl}&userid={userId}";
//		EasyrecResponse response = template.getForObject(url, EasyrecResponse.class, params);
//		log.info(response.getResponseCode().getMessage());
		Object response = template.getForObject(url, String.class, params);
		log.info(response.toString());
	}

	private void fillCallParameters() {
		params.put("tenantId", tenantId);
		params.put("login", login);
		params.put("password", password);
		params.put("itemId", itemId);
		params.put("description", description);
		params.put("itemUrl", itemUrl);
		params.put("action", action);
		params.put("userId", userId);
		params.put("sessionId", sessionId);
		params.put("apiKey", apiKey);
	}

	private void login() {
		String url = baseUrl + "/operator/signin?operatorId={login}&password={password}";
		EasyrecResponse response = template.getForObject(url, EasyrecResponse.class, params);

		//TODO: test with login failure
		log.info(response.getResponseCode().getMessage());
		if (response.getResponseCode().getCode() != ResponseCodes.SUCCESS) {
			log.info(response.getResponseCode().getCode());
		}
		
		sessionId = response.getToken();
	}

	private void validateArgs() {
		if (action == null) {
			throw new InvalidParameterException("Action must be defined");
		}
		op = Operation.valueOf(action.toUpperCase());
		if (baseUrl == null) {
			throw new InvalidParameterException("Base URL must be defined");
		}
		URI.create(baseUrl);
		if (login == null) {
			throw new InvalidParameterException("Login must be defined");
		}
		if (apiKey == null) {
			throw new InvalidParameterException("API Key must be defined");
		}
		if (password == null) {
			throw new InvalidParameterException("Password must be defined");
		}
	}

	private void parseArgs(String[] args) {
		for (String arg : args) {
			String argLc = arg.toLowerCase();
			if (argLc.startsWith("url=")) {
				// Base URL for API calls
				baseUrl = arg.substring("url=".length());
			} else if (argLc.startsWith("tenant=")) {
				// TENANT ID
				tenantId = arg.substring("tenant=".length());
			} else if (argLc.startsWith("login=")) {
				// User login (for session)
				login = arg.substring("login=".length());
			} else if (argLc.startsWith("password=")) {
				// User password (for session)
				password = arg.substring("password=".length());
			} else if (argLc.startsWith("itemid=")) {
				// Item ID
				itemId = arg.substring("itemid=".length());
			} else if (argLc.startsWith("description=")) {
				description = arg.substring("description=".length());
				// Item description
			} else if (argLc.startsWith("itemurl=")) {
				itemUrl = arg.substring("itemUrl=".length());
				// Item URL
			} else if (argLc.startsWith("action=")) {
				action = arg.substring("action=".length()).toUpperCase();
				// Action
			} else if (argLc.startsWith("userid=")) {
				// User ID of user which performed action
				userId = arg.substring("userid=".length());
			} else if (argLc.startsWith("apikey=")) {
				// API Key
				apiKey = arg.substring("apikey=".length());
			}
		}
	}
}
