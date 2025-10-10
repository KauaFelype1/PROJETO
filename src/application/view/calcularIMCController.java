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
    	
    	nome = txtNome.getText();
    	altura = calculadoraController.StrToDbl(txtAltura.getText());
    	peso = Double.valueOf(txtPeso.getText());
    	resultado = peso/(altura*altura);
    	
    	lblResultado.setText("Resultado: "+String.valueOf(resultado));
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

