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

public class CadastroFuncionarioController {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	
    @FXML
    private TextField txtOutros;

    @FXML
    private Button buttomVoltarGrupo;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button buttomIrGrupo;

    @FXML
    private Button buttomLimpar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button buttomVoltar;

    @FXML
    private TextField txtCpf;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private TextField txtRg;

    @FXML
    void irGrupo(ActionEvent event) {

    }

    @FXML
    void voltarGrupo(ActionEvent event) {

    }

    @FXML
    void limpar(ActionEvent event) {
    	txtNome.setText("");
    	txtSenha.setText("");
    	txtCpf.setText("");
    	txtRg.setText("");
    	txtEmail.setText("");
    	txtOutros.setText("");
    }

    @FXML
    void confirmar(ActionEvent event) {
    	conecta.conexao();
    	try {
			PreparedStatement pst = conecta.conn.prepareStatement("insert into funcionarios (nome_funcionario, senha_funcionario, cpf_funcionario, rg_funcionario, email_funcionario, outros_funcionario) values(?,?,?,?,?,?)");
	    	pst.setString(1, txtNome.getText());
	    	pst.setString(2, txtSenha.getText());
	    	pst.setString(3, txtCpf.getText());
	    	pst.setString(4, txtRg.getText());
	    	pst.setString(5, txtEmail.getText());
	    	pst.setString(6, txtOutros.getText());
	    	pst.executeUpdate();
	    	JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso");
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null,"Erro ao cadastrar"+e);
		}
    	txtNome.setText("");
    	txtSenha.setText("");
    	txtCpf.setText("");
    	txtRg.setText("");
    	txtEmail.setText("");
    	txtOutros.setText("");
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Cadastro.fxml");
    }

}
