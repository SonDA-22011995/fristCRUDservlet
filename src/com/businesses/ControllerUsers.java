package com.businesses;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.UserDB;
import com.pojo.User;
import com.pojo.Users;

/**
 * Servlet implementation class ControllerUsers
 */
@WebServlet(urlPatterns = {"","/check"})
public class ControllerUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action == null) {
			action = "action";
		}
		if(action.equals("delete_user")) {
			deleteUser(request, response);
			return;
		}
		if(action.equals("select_user_update")) {
			selectUserUpdate(request, response);
			return;
		}
		else{
			listUsers(request, response);
			return;
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action == null) {
			action = "action";
		}
		if(action.equals("update_user")) {
			updateUser(request, response);
			return;
		}
		if(action.equals("insert_user")) {
			insertUser(request, response);
			return;
		}
	}
	
	public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users users = null;
		if(UserDB.isExist()) {
			users = UserDB.selectUsers();
		}
		request.setAttribute("users", users);
		RequestDispatcher rd = request.getRequestDispatcher("/home");
		rd.forward(request, response);
	}
	
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		ServletContext sc = getServletContext();
		UserDB.deleteUser(email);
		response.sendRedirect(sc.getContextPath());
	}
	
	public void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String fristName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		ServletContext sc = getServletContext();
		UserDB.insertUser(email, fristName, lastName);
		response.sendRedirect(sc.getContextPath());
	}
	
	public void selectUserUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email =  request.getParameter("email");
		User user = UserDB.selectUser(email);
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("update");
		rd.forward(request, response);
	}
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String email =  request.getParameter("email");
		String firstName =  request.getParameter("firstName");
		String lastName =  request.getParameter("lastName");
		UserDB.updateUser(email,firstName,lastName);
		response.sendRedirect(sc.getContextPath()+"");	
	}
}
