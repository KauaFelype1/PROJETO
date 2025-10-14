package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import application.view.calculadoraController;

public class calcularIMCController {
	
    @FXML
    private Button btnCalcular;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtAltura;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPeso;
    
    @FXML
    public void CalcularIMC() {
    	Double altura;
    	Double peso;
    	String nome;
    	Double resultado;
    	// Primeira forma de fazer a classificação:
    	//String classificacao;
    	
    	nome = txtNome.getText();
    	altura = calculadoraController.StrToDbl(txtAltura.getText());
    	peso = Double.valueOf(txtPeso.getText());
    	resultado = peso/(altura*altura);
    	
    	//lblResultado.setText("Resultado: "+String.valueOf(resultado)+" "+classificarIMC(resultado));
    	lblResultado.setText(String.format(txtNome.getText()+" O seu IMC é %.2f",resultado)+" "+classificarIMC(resultado));
    	
    	/*if(resultado < 18.5) {
    		classificacao = "Você está abaixo do peso normal";
    	} else if(resultado >=18.5 && resultado <25){
    		classificacao = "Você está no peso normal";
    	} else if(resultado >=25 && resultado < 30) {
    		classificacao = "Você está em excesso de peso";
    	} else if(resultado >=30 && resultado < 35) {
    		classificacao = "Você está classificado em Obesidade Grau I";
    	} else if(resultado >= 35 && resultado < 40) {
    		classificacao = "Você está classificado em Obesidade Grau II";
    	} else if (resultado >= 40) {
    		classificacao = "Você está classificado em Obesidade Grau III";
    	}*/
    	
    }
    
    // Segunda forma de fazer a classificação:
   
    private String classificarIMC(double resultado) {
    	if(resultado < 18.5) {
    		return "Você está abaixo do peso normal";
    	} else if(resultado >=18.5 && resultado <25){
    		return "Você está no peso normal";
    	} else if(resultado >=25 && resultado < 30) {
    		return "Você está em excesso de peso";
    	} else if(resultado >=30 && resultado < 35) {
    		return "Você está classificado em Obesidade Grau I";
    	} else if(resultado >= 35 && resultado < 40) {
    		return "Você está classificado em Obesidade Grau II";
    	} else if (resultado >= 40) {
    		return "Você está classificado em Obesidade Grau III";
    	} else {
    		return "";
    	}
    }
    
    
    
    //Código para quando o enter for precionado a label passar automaticamente
    @FXML
    private void initialize() {
    	txtNome.setOnAction(e->{txtAltura.requestFocus();});
    	txtAltura.setOnAction(e->{txtPeso.requestFocus();});
    	txtPeso.setOnAction(e->{CalcularIMC();});
    	
    	
    	txtAltura.textProperty().addListener(
    	(observable, oldValue, newValue)->{
      	txtAltura.setText(newValue.replaceAll("[^\\d.]",""));
    	});
    	    	
      	txtPeso.textProperty().addListener(
    	(observable, oldValue, newValue)->{
    	txtPeso.setText(newValue.replaceAll("[^\\d.]",""));
       	});
    	
    	
    }
    
}

