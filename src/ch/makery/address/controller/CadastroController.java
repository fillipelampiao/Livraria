package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CadastroController {
	Main main = new Main();
	
    @FXML
    private Button buttomFornecedoresCadastro;

    @FXML
    private Button buttomFuncionariosCadastro;

    @FXML
    private Button buttomGruposCadastro;

    @FXML
    private Button buttomClientesCadastro;

    @FXML
    private Button buttomProdutosCadastro;

    @FXML
    private Button buttomLogoff;

    @FXML
    void gruposCadastro(ActionEvent event) {
    	main.iniciaTelas("view/CadastroGrupos.fxml");
    }

    @FXML
    void fornecedoresCadastro(ActionEvent event) {
    	main.iniciaTelas("view/CadastroFornecedor.fxml");
    }

    @FXML
    void produtosCadastro(ActionEvent event) {
    	main.iniciaTelas("view/CadastroProduto.fxml");
    }

    @FXML
    void clientesCadastro(ActionEvent event) {
    	main.iniciaTelas("view/CadastroCliente.fxml");
    }

    @FXML
    void funcionariosCadastro(ActionEvent event) {
    	main.iniciaTelas("view/CadastroFuncionario.fxml");
    }

    @FXML
    void logoff(ActionEvent event) {

    }

}
