package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fornecedores {

	private StringProperty id;
	private StringProperty nome;
	private StringProperty cnpj;
	private StringProperty email;
	private StringProperty fone;
	private StringProperty outros;
	
	public Fornecedores (String id,String nome,String cnpj,String email,String fone, String outros){
		this.id = new SimpleStringProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.cnpj = new SimpleStringProperty(cnpj);
		this.email = new SimpleStringProperty(email);
		this.fone = new SimpleStringProperty(fone);
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
    public String getCnpj() {
        return cnpj.get();
    }

    public void setCnpj(String cnpj) {
        this.cnpj.set(cnpj);
    }

    public StringProperty cnpjProperty() {
        return cnpj;
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

    public StringProperty OutrosProperty() {
        return outros;
    }
    
}

