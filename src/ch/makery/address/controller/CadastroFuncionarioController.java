package ch.makery.address.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Funcionarios;
import ch.makery.address.model.Grupos;
import ch.makery.address.util.ConectaBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CadastroFuncionarioController {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	
	@FXML
    private TextField txtOutros;

    @FXML
    private Button buttomVoltarGrupo;

    @FXML
    private CheckBox perConsultar;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button buttomLimpar;

    @FXML
    private CheckBox perCadastrar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button buttomVoltar;

    @FXML
    private TableView<Grupos> grupos;

    @FXML
    private TextField txtCpf;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private Button buttomIrGrupo;

    @FXML
    private CheckBox perVender;

    @FXML
    private TableView<Grupos> gruposSugeridos;

    @FXML
    private TextField txtRg;

    @FXML
    private CheckBox perRelatorio;

    @FXML
    void irGrupo(ActionEvent event) {
    	if (gruposSugeridos.getSelectionModel().getSelectedItem() != null ){
    	    Grupos c = grupos.getSelectionModel().getSelectedItem();
    	    gruposAceitos.add(new Grupos(c.getId(),c.getNome()));
    	    codSugeridos.setCellValueFactory(new PropertyValueFactory<Grupos, String>("id"));
    	    nomeSugeridos.setCellValueFactory(new PropertyValueFactory<Grupos, String>("nome"));
    	    gruposSugeridos.setItems(gruposAceitos);
    	}

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
			PreparedStatement pst = conecta.conn.prepareStatement("insert into funcionarios (nome_funcionario, senha_funcionario, cpf_funcionario, rg_funcionario, email_funcionario, outros_funcionario) values(?,?,?,?,?,?,?)");
	    	Funcionarios funcionario = new Funcionarios(txtNome.getText(),txtSenha.getText(),txtCpf.getText(),
	    								txtRg.getText(),txtEmail.getText(),txtOutros.getText());
			
			pst.setString(1, funcionario.getNome() );
	    	pst.setString(2, funcionario.getidentificacao());
	    	pst.setString(3, funcionario.getCpf());
	    	pst.setString(4, funcionario.getRg());
	    	pst.setString(5, funcionario.getEmail());
	    	pst.setString(6, funcionario.getOutros());
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
