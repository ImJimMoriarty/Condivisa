package control;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import data.Account;
import model.AccountDAO;

@WebServlet("/account_verify")
public class account_verify extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public account_verify() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean submit = request.getParameter("login") != null;
		boolean back = request.getParameter("backbutton") != null;
		String user = request.getParameter("login_txt");
		String pass = request.getParameter("password_txt");
		String date = "07/12/2022";
		AccountDAO accountdao = new AccountDAO();
		Account acc =  accountdao.userLogin(user, pass);
		boolean check;
		RequestDispatcher rd;
		HttpSession session = request.getSession(true);
		System.out.println(session.getId());
		if(submit) {
			if(acc!=null) {
				System.out.println("LOGGED IN");
				session.setAttribute("nome", user);
				session.setAttribute("id", acc.getId());
				rd = request.getRequestDispatcher("login/welcome/jsp/welcome.jsp");
			} else {
				System.out.println("ERROR IN LOGIN");
				rd = request.getRequestDispatcher("login/html/error.html");
			}
		} else if(back) {
			System.out.println("PRESSED BACK BUTTON");
			rd = request.getRequestDispatcher("/home/html/index.html");
		} else {
			System.out.println("ERROR IN BUTTONS");
			rd = request.getRequestDispatcher("login/html/error.html");
		}
		rd.forward(request, response);
		List<Account> lista = accountdao.selectAllAccounts();
		Gson gson = new Gson();
		//Account test = new Account(5, "ciaone", "ciaone", 6, "ciaone", "ciaone");
		FileWriter writer = new FileWriter("E:\\Generation Esercizi\\Java\\Eclipso\\JSON\\lista.json");
		gson.toJson(lista, writer);
		writer.close();
	}

}
