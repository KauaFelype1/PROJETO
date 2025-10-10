module Projeto {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.view to javafx.fxml; // Caso ocorra erro, adicionar os dois ultimos códigos 
	exports application.view;
}
