package varietyIdeas;

import java.awt.Container;

import javax.swing.JFrame;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class planeCoUserInterface extends Application implements EventHandler<ActionEvent> {

	private GraphicsContext g;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// Makes canvas and changes the color
		Canvas canvas = new Canvas(450, 750);
		g = canvas.getGraphicsContext2D();

		StackPane root = new StackPane(canvas);
		Scene scene = new Scene(root, 450, 750, javafx.scene.paint.Color.BLACK);

		// AddPatron Button
		Button AddP = new Button("Add Patron");
		
		
		root.getChildren().add(AddP);
		
		
		
		// Moves button to desired location
		AddP.setTranslateX(-150);
		AddP.setTranslateY(-315);

		AddP.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				GridPane grid = new GridPane();
			      
			      
				StackPane secondaryLayout = new StackPane();
				
				
				
				
				Scene secondScene = new Scene(grid, 400, 500);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Create A Patron");
				newWindow.setScene(secondScene);

				// Set position of second window, related to primary window.
				newWindow.setX(stage.getX() + 200);
				newWindow.setY(stage.getY() + 100);

				newWindow.show();
				/*
				 * 
				 * Opens new page and prompts user to fill text which is for Patron()
				 */
				// First Name Field
				TextField fN = new TextField();
				fN.setPromptText("Enter Your First Name");
				fN.setFocusTraversable(false);
				fN.setTranslateY(-315);
				grid.add(fN, 2, 2);
				
				
				// Last Name Field
				TextField lN = new TextField();
				lN.setPromptText("Enter your Last Name");
				lN.setFocusTraversable(false);
				
			}
		});

		stage.setScene(scene);
		stage.setTitle("PlaneCo");
		stage.show();

	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

}
