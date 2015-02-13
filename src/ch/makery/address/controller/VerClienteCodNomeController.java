package ch.makery.address.controller;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Cliente;
import ch.makery.address.util.ConectaBanco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VerClienteCodNomeController {
	Main main = new Main();
	String idCliente;
	ConectaBanco conecta = new ConectaBanco();
	private ObservableList<Cliente> verclientes = FXCollections.observableArrayList();

    @FXML
    private Button buttomfechar;

    @FXML
    private TableColumn<Cliente, String> cliente;

    @FXML
    private Button buttomPesquisar;

    @FXML
    private TableColumn<Cliente, String> cod;
    
    @FXML
    private TableView<Cliente> tabelaVerCliente;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private TextField txtCliente;

    @FXML
    void fechar(ActionEvent event) {
    	main.iniciaTelas("view/VenderVendas.fxml");

    }

    @FXML
    void confirmar(ActionEvent event) {
    	if (tabelaVerCliente.getSelectionModel().getSelectedItem() != null ){
    		Cliente clie = tabelaVerCliente.getSelectionModel().getSelectedItem();
    		idCliente = clie.getId();
    		String nome = clie.getNome();
    		VenderVenderController.idCliente = idCliente;
    		VenderVenderController.nome = nome;
    		main.iniciaTelas("view/VenderVendas.fxml");
    	}
    }

    @FXML
    void pesquisar(ActionEvent event) {
    	verclientes.clear();
    	String pesquisa = txtCliente.getText();
    	try{
    		conecta.conexao();
    		conecta.executaSQL("SELECT * FROM clientes");
    		while(conecta.rs.next()){
    			if (conecta.rs.getString("nome_cliente").contains(pesquisa)) {
    				verclientes.add(new Cliente(String.valueOf(conecta.rs.getInt("id_cliente")), conecta.rs.getString("nome_cliente")));
    				cod.setCellValueFactory(new PropertyValueFactory<Cliente, String>("id"));
    				cliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
    				tabelaVerCliente.setItems(verclientes);
    			}
    		}
    	} catch (Exception ex){
    		JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
    	}

    }
   

}
