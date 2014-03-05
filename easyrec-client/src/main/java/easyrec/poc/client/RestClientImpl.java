package easyrec.poc.client;

import java.net.URI;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
	private Operation op;
	private Map<String, String> params = new HashMap<String, String>();
	RestTemplate template = new RestTemplate();
	
	@Override
	public void run(String[] args) {
		parseArgs(args);
		validateArgs();
		fillCallParameters();
		sessionId = login();
		
		switch(op) {
			case VIEW: doView();
		}
	}

	private void doView() {
		// TODO Auto-generated method stub
		
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
	}

	private String login() {
		String url = baseUrl + "/operator/signin?operatorId={login}&password={password}";
		
		// template.getForObject(url, responseType, urlVariables);
		Object response = template.getForObject(url, String.class, params);
		
		return response.toString();
	}

	private void validateArgs() {
		if (action == null) {
			throw new InvalidParameterException("Action must be defined");
		}
		op = Operation.valueOf(action.toUpperCase());
		if (baseUrl == null) {
			throw new InvalidParameterException("Action must be defined");
		}
		URI.create(baseUrl);
		if (login == null) {
			throw new InvalidParameterException("Action must be defined");
		}
		if (password == null) {
			throw new InvalidParameterException("Action must be defined");
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
			} else if (argLc.startsWith("itemId=")) {
				itemId = arg.substring("itemId=".length());
				// Item ID
			} else if (argLc.startsWith("description=")) {
				description = arg.substring("description=".length());
				// Item description
			} else if (argLc.startsWith("itemUrl=")) {
				itemUrl = arg.substring("itemUrl=".length());
				// Item URL
			} else if (argLc.startsWith("action=")) {
				action = arg.substring("action=".length());
				// Action
			} else if (argLc.startsWith("userId=")) {
				// User ID of user which performed action
				userId = arg.substring("userId=".length());
			}
		}
	}
}
