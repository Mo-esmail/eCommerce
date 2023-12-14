package eCommerce.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.JDBCControl.JDBCControler;
import eCommerce.models.Client;


/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JDBCControler worker = new JDBCControler();
		Client user= new Client(request.getParameter("username"),worker.cryptWithMD5(request.getParameter("password")));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(checkUser(worker, user)==1){
			 Cookie usercookie = new Cookie(user.getName(),user.getPassword());
			   response.addCookie(usercookie);
				response.sendRedirect(request.getContextPath()+"/Products.jsp");
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
		doGet(request, response);
	}
	public int checkUser(JDBCControler worker,Client user){
		Client client = worker.checkUserName(user);
		if(client!=null){
			if(user.getPassword().equals(client.getPassword()))
				return 1;
			else
				return 0;
		}
		else
			return 0;
	}

}

