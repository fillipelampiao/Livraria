package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Funcionarios extends Cliente{

	private StringProperty identificacao;
	//String id,String nome,String cpf,String rg,String email, String fone, String outros
	public Funcionarios (String id,String nome,String identificacao,String cpf,String rg,String email,String outros){
		super(id, nome, cpf, rg, email, outros);
		this.identificacao = new SimpleStringProperty(identificacao);
	}
	
	public Funcionarios (String nome,String identificacao,String cpf,String rg,String email,String outros){
		super(nome, cpf, rg, email,outros);
		this.identificacao = new SimpleStringProperty(identificacao);
	}

	
	
	public String getidentificacao() {
        return identificacao.get();
    }

    public void setidentificacao(String identificacao) {
        this.identificacao.set(identificacao);
    }

    public StringProperty identificacaoProperty() {
        return identificacao;
    }	
	
}