module A1_Project_Search {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	
	opens Path to javafx.graphics, javafx.fxml;
}
