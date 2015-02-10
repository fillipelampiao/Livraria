package ch.makery.address.model;

import java.util.ArrayList;
import java.util.HashSet;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente{

	
	
	private StringProperty id;
	private StringProperty nome;
	private StringProperty cpf;
	private StringProperty rg;
	private StringProperty email;
	private StringProperty fone; //sugestao do cliente
	private StringProperty outros;
	private StringProperty idGrupo;
	
	private static ArrayList<Grupos> gruposClientes = new ArrayList<Grupos>();
	
	
	public Cliente(){}
	
	// Para Clientes
public Cliente (String id,String nome,String cpf,String rg,String email, String fone, String outros){
		this.id = new SimpleStringProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.cpf = new SimpleStringProperty(cpf);
		this.rg = new SimpleStringProperty(rg);
		this.email = new SimpleStringProperty(email);
		this.fone = new SimpleStringProperty(fone);
		this.outros = new SimpleStringProperty(outros);
}

public Cliente (String nome,String cpf,String rg,String email, String fone, String outros){
	this.nome = new SimpleStringProperty(nome);
	this.cpf = new SimpleStringProperty(cpf);
	this.rg = new SimpleStringProperty(rg);
	this.email = new SimpleStringProperty(email);
	this.fone = new SimpleStringProperty(fone);
	this.outros = new SimpleStringProperty(outros);
}
// Para funcionarios
public Cliente (String nome,String cpf,String rg,String email,String outros) {
	this.nome = new SimpleStringProperty(nome);
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
    public String getFone() {
        return fone.get();
    }

    public void setFone(String fone) {
        this.fone.set(fone);
    }

    public StringProperty foneProperty() {
        return fone;
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
    
    //
    public String getGrupo() {
        return idGrupo.get();
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo.set(idGrupo);
    }

    public StringProperty grupoProperty() {
        return idGrupo;
    }
    
    //
    public ArrayList<Grupos> getArrayGrupo(){
    	return this.gruposClientes;
    }
    public void setArrayGrupo(){
    	this.gruposClientes = gruposClientes;
    }
   
    
}