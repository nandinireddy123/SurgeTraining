package com.aem.geeks.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.aem.geeks.core.models.clginf;
@Model (adaptables=SlingHttpServletRequest.class,adapters=clginf.class)
public abstract class clgimpl implements clginf {
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
