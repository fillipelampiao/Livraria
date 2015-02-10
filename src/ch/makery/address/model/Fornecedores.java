package ch.makery.address.model;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fornecedores {

	private StringProperty id;
	private StringProperty nome;
	private StringProperty cnpj;
	private StringProperty outros;
	private StringProperty grupo;
	
	private static ArrayList<Grupos> grupos = new ArrayList<Grupos>();
	
	public Fornecedores(){};
	
	public Fornecedores (String id,String nome,String cnpj, String outros,String grupo){
		this.id = new SimpleStringProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.cnpj = new SimpleStringProperty(cnpj);
		this.outros = new SimpleStringProperty(outros);
		this.grupo =  new SimpleStringProperty(grupo);
	}
	
	public Fornecedores (String nome,String cnpj, String outros){
		this.nome = new SimpleStringProperty(nome);
		this.cnpj = new SimpleStringProperty(cnpj);
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
    public String getOutros() {
        return outros.get();
    }

    public void setOutros(String outros) {
        this.outros.set(outros);
    }

    public StringProperty OutrosProperty() {
        return outros;
    }
    
    //
    
    public String getGrupo() {
        return outros.get();
    }

    public void setGrupo(String grupo) {
        this.grupo.set(grupo);
    }

    public StringProperty grupoProperty() {
        return grupo;
    }
    
    public ArrayList<Grupos> getArrayGrupo(){
    	return this.grupos;
    }
    
    public void setArrayGrupo(){
    	this.grupos = grupos;
    }
    
}

