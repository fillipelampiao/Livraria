package ch.makery.address.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Funcionarios;
import ch.makery.address.model.Grupos;
import ch.makery.address.util.ConectaBanco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CadastroFuncionarioController implements Initializable{
	Funcionarios funcionario = new Funcionarios();
	
	ConectaBanco conecta = new ConectaBanco();
	
	Main main = new Main();
	
	private ObservableList<Grupos> gruposSugestoes = FXCollections.observableArrayList();
	private ObservableList<Grupos> gruposAceitos = FXCollections.observableArrayList();
	
	@FXML 
	private TextField txtOutros;

	@FXML
	private Button buttomVoltarGrupo;

	@FXML
	private TableColumn<Grupos, String> codSugeridos;

	@FXML
	private CheckBox perConsultar;

	@FXML
	private TableColumn<Grupos, String> nomeSugeridos;

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
	private TableColumn<Grupos, String> nome;

	@FXML
	private TextField txtCpf;

	@FXML
	private Button buttomConfirmar;

	@FXML
	private Button buttomIrGrupo;

	@FXML
	private TableColumn<Grupos, String> cod;

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
    	    Grupos grup = gruposSugeridos.getSelectionModel().getSelectedItem();
    	    funcionario.getArrayGrupo().add(grup);
    	    gruposAceitos.add(new Grupos(grup.getId(),grup.getNome()));
	    	cod.setCellValueFactory(new PropertyValueFactory<Grupos, String>("id"));
			nome.setCellValueFactory(new PropertyValueFactory<Grupos, String>("nome"));
			gruposSugestoes.remove(gruposSugeridos.getSelectionModel().getSelectedItem());
			grupos.setItems(gruposAceitos);
	    }

    }

    @FXML
    void voltarGrupo(ActionEvent event) {
    	Grupos grup = grupos.getSelectionModel().getSelectedItem();
    	if (grup != null ){
    		gruposAceitos.removeAll(grup);
    		gruposSugestoes.add(grup);
    		Grupos grupo = null;
    		for(Grupos g : funcionario.getArrayGrupo()) {
    			if(g.getId().equals(grup.getId())) {
    				grupo = g;
    				break;
    			}
    		}
    		if(grupo != null)
    			funcionario.getArrayGrupo().remove(grupo);
    	}
    }

    @FXML
    void limpar(ActionEvent event) {
    	txtNome.setText("");
    	txtSenha.setText("");
    	txtCpf.setText("");
    	txtRg.setText("");
    	txtEmail.setText("");
    	txtOutros.setText("");
    	gruposAceitos.clear();
    	gruposSugestoes.clear();
    	funcionario.getArrayGrupo().clear();
    	initialize(null,null);
    }

    @FXML
    void confirmar(ActionEvent event) {
    	conecta.conexao();
    	try {
			PreparedStatement pst = conecta.conn.prepareStatement("insert into funcionarios (nome_funcionario, cpf_funcionario, rg_funcionario, email_funcionario, outros_funcionario, senha_funcionario) values(?,?,?,?,?,?)");
	    	Funcionarios funcionario = new Funcionarios(txtNome.getText(),txtCpf.getText(),
	    								txtRg.getText(),txtEmail.getText(),txtOutros.getText(),txtSenha.getText());
			pst.setString(1, funcionario.getNome() );
	    	pst.setString(2, funcionario.getCpf());
	    	pst.setString(3, funcionario.getRg());
	    	pst.setString(4, funcionario.getEmail());
	    	pst.setString(5, funcionario.getOutros());
	    	pst.setString(6, funcionario.getidentificacao());
	    	pst.executeUpdate();
	    	
	    	for (Grupos grupos : funcionario.getArrayGrupo()) {
	    		conecta.executaSQL("select * from funcionarios");
	    		conecta.rs.last();
	    		int idFuncionario = conecta.rs.getInt("id_funcionario"); 
	    		PreparedStatement pstGrupo = conecta.conn.prepareStatement("insert into grupos_funcionarios (id_funcionario, id_grupo) values(?,?)");
	    		pstGrupo.setInt(1, idFuncionario);
	    		pstGrupo.setInt(2, Integer.valueOf(grupos.getId()));
	    		pstGrupo.executeUpdate();
	    	}
	    	
	    	
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
    	funcionario.getArrayGrupo().clear();
    	gruposSugestoes.clear();
    	gruposAceitos.clear();
    	initialize(null, null);
    	conecta.desconecta();
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Cadastro.fxml");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conecta.conexao();
    	conecta.executaSQL("select * from grupos where tipo_grupo = 2");
    	try {
			while (conecta.rs.next()) {
				gruposSugestoes.add(new Grupos(String.valueOf(conecta.rs.getInt("id_grupo")),conecta.rs.getString("nome_grupo")));
				codSugeridos.setCellValueFactory(new PropertyValueFactory<Grupos, String>("id"));
				nomeSugeridos.setCellValueFactory(new PropertyValueFactory<Grupos, String>("nome"));
				gruposSugeridos.setItems(gruposSugestoes);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao inicializar Grupos de fornecedores");
		}
    	PreparedStatement pst;
		
    	try {
			pst = conecta.conn.prepareStatement("INSERT INTO grupos (tipo_grupo) values (?)");
			pst.setInt(1,1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	conecta.desconecta();
		
	}

}
