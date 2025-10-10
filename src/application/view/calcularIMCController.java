package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    
    public void CalcularIMC() {
    	Double altura;
    	Double peso;
    	String nome;
    	Double resultado;
    	
    	nome = String.valueOf(txtNome.getText());
    	altura = Double.valueOf(txtAltura.getText());
    	peso = Double.valueOf(txtPeso.getText());
    	resultado = peso/(altura*altura);
    	
    	lblResultado.setText("Resultado: "+String.valueOf(resultado));
    	
    }

}

