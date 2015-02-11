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

public class EditarConsultaClienteController implements Initializable {
	static String idcliente;
	VerProdutoCadastro novaTela = new VerProdutoCadastro();
	ConsultaClienteController clienteDados = new ConsultaClienteController();
	ConectaBanco conecta = new ConectaBanco();
	static String pesquisa;

    @FXML
    private Button buttomExcluir;

    @FXML
    private Button butomVoltar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button buttomSelecionaGrupo;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtFone;

    @FXML
    private TextField txtGrupo;

    @FXML
    private TextField txtRg;

    @FXML
    void voltar(ActionEvent event) {
    	novaTela.stage2.close();
    }

    @FXML
    void excluir(ActionEvent event) {
		idcliente = ConsultaClienteController.idcliente;
		int id = Integer.valueOf(idcliente);
    	conecta.conexao();
		try {
			PreparedStatement pst = conecta.conn.prepareStatement("update clientes set nome_cliente='"+txtNome.getText()+"',email_cliente='"+txtEmail.getText()+"',cpf_cliente='"+txtCpf.getText()+"',rg_cliente='"+txtRg.getText()+"',telefone_cliente='"+txtFone.getText()+"'");
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	novaTela.stage2.close();
    }

    @FXML
    void selecionaGrupo(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idcliente = ConsultaClienteController.idcliente;
		int id = Integer.valueOf(idcliente);
		conecta.conexao();
		conecta.executaSQL("select * from clientes where id_cliente='"+id+"'");
	
		try {
			while (conecta.rs.next()) {
				txtFone.setText(conecta.rs.getString("telefone_cliente"));
				txtNome.setText(conecta.rs.getString("nome_cliente"));
				txtEmail.setText(conecta.rs.getString("email_cliente"));
				txtCpf.setText(conecta.rs.getString("cpf_cliente"));
				txtRg.setText(conecta.rs.getString("rg_cliente"));
//				txtGrupo.setText(conecta.rs.getString("grupo_funcionario"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
