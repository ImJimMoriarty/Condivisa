package control;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.Account;

@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public search() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String test = request.getParameter("nickname");
		System.out.println("USER QUERY: "+test);
		Gson gson = new Gson();
		List<Account> lista = new ArrayList<Account>();
		
		for(Account acc : lista) {
			acc = gson.fromJson(new FileReader("E:\\Generation Esercizi\\Java\\Eclipso\\JSON\\lista.json"), Account.class);
			lista.add(acc);
		}
		System.out.println(gson.fromJson(new FileReader("E:\\Generation Esercizi\\Java\\Eclipso\\JSON\\lista.json"), Account.class));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
