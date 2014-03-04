package easyrec.poc.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClientImpl implements RestClient {

	@Override
	public void run(String[] args) {
		//parseArgs(args);
		
		RestTemplate template = new RestTemplate();
		
		//template.getForObject(url, responseType, urlVariables);
	}
}
