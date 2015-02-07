package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

public class DataInicialFinalController {
	
	Main main = new Main();

    @FXML
    private Button buttomVoltar;

    @FXML
    private DatePicker dataInicial;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private DatePicker dataFinal;

    @FXML
    void confirmar(ActionEvent event) {
    	
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Relatorio.fxml");
    }

}
