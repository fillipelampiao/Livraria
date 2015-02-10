package ch.makery.address.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Cliente;
import ch.makery.address.model.Grupos;
import ch.makery.address.util.ConectaBanco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CadastroClienteController implements Initializable {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	Cliente cliente = new Cliente();
	
	private ObservableList<Grupos> gruposSugestoes = FXCollections.observableArrayList();
	private ObservableList<Grupos> gruposAceitos = FXCollections.observableArrayList();
	

    @FXML
    private TextField txtOutros;

    @FXML
    private Button buttomVoltarGrupo;

    @FXML
    private TableColumn<Grupos, String> codSugeridos;

    @FXML
    private TableColumn<Grupos, String> nomeSugeridos;

    @FXML
    private Button buttomLimpar;

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
    private TextField txtFone;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private Button buttomIrGrupo;

    @FXML
    private TableColumn<Grupos, String> cod;

    @FXML
    private TableView<Grupos> gruposSugeridos;

    @FXML
    private TextField txtRg;
    
    @FXML
    void irGrupo(ActionEvent event) {
    	if (gruposSugeridos.getSelectionModel().getSelectedItem() != null ){
    	    Grupos grup = gruposSugeridos.getSelectionModel().getSelectedItem();
    	    cliente.getArrayGrupo().add(grup);
    	    gruposAceitos.add(new Grupos(grup.getId(),grup.getNome()));
	    	cod.setCellValueFactory(new PropertyValueFactory<Grupos, String>("id"));
			nome.setCellValueFactory(new PropertyValueFactory<Grupos, String>("nome"));
			grupos.setItems(gruposAceitos);
    		conecta.executaSQL("select * from clientes");
	    }
	    	    	
    }
    	
   

    @FXML
    void voltarGrupo(ActionEvent event) {
    	if (grupos.getSelectionModel().getSelectedItem() != null ){
    		Grupos grup = grupos.getSelectionModel().getSelectedItem();
    		gruposAceitos.removeAll(grup);
    		cliente.getArrayGrupo().remove(grup);
    	}
    }

    @FXML
    void limpar(ActionEvent event) {
    	txtNome.setText("");
    	txtCpf.setText("");
    	txtRg.setText("");
    	txtEmail.setText("");
    	txtOutros.setText("");
    	txtFone.setText("");
    	gruposAceitos.clear();
    	cliente.getArrayGrupo().clear();
    }

    @FXML
    void confirmar(ActionEvent event) {
    	conecta.conexao();
    	try {
			PreparedStatement pst = conecta.conn.prepareStatement("insert into clientes (nome_cliente, cpf_cliente, rg_cliente, email_cliente, outros_cliente, telefone_cliente) values(?,?,?,?,?,?)");
			cliente = new Cliente(txtNome.getText(),txtCpf.getText(),txtRg.getText(),txtEmail.getText(),txtOutros.getText(),txtFone.getText());

			pst.setString(1, cliente.getNome());
	    	pst.setString(2, cliente.getCpf());
	    	pst.setString(3, cliente.getRg());
	    	pst.setString(4, cliente.getEmail());
	    	pst.setString(5, cliente.getOutros());
	    	pst.setString(6, cliente.getFone());
	    	pst.executeUpdate();
	    	
	    	for (Grupos grupos : cliente.getArrayGrupo()) {
	    		conecta.rs.last();
	    		int idCliente = conecta.rs.getInt("id_cliente"); 
	    		PreparedStatement pstGrupo = conecta.conn.prepareStatement("insert into grupos_clientes (id_cliente, id_grupo) values(?,?)");
	    		pstGrupo.setInt(1, idCliente);
	    		pstGrupo.setInt(2, Integer.valueOf(grupos.getId()));
	    		pstGrupo.executeUpdate();
	    	}
	    	
	    	JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso");
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null,"Erro ao cadastrar"+e);
		}
    	txtNome.setText("");
    	txtCpf.setText("");
    	txtRg.setText("");
    	txtEmail.setText("");
    	txtOutros.setText("");
    	txtFone.setText("");
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Cadastro.fxml");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conecta.conexao();
    	conecta.executaSQL("select * from grupos where tipo_grupo = 1");
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
        
    
	}

}
