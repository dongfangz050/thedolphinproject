package controller;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import userManagementService.UserManagementService;
import userManagementService.UserManagementServiceImpl;

public class UserAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6034476842725458979L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		String action = req.getParameter("action");
		res.setContentType("text/html");
		
		if(action == null)
		{
			res.getWriter().write("false");
			return;
			
		}
		
		UserManagementService service = new UserManagementServiceImpl();
		
		if(action.equals("create"))
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			
			System.err.println("Creating account: " + username+" "+password+" "+firstname+" "+lastname+" "+email+" "+phone);
			
			User user = new User(0, username, password,
					firstname, lastname, email,
					phone,  new Date());
					
			try {
				if(!service.createAccount(user))
				{
					res.getWriter().write("false");
					System.err.println("Account not created for username: " + username);
				}
				else
				{
					res.getWriter().write("true");
					System.err.println("Account created for username: " + username);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res.getWriter().write("error");
				e.printStackTrace();
			}
			
			
		}
		else if(action.equals("get")){
			String userIDString = req.getParameter("userid");
			long userID = Long.parseLong(userIDString);
			
			User user;
			try {
				user = service.getAccount(userID);
				
				if(user == null)
				{
					res.getWriter().write("false");
				}
				else
				{
					String returnData = user.getUsername() + "," + user.getPassword() + "," +
							user.getFirstName() + "," + user.getLastName() + "," +
							user.getEmail() + "," + user.getPhoneNumber();
					res.getWriter().write(returnData);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				res.getWriter().write("error");
				e.printStackTrace();
				
			}
			

			
			
			
		}

		

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}
}
