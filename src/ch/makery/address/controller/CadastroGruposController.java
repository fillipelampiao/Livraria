package ch.makery.address.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import ch.makery.address.Main;
import ch.makery.address.model.Grupos;
import ch.makery.address.util.ConectaBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class CadastroGruposController implements Initializable {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	int tipoGrupo;
	
	@FXML
    private RadioButton fornecedor;
	
	@FXML
	private RadioButton funcionario;
	    
	@FXML
	private RadioButton cliente;

	
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
    	Toggle tipo = cf.getSelectedToggle();
    
    	if (tipo.toString().contains("Cliente")){
    		tipoGrupo = 1;
    	} else if (tipo.toString().contains("Funcionário")){
    		tipoGrupo = 2;    		 
    	} else if (tipo.toString().contains("Fornecedor")){
    		tipoGrupo = 3;
    	}
    	
    	Grupos grupo = new Grupos(txtNome.getText(),String.valueOf(tipoGrupo),txtOutros.getText());
    	if (grupo.getNome().length() == 0){
    		JOptionPane.showMessageDialog(null, "Prencha os dados obrigatorios!");
    	}else {
	    	try {
				PreparedStatement pst = conecta.conn.prepareStatement("insert into grupos (nome_grupo, tipo_grupo, outros_grupo) values(?,?,?)");
				pst.setString(1, grupo.getNome());
		    	pst.setInt(2, Integer.parseInt(grupo.getTipo()));
		    	pst.setString(3, grupo.getOutros());
		    	pst.executeUpdate();
		    	JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso");
	    	} catch (SQLException e) {
	    		JOptionPane.showMessageDialog(null,"Erro ao cadastrar"+e);
			}
	    	txtNome.setText("");
	    	txtOutros.setText("");
    	}
   }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Cadastro.fxml");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cliente.setSelected(true);
		
	}

}
