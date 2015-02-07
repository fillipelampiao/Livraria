package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;

import javafx.beans.property.StringProperty;


public class Funcionarios{

	private StringProperty id;
	private StringProperty nome;
	private StringProperty senha;
	private StringProperty cpf;
	private StringProperty rg;
	private StringProperty email;
	private StringProperty outros;
	
	public Funcionarios (String id,String nome, String senha,String cpf,String rg,String email, String outros){
		this.id = new SimpleStringProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.senha = new SimpleStringProperty(senha);
		this.cpf = new SimpleStringProperty(cpf);
		this.rg = new SimpleStringProperty(rg);
		this.email = new SimpleStringProperty(email);
		this.outros = new SimpleStringProperty(outros);
	}
	
	
	public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
    }
	
	//
	public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public StringProperty nomeProperty() {
        return nome;
    }
    //
    public String getSenha() {
        return senha.get();
    }

    public void setSenha(String senha) {
        this.senha.set(senha);
    }

    public StringProperty senhaProperty() {
        return senha;
    }
    //
    public String getCpf() {
        return cpf.get();
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public StringProperty cpfProperty() {
        return cpf;
    }
    //
    public String getRg() {
        return rg.get();
    }

    public void setRg(String rg) {
        this.rg.set(rg);
    }

    public StringProperty rgProperty() {
        return rg;
    }
    

    //
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }
   
    //
    public String getOutros() {
        return outros.get();
    }

    public void setOutros(String outros) {
        this.outros.set(outros);
    }

    public StringProperty outroProperty() {
        return outros;
    }
}