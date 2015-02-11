package ch.makery.address.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ch.makery.address.util.ConectaBanco;
import ch.makery.address.util.VerProdutoCadastro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditarConsultaFornecedorController implements Initializable{
	VerProdutoCadastro novaTela = new VerProdutoCadastro();
	static String idforn;
	ConsultaFornecedorController fornecedorDados = new ConsultaFornecedorController();
	ConectaBanco conecta = new ConectaBanco();
	static String pesquisa;

    @FXML
    private Button buttomSelecionar;

    @FXML
    private Button buttomExcluir;

    @FXML
    private Button butomVoltar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFone;

    @FXML
    private TextField txtGrupo;

    @FXML
    private TextField txtCpfCnpj;

    @FXML
    void voltar(ActionEvent event) {
    	novaTela.stage2.close();
    }

    @FXML
    void excluir(ActionEvent event) {
		idforn = ConsultaFornecedorController.idforn;
		int id = Integer.valueOf(idforn);
    	conecta.conexao();
		try {
			PreparedStatement pst = conecta.conn.prepareStatement("update fornecedores set nome_fornecedor='"+txtNome.getText()+"',telefone_fornecedor='"+txtFone.getText()+"',email_fornecedor='"+txtEmail.getText()+"',cnpj_fornecedor='"+txtCpfCnpj.getText()+"'");
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	novaTela.stage2.close();
    }

    @FXML
    void selecionar(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idforn = ConsultaFornecedorController.idforn;
		int id = Integer.valueOf(idforn);
		conecta.conexao();
		conecta.executaSQL("select * from fornecedores where id_fornecedore='"+id+"'");
	
		try {
			while (conecta.rs.next()) {
				txtFone.setText(conecta.rs.getString("outros_fornecedor"));
				txtNome.setText(conecta.rs.getString("nome_fornecedor"));
//				txtEmail.setText(conecta.rs.getString("email_fornecedor"));
				txtCpfCnpj.setText(conecta.rs.getString("cnpj_fornecedor"));
//				txtGrupo.setText(conecta.rs.getString("grupo_funcionario"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
