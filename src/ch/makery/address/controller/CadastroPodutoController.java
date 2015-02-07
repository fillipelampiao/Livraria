package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroPodutoController {

	Main main = new Main();
	
    @FXML
    private TextField txtOutros;

    @FXML
    private Button buttomUploadVendas;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private Button buttomLimpar;

    @FXML
    private TextField txtNome;

    @FXML
    private Button buttomVoltar;

    @FXML
    private TextField txtCod;

    @FXML
    private Button buttomAlterarPrecoCompra;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private TextArea txtDescricaoVendas;

    @FXML
    private Button buttomAlterarPrecoVenda;

    @FXML
    private TextField txtPrecoVenda;

    @FXML
    private TextField txtPrecoCompra;

    @FXML
    void alterarPrecoCompra(ActionEvent event) {

    }

    @FXML
    void alterarPrecoVenda(ActionEvent event) {

    }

    @FXML
    void uploadVendas(ActionEvent event) {

    }

    @FXML
    void limpar(ActionEvent event) {

    }

    @FXML
    void confirmar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Cadastro.fxml");
    }

}
