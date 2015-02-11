package ch.makery.address.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditarConsultaProdutoController {
	VerProdutoCadastro novaTela = new VerProdutoCadastro();


    @FXML
    private TextField txtOutros;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private Button butomVoltar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPrecoVenda;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private TextField txtPrecoCompra;

    @FXML
    void voltar(ActionEvent event) {
    	novaTela.stage2.close();
    }

    @FXML
    void confirmar(ActionEvent event) {

    }

}
