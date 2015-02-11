package ch.makery.address.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ch.makery.address.model.Produtos;
import ch.makery.address.util.ConectaBanco;
import ch.makery.address.util.VerProdutoCadastro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditarConsultaFuncionarioController implements Initializable {
	static String idfunc;
	VerProdutoCadastro novaTela = new VerProdutoCadastro();
	ConsultaFuncionarioController funcionarioDados = new ConsultaFuncionarioController();
	ConectaBanco conecta = new ConectaBanco();
	static String pesquisa;

    @FXML
    private Button buttomSelecionar;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private Button butomVoltar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtGrupo;

    @FXML
    private TextField txtRg;

    @FXML
    void voltar(ActionEvent event) {
    	novaTela.stage2.close();
    }

    @FXML
    void confirmar(ActionEvent event) {
		idfunc = ConsultaFuncionarioController.idfunc;
		int id = Integer.valueOf(idfunc);
    	conecta.conexao();
		try {
			PreparedStatement pst = conecta.conn.prepareStatement("update funcionarios set nome_funcionario='"+txtNome.getText()+"',senha_funcionario='"+txtSenha.getText()+"',email_funcionario='"+txtEmail.getText()+"',cpf_funcionario='"+txtCpf.getText()+"',rg_funcionario='"+txtRg.getText()+"'");
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	novaTela.stage2.close();
    	funcionarioDados.pesquisar(event);
    }

    @FXML
    void selecionar(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idfunc = ConsultaFuncionarioController.idfunc;
		int id = Integer.valueOf(idfunc);
		conecta.conexao();
		conecta.executaSQL("select * from funcionarios where id_funcionario='"+id+"'");
	
		try {
			while (conecta.rs.next()) {
				txtSenha.setText(conecta.rs.getString("senha_funcionario"));
				txtNome.setText(conecta.rs.getString("nome_funcionario"));
				txtEmail.setText(conecta.rs.getString("email_funcionario"));
				txtCpf.setText(conecta.rs.getString("cpf_funcionario"));
				txtRg.setText(conecta.rs.getString("rg_funcionario"));
//				txtGrupo.setText(conecta.rs.getString("grupo_funcionario"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
