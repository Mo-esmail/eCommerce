package eCommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.JDBCControl.JDBCControler;
import eCommerce.models.Client;

/**
 * Servlet implementation class Admins_LogIn
 */
@WebServlet("/Admins_LogIn")
public class Admins_LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admins_LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JDBCControler worker = new JDBCControler();
		Client user= new Client(request.getParameter("username"),worker.cryptWithMD5(request.getParameter("password")));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(checkUser(user)==1){
			response.sendRedirect("AddProduct.html");
		}
		else{
		out.println("<!doctype html>\n" +
				"<html>\n" +
					"<head>"+
				"<style>"+
					"body{"+
					"background: #48BCE2;"+
				"}</style>"+
				"<title>lig in result</title></head>\n" +
					"<body bgcolor = \"#f0f0f0\">\n" +
						"<h1 align = \"center\">lig in result</h1>"+
					"UserName or password invalid"+
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
	public int checkUser(Client user){
		//if(user.getName().equals("mohamad")){
		//	if(user.getPassword().equals("854f284dc3cae07e3b638be9778361"))
				return 1;
		//	else
		//		return 0;
		//}
		//else
		//	return 0;
	}

}

