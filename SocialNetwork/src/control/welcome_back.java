package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome_back")
public class welcome_back extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public welcome_back() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		System.out.println("USER LOGGED IN");
		rd = request.getRequestDispatcher("landing/html/index.jsp");
		rd.forward(request, response);
	}

}
