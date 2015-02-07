package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;

import javafx.beans.property.StringProperty;


public class Produtos{

	private StringProperty id;
	private StringProperty nome;
	private StringProperty quantidade;
	private StringProperty pCompra;
	private StringProperty pVenda;
	private StringProperty outros;
	private StringProperty descricao;
	private StringProperty imagem;
	
	public Produtos (String id,String nome,String quantidade,String pCompra,String pVenda, String outros, String descricao, String imagem){
		this.id = new SimpleStringProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.quantidade = new SimpleStringProperty(quantidade);
		this.pCompra = new SimpleStringProperty(pCompra);
		this.pVenda = new SimpleStringProperty(pVenda);
		this.outros = new SimpleStringProperty(outros);
		this.descricao = new SimpleStringProperty(descricao);
		this.imagem = new SimpleStringProperty(imagem);
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
    public String getQuantidade() {
        return quantidade.get();
    }

    public void setQuantidade(String quantidade) {
        this.quantidade.set(quantidade);
    }

    public StringProperty quantidadeProperty() {
        return quantidade;
    }
    //
    public String getPCompra() {
        return pCompra.get();
    }

    public void setPCompra(String pCompra) {
        this.pCompra.set(pCompra);
    }

    public StringProperty pCompraProperty() {
        return pCompra;
    }
    

    //
    public String getPVenda() {
        return pVenda.get();
    }

    public void setPVenda(String pVenda) {
        this.pVenda.set(pVenda);
    }

    public StringProperty pVendaProperty() {
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
    public String getImagem() {
        return imagem.get();
    }

    public void setImagem(String imagem) {
        this.imagem.set(imagem);
    }

    public StringProperty imagemProperty() {
        return imagem;
    }
   
    
}