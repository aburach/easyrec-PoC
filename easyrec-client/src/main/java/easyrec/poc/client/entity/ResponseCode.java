package easyrec.poc.client.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="success")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseCode {
	@XmlAttribute(name="code")
	private Integer code;
	@XmlAttribute(name="message")
	private String message;

	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
}
