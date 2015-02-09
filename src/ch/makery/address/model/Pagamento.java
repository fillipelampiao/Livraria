package ch.makery.address.model;

public class Pagamento {
	
	private String id;
	private boolean status;
	private String tipo;
	
	public Pagamento(String id,boolean status,String tipo){
		this.id = id;
		this.status = status;
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
