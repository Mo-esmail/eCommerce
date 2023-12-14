package eCommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.JDBCControl.JDBCControler;
import eCommerce.models.Client;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client user= new Client(request.getParameter("username"),request.getParameter("password"),Integer.parseInt(request.getParameter("age")),
				request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("Gender"),request.getParameter("email"));
		JDBCControler worker = new JDBCControler();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(checkUser(worker, user)==0)
			response.sendRedirect(request.getContextPath() +"/LogIn.html");
		else{
		out.println("<!doctype html>\n" +
				"<html>\n" +
					"<head><title>login result</title>"+
					"<style>"+
				"body{"+
				"background: #48BCE2;"+
				"}</style>"+
					"</head>\n" +
					"<body bgcolor = \"#f0f0f0\">\n" +
						"<h1 align = \"center\">lig in result</h1>"+
					"Username reserved"+
				"</body>"+
					"</html>"
						);}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public int checkUser(JDBCControler worker,Client user){
		Client client = worker.checkUserName(user);
		if(client!=null)
			return 1;
		else{
			worker.addUser(user);
			return 0;
		}
	}
}

