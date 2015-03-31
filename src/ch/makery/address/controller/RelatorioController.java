package ch.makery.address.controller;
import java.io.*;
import java.net.MalformedURLException;
import java.sql.SQLException;

import com.itextpdf.text.DocumentException;

import ch.makery.address.Main;
import ch.makery.address.util.GeraTabelaProduto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RelatorioController {
	GeraTabelaProduto gera = new GeraTabelaProduto();
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
    void Estoque(ActionEvent event) throws MalformedURLException, DocumentException, SQLException, IOException {
     	gera.geraPdf();
    	gera.chamaCaminho();
    }

    @FXML
    void logoff(ActionEvent event) {

    }

}
