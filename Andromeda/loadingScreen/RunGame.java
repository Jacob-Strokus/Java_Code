package loadingScreen;

import EngineTester.MainGameLoop;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RunGame extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) {

		VBox layout = new VBox(20);
		primaryStage.setTitle("Menu");

		Button createNewGame = new Button(" New Game ");
		Button loadSavedGame = new Button(" Load Saved Game ");
		Button settings = new Button(" Settings ");
		Button credits = new Button(" Credits ");

		Image background = new Image(RunGame.class.getResourceAsStream("Background.png"), 650, 400, false, false);
		Background b = new Background(new BackgroundImage(background, null, null, null, null));

		createNewGame.setBackground(b);
		loadSavedGame.setBackground(b);
		settings.setBackground(b);
		credits.setBackground(b);

		createNewGame.setTextFill(Color.DARKGREEN);
		loadSavedGame.setTextFill(Color.DARKBLUE);
		settings.setTextFill(Color.ORANGERED);
		credits.setTextFill(Color.BROWN);

		createNewGame.setFont(new Font(14));
		loadSavedGame.setFont(new Font(14));
		settings.setFont(new Font(14));
		credits.setFont(new Font(14));

		layout.setBackground(b);
		layout.getChildren().addAll(createNewGame, loadSavedGame, settings, credits);
		layout.setSpacing(40);
		layout.setAlignment(Pos.CENTER);

		createNewGame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				primaryStage.hide();
				MainGameLoop.main(null);
			}

		});

		loadSavedGame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				// primaryStage.hide();
				// loadGame();
			}

		});

		settings.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

			}

		});

		credits.setOnAction(actionEvent -> loadCredits());

		Scene scene = new Scene(layout, 650, 400);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private static void loadCredits() {

		Stage window = new Stage();
		Label label = new Label("Created by: Jacob Strokus");
		final double MAX_FONT_SIZE = 30.0;
		label.setFont(new Font(MAX_FONT_SIZE));
		VBox layout = new VBox(10);
		Image background = new Image(RunGame.class.getResourceAsStream("Credits.png"), 650, 400, false, false);
		Background b = new Background(new BackgroundImage(background, null, null, null, null));

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Credits");

		layout.setBackground(b);
		layout.getChildren().add(label);
		layout.setAlignment(Pos.BOTTOM_CENTER);

		label.setTextFill(Color.DARKRED);

		Scene scene = new Scene(layout, 550, 300);
		window.setScene(scene);
		window.show();
	}
}
