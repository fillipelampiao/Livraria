package ch.makery.address.model;

import java.sql.Date;

public class Vendas {
	private int quantidade;
	private float preco;
	private Date data;
	private String outros;
	
	public Vendas(int quantidade, float preco, Date data, String outros){
		this.quantidade = quantidade;
		this.preco = preco;
		this.data = data;
		this.outros = outros;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
	}
	
}
