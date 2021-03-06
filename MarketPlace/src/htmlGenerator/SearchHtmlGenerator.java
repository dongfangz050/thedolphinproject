package htmlGenerator;

import java.util.List;

import model.Item;

public class SearchHtmlGenerator {
	/**
	 * Used for generating HTML table
	 * @return A html table
	 */
	
	public static String createItemTableHtml(List<Item> searchResult){
		StringBuilder table = new StringBuilder();
		table.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\" id=\"searchResultTable\" width=\"100%\">");
		table.append("<thead>");
		table.append("<tr>");
		table.append("<th>Name</th>");
		table.append("<th>Category</th>");
		table.append("<th>Description</th>");
		table.append("<th>Price Low</th>");
		table.append("<th>Price High</th>");
		table.append("<th>Time Posted</th>");
		table.append("</tr>");
		table.append("</thead>");
		table.append("<tbody>");
		
		for(int i = 0; i<searchResult.size(); i++){
			table.append("<tr>");
			table.append("<td>" + searchResult.get(i).getName()+"</td>");
			table.append("<td>" + searchResult.get(i).getCategory()+"</td>");
			table.append("<td>" + searchResult.get(i).getDescription()+"</td>");
			table.append("<td>" + searchResult.get(i).getPriceLow()+"</td>");
			table.append("<td>" + searchResult.get(i).getPriceLow()+"</td>");
			table.append("<td>" + searchResult.get(i).getTimePosted().toString()+"</td>");
			table.append("</tr>");
		}
		
		table.append("</tbody>");
		
		// Adding table footer
		
		table.append("<tfoot>");
		table.append("<tr>");
		table.append("<th>Name</th>");
		table.append("<th>Category</th>");
		table.append("<th>Description</th>");
		table.append("<th>Price Low</th>");
		table.append("<th>Price High</th>");
		table.append("<th>Time Posted</th>");
		table.append("</tr>");
		table.append("</tfoot>");
		
		// End of table
		table.append("</table>");
		
		return table.toString();
	
	}
}
