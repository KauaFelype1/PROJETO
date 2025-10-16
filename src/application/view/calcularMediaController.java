package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import application.view.calculadoraController;

public class calcularMediaController {

    @FXML
    private Button btnCalcular;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField lbln1;

    @FXML
    private TextField lbln2;

    @FXML
    private TextField lbln3;

    @FXML
    private TextField lbln4;
    
    
    @FXML
    private void initialize() {
    	lbln1.textProperty().addListener((observable, oldValue, newValue)->{lbln1.setText(newValue.replaceAll("[^\\d.]",""));});
    	lbln2.textProperty().addListener((observable, oldValue, newValue)->{lbln2.setText(newValue.replaceAll("[^\\d.]",""));});
    	lbln3.textProperty().addListener((observable, oldValue, newValue)->{lbln3.setText(newValue.replaceAll("[^\\d.]",""));});
    	lbln4.textProperty().addListener((observable, oldValue, newValue)->{lbln4.setText(newValue.replaceAll("[^\\d.]",""));});
    	
    	
    	lbln1.setOnAction(e->{lbln2.requestFocus();});
    	lbln2.setOnAction(e->{lbln3.requestFocus();});
    	lbln3.setOnAction(e->{lbln4.requestFocus();});
    	lbln4.setOnAction(e->{Calcular();});
    	
    }
    
    
    @FXML
    private void Calcular() {
    	double n1;
    	double n2;
    	double n3;
    	double n4;
    	double media;
    	
    	n1 = calculadoraController.StrToDbl(lbln1.getText());
    	n2 = calculadoraController.StrToDbl(lbln2.getText());
    	n3 = calculadoraController.StrToDbl(lbln3.getText());
    	n4 = calculadoraController.StrToDbl(lbln4.getText());
    	media = (n1+n2+n3+n4)/4;
    	
    	lblResultado.setText("Resultado: "+media+ " Você está "+avaliacao(media));
    	
    	
    }
    
    
    private String avaliacao(double media) {
    	if(media <=4) {
    		return "Reprovado";
    	} else if(media>4 && media<7) {
    		return "Recuperação";
    	} else if(media>=7) {
    		return "Aprovado";
    	} else {
    		return "";
    	}	
    }
    	

}
