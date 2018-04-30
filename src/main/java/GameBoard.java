import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;

public class GameBoard {
    private GameEngine _gameEngine;
    private Tile _tiles[];
    private StackPane _parentPane;
    private VBox _sidebarSplitPane;
    private BorderPane _boardPane;
    private HBox _boardContainer;
    private Button _detailsButton;
    private StackPane _centerStack;

    public GameBoard(GameEngine gameEngine) {
        this._gameEngine = gameEngine;
    }

    public Scene getLayout() {
        this._parentPane = new StackPane();
        this._boardContainer = new HBox();
        this._sidebarSplitPane = new VBox();
        this._boardPane = new BorderPane();
        this._centerStack = new StackPane();

        this._parentPane.setMinWidth(400);
        this._parentPane.setMinHeight(400);

        this._createBoardLayout();

        Scene returnPane = new Scene(_parentPane);
        URL url = MainMenuScreens.class.getResource("resources/style.css");
        if (url == null) {
            System.out.println("Resource not found");
        }
        String css = url.toExternalForm();
        returnPane.getStylesheets().add(css);
        return returnPane;
    }

    private void _createBoardLayout() {

        this._detailsButton = new Button();
        this._detailsButton.setText("Property details");
        this._detailsButton.setId("property-details");

        this._centerStack.setMaxHeight(880);
        this._centerStack.setStyle("-fx-background-color: '#c4e0c8';");
        this._boardPane.setCenter(this._centerStack);
        this._boardContainer.getChildren().addAll(this._boardPane, this._sidebarSplitPane);
        this._parentPane.getChildren().add(_boardContainer);

        BorderPane board = new BorderPane();
        ArrayList<Tile> tiles = this._gameEngine.getBoard().getTiles();

        ArrayList<Tile> bottomRow = new ArrayList<Tile>();
        ArrayList<Tile> topRow = new ArrayList<Tile>();
        ArrayList<Tile> leftColumn = new ArrayList<Tile>();
        ArrayList<Tile> rightColumn = new ArrayList<Tile>();

        for (int i = 0; i < tiles.size(); i++) {
            if (i < 10) {
                bottomRow.add(tiles.get(9 - i));
            } else if (i < 20) {
                leftColumn.add(tiles.get(29 - i));
            } else if (i < 30) {
                topRow.add(tiles.get(i));
            } else if (i < 40) {
                rightColumn.add(tiles.get(i));
            }
        }

        ArrayList<VBox> bottomRowTiles = new ArrayList<VBox>();
        ArrayList<VBox> topRowTiles = new ArrayList<VBox>();
        ArrayList<HBox> leftColumnTiles = new ArrayList<HBox>();
        ArrayList<HBox> rightColumnTiles = new ArrayList<HBox>();

        ArrayList<Tile> corners = new ArrayList<Tile>();

        for (int i = 0; i < bottomRow.size(); i++) {
            if (i == 9) {
                corners.add(bottomRow.get(i));
            } else if (bottomRow.get(i) instanceof Go) {
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(80);
                v.setMaxWidth(80);
                v.setStyle("-fx-background-color: '#f3b2b2';");
                Label go = new Label("Go");
                go.getStyleClass().add("go-text");
                v.getChildren().add(go);
                bottomRowTiles.add(v);
            } else if (bottomRow.get(i) instanceof Ownable || bottomRow.get(i) instanceof Station) {
                Ownable o = (Ownable) bottomRow.get(i);
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(80);
                v.setMaxWidth(80);
                HBox colour = new HBox();
                colour.setStyle("-fx-background-color: '" + getStyle(o) + "';");
                colour.setAlignment(Pos.CENTER);
                Label l = new Label(bottomRow.get(i).getName());
                l.getStyleClass().add("tile-text");
                l.setTextFill(Color.web("#ffffff"));
                l.setWrapText(true);
                colour.getChildren().add(l);
                colour.setMaxHeight(25);
                colour.setMinHeight(25);
                HBox price = new HBox();
                price.setAlignment(Pos.CENTER);
                price.setMaxHeight(75);
                price.setMinHeight(75);
                Label priceTag = new Label("£" + o.getPrice());
                price.getChildren().add(priceTag);
                priceTag.getStyleClass().add("tax-tile-text");
                v.getChildren().add(colour);
                v.getChildren().add(price);
                bottomRowTiles.add(v);
            } else if (bottomRow.get(i) instanceof TaxTile) {
                TaxTile t = (TaxTile) bottomRow.get(i);
                VBox v = new VBox();
                v.setAlignment(Pos.CENTER);
                v.getStyleClass().add("tile");
                v.setMinWidth(80);
                v.setMaxWidth(80);
                Label l = new Label("£" + t.getAmount());
                l.getStyleClass().add("tax-tile-text");
                v.setStyle("-fx-background-color: '#b8b8b8';");
                v.getChildren().add(l);
                bottomRowTiles.add(v);
            } else if (bottomRow.get(i) instanceof Card) {
                Card c = (Card) bottomRow.get(i);
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(80);
                v.setMaxWidth(80);
                Label l = new Label("?");
                l.getStyleClass().add("card-text");
                v.getChildren().add(l);
                bottomRowTiles.add(v);
            } else if (bottomRow.get(i) instanceof Jail) {
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(80);
                v.setMaxWidth(80);
                Label jail = new Label("Jail");
                jail.setStyle("-fx-font-size: 10px; -fx-font-family: 'Raleway'; -fx-font-color: white;");
                v.getChildren().add(jail);
                bottomRowTiles.add(v);
            } else if (bottomRow.get(i) instanceof GoToJail) {
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(80);
                v.setMaxWidth(80);
                v.setStyle("-fx-background-color: '#a1d87e'");
                Label goToJail = new Label("Go To Jail");
                goToJail.setStyle("-fx-font-size: 10px; -fx-font-family: 'Raleway'; -fx-font-color: white");
                v.getChildren().add(goToJail);
                bottomRowTiles.add(v);
            }
        }

        for (int i = 0; i < topRow.size(); i++) {
            if (i == 9) {
                corners.add(topRow.get(i));
            } else if (topRow.get(i) instanceof Go) {
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(80);
                v.setMaxWidth(80);
                v.setStyle("-fx-background-color: '#f3b2b2';");
                Label go = new Label("Go");
                go.getStyleClass().add("go-text");
                v.getChildren().add(go);
                topRowTiles.add(v);
            } else if (topRow.get(i) instanceof Ownable || topRow.get(i) instanceof Station) {
                Ownable o = (Ownable) topRow.get(i);
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(80);
                v.setMaxWidth(80);
                HBox colour = new HBox();
                colour.setStyle("-fx-background-color: '" + getStyle(o) + "';");
                colour.setAlignment(Pos.CENTER);
                Label l = new Label(topRow.get(i).getName());
                l.getStyleClass().add("tile-text");
                l.setTextFill(Color.web("#ffffff"));
                l.setWrapText(true);
                colour.getChildren().add(l);
                colour.setMaxHeight(25);
                colour.setMinHeight(25);
                HBox price = new HBox();
                price.setAlignment(Pos.CENTER);
                price.setMaxHeight(75);
                price.setMinHeight(75);
                Label priceTag = new Label("£" + o.getPrice());
                price.getChildren().add(priceTag);
                priceTag.getStyleClass().add("tax-tile-text");
                v.getChildren().add(price);
                v.getChildren().add(colour);
                topRowTiles.add(v);
            } else if (topRow.get(i) instanceof TaxTile) {
                TaxTile t = (TaxTile) topRow.get(i);
                VBox v = new VBox();
                v.setAlignment(Pos.CENTER);
                v.getStyleClass().add("tile");
                v.setMinWidth(80);
                v.setMaxWidth(80);
                Label l = new Label("£" + t.getAmount());
                l.getStyleClass().add("tax-tile-text");
                v.setStyle("-fx-background-color: '#b8b8b8';");
                v.getChildren().add(l);
                topRowTiles.add(v);
            } else if (topRow.get(i) instanceof Card) {
                Card c = (Card) topRow.get(i);
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(80);
                v.setMaxWidth(80);
                Label l = new Label("?");
                l.getStyleClass().add("card-text");
                v.getChildren().add(l);
                topRowTiles.add(v);
            } else if (topRow.get(i) instanceof Jail) {
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(80);
                v.setMaxWidth(80);
                Label jail = new Label("Jail");
                jail.setStyle("-fx-font-size: 10px; -fx-font-family: 'Raleway'; -fx-font-color: white;");
                v.getChildren().add(jail);
                topRowTiles.add(v);
            } else if (topRow.get(i) instanceof GoToJail) {
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(80);
                v.setMaxWidth(80);
                v.setStyle("-fx-background-color: '#a1d87e'");
                Label goToJail = new Label("Go To Jail");
                goToJail.setStyle("-fx-font-size: 10px; -fx-font-family: 'Raleway'; -fx-font-color: white");
                v.getChildren().add(goToJail);
                topRowTiles.add(v);
            }
        }

        HBox botTiles = new HBox();
        for (int i = 0; i < bottomRowTiles.size(); i++) {
            botTiles.getChildren().add(bottomRowTiles.get(i));
        }
        this._boardPane.setBottom(botTiles);

        HBox topTiles = new HBox();
        for (int i = 0; i < topRowTiles.size(); i++) {
            topTiles.getChildren().add(topRowTiles.get(i));
        }
        this._boardPane.setTop(topTiles);
        //this._boardPane.setBottom(bottomRowTiles);
        //this._boardPane.setTop(topRowTiles);
        //this._boardPane.setLeft(leftColumnTiles);
        //this._boardPane.setRight(rightColumnTiles);
    }

    public String getStyle(Tile tile) {
        String style = "";
        if (tile instanceof Ownable) {
            Ownable o = (Ownable) tile;
            style = o.getGroup().getColour().getValue();
        }
        return style;
    }
}
