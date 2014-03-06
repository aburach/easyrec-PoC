package easyrec.poc.client.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
	@XmlElement(name="id", required=false)
	private Long id;
	@XmlElement(name="type", required=false)
	private String type;
	@XmlElement(name="itemType", required=false)
	private String itemType;
	@XmlElement(name="creationDate", required=false)
	private String creationDate;
	@XmlElement(name="description", required=false)
	private String description;
	@XmlElement(name="url", required=false)
	private String url;
	@XmlElement(name="imageUrl", required=false)
	private String imageUrl;
	@XmlElement(name="profileData", required=false)
	private String profileData;
	@XmlElement(name="value", required=false)
	private String value;
	@XmlElement(name="ratingValue", required=false)
	private Integer ratingValue;

	public Long getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public String getDescription() {
		return description;
	}
	public String getUrl() {
		return url;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public Integer getRatingValue() {
		return ratingValue;
	}
	
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		
		text.append('{').append(id).append(',').append(type).append(',')
			.append('"').append(description).append('"').append(',')
			.append(url).append(',').append(imageUrl).append('}');
		
		return text.toString();
	}
}
//<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
//<easyrec>
//	<action>recommendationsforuser</action>
//	<recommendeditems>
//		<item>
//			<creationDate>2014-03-06 13:42:51.0</creationDate>
//			<description>Item 2</description>
//			<imageUrl></imageUrl>
//			<id>2</id>
//			<itemType>ITEM</itemType>
//			<profileData xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:nil="true"/>
//			<url>http://localhost:8080/easyrec-web/t?r=10&amp;t=1&amp;f=0&amp;i=9&amp;a=999&amp;u=http%3A%2F%2Flocalhost%3A8080%2Fitems%2F2</url>
//			<value>33.33333333333335</value>
//			</item>
//		<item>
//			<creationDate>2014-03-06 13:43:15.0</creationDate>
//			<description>Item 3</description>
//			<imageUrl></imageUrl>
//			<id>3</id>
//			<itemType>ITEM</itemType>
//			<profileData xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:nil="true"/>
//			<url>http://localhost:8080/easyrec-web/t?r=10&amp;t=1&amp;f=0&amp;i=10&amp;a=999&amp;u=http%3A%2F%2Flocalhost%3A8080%2Fitems%2F3</url>
//			<value>33.33333333333335</value>
//		</item>
//	</recommendeditems>
//	<tenantid>EASYREC_DEMO</tenantid>
//	<userid>3</userid>
//</easyrec> 
