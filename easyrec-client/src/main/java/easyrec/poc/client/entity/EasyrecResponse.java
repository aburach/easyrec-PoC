package easyrec.poc.client.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
//	@XmlElement(name="item", required=false)
//	private Item item;
	@XmlElement
	private String token;
	
	public String getToken() {
		return token;
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public ResponseCode getFailureResponse() {
		return failureResponse;
	}
}
