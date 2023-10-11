package com.aem.geeks.core.servlets;

import java.util.Iterator;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = {"/bin/employee"}
)

public class EmployeResource extends SlingAllMethodsServlet{
    protected void doGet(SlingHttpServletRequest req,SlingHttpServletResponse res){
        ResourceResolver resourceResolver = req.getResourceResolver();
        String parameter = req.getParameter("parameter");

        Page page = resourceResolver.adaptTo(PageManager.class).getPage();
        Iterator<Page> listChildren = page.listChildren();
        while(listChildren.hasNext()){
            Page listChild = listChildren.next();
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put(listChild.getTitle(),listChild.getPath().toString());
                 jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
        }
        res.setContentType("application/json");
            res.getWriter().write(jsonArray.toString()); 
    }

        
    }
    
}
