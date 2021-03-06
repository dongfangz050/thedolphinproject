package controller;

import htmlGenerator.SearchHtmlGenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import listingService.ListingService;
import listingService.ListingServiceImpl;
import model.Item;
import model.Tag;
import model.User;
import userManagementService.UserManagementService;
import userManagementService.UserManagementServiceImpl;

public class SearchAction extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		
		String action = req.getParameter("action");
		String longTag = req.getParameter("headerSearchInput");
		String [] tagTemp = longTag.split(" ");
		List<Tag> tags = new ArrayList<Tag>();
		
		
		//Possible Search Actions
		
		if("searchFromHeader".equals(action)){
			
			for(int i = 0; i<tagTemp.length; i++){
				tagTemp[i].trim();
				if(!tagTemp.equals("")){
					tags.add(new Tag(0,tagTemp[i]));
				}
			}
			//String category = req.getParameter("category");
			//String sortType = req.getParameter("sortType");
			
			ListingService listingService = new ListingServiceImpl();
			List <Item> searchResult = listingService.findItems(tags, null, null);
			
			res.setContentType("text/html");
			res.getWriter().write(SearchHtmlGenerator.createItemTableHtml(searchResult));

		}
				
			

		

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}
}
