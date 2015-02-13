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

public class EditarConsultaGrupoFuncionarioController implements Initializable {
	static String idGrupo;
	VerProdutoCadastro novaTela = new VerProdutoCadastro();
	ConsultaGrupoFuncionarioController grupoDados = new ConsultaGrupoFuncionarioController();
	ConectaBanco conecta = new ConectaBanco();
	static String pesquisa;

    @FXML
    private Button butomVoltar;

    @FXML
    private TextField txtNome;

    @FXML
    private Button buttomConfirmar;

    @FXML
    void voltar(ActionEvent event) {
    	novaTela.stage2.close();
    }

    @FXML
    void confirmar(ActionEvent event) {
    	idGrupo = ConsultaGrupoFuncionarioController.idGrupo;
		int id = Integer.valueOf(idGrupo);
    	conecta.conexao();
		try {
			PreparedStatement pst = conecta.conn.prepareStatement("update grupos set nome_grupo='"+txtNome.getText()+"' where id_grupo='"+id+"'");
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	novaTela.stage2.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idGrupo = ConsultaGrupoFuncionarioController.idGrupo;
		int id = Integer.valueOf(idGrupo);
		conecta.conexao();
		conecta.executaSQL("select * from grupos, grupos_funcionarios where grupos.id_grupo=grupos_funcionarios.id_grupo");
	
		try {
			while (conecta.rs.next()) {
				txtNome.setText(conecta.rs.getString("nome_grupo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
