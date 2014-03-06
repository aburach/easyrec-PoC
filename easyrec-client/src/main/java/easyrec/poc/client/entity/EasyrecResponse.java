package easyrec.poc.client.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="easyrec")
@XmlAccessorType(XmlAccessType.FIELD)
public class EasyrecResponse {
	@XmlElement
	private String action;
	@XmlElement(name="success", required=false)
	private ResponseCode responseCode;
	@XmlElement(name="error", required=false)
	private ResponseCode failureResponse;
	@XmlElement(name="token", required=false)
	private String token;
	@XmlElement(name="tenantid", required=false)
	private String tenantId;
	@XmlElement(name="userid", required=false)
	private String userId;
	@XmlElement(name="sessionid", required=false)
	private String sessionId;
	@XmlElement(name="item", required=false)
	private Item item;
	@XmlElementWrapper(name="recommendeditems")
	@XmlElement(name="item", required=false, type=Item.class)
	private List<Item> items;
	
	public String getToken() {
		return token;
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public ResponseCode getFailureResponse() {
		return failureResponse;
	}

	public Item getItem() {
		return item;
	}

	public List<Item> getRecommendations() {
		return items;
	}
}
