package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ConsultaGrupoController {
	
	Main main = new Main();

    @FXML
    private Button buttomFornecedor;
    
    @FXML
    private Button buttomFuncionario;

    @FXML
    private Button buttomCliente;

    @FXML
    private Button buttomLogoff;

    @FXML
    void fornecedor(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaGrupoFornecedor.fxml");
    }

    @FXML
    void cliente(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaGrupoCliente.fxml");
    }
    
    @FXML
    void funcionario(ActionEvent event) {

    }

    @FXML
    void logoff(ActionEvent event) {

    }

}
