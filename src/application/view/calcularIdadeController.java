package application.view;

import java.time.LocalDate;
import java.time.Period;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class calcularIdadeController {

    @FXML
    private Button btnIdade;

    @FXML
    private DatePicker txtIdade;

    @FXML
    private TextField txtNome;

    @FXML
    private Label txtResultado;

    @FXML
    public void CalcularIdade() {
    	String nome = txtNome.getText();
    	LocalDate dataNascimento = txtIdade.getValue();
    	
    	if(dataNascimento != null && nome != null && !nome.isEmpty()) {
    		LocalDate hoje = LocalDate.now();
    		Period idade = Period.between(dataNascimento, hoje);
    		
    		long diasVividos = java.time.temporal.ChronoUnit.DAYS.between(dataNascimento, hoje);
    		
    		String diaSemanaNascimento =
    		dataNascimento.getDayOfWeek().getDisplayName(
    				java.time.format.TextStyle.FULL,
    				java.util.Locale.getDefault());
    		
    		txtResultado.setText(nome + ", sua idade é: " + idade.getYears() + " anos." + " Você viveu: "+ diasVividos + " dias," + " e nasceu em uma " + diaSemanaNascimento);
    	} else {
    		txtResultado.setText("Por favor preencha todos os campos.");
    	} 	
    }
    
    
}
