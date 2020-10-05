package data.gui;

import EngineTester.MainGameLoop;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class iconic extends Application{
	
	static Button b1 = new Button ("Accept");
	static Button b2 = new Button ("Decline");
	static Button Warrior = new Button();
	static Button Wizard = new Button();
	static Button Archer = new Button();
	static Button Assassin = new Button();
	static Button Theif = new Button();
	
	public static boolean warrior = false;
	public static boolean wizard = false;
	public static boolean archer = false;
	public static boolean assassin = false;
	public static boolean theif = false;

	public static void main(String[] args) {

		launch(args);
		
	}
	
	public void start (Stage window) throws Exception {
		
		String title = "Main Menu - Select ArcheType you wish to play as";
		window.setTitle(title);
		FlowPane fp = new FlowPane(); 
		
		fp.getChildren().addAll(Warrior, Archer, Wizard, Assassin, Theif);
		
		BorderPane layout = new BorderPane();
		layout.setStyle("-fx-background-color: black;");
		layout.setTop(fp);
		
		ImageView Warrior_Image = new ImageView(new Image(iconic.class.getResourceAsStream("Warrior.jpg")));
		Warrior_Image.setFitWidth(112);
		Warrior_Image.setFitHeight(290);
		
		ImageView Archer_Image = new ImageView(new Image(iconic.class.getResourceAsStream("Mech-Archer.jpg")));
		Archer_Image.setFitWidth(112);
		Archer_Image.setFitHeight(290);
		
		ImageView Wizard_Image = new ImageView(new Image(iconic.class.getResourceAsStream("Wizard.jpg")));
		Wizard_Image.setFitWidth(115);
		Wizard_Image.setFitHeight(290);
		
		ImageView Assassin_Image = new ImageView(new Image(iconic.class.getResourceAsStream("Assassin.jpg")));
		Assassin_Image.setFitWidth(115);
		Assassin_Image.setFitHeight(290);
		
		ImageView Theif_Image = new ImageView(new Image(iconic.class.getResourceAsStream("Theif.jpg")));
		Theif_Image.setFitWidth(115);
		Theif_Image.setFitHeight(290);
		
		Warrior.setGraphic(Warrior_Image);
		
		Warrior.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				warrior = true;
				confirm("Confirm Selection", "You have selected Warrior type. \nIs this the character you would like to choose?", b1, b2, window);
			}
			
		});
		
		Archer.setGraphic(Archer_Image);
		
		Archer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				archer = true;
				confirm("Confirm Selection", "You have selected Archer type. \nIs this the character you would like to choose?", b1, b2, window);
			}
			
		});
		
		Wizard.setGraphic(Wizard_Image);
		
		Wizard.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				wizard = true;
				confirm("Confirm Selection", "You have selected Sorcerer type. \nIs this the character you would like to choose?", b1, b2, window);
			}
			
		});
		
		Assassin.setGraphic(Assassin_Image);
		
		Assassin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				assassin = true;
				confirm("Confirm Selection", "You have selected Assassin type. \nIs this the character you would like to choose?", b1, b2, window);				
			}
			
		});

		Theif.setGraphic(Theif_Image);
		
		Theif.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theif = true;
				confirm("Confirm Selection", "You have selected Theif type. \nIs this the character you would like to choose?", b1, b2, window);
			}
			
		});
		
		Scene scene = new Scene(layout, 650, 300);
		window.setScene(scene);
		
		window.centerOnScreen();
		window.show();
	}
	
	public static void confirm (String title, String message, Button b1, Button b2, Stage main_window) {
		Stage confirm = new Stage();
		confirm.initModality(Modality.APPLICATION_MODAL);
		confirm.setTitle(title);
		Label label = new Label(message);
		VBox layout = new VBox(10);
		layout.setStyle("fx-background-color: blue;");
		layout.getChildren().addAll(label, b1, b2);
		b1.setTextFill(Color.GREEN);
		b2.setTextFill(Color.RED);
		
		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				main_window.hide();
				confirm.hide();
				menu();
			}
			
		});
		
		b2.setOnAction(actionEvent ->{ confirm.close();
		warrior = false;
		wizard = false;
		archer = false;
		assassin = false;
		theif = false;
		});
		
		Scene scene = new Scene(layout, 350, 150);
		confirm.setScene(scene);
		confirm.show();
	}
	
	public static void menu() {
		
		Stage menu = new Stage();
		VBox layout = new VBox(20);
		menu.initModality(Modality.APPLICATION_MODAL);
		menu.setTitle("Menu");

		Button createNewGame = new Button(" New Game ");
		Button loadSavedGame = new Button(" Load Saved Game ");
		Button characterSelect = new Button (" Select a different character ");
		Button extra = new Button(" Extras ");
		Button credits = new Button(" Credits ");
		
		ImageView gameButton = new ImageView(new Image(iconic.class.getResourceAsStream("button.png")));
		
		Image background = new Image(iconic.class.getResourceAsStream("Background.png"), 650, 400, false, false);
		Background b = new Background(new BackgroundImage(background, null, null, null, null));
		
		/*createNewGame.setGraphic(gameButton);
		loadSavedGame.setGraphic(gameButton);
		characterSelect.setGraphic(gameButton);
		extra.setGraphic(gameButton);
		credits.setGraphic(gameButton);*/
		
		
		layout.setBackground(b);
		layout.getChildren().addAll(createNewGame, loadSavedGame, characterSelect, extra, credits);
		layout.setSpacing(30);
		layout.setAlignment(Pos.CENTER);

		createNewGame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				menu.hide();
				MainGameLoop.main(null);
			}
			
		});
		
		loadSavedGame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				menu.hide();
				loadGame();
			}


			
		});
		
		characterSelect.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				menu.hide();
				wizard = false;
				warrior = false;
				archer = false;
				assassin = false;
				theif = false;
				//show primary window
				primaryWindow();
				
			}
			
			
		});
		
		extra.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				
			}
			
		});
		
		credits.setOnAction(actionEvent -> loadCredits());
		
		Scene scene = new Scene(layout, 650, 400);
		menu.setScene(scene);
		menu.show();
		
	}
	
	private static void loadGame() {
		
		//	load game
	}
	
	public static void primaryWindow() {
		
		Stage window = new Stage();
		String title = " Select ArchType you wish to play as";
		window.setTitle(title);
		FlowPane fp = new FlowPane(); 
		
		fp.getChildren().addAll(Warrior, Archer, Wizard, Assassin, Theif);
		
		BorderPane layout = new BorderPane();
		layout.setStyle("-fx-background-color: black;");
		layout.setTop(fp);
		
		ImageView Warrior_Image = new ImageView(new Image(iconic.class.getResourceAsStream("Warrior.jpg")));
		Warrior_Image.setFitWidth(112);
		Warrior_Image.setFitHeight(290);
		
		ImageView Archer_Image = new ImageView(new Image(iconic.class.getResourceAsStream("Mech-Archer.jpg")));
		Archer_Image.setFitWidth(112);
		Archer_Image.setFitHeight(290);
		
		ImageView Wizard_Image = new ImageView(new Image(iconic.class.getResourceAsStream("Wizard.jpg")));
		Wizard_Image.setFitWidth(112);
		Wizard_Image.setFitHeight(290);
		
		ImageView Assassin_Image = new ImageView(new Image(iconic.class.getResourceAsStream("Assassin.jpg")));
		Assassin_Image.setFitWidth(115);
		Assassin_Image.setFitHeight(290);
		
		ImageView Theif_Image = new ImageView(new Image(iconic.class.getResourceAsStream("Theif.jpg")));
		Theif_Image.setFitWidth(115);
		Theif_Image.setFitHeight(290);
		
		Warrior.setGraphic(Warrior_Image);
		
		Warrior.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				warrior = true;
				confirm("Confirm Selection", "You have selected Warrior type. \nIs this the character you would like to choose?", b1, b2, window);
			}
			
		});
		
		Archer.setGraphic(Archer_Image);
		
		Archer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				archer = true;
				confirm("Confirm Selection", "You have selected Archer type. \nIs this the character you would like to choose?", b1, b2, window);
			}
			
		});
		
		Wizard.setGraphic(Wizard_Image);
		
		Wizard.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				wizard = true;
				confirm("Confirm Selection", "You have selected Sorcerer type. \nIs this the character you would like to choose?", b1, b2, window);
			}
			
		});
		
		Assassin.setGraphic(Assassin_Image);
		
		Assassin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				assassin = true;
				confirm("Confirm Selection", "You have selected Assassin type. \nIs this the character you would like to choose?", b1, b2, window);				
			}
			
		});

		Theif.setGraphic(Theif_Image);
		
		Theif.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theif = true;
				confirm("Confirm Selection", "You have selected Theif type. \nIs this the character you would like to choose?", b1, b2, window);
			}
			
		});
		
		Scene scene = new Scene(layout, 650, 300);
		window.setScene(scene);
		
		window.centerOnScreen();
		window.show();
	}

	private static void loadCredits() {
		
		Stage window = new Stage();
		Label label = new Label("Created by: Jacob Strokus");
		label.setMaxSize(2000, 2000);
		VBox layout = new VBox(10);
		Image background = new Image(iconic.class.getResourceAsStream("Credits.png"), 300, 150, false, false);
		Background b = new Background(new BackgroundImage(background, null, null, null, null));
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Credits");
		
		layout.setBackground(b);
		layout.getChildren().add(label);
		layout.setAlignment(Pos.BOTTOM_CENTER);
		
		label.setTextFill(Color.TEAL);
		
		Scene scene = new Scene(layout, 300, 150);
		window.setScene(scene);
		window.show();
	}
}
