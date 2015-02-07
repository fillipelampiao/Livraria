package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VenderController {

	Main main = new Main();
	
    @FXML
    private Button buttomPagamento;

    @FXML
    private Button buttomAlterarVenda;

    @FXML
    private Button buttomLogoff;

    @FXML
    private Button buttomVender;

    @FXML
    void vender(ActionEvent event) {
    	main.iniciaTelas("view/VenderVendas.fxml");
    }

    @FXML
    void pagamento(ActionEvent event) {
    	main.iniciaTelas("view/PagamentoVendas.fxml");
    }

    @FXML
    void alterarVenda(ActionEvent event) {
    	main.iniciaTelas("view/AlterarVender.fxml");
    }

    @FXML
    void logoff(ActionEvent event) {

    }

}
