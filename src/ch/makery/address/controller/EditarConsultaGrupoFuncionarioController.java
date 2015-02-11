package ch.makery.address.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditarConsultaGrupoFuncionarioController {
	VerProdutoCadastro novaTela = new VerProdutoCadastro();

    @FXML
    private Button butomVoltar;

    @FXML
    private TextField txtNome;

    @FXML
    private Button buttomConfirmar;

    @FXML
    void voltar(ActionEvent event) {
    	novaTela.stage2.close();
    }

    @FXML
    void confirmar(ActionEvent event) {

    }

}
