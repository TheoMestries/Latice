package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import latice.application.Game;
import latice.ihm.view.MenuFX;
import latice.ihm.view.PlayFX;

public class PlayController implements EventHandler<MouseEvent>{

	private Stage primaryStage;
	private MenuFX menu;
	private AudioClip song;
	
	public PlayController(Stage primaryStage, MenuFX menu) {
		this.primaryStage = primaryStage;
		this.menu = menu;
		this.song = new AudioClip(getClass().getResource("/song/Loading.mp3").toExternalForm());
	}
	
	@Override
	public void handle(MouseEvent event) {
		this.menu.getSong().stop();
		this.song.play();
		Game game = new Game(primaryStage);
		game.play();
		
	}
}
