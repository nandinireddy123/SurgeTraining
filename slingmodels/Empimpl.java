package com.aem.geeks.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model (adaptables=SlingHttpServletRequest.class,adapters = Emplinf.class)
public class Empimpl implements Emplinf {
	
	
	@ValueMapValue
    public String name;
	@ValueMapValue
    public String location;
	@ValueMapValue
    public String text;
	@ValueMapValue
	
    public String picture;
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public String getText() {
		return text;
	}
	public String getPicture() {
		return picture;
	}
	
	

}
