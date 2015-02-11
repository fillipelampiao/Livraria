package ch.makery.address.controller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.*;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RelatorioController {
	
	Main main = new Main();

    @FXML
    private Button buttomEstoque;

    @FXML
    private Button buttomLogoff;

    @FXML
    private Button buttomVender;

    @FXML
    void vender(ActionEvent event) {
    	main.iniciaTelas("view/DataInicialFinal.fxml");
    }

    @FXML
    void Estoque(ActionEvent event) throws FileNotFoundException {
    	main.iniciaTelas("view/DataInicialFinal.fxml");
    }

    @FXML
    void logoff(ActionEvent event) {

    }

}
