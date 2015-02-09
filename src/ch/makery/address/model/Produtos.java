package ch.makery.address.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Produtos{

	private StringProperty id;
	private StringProperty nome;
	private IntegerProperty quantidade;
	private FloatProperty pCompra;
	private FloatProperty pVenda;
	private StringProperty outros;
	private StringProperty descricao;

	
	public Produtos (String id,String nome,int quantidade,Float pCompra,Float pVenda,String outros, String descricao){
		this.id = new SimpleStringProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.quantidade = new SimpleIntegerProperty(quantidade);
		this.pCompra = new SimpleFloatProperty(pCompra);
		this.pVenda = new SimpleFloatProperty(pVenda);
		this.outros = new SimpleStringProperty(outros);
		this.descricao = new SimpleStringProperty(descricao);

	}
	
	public Produtos (String nome,int quantidade,Float pCompra,Float pVenda,String outros, String descricao){
		this.nome = new SimpleStringProperty(nome);
		this.quantidade = new SimpleIntegerProperty(quantidade);
		this.pCompra = new SimpleFloatProperty(pCompra);
		this.pVenda = new SimpleFloatProperty(pVenda);
		this.outros = new SimpleStringProperty(outros);
		this.descricao = new SimpleStringProperty(descricao);
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
    public Integer getQuantidade() {
        return quantidade.get();
    }

    public void setQuantidade(int quantidade) {
        this.quantidade.set(quantidade);
    }

    public IntegerProperty quantidadeProperty() {
        return quantidade;
    }
    //
    public Float getPCompra() {
        return pCompra.get();
    }

    public void setPCompra(Float pCompra) {
        this.pCompra.set(pCompra);
    }

    public FloatProperty pCompraProperty() {
        return pCompra;
    }
    

    //
    public Float getPVenda() {
        return pVenda.get();
    }

    public void setPVenda(Float pVenda) {
        this.pVenda.set(pVenda);
    }

    public FloatProperty pVendaProperty() {
        return pVenda;
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
    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }
    //
  
    
}