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

public class EditarConsultaGrupoClienteController implements Initializable{
	static String idgrupo;
	VerProdutoCadastro novaTela = new VerProdutoCadastro();
	ConsultaGrupoClienteController grupoDados = new ConsultaGrupoClienteController();
	ConectaBanco conecta = new ConectaBanco();
	static String pesquisa;

    @FXML
    private Button buttomExcluir;

    @FXML
    private Button butomVoltar;

    @FXML
    private TextField txtNome;

    @FXML
    void voltar(ActionEvent event) {
    	novaTela.stage2.close();
    }

    @FXML
    void excluir(ActionEvent event) {
		idgrupo = ConsultaGrupoClienteController.idGrupo;
		int id = Integer.valueOf(idgrupo);
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
		idgrupo = ConsultaGrupoClienteController.idGrupo;
		int id = Integer.valueOf(idgrupo);
		conecta.conexao();
		conecta.executaSQL("select * from grupos, grupos_clientes where grupos.tipo_grupo=grupos_clientes.id_grupo_cliente ");
	
		try {
			while (conecta.rs.next()) {
				txtNome.setText(conecta.rs.getString("nome_grupo"));
//				txtGrupo.setText(conecta.rs.getString("grupo_funcionario"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
