package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;

import model.Passenger;
import view.PassengerView;


public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setContentType("text/html");  
//		PrintWriter pw=response.getWriter();  
//		  
//		response.sendRedirect("html/login.html");  
//		  
//		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action  = request.getParameter("action");
		String emailId  = request.getParameter("emailId");
		String password  = request.getParameter("password");
		PassengerView passengerView=new PassengerView();
		Passenger passengerObj=passengerView.login(emailId, password);
		response.setContentType("application/json");
		JSONObject resp = new JSONObject();
		if(passengerObj != null) {
			response.setStatus(HttpStatus.SC_ACCEPTED);
			resp.put("data", new JSONArray().put(new JSONObject(passengerObj)));
			resp.put("status", "success");
		}else {
			response.setStatus(HttpStatus.SC_UNAUTHORIZED);
			resp.put("status", "failure");
		}
		response.getWriter().write(resp.toString());
	}

}
