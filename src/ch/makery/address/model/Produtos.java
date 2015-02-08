package ch.makery.address.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Produtos{

	private StringProperty id;
	private StringProperty nome;
	private FloatProperty quantidade;
	private FloatProperty pCompra;
	private FloatProperty pVenda;
	private StringProperty outros;
	private StringProperty descricao;
	private StringProperty imagem;
	
	public Produtos (String id,String nome,Float quantidade,Float pCompra,Float pVenda, String outros){
		this.id = new SimpleStringProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.quantidade = new SimpleFloatProperty(quantidade);
		this.pCompra = new SimpleFloatProperty(pCompra);
		this.pVenda = new SimpleFloatProperty(pVenda);
		this.outros = new SimpleStringProperty(outros);
//		this.descricao = new SimpleStringProperty(descricao);
//		this.imagem = new SimpleStringProperty(imagem);
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
    public Float getQuantidade() {
        return quantidade.get();
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade.set(quantidade);
    }

    public FloatProperty quantidadeProperty() {
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