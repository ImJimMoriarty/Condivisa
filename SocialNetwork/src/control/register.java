package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Account;
import model.AccountDAO;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("name");
		String cognome = request.getParameter("cognome");
		int eta = Integer.parseInt(request.getParameter("eta"));
		String nick = request.getParameter("nickname");
		String pass = request.getParameter("password_txt");
		AccountDAO accountdao = new AccountDAO();
		Account acc =  accountdao.userLogin(nick, pass);
		RequestDispatcher rd;
		if(acc==null) {
			System.out.println("USER REGISTERED");
			accountdao.insertUser(nome, cognome, eta, nick, pass);
			acc =  accountdao.userLogin(nick, pass);
			request.setAttribute("username", acc.getNickname());
			request.setAttribute("account", acc);
			rd = request.getRequestDispatcher("home/html/index.html");
		} else {
			System.out.println("ERROR USER NOT REGISTERED");
			rd = request.getRequestDispatcher("error.html");
		}
		rd.forward(request, response);
	}

}
