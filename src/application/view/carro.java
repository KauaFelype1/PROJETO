package application.view;

import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class carro {
	
	@FXML
    private Button btnDesligar;

    @FXML
    private Button btnInformacao;

    @FXML
    private Button btnLigar;

    @FXML
    private Label lblIn;

    @FXML
    private TextField txt1;
	
	//Scanner entrada = new Scanner(System.in);
	String Marca1;
	String Nome1;
	String Motor1;
	String Cor1;
	String ano1;
	String Modelo1;
	boolean carroLigado1, carroLigado2, carroLigado3, carroLigado4, carroLigado5;
	String escolha;
	
	
	@FXML
	private void exibirInformacoes() {
		escolha = txt1.getText();
		
		if(escolha.equalsIgnoreCase("Carro 1") && carroLigado1 == true) {
			Marca1 = "Chevrolet";
			Motor1 = "1.4 Flex";
			Cor1 = "Branco";
			ano1 = "2025";
			Modelo1 = "Prisma";
			lblIn.setText("Marca: "+Marca1+", Motor: "+Motor1+", Cor: "+Cor1+", Ano: "+ano1+", Modelo: "+Modelo1+". O carro está ligado.");
	
		} else if(escolha.equalsIgnoreCase("Carro 2") && carroLigado2 == true) {
			Marca1 = "Toyota";
			Motor1 = "motor 2.0 Dynamic Force Dual VVT-iE flex";
			Cor1 = "Cinza";
			ano1 = "2025";
			Modelo1 = "Corolla";
			lblIn.setText("Marca: "+Marca1+", Motor: "+Motor1+", Cor: "+Cor1+", Ano: "+ano1+", Modelo: "+Modelo1+". O carro está ligado.");

		} else if(escolha.equalsIgnoreCase("Carro 3") && carroLigado3 == true) {
			Marca1 = "Fiat";
			Motor1 = "Firefly 1.0 de 3 cilindros";
			Cor1 = "Preto";
			ano1 = "2022";
			Modelo1 = "Argo";
			lblIn.setText("Marca: "+Marca1+", Motor: "+Motor1+", Cor: "+Cor1+", Ano: "+ano1+", Modelo: "+Modelo1+". O carro está ligado.");

		} else if(escolha.equalsIgnoreCase("Carro 4") && carroLigado4 == true) {
			Marca1 = "Hyundai";
			Motor1 = "1.6 Turbo GDI de 177 cv";
			Cor1 = "Azul Escuro";
			ano1 = "2025";
			Modelo1 = "Tucson";
			lblIn.setText("Marca: "+Marca1+", Motor: "+Motor1+", Cor: "+Cor1+", Ano: "+ano1+", Modelo: "+Modelo1+". O carro está ligado.");

		} else if(escolha.equalsIgnoreCase("Carro 5") && carroLigado5 == true) {
			Marca1 = "Honda";
			Motor1 = "1.5 i-VTEC aspirado flex";
			Cor1 = "Vermelho";
			ano1 = "2024";
			Modelo1 = "SUV compacto WR-V";
			lblIn.setText("Marca: "+Marca1+", Motor: "+Motor1+", Cor: "+Cor1+", Ano: "+ano1+", Modelo: "+Modelo1+". O carro está ligado.");

		} else if(carroLigado1 == false) {
			lblIn.setText("Carro deligado!!");	
		} else if(carroLigado2 == false) {
			lblIn.setText("Carro desligado!!");
		} else if(carroLigado3 == false) {
			lblIn.setText("Carro desligado!!");
		} else if(carroLigado4 == false ) {
			lblIn.setText("Carro desligado!!");
		}else if(carroLigado5 == false) {
			lblIn.setText("Carro desligado!!");
		} else {
			lblIn.setText("Escolha inválida");
		}
		
		
	}
	
	@FXML
	private void ligarCarro() {
		carroLigado1 = true;
		carroLigado2 = true;
		carroLigado3 = true;
		carroLigado4 = true;
		carroLigado5 = true;
		lblIn.setText("Carro ligado");
		/*if(escolha.equalsIgnoreCase("Carro 1")) {
		carroLigado1 = true;
		lblIn.setText("Carro Ligado!");
		} else if(escolha.equalsIgnoreCase("Carro 2")) {
			carroLigado2 = true;
			lblIn.setText("Carro Ligado!");
		} else if(escolha.equalsIgnoreCase("Carro 3")) {
			carroLigado3 = true;
			lblIn.setText("Carro Ligado!");
		} else if(escolha.equalsIgnoreCase("Carro 4")) {
			carroLigado4 = true;
			lblIn.setText("Carro Ligado!");
		} else if(escolha.equalsIgnoreCase("Carro 5")) {
			carroLigado5 = true;
			lblIn.setText("Carro Ligado!");
		}*/
	}
	
	@FXML
	private void desligarCaro() {
		carroLigado1 = false;
		carroLigado2 = false;
		carroLigado3 = false;
		carroLigado4 = false;
		carroLigado5 = false;
		lblIn.setText("Carro desligado!");
		//escolha = txt1.getText();
		/*if(escolha.equalsIgnoreCase("Carro 1")) {
			carroLigado1 = false;
			lblIn.setText("Carro Ligado!");
			} else if(escolha.equalsIgnoreCase("Carro 2")) {
				carroLigado2 = false;
				lblIn.setText("Carro Ligado!");
			} else if(escolha.equalsIgnoreCase("Carro 3")) {
				carroLigado3 = false;
				lblIn.setText("Carro Ligado!");
			} else if(escolha.equalsIgnoreCase("Carro 4")) {
				carroLigado4 = false;
				lblIn.setText("Carro Ligado!");
			} else if(escolha.equalsIgnoreCase("Carro 5")) {
				carroLigado5 = false;
				lblIn.setText("Carro Ligado!");
			}*/
	}

}
