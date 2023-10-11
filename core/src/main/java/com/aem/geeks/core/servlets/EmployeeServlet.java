package com.aem.geeks.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
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
public class EmployeeServlet extends SlingSafeMethodsServlet{
     protected void doGet(SlingHttpServletRequest req,SlingHttpServletResponse res) throws IOException  {
        ResourceResolver resourceResolver = req.getResourceResolver();
        String parameter = req.getParameter("parameter");

        Page page = resourceResolver.adaptTo(PageManager.class).getPage(parameter);
        JSONArray jsonArray = new JSONArray();
        Iterator<Page> listChildren = page.listChildren();
        while (listChildren .hasNext()) {
            Page listChild = listChildren.next();
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put(listChild.getTitle(),listChild.getPath().toString());
                 jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            
        }
         res.setContentType("application/json");
            res.getWriter().write(jsonArray.toString()); 
    }
    
            
        




    
}x
