package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import latice.application.Game;
import latice.ihm.view.MenuFX;

public class EndTurnController implements EventHandler<MouseEvent>{
	
	private Stage primaryStage;
	
	public EndTurnController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void handle(MouseEvent event) {
		Game game = Game.getInstance();
		game.endTurn();
		
		if(game.getTurn() == 15) {
			game.getPlayFX().getSong().stop();
			game.getPlayFX().setSong(new AudioClip(getClass().getResource("/music/TimeBegging.mp3").toExternalForm()));
			game.getPlayFX().getSong().play();
			game.getPlayFX().getSong().stop();
			game.getPlayFX().setSong(new AudioClip(getClass().getResource("/music/Time.mp3").toExternalForm()));
			game.getPlayFX().getSong().setCycleCount(AudioClip.INDEFINITE);
			game.getPlayFX().getSong().play();
		}
		if(game.getPlayer1().getStack().isEmpty() || game.getPlayer2().getStack().isEmpty() || game.getTurn() > 20) {
			
			game.getPlayFX().getSong().stop();
			String victorie = " ";
			if(game.isATie()) {
				victorie = "C'est une égalité !";
			} else {
				victorie = game.calculateWinner().getName() + " à gagné, bravo !";
			}
			
			//TODO personnalisé la fenetre ?
			Alert dialog = new Alert(AlertType.INFORMATION);
			dialog.setTitle("Fin de partie !");
			dialog.setHeaderText("La partie est fini !");
			dialog.setContentText(victorie);
			dialog.initOwner(((Node)event.getSource()).getScene().getWindow() );
			//dialog.setGraphic(img);
			dialog.showAndWait();
			
			MenuFX menu = new MenuFX();
			this.primaryStage.getScene().setRoot(menu);
			menu.getBtnExit().setOnMouseClicked(new ExitController());
			menu.getBtnGame().setOnMouseClicked(new PlayController(primaryStage, menu));
			
		}
	}
	
}