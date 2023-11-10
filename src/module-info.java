/**
 * 
 */
/**
 * 
 */
module EjercicioK {
	requires javafx.graphics;
	requires javafx.fxml;
	opens application to javafx.graphics, javafx.base;
	opens controller to javafx.fxml,javafx.graphics, javafx.base;
}