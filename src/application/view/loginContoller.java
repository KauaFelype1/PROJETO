package application.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginContoller {
	@FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtUsuario;
	
	public void voltar() {
		System.exit(0);
	}
	
	public void confirmar() {
		try {
		String usuario=txtUsuario.getText();
		String senha=txtSenha.getText();
		
		if (usuario.equals("kaua") && senha.equals("admin")) {
			Alert mensagem;
			mensagem = new Alert(Alert.AlertType.CONFIRMATION);
			mensagem.setTitle("Confirmação");
			mensagem.setHeaderText(null);
			mensagem.setContentText("Bem Vindo ao Sistema "+usuario);
			mensagem.showAndWait();
			
			// FECHAR TELA DE LOGIN
			txtUsuario.getScene().getWindow().hide();
			
			// ABRE A TELA PRINCIPAL
			Parent root = FXMLLoader.load(getClass().getResource("aplicativo.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			
			
		} else {
			Alert mensagem;
			mensagem = new Alert(Alert.AlertType.ERROR);
			mensagem.setTitle("Erro");
			mensagem.setHeaderText(null);
			mensagem.setContentText("Usuario ou senha incorretos");
			mensagem.showAndWait();
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	/* @FXML ou @override -> indica que o código será executado assim que carregar
	 * a página*/
	private void initialize() {
	//QUANDO PRECIONAR ENTER NO CAMPO USUARIO FOCA A EDIÇÃO NO CAMPO DE SENHA
		txtUsuario.setOnAction(e->{txtSenha.requestFocus();});
	// QUANDO PRESSIONAR ENTER NO CAMPO SENHA ACIONA O MÉTODO DE ENTRAR
		txtSenha.setOnAction(e->{confirmar();});
	}
}
