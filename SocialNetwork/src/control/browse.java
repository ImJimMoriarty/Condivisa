package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

@WebServlet("/browse")
public class browse extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public browse() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean account = request.getParameter("account_button") != null;
		boolean u_list = request.getParameter("u_list_button") != null;
		boolean logout = request.getParameter("logout_button") != null;
		RequestDispatcher rd;
		if(account==true) {
			System.out.println("USER BROWSE REQUEST: ACCOUNT EDIT");
			rd = request.getRequestDispatcher("browse/users/html/account.jsp");
		} else if(u_list==true) {
			System.out.println("USER BROWSE REQUEST: PUBLIC USER LIST");
			rd = request.getRequestDispatcher("browse/users/html/users.jsp");
		} else if(logout==true) {
			System.out.println("USER BROWSE REQUEST: LOGOUT");
			rd = request.getRequestDispatcher("login/welcome/jsp/logout.jsp");
		} else {
			System.out.println("BROWSE ERROR");
			rd = request.getRequestDispatcher("login/html/error.html");
		}
		rd.forward(request, response);
	}

}
