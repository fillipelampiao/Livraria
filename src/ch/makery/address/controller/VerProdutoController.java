package ch.makery.address.controller;



import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Cliente;
import ch.makery.address.model.Produtos;
import ch.makery.address.util.ConectaBanco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VerProdutoController {
	
	Main main = new Main();
	String idProdutos;
	ConectaBanco conecta = new ConectaBanco();
	private ObservableList<Produtos> verprodutos = FXCollections.observableArrayList();
	 
	@FXML
	private Button buttomfechar;

	@FXML
	private TableColumn<Produtos, String> produto;

	@FXML
	private TextField txtProduto;

	@FXML
	private Button buttomPesquisar;

	@FXML
	private TableColumn<Produtos, String> cod;

	@FXML
	private Button buttomConfirmar;

	@FXML
	private TableView<Produtos>  tabelaVerProduto;

	@FXML
	void pesquisar(ActionEvent event) {
		verprodutos.clear();
    	String pesquisa = txtProduto.getText();
    	try{
    		conecta.conexao();
    		conecta.executaSQL("SELECT * FROM produtos");
    		
    		while(conecta.rs.next()){
    			if (conecta.rs.getString("nome_produto").contains(pesquisa)) {
    				verprodutos.add(new Produtos(String.valueOf(conecta.rs.getString("id_produto")), conecta.rs.getString("nome_produto"), conecta.rs.getInt("quantidade_produto")));
    				cod.setCellValueFactory(new PropertyValueFactory<Produtos, String>("id"));
    				produto.setCellValueFactory(new PropertyValueFactory<Produtos, String>("nome"));
    				tabelaVerProduto.setItems(verprodutos);
    			}
    		}
    	} catch (Exception ex){
    		JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
    	}
		

	    }

	@FXML
	void confirmar(ActionEvent event) {
		if ( tabelaVerProduto.getSelectionModel().getSelectedItem() != null ){
    		Produtos prod =  tabelaVerProduto.getSelectionModel().getSelectedItem();
    		idProdutos = prod.getId();
    		String quantEstoque = String.valueOf(prod.getQuantidade());
    		VenderVenderController.idProdutos = idProdutos;
    		VenderVenderController.quantEstoque = quantEstoque;
    		main.iniciaTelas("view/VenderVendas.fxml");
    	}

	    }

	@FXML
	void fechar(ActionEvent event) {
		main.iniciaTelas("view/VenderVendas.fxml");

	    }

}
