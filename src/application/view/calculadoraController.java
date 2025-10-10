package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class calculadoraController {

	@FXML
    private Button btnReset;
	
    @FXML
    private Button btnDividir;

    @FXML
    private Button btnMultiplicar;

    @FXML
    private Label btnResultado;

    @FXML
    private Button btnSomar;

    @FXML
    private Button btnSubtrair;

    @FXML
    private TextField txtn1;

    @FXML
    private TextField txtn2;

    @FXML
    private void initialize() {
    	//setOnAction aciona o evento do componente
    	//por exemplo: o click no botão
    	//ou o enter em um text field
    	//btnSubtrair.setOnAction(e->{Subtrair();}); = colocar a função dos botões sem sair do eclipse
    	
    	btnReset.setOnAction(e->{
    		txtn1.setText("0");
    		txtn2.setText("0");
    		btnResultado.setText("0");
    	});
    	
    	
    	//adicionar um escutador de evento no text field de numero 1
    	//ao digitar dentro do text field ele vai trocar a letra por uma informação
    	txtn1.textProperty().addListener(
    	(observable, oldValue, newValue)->{
    	txtn1.setText(newValue.replaceAll("[^\\d.]",""));
    	});
    	
    	txtn2.textProperty().addListener(
    	(observable, oldValue, newValue)->{
    	txtn2.setText(newValue.replaceAll("[^\\d.]",""));
    	});
    	
    }
    
    @FXML
    public void Somar() {
    	double numero1;
    	double numero2;
    	try {
    	    numero1 = Double.valueOf(txtn1.getText());
    	} catch(Exception e) {
    		numero1=0;
    		txtn1.setText("0");
    	}
    	try {
    	    numero2 = Double.valueOf(txtn2.getText());
    	} catch(Exception e) {
    		numero2=0;
    		txtn2.setText("0");
    	}
    	double resultado = numero1+numero2;
    	// informa o resultado na label com o setText
    	String parOuImpar;
    	if(resultado % 2 == 0) {
    		parOuImpar="É Par.";
    	} else {
    		parOuImpar="É Impar";
    	}
    	
    	btnResultado.setText("Resultado: "+String.valueOf(resultado)+parOuImpar); // retorna o valor de double para string
    	
    }
    
    @FXML
    public void Subtrair() {
    	double numero1 = StrToDbl(txtn1.getText());
    	double numero2 = StrToDbl(txtn2.getText());
    	txtn1.setText(String.valueOf(numero1));
    	txtn2.setText(String.valueOf(numero2));
    	double resultado = numero1-numero2;
    	String parOuImpar;
    	if(resultado % 2==0) {
    		parOuImpar = "É Par.";
    	} else {
    		parOuImpar = "É Impar.";
    	}
    	
    	btnResultado.setText("Resultado: "+String.valueOf(resultado)+parOuImpar);
    }
    
    @FXML
    public void Multiplicar() {
    	double numero1 = StrToDbl(txtn1.getText());
    	double numero2 = StrToDbl(txtn2.getText());
    	txtn1.setText(String.valueOf(numero1));
    	txtn2.setText(String.valueOf(numero2));
    	double resultado = numero1*numero2;
    	String parOuImpar;
    	if(resultado % 2 == 0) {
    		parOuImpar ="É Par.";
    	} else {
    		parOuImpar ="É Impar.";
    	}
    	
    	btnResultado.setText("Resultado: "+String.valueOf(resultado)+parOuImpar);
    }
    
    @FXML
    public void Dividir() {
    	double numero1 = StrToDbl(txtn1.getText());
    	double numero2 = StrToDbl(txtn2.getText());
    	txtn1.setText(String.valueOf(numero1));
    	txtn2.setText(String.valueOf(numero2));
    	double resultado = numero1/numero2;
    	String parOuImpar;
    	if(resultado % 2 == 0) {
    		parOuImpar = "É Par.";
    	} else {
    		parOuImpar = "É Impar.";
    	}
    	
    	btnResultado.setText("Resultado: "+String.valueOf(resultado)+parOuImpar);
    }
    
    //metodo de converter string para double
    private static double StrToDbl(String numero) {
    	try {
    		return Double.valueOf(numero);
    	} catch(Exception e) {
    		return 0;
    	}
    }
    
}

//Anotação: setText = escrever uma fala na label
// getText = saber o que foi escrito na label

