module ProjectFx {
	requires javafx.controls;
	requires javafx.graphics;
	requires org.apache.poi.ooxml;
	requires org.apache.poi.poi;
	
	opens application to javafx.graphics, javafx.fxml;
}
