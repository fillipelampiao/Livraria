package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ConsultaController {

	Main main = new Main();
	
    @FXML
    private Button buttomProdutos;

    @FXML
    private Button buttomGrupos;

    @FXML
    private Button buttomFuncionarios;

    @FXML
    private Button buttomLogoff;

    @FXML
    private Button buttomClientes;

    @FXML
    private Button buttomFornecedores;

    @FXML
    void grupos(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaGrupo.fxml");
    }

    @FXML
    void fornecedores(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaFornecedor.fxml");
    }

    @FXML
    void produtos(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaProduto.fxml");
    }

    @FXML
    void clientes(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaCliente.fxml");
    }

    @FXML
    void funcionarios(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaFuncionario.fxml");
    }

    @FXML
    void logoff(ActionEvent event) {

    }

}
