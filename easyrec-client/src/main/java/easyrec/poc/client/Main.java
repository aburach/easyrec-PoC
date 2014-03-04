package easyrec.poc.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "spring-config.xml" });
		RestClient client = ctx.getBean(RestClient.class);
		
		client.run(args);
		
		ctx.close();
	}
}
