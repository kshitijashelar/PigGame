module Project {
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires org.junit.jupiter.api;
	exports pig.gui;
    opens pig.gui to javafx.fxml;
}
