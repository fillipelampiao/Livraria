package ch.makery.address.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.util.ConectaBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class CadastroGruposController {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	
    @FXML
    private TextField txtOutros;

    @FXML
    private ToggleGroup cf;

    @FXML
    private Button confirmar;

    @FXML
    private Button buttomLimpar;

    @FXML
    private TextField txtNome;

    @FXML
    private Button buttomVoltar;

    @FXML
    void limpar(ActionEvent event) {

    }

    @FXML
    void confirmar(ActionEvent event) {
    	conecta.conexao();
//    	Toggle tipo = cf.getSelectedToggle();
    	try {
			PreparedStatement pst = conecta.conn.prepareStatement("insert into grupos (nome_grupo, tipo_grupo, outros_grupo) values(?,?,?)");
	    	pst.setString(1, txtNome.getText());
//	    	pst.setString(2, tipo);
	    	pst.setString(3, txtOutros.getText());
	    	pst.executeUpdate();
	    	JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso");
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null,"Erro ao cadastrar"+e);
		}
    	txtNome.setText("");
    	txtOutros.setText("");
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Cadastro.fxml");
    }

}
