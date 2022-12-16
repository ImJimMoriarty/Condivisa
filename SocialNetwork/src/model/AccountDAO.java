package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Account;

public class AccountDAO 
{
	private ConnessioneDB con;
	
	private static final String SELECT_ACCOUNT_USER_LOGIN = "select *"
			+ " from account where ((nickname=?)and(password=?))";
	private static final String INSERT_USERS_SQL = "INSERT INTO account" + "  (nome,cognome,eta,nickname,password) VALUES "
			+ " (?, ?, ?, ?, ?);";
	private static final String SELECT_ALL_ACCOUNTS = "select * from account";
	private static final String SELECT_USER_BY_ID = "select id,user,email,citta,password,role from account where id =?";
	private static final String UPDATE_ACCOUNTS_SQL = "update account set user=?, email=?, citta=?, password =?, role=? where id = ?;";
	private static final String DELETE_ACCOUNTS_SQL = "delete from account where id = ?;";
	
	public AccountDAO() {
		this.con = new ConnessioneDB();
	}
	
	public Account userLogin(String user, String pass)
	{
		System.out.println("Method: userLogin");
		Account acc = null;
		try {
			con.connect();
			Connection connection = con.getCon();
			PreparedStatement ps = connection.prepareStatement(SELECT_ACCOUNT_USER_LOGIN);
			ps.setString(1, user);
			ps.setString(2, pass);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				int eta = rs.getInt("eta");
				String nickname = rs.getString("nickname");
				String password = rs.getString("password");
				acc = new Account(id,nome,cognome,eta,nickname,password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDAO();
		return acc;
	}
	
	public void insertUser(String nome, String cognome, int eta, String nickname, String password) {
		System.out.println("Metodo invocato insertUser");
		System.out.println(INSERT_USERS_SQL);
		try {
			con.connect();
			Connection connection = con.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, cognome);
			preparedStatement.setInt(3, eta);
			preparedStatement.setString(4, nickname);
			preparedStatement.setString(5, password);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			closeDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Account> selectAllAccounts() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Account> accounts = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			con.connect();
			Connection connection = con.getCon();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNTS);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				int eta = rs.getInt("eta");
				String nick = rs.getString("nickname");
				String pass = rs.getString("password");
				accounts.add(new Account(id, nome, cognome, eta, nick, pass));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDAO();
		return accounts;
	}
	
	public Account selectUser(int id) {
		Account acc = null;
		try {
			// Step 1: Establishing a Connection
			con.connect();
			Connection connection = con.getCon();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nome = rs.getString("user");
				String email = rs.getString("email");
				String city = rs.getString("citta");
				String password = rs.getString("password");
				String role =  rs.getString("role");
				//acc = new Account(id, nome, email, city, password, role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDAO();
		return acc;
	}
	
	public boolean updateUser(int id,String user, String email, String citta, String pass, String role) {
		System.out.println("Metodo invocato updateUser");
		boolean rowUpdated = true;
		try {
			con.connect();
			Connection connection = con.getCon();
			PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNTS_SQL);
			statement.setString(1, user);
			statement.setString(2, email);
			statement.setString(3, citta);
			statement.setString(4, pass);
			statement.setString(5, role);
			statement.setInt(6, id);
			System.out.println(statement);

			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDAO();
		return rowUpdated;
	}
	
	public boolean deleteUser(int id) {
		boolean rowDeleted = true;
		try {
			con.connect();
			Connection connection = con.getCon();
			PreparedStatement statement = connection.prepareStatement(DELETE_ACCOUNTS_SQL);
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	public void closeDAO()
	{
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
