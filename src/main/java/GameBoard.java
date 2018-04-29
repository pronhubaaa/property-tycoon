import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class GameBoard {
    private GameEngine _gameEngine;
    private Tile _tiles[];
    private StackPane _parentPane;
    private VBox _sidebarSplitPane;
    private BorderPane _boardPane;
    private HBox _boardContainer;
    private Button _detailsButton;

    public GameBoard(GameEngine gameEngine) {
        this._gameEngine = gameEngine;
    }

    public Scene getLayout() {
        this._parentPane = new StackPane();
        this._boardContainer = new HBox();
        this._sidebarSplitPane = new VBox();
        this._boardPane = new BorderPane();

        this._parentPane.setMinWidth(400);
        this._parentPane.setMinHeight(400);

        this._createBoardLayout();

        Scene returnPane = new Scene(_parentPane);
        return returnPane;
    }

    private void _createBoardLayout() {
        this._detailsButton = new Button();
        this._detailsButton.setText("Property details");
        this._detailsButton.setId("property-details");

        this._boardContainer.getChildren().addAll(this._boardPane, this._sidebarSplitPane);
        this._parentPane.getChildren().add(_boardContainer);

        BorderPane board = new BorderPane();
        ArrayList<Tile> tiles = this._gameEngine.getBoard().getTiles();
        ArrayList<Button> tileButtons = new ArrayList<Button>();

        for(Tile tile : tiles) {
            Button tileButton = new Button();
            tileButton.setText(tile.getName());
            tileButton.setId("tile-" + Integer.toString(tile.getPosition()));
            tileButton.setMinWidth(40);
            tileButton.setMinHeight(40);

            if(tile instanceof Ownable) {
                tileButton.setOnAction((ActionEvent e) -> {
                    if(this._detailsButton.getParent() == null) {
                        this._parentPane.getChildren().add(this._detailsButton);
                    }
                    else {
                        this._parentPane.getChildren().remove(this._detailsButton);
                    }
                });
            }

            tileButtons.add(tileButton);
        }

        HBox bottomRow = new HBox();
        HBox topRow = new HBox();
        VBox leftColumn = new VBox();
        VBox rightColumn = new VBox();

        for(int i = 0; i < tileButtons.size(); i++) {
            if(i < 10) {
                bottomRow.getChildren().add(tileButtons.get(9 - i));
            }
            else if(i < 20) {
                leftColumn.getChildren().add(tileButtons.get(i));
            }
            else if(i < 31) {
                topRow.getChildren().add(tileButtons.get(i));
            }
            else {
                rightColumn.getChildren().add(tileButtons.get(i));
            }
        }

        this._boardPane.setBottom(bottomRow);
        this._boardPane.setTop(topRow);
        this._boardPane.setLeft(leftColumn);
        this._boardPane.setRight(rightColumn);
    }
}