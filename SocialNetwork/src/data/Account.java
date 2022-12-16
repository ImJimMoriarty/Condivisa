package data;

public class Account 
{
	private int id;
	private String nome;
	private String cognome;
	private int eta;
	private String nickname;
	private String password;
	
	public Account() 
	{
		this.id = 0;
		this.nome = "";
		this.cognome = "";
		this.eta = 0;
		this.nickname = "";
		this.password = "";
	}
	
	public Account(String nome, String cognome, int eta, String password) 
	{
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.password = password;
	}
	
	public Account(int id, String nome, String cognome, int eta, String nickname, String password) 
	{
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.nickname = nickname;
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
}
