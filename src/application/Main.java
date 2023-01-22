package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class Main extends Application {
	ProjectCollection p;
    ListView<String> listView;
    String CurrentProject;
    String CurrentSelection;
    Pane pane;
    BorderPane borderPane;
    public static void main (String[]args){
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException, ParseException {
        VBox layout = new VBox(10);
         borderPane = new BorderPane();
         pane = new Pane();
        StackPane stackPane = new StackPane(pane);
        Scene scene = new Scene(borderPane);
        borderPane.setLeft(layout);
        borderPane.setCenter(stackPane);

        stackPane.setAlignment(pane,Pos.BOTTOM_RIGHT);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        listView = new ListView<>();
        listView.setPrefWidth(300);
         p = readExcel.getProjects();
         // adding the projects in the listView
        for (project p1 : p.projectArray()) {
            listView.getItems().addAll(p1.getCustomerProjectID() + "      Stages : " + p1.getNumberofStage());

                }
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView);



        // the handler of listView      
        listView.setOnMouseClicked(event->{
        	
        	String id=listView.getSelectionModel().getSelectedItem();        	
        	String CustomerProjectID= id.split("\\s")[0]; 
        	project clickedProject=p.findProjectById(CustomerProjectID) ;
//        	System.out.println(clickedProject.getBefor());
//        	System.out.println(clickedProject.getAfter());
        	setTimeLine( clickedProject);
        	AfterBefore(clickedProject.getBefor()+"",clickedProject.getAfter()+"");
        	
        });
        stage.show();
            };
            
            
public void setTimeLine(project p) {
	pane.getChildren().clear();
	//Drowning the line Y  is 300 and the X position from 10 to 550 
//	 Line line1 = new Line(10, 300, 550, 300);
//     for(int i=0; i<550; i=i+10){
//     	Text text1 = new Text(10+i, 305, "|");
//         pane.getChildren().add(text1);
//         }
     

	Date befor=p.stageArray()[0].getDateObj();
	// Difference= the Difference between 2 stages
	int Difference=0;
	int x=10;
	int y=300;
	// Duration=last stage date - first stage date
	int Duration=(int) ChronoUnit.DAYS.between(p.stageArray()[0].getDateObj().toInstant(), p.stageArray()[p.stageArray().length-1].getDateObj().toInstant());
	Text text3 = new Text(300, 150, "Durtaion is "+Duration+" days");
	pane.getChildren().addAll(text3);
	// loop for all stages in a project p
	 for (stage s : p.stageArray()) {
		 // if a stage is the first stage in a date 
		 if(!s.getDuplicat()) {
			 y=300;
			 Difference= (int) ChronoUnit.DAYS.between(befor.toInstant(), s.getDateObj().toInstant());
			 // x = x+5 ,if there is a difference between 2 stage then x=x+Difference*5+5
			 x=x+Difference*10;
			 Text text1 = new Text(x, y, "*");
			 // text2 is the date in the timeline
			 Text text2 = new Text(x, y+30, s.getDate());
			 text2.setStyle("-fx-font: 10 arial;");
			 text1.setStyle("-fx-font: 20 arial;");
			 text2.setRotate(40);
			 double d = Double.parseDouble(s.getNewvalue());
			 int i = (int) d;
//			 Text newvalue= new Text(x-5, y, i+"");
			 draw(x-5, y, i+"");
			 // if the old value> new value
			  if(s.getOldvalue().compareTo(s.getNewvalue())==1) {
				 text1.setFill(Color.RED); 
				 text2.setFill(Color.RED); 
			 }
			 pane.getChildren().addAll(text1,text2);
			 befor=s.getDateObj();
		 }
		 
		 // if a stage is not the first stage in a date we just modify the Y position
		 else if(s.getDuplicat()) {
			 y=y-10;
			 Text text1 = new Text(x, y, "*");
			 text1.setStyle("-fx-font: 20 arial;");



			 // if the old value> new value

			  if(s.getOldvalue().compareTo(s.getNewvalue())==1) {
				 text1.setFill(Color.RED); 

			 }
			 pane.getChildren().add(text1);
			 double d = Double.parseDouble(s.getNewvalue());
			 int i = (int) d;
			 draw(x-5, y, i+"");
			 
		 }
		
	     for(int i=0; i<x; i=i+10){
	     	Text text1 = new Text(10+i, 305, "|");
	         pane.getChildren().addAll(text1);
	         }
             }
	 	Line line1 = new Line(10, 300, x, 300);
        pane.getChildren().addAll(line1);

	
}
public void draw(int x ,int y , String s) {
	Text text1 = new Text(x, y-5, s);
	text1.setStyle("-fx-font: 10 arial;");
	pane.getChildren().addAll(text1);
}
public HBox AfterBefore(String b, String a) {
	 VBox befor = new VBox(10);
	 befor.getChildren().addAll(new Text("Before Award"),new Text(b));
	 VBox after = new VBox(10);
	 after.getChildren().addAll(new Text("After Award"),new Text(a));
//	 befor.setStyle("-fx-border-color: black");
//	 after.setStyle("-fx-border-color: black");
	 HBox hbox = new HBox(10);
	 hbox.getChildren().addAll(befor,after);
	 
//	 hbox.setStyle("-fx-border-color: black");
	 hbox.setPadding(new Insets(30, 30, 30, 30));
	 hbox.setStyle("-fx-font: 20 arial;");
	 BorderPane.setAlignment(hbox, Pos.CENTER);
	 borderPane.setTop(hbox);
	
	 return hbox;
}

}
        

