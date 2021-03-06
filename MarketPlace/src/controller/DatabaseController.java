package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import global.MarketplaceConfig;

public class DatabaseController {
	Connection mConnection;

	public Connection ConnectToDatabase()
	{

		String url = "jdbc:mysql://localhost:3306/";
		String db = "marketplace";
		String driver = "com.mysql.jdbc.Driver";
		try
		{
			//Class.forName(driver);

			Class.forName("com.mysql.jdbc.Driver");
			mConnection = DriverManager.getConnection(url + db, "root", MarketplaceConfig.DB_PW);

			return mConnection;

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;

	}

	public String query(){

		ConnectToDatabase();
		String htmlCode = "";
		
		try{
			Statement st = mConnection.createStatement();
			String query = "SELECT iditem FROM item";
			st.execute(query);
			
			ResultSet rs = st.getResultSet();
			
			while(rs.next()){
				htmlCode += "<p>" + rs.getInt("iditem") + "</p>";
			}
			
		}
		catch(Exception e){

		}
		
		return htmlCode;


	}


}
