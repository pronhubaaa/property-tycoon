import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;

public class GameBoard {
    private GameEngine _gameEngine;
    private StackPane _parentPane;
    private VBox _sidebarSplitPane;
    private BorderPane _boardPane;
    private HBox _boardContainer;
    private Button _detailsButton;
    private StackPane _centerStack;
    private ArrayList<Node> _storedStack;
    private Label _currentMsg = new Label("");
    private BorderPane rightSidebar;
    private VBox playersPane;


    private Dice _dice;
    private ArrayList<Tile> tiles;


    public GameBoard(GameEngine gameEngine) {
        this._gameEngine = gameEngine;
    }

    public Scene getLayout() {
        this._dice = new Dice();
        this._parentPane = new StackPane();
        this._boardContainer = new HBox();
        this._sidebarSplitPane = new VBox();
        this._boardPane = new BorderPane();
        this._centerStack = new StackPane();
        this._storedStack = new ArrayList<>();

        this._parentPane.setMinWidth(400);
        this._parentPane.setMinHeight(400);
        this._boardContainer.setStyle("-fx-background-color: white;");

        this._createSideLayout();
        this._createBoardLayout();

        Scene returnPane = new Scene(_parentPane);
        URL url = MainMenuScreens.class.getResource("resources/style.css");
        if (url == null) {
            System.out.println("Resource not found");
        }
        String css = url.toExternalForm();
        returnPane.getStylesheets().add(css);
        startGame();
        return returnPane;
    }

    private void _createSideLayout() {
        rightSidebar = new BorderPane();
        playersPane = new VBox();
        rightSidebar.setTop(playersPane);
        this._sidebarSplitPane.getChildren().add(rightSidebar);
        reorderPlayersSidebar();
    }

    private void reorderPlayersSidebar() {
        playersPane.getChildren().clear();
        for (Player player : this._gameEngine.getPlayers()) {
            if (player.equals(_gameEngine.getCurrentPlayer())) {
                rightSidebar.setBottom(getPlayerMetaCard(player));
            } else if (!player.getName().equals("")) {
                playersPane.getChildren().add(getPlayerMetaCard(player));
            }
        }
    }

    private static HBox getPlayerMetaCard(Player player) {
        return new HBox() {{ // container
            setAlignment(Pos.CENTER);
            getChildren().addAll(
                    new ImageView(new Image("resources/player-piece" + player.getPiece().getValue() + ".png")) {{ //playerpiece
                        setFitHeight(100);
                        setPreserveRatio(true);
                    }},
                    new VBox() {{ // text on right-hand-side
                        getChildren().addAll(
                                new Label(player.getName()), // name label
                                new Label("£" + player.getBalance()) {{ // balance label
                                    getStyleClass().add("player-balance");
                                }});
                        setAlignment(Pos.CENTER_RIGHT);
                    }});
            getStyleClass().add("player-panel");
            getStyleClass().add("raleway");
            setMinHeight(25);
        }};
    }

    private void _createBoardLayout() {
        this._centerStack.setMaxHeight(880);
        this._centerStack.setStyle("-fx-background-color: '#c4e0c8';");
        this._boardPane.setCenter(this._centerStack);
        this._boardContainer.getChildren().addAll(this._boardPane, this._sidebarSplitPane);
        this._parentPane.getChildren().add(_boardContainer);

        tiles = this._gameEngine.getBoard().getTiles();

        ArrayList<Tile> bottomRow = new ArrayList<>();
        ArrayList<Tile> topRow = new ArrayList<>();
        ArrayList<Tile> leftColumn = new ArrayList<>();
        ArrayList<Tile> rightColumn = new ArrayList<>();

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

        ArrayList<VBox> bottomRowTiles = new ArrayList<>();
        ArrayList<VBox> topRowTiles = new ArrayList<>();
        ArrayList<HBox> leftColumnTiles = new ArrayList<>();
        ArrayList<HBox> rightColumnTiles = new ArrayList<>();

        for (int i = 0; i < rightColumn.size(); i++) {
            if (i == 0) {
                topRow.add(rightColumn.get(0));
            } else if (rightColumn.get(i) instanceof Go) {
                HBox v = new HBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(93);
                v.setMaxHeight(93);
                v.setStyle("-fx-background-color: '#ff3355';");
                v.setSpacing(2);
                Image goImg = new Image("resources/go.png");
                ImageView goImgHolder = new ImageView(goImg);
                goImgHolder.setFitHeight(60);
                goImgHolder.setFitWidth(60);
                Label go = new Label("Go");
                go.getStyleClass().add("go-text");
                v.getChildren().add(go);
                v.getChildren().add(goImgHolder);
                VBox owner = new VBox();
                owner.setSpacing(5);
                VBox landed = new VBox();
                landed.setSpacing(5);
                v.getChildren().addAll(owner, landed);
                v.setId("right-" + String.valueOf(i));
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof Ownable) {
                Ownable o = (Ownable) rightColumn.get(i);
                _storedStack.addAll(_centerStack.getChildren());
                HBox v = new HBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(93);
                v.setMaxHeight(93);
                VBox colour = new VBox();
                colour.setStyle("-fx-background-color: '" + getStyle(o) + "';");
                Label l = new Label(rightColumn.get(i).getName());
                l.getStyleClass().add("tile-text");
                l.setTextFill(Color.web("#ffffff"));
                l.setMinHeight(30);
                l.setMaxHeight(30);
                l.setMinWidth(93);
                l.setMaxWidth(93);
                l.setAlignment(Pos.CENTER);
                colour.setAlignment(Pos.CENTER);
                colour.getChildren().add(l);
                l.setRotate(-90);
                colour.setMaxWidth(30);
                colour.setMinWidth(30);
                colour.setMinHeight(93);
                colour.setMaxHeight(93);
                VBox price = new VBox();
                price.setAlignment(Pos.CENTER);
                price.setMaxWidth(91);
                price.setMinWidth(91);
                Label priceTag = new Label("£" + o.getPrice());
                price.getChildren().add(priceTag);
                priceTag.getStyleClass().add("tax-tile-text");
                priceTag.setRotate(-90);
                v.setOnMouseClicked(t -> {
                    _storedStack.addAll(_centerStack.getChildren());
                    VBox grey = new VBox();
                    grey.setMaxWidth(_centerStack.widthProperty().intValue());
                    grey.setMinWidth(_centerStack.widthProperty().intValue());
                    grey.setMaxHeight(_centerStack.heightProperty().intValue());
                    grey.setMinHeight(_centerStack.heightProperty().intValue());
                    grey.setStyle("-fx-background-color: '#222222';");
                    grey.setOpacity(0.5);
                    HBox closeWindow = new HBox();
                    closeWindow.setMaxWidth(_centerStack.getWidth());
                    closeWindow.setMinWidth(_centerStack.getWidth());
                    Label close = new Label("X");
                    close.getStyleClass().add("raleway");
                    close.setStyle("-fx-font-size: 50px");
                    close.setAlignment(Pos.TOP_RIGHT);
                    close.setPadding(new Insets(20, 20, 0, 0));
                    closeWindow.setAlignment(Pos.TOP_RIGHT);
                    closeWindow.getChildren().add(close);
                    VBox card = getCardStyle(o);
                    _centerStack.getChildren().add(card);
                    _centerStack.getChildren().add(grey);
                    _centerStack.getChildren().add(closeWindow);
                    grey.toFront();
                    card.toFront();
                    close.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                    grey.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                    card.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                });
                v.getChildren().add(colour);
                v.getChildren().add(price);
                VBox currentPlayers = new VBox();
                currentPlayers.setSpacing(5);
                v.getChildren().add(currentPlayers);
                VBox owner = new VBox();
                owner.setSpacing(5);
                owner.setMaxHeight(10);
                owner.setMinHeight(10);
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(owner, landed);
                v.setId("right-" + String.valueOf(i));
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof TaxTile) {
                TaxTile t = (TaxTile) rightColumn.get(i);
                _storedStack.addAll(_centerStack.getChildren());
                HBox v = new HBox();
                v.setAlignment(Pos.CENTER);
                v.getStyleClass().add("tile");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(93);
                v.setMaxHeight(93);
                Image taxImg = new Image("resources/tax.png");
                ImageView iv = new ImageView(taxImg);
                iv.setFitWidth(50);
                iv.setFitHeight(50);
                v.setSpacing(5);
                Label l = new Label("£" + t.getAmount());
                l.getStyleClass().add("tax-tile-text");
                l.setRotate(-90);
                v.setStyle("-fx-background-color: '#b8b8b8';");
                v.getChildren().add(iv);
                v.getChildren().add(l);
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.setId("right-" + String.valueOf(i));
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof CardTile) {
                CardTile c = (CardTile) rightColumn.get(i);
                _storedStack.addAll(_centerStack.getChildren());
                HBox v = new HBox();
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(93);
                v.setMaxHeight(93);
                Label l = new Label("?");
                l.setRotate(-90);
                l.getStyleClass().add("card-text");
                v.getChildren().add(l);
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.setId("right-" + String.valueOf(i));
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof Jail) {
                HBox v = new HBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setStyle("-fx-background-color: '#fbb676'");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(121);
                v.setMaxHeight(121);
                HBox topColumn = new HBox();
                Label justVisiting1 = new Label("Just visiting");
                justVisiting1.getStyleClass().add("jail-text-rotated");
                justVisiting1.setMinWidth(Label.USE_PREF_SIZE);
                justVisiting1.setMaxWidth(Label.USE_PREF_SIZE);
                justVisiting1.setMinHeight(Label.USE_PREF_SIZE);
                justVisiting1.setMaxHeight(Label.USE_PREF_SIZE);
                justVisiting1.setAlignment(Pos.CENTER_LEFT);
                justVisiting1.setPadding(new Insets(0, 0, 0, -5));
                topColumn.setAlignment(Pos.CENTER_LEFT);
                topColumn.getChildren().add(justVisiting1);
                topColumn.setMaxHeight(80);
                topColumn.setMinHeight(80);
                VBox jailBox = new VBox();
                jailBox.setMaxWidth(80);
                jailBox.setMaxHeight(80);
                jailBox.setMinWidth(70);
                jailBox.setMaxWidth(70);
                jailBox.setAlignment(Pos.CENTER);
                jailBox.setStyle("-fx-background-color: '#fbdb76'");
                Label inJail = new Label("In Jail");
                inJail.getStyleClass().add("jail-text");
                jailBox.getChildren().add(inJail);
                Image jailPng = new Image("resources/jail.png");
                ImageView jailView = new ImageView(jailPng);
                jailView.setFitHeight(60);
                jailView.setFitWidth(60);
                jailBox.getChildren().add(jailView);
                topColumn.getChildren().add(jailBox);
                v.getChildren().add(topColumn);
//                Label justVisiting2 = new Label("Just visiting");
//                justVisiting2.getStyleClass().add("jail-text");
//                justVisiting2.setPadding(new Insets(12, 0, 0, 0));
//                HBox bottomColumn = new HBox();
//                bottomColumn.setAlignment(Pos.BOTTOM_CENTER);
//                bottomColumn.getChildren().add(justVisiting2);
//                v.getChildren().add(bottomColumn);
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.setId("right-" + String.valueOf(i));
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof GoToJail) {
                HBox v = new HBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(121);
                v.setMaxHeight(121);
                v.setStyle("-fx-background-color: '#a1d87e'");
                Label goToJail = new Label("Go To Jail");
                goToJail.setStyle("-fx-font-size: 10px; -fx-font-family: 'Raleway'; -fx-font-color: white");
                v.getChildren().add(goToJail);
                VBox owner = new VBox();
                owner.setSpacing(5);
                VBox landed = new VBox();
                landed.setSpacing(5);
                v.getChildren().addAll(owner, landed);
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof FreeParking) {
                HBox v = new HBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.setMaxWidth(121);
                v.setMinWidth(121);
                v.setMaxHeight(121);
                v.setMinHeight(121);
                Label l = new Label("Free parking");
                v.getChildren().add(l);
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.setId("right-" + String.valueOf(i));
                rightColumnTiles.add(v);
            }
        }

        for (int i = 0; i < leftColumn.size(); i++) {
            if (i == leftColumn.size() - 1) {
                bottomRow.add(0, leftColumn.get(i));
            } else if (leftColumn.get(i) instanceof Go) {
                HBox v = new HBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(93);
                v.setMaxHeight(93);
                v.setStyle("-fx-background-color: '#ff3355';");
                v.setSpacing(2);
                Image goImg = new Image("resources/go.png");
                ImageView goImgHolder = new ImageView(goImg);
                goImgHolder.setFitHeight(60);
                goImgHolder.setFitWidth(60);
                Label go = new Label("Go");
                go.getStyleClass().add("go-text");
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.getChildren().add(go);
                v.getChildren().add(goImgHolder);
                v.setId(String.valueOf(i));
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof Ownable) {
                Ownable o = (Ownable) leftColumn.get(i);
                _storedStack.addAll(_centerStack.getChildren());
                HBox v = new HBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(93);
                v.setMaxHeight(93);
                VBox colour = new VBox();
                colour.setStyle("-fx-background-color: '" + getStyle(o) + "';");
                Label l = new Label(leftColumn.get(i).getName());
                l.getStyleClass().add("tile-text");
                l.setTextFill(Color.web("#ffffff"));
                l.setMinHeight(30);
                l.setMaxHeight(30);
                l.setMinWidth(93);
                l.setMaxWidth(93);
                l.setAlignment(Pos.CENTER);
                colour.setAlignment(Pos.CENTER);
                colour.getChildren().add(l);
                l.setRotate(90);
                colour.setMaxWidth(30);
                colour.setMinWidth(30);
                colour.setMinHeight(93);
                colour.setMaxHeight(93);
                VBox price = new VBox();
                price.setAlignment(Pos.CENTER);
                price.setMaxWidth(91);
                price.setMinWidth(91);
                Label priceTag = new Label("£" + o.getPrice());
                price.getChildren().add(priceTag);
                priceTag.getStyleClass().add("tax-tile-text");
                priceTag.setRotate(90);
                v.setOnMouseClicked(t -> {
                    _storedStack.addAll(_centerStack.getChildren());
                    VBox grey = new VBox();
                    grey.setMaxWidth(_centerStack.widthProperty().intValue());
                    grey.setMinWidth(_centerStack.widthProperty().intValue());
                    grey.setMaxHeight(_centerStack.heightProperty().intValue());
                    grey.setMinHeight(_centerStack.heightProperty().intValue());
                    grey.setStyle("-fx-background-color: '#222222';");
                    grey.setOpacity(0.5);
                    HBox closeWindow = new HBox();
                    closeWindow.setMaxWidth(_centerStack.getWidth());
                    closeWindow.setMinWidth(_centerStack.getWidth());
                    Label close = new Label("X");
                    close.getStyleClass().add("raleway");
                    close.setStyle("-fx-font-size: 50px");
                    close.setAlignment(Pos.TOP_RIGHT);
                    close.setPadding(new Insets(20, 20, 0, 0));
                    closeWindow.setAlignment(Pos.TOP_RIGHT);
                    closeWindow.getChildren().add(close);
                    VBox card = getCardStyle(o);
                    _centerStack.getChildren().add(card);
                    _centerStack.getChildren().add(grey);
                    _centerStack.getChildren().add(closeWindow);
                    grey.toFront();
                    card.toFront();
                    close.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                    grey.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                    card.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                });
                VBox owner = new VBox();
                owner.setSpacing(5);
                owner.setMaxHeight(10);
                owner.setMinHeight(10);
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(owner, landed);
                v.getChildren().add(price);
                v.getChildren().add(colour);
                v.setId(String.valueOf(i));
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof TaxTile) {
                TaxTile t = (TaxTile) leftColumn.get(i);
                _storedStack.addAll(_centerStack.getChildren());
                HBox v = new HBox();
                v.setAlignment(Pos.CENTER);
                v.getStyleClass().add("tile");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(93);
                v.setMaxHeight(93);
                Image taxImg = new Image("resources/tax.png");
                ImageView iv = new ImageView(taxImg);
                iv.setFitWidth(50);
                iv.setFitHeight(50);
                v.setSpacing(5);
                Label l = new Label("£" + t.getAmount());
                l.getStyleClass().add("tax-tile-text");
                v.setStyle("-fx-background-color: '#b8b8b8';");
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.getChildren().add(iv);
                v.getChildren().add(l);
                v.setId(String.valueOf(i));
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof CardTile) {
                CardTile c = (CardTile) leftColumn.get(i);
                _storedStack.addAll(_centerStack.getChildren());
                HBox v = new HBox();
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(93);
                v.setMaxHeight(93);
                Label l = new Label("?");
                l.setRotate(90);
                l.getStyleClass().add("card-text");
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.getChildren().add(l);
                v.setId(String.valueOf(i));
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof Jail) {
                HBox v = new HBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setStyle("-fx-background-color: '#fbb676'");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(121);
                v.setMaxHeight(121);
                HBox topColumn = new HBox();
                Label justVisiting1 = new Label("Just visiting");
                justVisiting1.getStyleClass().add("jail-text-rotated");
                justVisiting1.setMinWidth(Label.USE_PREF_SIZE);
                justVisiting1.setMaxWidth(Label.USE_PREF_SIZE);
                justVisiting1.setMinHeight(Label.USE_PREF_SIZE);
                justVisiting1.setMaxHeight(Label.USE_PREF_SIZE);
                justVisiting1.setAlignment(Pos.CENTER_LEFT);
                justVisiting1.setPadding(new Insets(0, 0, 0, -5));
                topColumn.setAlignment(Pos.CENTER_LEFT);
                topColumn.getChildren().add(justVisiting1);
                topColumn.setMaxHeight(80);
                topColumn.setMinHeight(80);
                VBox jailBox = new VBox();
                jailBox.setMaxWidth(80);
                jailBox.setMaxHeight(80);
                jailBox.setMinWidth(70);
                jailBox.setMaxWidth(70);
                jailBox.setAlignment(Pos.CENTER);
                jailBox.setStyle("-fx-background-color: '#fbdb76'");
                Label inJail = new Label("In Jail");
                inJail.getStyleClass().add("jail-text");
                jailBox.getChildren().add(inJail);
                Image jailPng = new Image("resources/jail.png");
                ImageView jailView = new ImageView(jailPng);
                jailView.setFitHeight(60);
                jailView.setFitWidth(60);
                jailBox.getChildren().add(jailView);
                topColumn.getChildren().add(jailBox);
                v.getChildren().add(topColumn);
                HBox bottomColumn = new HBox();
                bottomColumn.setAlignment(Pos.BOTTOM_CENTER);
                v.getChildren().add(bottomColumn);
                v.setId(String.valueOf(i));
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof GoToJail) {
                HBox v = new HBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(121);
                v.setMaxHeight(121);
                v.setStyle("-fx-background-color: '#a1d87e'");
                Label goToJail = new Label("Go To Jail");
                goToJail.setStyle("-fx-font-size: 10px; -fx-font-family: 'Raleway'; -fx-font-color: white");
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.getChildren().add(goToJail);
                v.setId(String.valueOf(i));
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof FreeParking) {
                HBox v = new HBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.setMaxWidth(121);
                v.setMinWidth(121);
                v.setMaxHeight(121);
                v.setMinHeight(121);
                Label l = new Label("Free parking");
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.getChildren().add(l);
                v.setId(String.valueOf(i));
                leftColumnTiles.add(v);
            }
        }

        for (Tile aBottomRow : bottomRow) {
            if (aBottomRow instanceof Go) {
                VBox v = new VBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(121);
                v.setMaxHeight(121);
                v.setStyle("-fx-background-color: '#ff3355';");
                v.setSpacing(2);
                Image goImg = new Image("resources/go.png");
                ImageView goImgHolder = new ImageView(goImg);
                goImgHolder.setFitHeight(60);
                goImgHolder.setFitWidth(60);
                Label go = new Label("Go");
                go.getStyleClass().add("go-text");
                v.getChildren().add(go);
                v.getChildren().add(goImgHolder);
                VBox landed = new VBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.setId(String.valueOf(bottomRow.indexOf(aBottomRow)));
                bottomRowTiles.add(v);
            } else if (aBottomRow instanceof Ownable) {
                Ownable o = (Ownable) aBottomRow;
                _storedStack.addAll(_centerStack.getChildren());
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(93);
                v.setMaxWidth(93);
                HBox colour = new HBox();
                colour.setStyle("-fx-background-color: '" + getStyle(o) + "';");
                colour.setAlignment(Pos.CENTER);
                Label l = new Label(aBottomRow.getName());
                l.getStyleClass().add("tile-text");
                l.setTextFill(Color.web("#ffffff"));
                l.setWrapText(true);
                colour.getChildren().add(l);
                colour.setMaxHeight(30);
                colour.setMinHeight(30);
                HBox price = new HBox();
                price.setAlignment(Pos.CENTER);
                price.setMaxHeight(91);
                price.setMinHeight(91);
                Label priceTag = new Label("£" + o.getPrice());
                price.getChildren().add(priceTag);
                priceTag.getStyleClass().add("tax-tile-text");
                v.setOnMouseClicked(t -> {
                    _storedStack.addAll(_centerStack.getChildren());
                    VBox grey = new VBox();
                    grey.setMaxWidth(_centerStack.widthProperty().intValue());
                    grey.setMinWidth(_centerStack.widthProperty().intValue());
                    grey.setMaxHeight(_centerStack.heightProperty().intValue());
                    grey.setMinHeight(_centerStack.heightProperty().intValue());
                    grey.setStyle("-fx-background-color: '#222222';");
                    grey.setOpacity(0.5);
                    HBox closeWindow = new HBox();
                    closeWindow.setMaxWidth(_centerStack.getWidth());
                    closeWindow.setMinWidth(_centerStack.getWidth());
                    Label close = new Label("X");
                    close.getStyleClass().add("raleway");
                    close.setStyle("-fx-font-size: 50px");
                    close.setAlignment(Pos.TOP_RIGHT);
                    close.setPadding(new Insets(20, 20, 0, 0));
                    closeWindow.setAlignment(Pos.TOP_RIGHT);
                    closeWindow.getChildren().add(close);
                    VBox card = getCardStyle(o);
                    _centerStack.getChildren().add(card);
                    _centerStack.getChildren().add(grey);
                    _centerStack.getChildren().add(closeWindow);
                    grey.toFront();
                    card.toFront();
                    close.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                    grey.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                    card.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                });
                v.getChildren().add(colour);
                v.getChildren().add(price);
                HBox owner = new HBox();
                owner.setSpacing(5);
                owner.setMaxHeight(10);
                owner.setMinHeight(10);
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(owner, landed);
                v.setId(String.valueOf(bottomRow.indexOf(aBottomRow)));
                bottomRowTiles.add(v);
            } else if (aBottomRow instanceof TaxTile) {
                TaxTile t = (TaxTile) aBottomRow;
                _storedStack.addAll(_centerStack.getChildren());
                VBox v = new VBox();
                v.setAlignment(Pos.CENTER);
                v.getStyleClass().add("tile");
                v.setMinWidth(93);
                v.setMaxWidth(93);
                Image taxImg = new Image("resources/tax.png");
                ImageView iv = new ImageView(taxImg);
                iv.setFitWidth(50);
                iv.setFitHeight(50);
                v.setSpacing(5);
                Label l = new Label("£" + t.getAmount());
                l.getStyleClass().add("tax-tile-text");
                v.setStyle("-fx-background-color: '#b8b8b8';");
                v.getChildren().add(iv);
                v.getChildren().add(l);
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.setId(String.valueOf(bottomRow.indexOf(aBottomRow)));
                bottomRowTiles.add(v);
            } else if (aBottomRow instanceof CardTile) {
                CardTile c = (CardTile) aBottomRow;
                _storedStack.addAll(_centerStack.getChildren());
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(93);
                v.setMaxWidth(93);
                Label l = new Label("?");
                l.getStyleClass().add("card-text");
                v.getChildren().add(l);
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.setId(String.valueOf(bottomRow.indexOf(aBottomRow)));
                bottomRowTiles.add(v);
            } else if (aBottomRow instanceof Jail) {
                VBox v = new VBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setStyle("-fx-background-color: '#fbb676'");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(121);
                v.setMaxHeight(121);
                HBox topColumn = new HBox();
                Label justVisiting1 = new Label("Just visiting");
                justVisiting1.getStyleClass().add("jail-text-rotated");
                justVisiting1.setMinWidth(Label.USE_PREF_SIZE);
                justVisiting1.setMaxWidth(Label.USE_PREF_SIZE);
                justVisiting1.setMinHeight(Label.USE_PREF_SIZE);
                justVisiting1.setMaxHeight(Label.USE_PREF_SIZE);
                justVisiting1.setAlignment(Pos.CENTER_LEFT);
                justVisiting1.setPadding(new Insets(0, 0, 0, -5));
                topColumn.setAlignment(Pos.CENTER_LEFT);
                topColumn.getChildren().add(justVisiting1);
                topColumn.setMaxHeight(80);
                topColumn.setMinHeight(80);
                VBox jailBox = new VBox();
                jailBox.setMaxWidth(80);
                jailBox.setMaxHeight(80);
                jailBox.setMinWidth(70);
                jailBox.setMaxWidth(70);
                jailBox.setAlignment(Pos.CENTER);
                jailBox.setStyle("-fx-background-color: '#fbdb76'");
                Label inJail = new Label("In Jail");
                inJail.getStyleClass().add("jail-text");
                jailBox.getChildren().add(inJail);
                Image jailPng = new Image("resources/jail.png");
                ImageView jailView = new ImageView(jailPng);
                jailView.setFitHeight(60);
                jailView.setFitWidth(60);
                jailBox.getChildren().add(jailView);
                topColumn.getChildren().add(jailBox);
                v.getChildren().add(topColumn);
                Label justVisiting2 = new Label("Just visiting");
                justVisiting2.getStyleClass().add("jail-text");
                justVisiting2.setPadding(new Insets(12, 0, 0, 0));
                HBox bottomColumn = new HBox();
                bottomColumn.setAlignment(Pos.BOTTOM_CENTER);
                bottomColumn.getChildren().add(justVisiting2);
                v.getChildren().add(bottomColumn);
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.setId(String.valueOf(bottomRow.indexOf(aBottomRow)));
                bottomRowTiles.add(v);
            } else if (aBottomRow instanceof GoToJail) {
                VBox v = new VBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(123);
                v.setMaxHeight(123);
                v.setStyle("-fx-background-color: '#a1d87e'");
                Label goToJail = new Label("Go To Jail");
                goToJail.getStyleClass().add("go-to-jail");
                goToJail.setStyle("-fx-font-size: 10px; -fx-font-family: 'Raleway'; -fx-font-color: white");
                Image goToBin = new Image("resources/gotojail.png");
                ImageView policeHat = new ImageView(goToBin);
                policeHat.setFitHeight(60);
                policeHat.setFitWidth(60);
                v.setAlignment(Pos.CENTER);
                v.getChildren().add(goToJail);
                v.getChildren().add(policeHat);
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.setId(String.valueOf(bottomRow.indexOf(aBottomRow)));
                bottomRowTiles.add(v);
            } else if (aBottomRow instanceof FreeParking) {
                VBox v = new VBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.setStyle("-fx-background-color: '#c7e7ff'");
                v.setMaxWidth(121);
                v.setMinWidth(121);
                v.setMaxHeight(123);
                v.setMinHeight(123);
                v.setAlignment(Pos.CENTER);
                v.setSpacing(5);
                Label l = new Label("Free parking");
                l.getStyleClass().add("free-parking");
                Image parking = new Image("resources/parking.png");
                ImageView parkingView = new ImageView(parking);
                parkingView.setFitHeight(50);
                parkingView.setFitWidth(50);
                v.getChildren().add(l);
                v.getChildren().add(parkingView);
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.setId(String.valueOf(bottomRow.indexOf(aBottomRow)));
                bottomRowTiles.add(v);
            }
        }

        for (Tile aTopRow : topRow) {
            if (aTopRow instanceof Go) {
                VBox v = new VBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(93);
                v.setMaxWidth(93);
                v.setStyle("-fx-background-color: '#ff3355';");
                v.setSpacing(2);
                Image goImg = new Image("resources/go.png");
                ImageView goImgHolder = new ImageView(goImg);
                goImgHolder.setFitHeight(60);
                goImgHolder.setFitWidth(60);
                Label go = new Label("Go");
                go.getStyleClass().add("go-text");
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.getChildren().add(go);
                v.getChildren().add(goImgHolder);
                v.setId(String.valueOf(topRow.indexOf(aTopRow)));
                topRowTiles.add(v);
            } else if (aTopRow instanceof Ownable) {
                Ownable o = (Ownable) aTopRow;
                _storedStack.addAll(_centerStack.getChildren());
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(93);
                v.setMaxWidth(93);
                HBox colour = new HBox();
                colour.setStyle("-fx-background-color: '" + getStyle(o) + "';");
                colour.setAlignment(Pos.CENTER);
                Label l = new Label(aTopRow.getName());
                l.getStyleClass().add("tile-text");
                l.setTextFill(Color.web("#ffffff"));
                l.setWrapText(true);
                colour.getChildren().add(l);
                colour.setMaxHeight(30);
                colour.setMinHeight(30);
                HBox price = new HBox();
                price.setAlignment(Pos.CENTER);
                price.setMaxHeight(91);
                price.setMinHeight(91);
                Label priceTag = new Label("£" + o.getPrice());
                price.getChildren().add(priceTag);
                priceTag.getStyleClass().add("tax-tile-text");
                v.setOnMouseClicked(t -> {
                    _storedStack.addAll(_centerStack.getChildren());
                    VBox grey = new VBox();
                    grey.setMaxWidth(_centerStack.widthProperty().intValue());
                    grey.setMinWidth(_centerStack.widthProperty().intValue());
                    grey.setMaxHeight(_centerStack.heightProperty().intValue());
                    grey.setMinHeight(_centerStack.heightProperty().intValue());
                    grey.setStyle("-fx-background-color: '#222222';");
                    grey.setOpacity(0.5);
                    HBox closeWindow = new HBox();
                    closeWindow.setMaxWidth(_centerStack.getWidth());
                    closeWindow.setMinWidth(_centerStack.getWidth());
                    Label close = new Label("X");
                    close.getStyleClass().add("raleway");
                    close.setStyle("-fx-font-size: 50px");
                    close.setAlignment(Pos.TOP_RIGHT);
                    close.setPadding(new Insets(20, 20, 0, 0));
                    closeWindow.setAlignment(Pos.TOP_RIGHT);
                    closeWindow.getChildren().add(close);
                    VBox card = getCardStyle(o);
                    _centerStack.getChildren().add(card);
                    _centerStack.getChildren().add(grey);
                    _centerStack.getChildren().add(closeWindow);
                    grey.toFront();
                    card.toFront();
                    close.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                    grey.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                    card.setOnMouseClicked(tp -> _centerStack.getChildren().removeAll(closeWindow, close, grey, card));
                });
                HBox owner = new HBox();
                owner.setSpacing(5);
                owner.setMaxHeight(10);
                owner.setMinHeight(10);
                v.getChildren().addAll(owner);
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.getChildren().add(price);
                v.getChildren().add(colour);
                v.setId(String.valueOf(topRow.indexOf(aTopRow)));
                topRowTiles.add(v);
            } else if (aTopRow instanceof TaxTile) {
                TaxTile t = (TaxTile) aTopRow;
                _storedStack.addAll(_centerStack.getChildren());
                VBox v = new VBox();
                v.setAlignment(Pos.CENTER);
                v.getStyleClass().add("tile");
                v.setMinWidth(93);
                v.setMaxWidth(93);
                Image taxImg = new Image("resources/tax.png");
                ImageView iv = new ImageView(taxImg);
                iv.setFitWidth(50);
                iv.setFitHeight(50);
                v.setSpacing(5);
                Label l = new Label("£" + t.getAmount());
                l.getStyleClass().add("tax-tile-text");
                v.setStyle("-fx-background-color: '#b8b8b8';");
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.getChildren().add(iv);
                v.getChildren().add(l);
                v.setId(String.valueOf(topRow.indexOf(aTopRow)));
                topRowTiles.add(v);
            } else if (aTopRow instanceof CardTile) {
                CardTile c = (CardTile) aTopRow;
                _storedStack.addAll(_centerStack.getChildren());
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(93);
                v.setMaxWidth(93);
                Label l = new Label("?");
                l.getStyleClass().add("card-text");
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.getChildren().add(l);
                v.setId(String.valueOf(topRow.indexOf(aTopRow)));
                topRowTiles.add(v);
            } else if (aTopRow instanceof Jail) {
                VBox v = new VBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setStyle("-fx-background-color: '#fbb676'");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(121);
                v.setMaxHeight(121);
                HBox topColumn = new HBox();
                Label justVisiting1 = new Label("Just visiting");
                justVisiting1.getStyleClass().add("jail-text-rotated");
                justVisiting1.setMinWidth(Label.USE_PREF_SIZE);
                justVisiting1.setMaxWidth(Label.USE_PREF_SIZE);
                justVisiting1.setMinHeight(Label.USE_PREF_SIZE);
                justVisiting1.setMaxHeight(Label.USE_PREF_SIZE);
                justVisiting1.setAlignment(Pos.CENTER_LEFT);
                justVisiting1.setPadding(new Insets(0, 0, 0, -5));
                topColumn.setAlignment(Pos.CENTER_LEFT);
                topColumn.getChildren().add(justVisiting1);
                topColumn.setMaxHeight(80);
                topColumn.setMinHeight(80);
                VBox jailBox = new VBox();
                jailBox.setMaxWidth(80);
                jailBox.setMaxHeight(80);
                jailBox.setMinWidth(70);
                jailBox.setMaxWidth(70);
                jailBox.setAlignment(Pos.CENTER);
                jailBox.setStyle("-fx-background-color: '#fbdb76'");
                Label inJail = new Label("In Jail");
                inJail.getStyleClass().add("jail-text");
                jailBox.getChildren().add(inJail);
                Image jailPng = new Image("resources/jail.png");
                ImageView jailView = new ImageView(jailPng);
                jailView.setFitHeight(60);
                jailView.setFitWidth(60);
                jailBox.getChildren().add(jailView);
                topColumn.getChildren().add(jailBox);
                v.getChildren().add(topColumn);
                v.setId(String.valueOf(topRow.indexOf(aTopRow)));
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                topRowTiles.add(v);
            } else if (aTopRow instanceof GoToJail) {
                VBox v = new VBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.getStyleClass().add("tile");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(123);
                v.setMaxHeight(123);
                v.setStyle("-fx-background-color: '#a1d87e'");
                Label goToJail = new Label("Go To Jail");
                goToJail.getStyleClass().add("go-to-jail");
                goToJail.setStyle("-fx-font-size: 10px; -fx-font-family: 'Raleway'; -fx-font-color: white");
                Image goToBin = new Image("resources/gotojail.png");
                ImageView policeHat = new ImageView(goToBin);
                policeHat.setFitHeight(60);
                policeHat.setFitWidth(60);
                v.setAlignment(Pos.CENTER);
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.getChildren().add(goToJail);
                v.getChildren().add(policeHat);
                v.setId(String.valueOf(topRow.indexOf(aTopRow)));
                topRowTiles.add(v);
            } else if (aTopRow instanceof FreeParking) {
                VBox v = new VBox();
                _storedStack.addAll(_centerStack.getChildren());
                v.setStyle("-fx-background-color: '#c7e7ff'");
                v.setMaxWidth(121);
                v.setMinWidth(121);
                v.setMaxHeight(123);
                v.setMinHeight(123);
                v.setAlignment(Pos.CENTER);
                v.setSpacing(5);
                Label l = new Label("Free parking");
                l.getStyleClass().add("free-parking");
                Image parking = new Image("resources/parking.png");
                ImageView parkingView = new ImageView(parking);
                parkingView.setFitHeight(50);
                parkingView.setFitWidth(50);
                HBox landed = new HBox();
                landed.setSpacing(5);
                landed.setMaxHeight(10);
                landed.setMinHeight(10);
                v.getChildren().addAll(landed);
                v.getChildren().add(l);
                v.getChildren().add(parkingView);
                v.setId(String.valueOf(topRow.indexOf(aTopRow)));
                topRowTiles.add(v);
            }
        }

        HBox botTiles = new HBox();
        for (VBox bottomRowTile : bottomRowTiles) {
            botTiles.getChildren().add(bottomRowTile);
        }
        this._boardPane.setBottom(botTiles);

        HBox topTiles = new HBox();
        for (VBox topRowTile : topRowTiles) {
            topTiles.getChildren().add(topRowTile);
        }
        this._boardPane.setTop(topTiles);

        VBox leftTiles = new VBox();
        for (HBox leftColumnTile : leftColumnTiles) {
            leftTiles.getChildren().add(leftColumnTile);
        }
        this._boardPane.setLeft(leftTiles);

        VBox rightTiles = new VBox();
        for (HBox rightColumnTile : rightColumnTiles) {
            rightTiles.getChildren().add(rightColumnTile);
        }
        this._boardPane.setRight(rightTiles);

        HBox imgContainer = new HBox();
        Image logo = new Image("resources/main-logo.png");
        ImageView centerLogo = new ImageView(logo);
        imgContainer.getChildren().add(centerLogo);
        imgContainer.setPadding(new Insets(-100, 0, 0, 0));
        imgContainer.setAlignment(Pos.CENTER);
        centerLogo.setFitHeight(225);
        centerLogo.setFitWidth(400);
        _centerStack.setAlignment(Pos.CENTER);
        _centerStack.getChildren().add(imgContainer);
    }

    public VBox getCardStyle(Tile t) {
        _storedStack.addAll(_centerStack.getChildren());
        VBox card = new VBox();
        card.setMaxWidth(400);
        card.setMinWidth(400);
        card.setMaxHeight(500);
        card.setMinHeight(500);
        card.setId("property-details");
        card.setStyle("-fx-background-color: '#ffffff';");
        BorderPane layout = new BorderPane();
        card.getChildren().add(layout);
        if (t instanceof Property) {
            Property p = (Property) t;
            HBox colour = new HBox();
            colour.setMaxHeight(70);
            colour.setMinHeight(70);
            colour.setStyle("-fx-background-color: '" + p.getGroup().getColour().getValue() + "';");
            Label l = new Label(t.getName());
            l.getStyleClass().add("property-title");
            colour.getChildren().add(l);
            colour.setAlignment(Pos.CENTER);
            Label price = new Label("Price");
            price.setPadding(new Insets(25, 0, 0, 50));
            price.getStyleClass().add("raleway");
            price.setStyle("-fx-font-size: 15px;");
            Label cost = new Label("£" + p.getPrice());
            cost.setPadding(new Insets(0, 0, 0, 50));
            cost.getStyleClass().add("raleway");
            cost.setStyle("-fx-font-size: 30px");
            VBox rent = new VBox();
            rent.setSpacing(10);
            Label rentLabel = new Label("Rent");
            rentLabel.getStyleClass().add("raleway");
            rent.getChildren().add(rentLabel);
            rent.setAlignment(Pos.CENTER);
            layout.setTop(colour);
            VBox priceCol = new VBox();
            priceCol.getChildren().addAll(price, cost);
            for (int i = 0; i < p.getRent().size(); i++) {
                HBox row = new HBox();
                Label rentLeft = new Label(i + " houses");
                rentLeft.getStyleClass().add("raleway");
                row.getChildren().add(rentLeft);
                row.setSpacing(150);
                row.setAlignment(Pos.CENTER);
                Label rentRight = new Label("£" + p.getRent().get(i));
                rentRight.getStyleClass().add("raleway");
                row.setPadding(new Insets(20, 0, 0, 0));
                row.getChildren().add(rentRight);
                rent.getChildren().add(row);
            }
            priceCol.getChildren().add(rent);
            layout.setCenter(priceCol);
            if (p.isOwned()) {
                HBox owner = new HBox();
                owner.setAlignment(Pos.BOTTOM_CENTER);
                owner.setMaxHeight(30);
                owner.setMinHeight(30);
                owner.setStyle("-fx-background-color:'" + p.getGroup().getColour().getValue() + "';");
                layout.setBottom(owner);
            }
        }
        if (t instanceof Station) {
            Station p = (Station) t;
            HBox colour = new HBox();
            colour.setMaxHeight(70);
            colour.setMinHeight(70);
            colour.setStyle("-fx-background-color: '" + p.getGroup().getColour().getValue() + "';");
            layout.setTop(colour);
            Label l = new Label(t.getName());
            l.getStyleClass().add("property-title");
            colour.getChildren().add(l);
            colour.setAlignment(Pos.CENTER);
            Label price = new Label("Price");
            price.setPadding(new Insets(25, 0, 0, 50));
            price.getStyleClass().add("raleway");
            price.setStyle("-fx-font-size: 15px;");
            Label cost = new Label("£" + p.getPrice());
            cost.setPadding(new Insets(0, 0, 0, 50));
            cost.getStyleClass().add("raleway");
            cost.setStyle("-fx-font-size: 30px");
            VBox rent = new VBox();
            rent.setSpacing(20);
            Label rentLabel = new Label("Rent");
            rentLabel.getStyleClass().add("raleway");
            rent.getChildren().add(rentLabel);
            rent.setAlignment(Pos.CENTER);
            card.getChildren().add(colour);
            card.getChildren().add(price);
            card.getChildren().add(cost);
            for (int i = 0; i < p.getRent().size(); i++) {
                HBox row = new HBox();
                Label rentLeft = new Label(i + " stations owned");
                rentLeft.getStyleClass().add("raleway");
                row.getChildren().add(rentLeft);
                row.setSpacing(150);
                row.setAlignment(Pos.CENTER);
                Label rentRight = new Label("£" + p.getRent().get(i));
                rentRight.getStyleClass().add("raleway");
                row.setPadding(new Insets(20, 0, 0, 0));
                row.getChildren().add(rentRight);
                rent.getChildren().add(row);
            }
            card.getChildren().add(rent);
            if (p.isOwned()) {
                HBox owner = new HBox();
                owner.setMaxHeight(50);
                owner.setMinHeight(50);
                owner.setStyle("-fx-background-color:'#222222';");
                layout.setBottom(owner);
            }
        }
        if (t instanceof Utility) {
            Utility p = (Utility) t;
            HBox colour = new HBox();
            colour.setMaxHeight(70);
            colour.setMinHeight(70);
            colour.setStyle("-fx-background-color: '" + p.getGroup().getColour().getValue() + "';");
            layout.setTop(colour);
            Label l = new Label(t.getName());
            l.getStyleClass().add("property-title");
            colour.getChildren().add(l);
            colour.setAlignment(Pos.CENTER);
            Label price = new Label("Price");
            price.setPadding(new Insets(25, 0, 0, 50));
            price.getStyleClass().add("raleway");
            price.setStyle("-fx-font-size: 15px;");
            Label cost = new Label("£" + p.getPrice());
            cost.setPadding(new Insets(0, 0, 0, 50));
            cost.getStyleClass().add("raleway");
            cost.setStyle("-fx-font-size: 30px");
            VBox rent = new VBox();
            rent.setSpacing(20);
            Label rentLabel = new Label("Rent");
            rentLabel.getStyleClass().add("raleway");
            rent.getChildren().add(rentLabel);
            rent.setAlignment(Pos.CENTER);
            card.getChildren().add(colour);
            card.getChildren().add(price);
            card.getChildren().add(cost);
            HBox row = new HBox();
            Label rentLeft = new Label("Some Utilities owned");
            rentLeft.getStyleClass().add("raleway");
            row.getChildren().add(rentLeft);
            row.setSpacing(150);
            row.setAlignment(Pos.CENTER);
            Label rentRight = new Label(p.getSomeOwned() + "x dice");
            rentRight.getStyleClass().add("raleway");
            row.setPadding(new Insets(20, 0, 0, 0));
            row.getChildren().add(rentRight);
            rent.getChildren().add(row);
            HBox row2 = new HBox();
            Label rentLeft2 = new Label("All Utilities owned");
            rentLeft2.getStyleClass().add("raleway");
            row2.getChildren().add(rentLeft2);
            row2.setSpacing(150);
            row2.setAlignment(Pos.CENTER);
            Label rentRight2 = new Label(p.getAllOwned() + "x dice");
            rentRight2.getStyleClass().add("raleway");
            row2.setPadding(new Insets(20, 0, 0, 0));
            row2.getChildren().add(rentRight2);
            rent.getChildren().add(row2);
            card.getChildren().add(rent);
            if (p.isOwned()) {
                HBox owner = new HBox();
                owner.setMaxHeight(50);
                owner.setMinHeight(50);
                owner.setStyle("-fx-background-color:'#222222';");
                layout.setBottom(owner);
            }
        }
        return card;
    }


    public void purchase(Ownable o, Player p) {
        HBox bottomRow = (HBox) _boardPane.getBottom();
        HBox topRow = (HBox) _boardPane.getTop();
        VBox leftCol = (VBox) _boardPane.getLeft();
        VBox rightCol = (VBox) _boardPane.getRight();
        System.out.println("HI");
        if (tiles.indexOf(o) < 12) {
            for (int i = 0; i < bottomRow.getChildren().size(); i++) {
                VBox v = (VBox) bottomRow.getChildren().get(i); //get next tile box
                if (Integer.parseInt(v.getId()) == tiles.indexOf(o)) {
                    System.out.println("Thing bought");
                    Image img = new Image("resources/player-piece" + p.getPiece().getValue() + "-small.png");
                    ImageView igv = new ImageView(img);
                    igv.setFitWidth(10);
                    igv.setFitHeight(10);
                    ((HBox) ((VBox) ((HBox) _boardPane.getBottom()).getChildren().get(10 - i)).getChildren().get(v.getChildren().size() - 2)).getChildren().add(igv);
                    ((HBox) _boardPane.getBottom()).getChildren().get(10 - i).setStyle("-fx-background-color: '" + OwnedColours.valueOf(o.getGroup().getColour().name()) + "';");
                }
            }
        } else if (tiles.indexOf(o) < 21) {
            for (int i = 0; i < topRow.getChildren().size(); i++) {
                VBox v = (VBox) topRow.getChildren().get(i); //get next tile box
                if (Integer.parseInt(v.getId()) == tiles.indexOf(p.getPosition())) {
                    System.out.println("Thing bought2");
                    Image img = new Image("resources/player-piece" + p.getPiece().getValue() + "-small.png");
                    ImageView igv = new ImageView(img);
                    igv.setFitWidth(10);
                    igv.setFitHeight(10);
                    ((HBox) ((VBox) ((HBox) _boardPane.getBottom()).getChildren().get(i)).getChildren().get(2)).getChildren().add(igv);
                    ((HBox) _boardPane.getBottom()).getChildren().get(i).setStyle("-fx-background-color: '" + OwnedColours.valueOf(o.getGroup().getColour().name()) + "';");
                }
            }
        } else if (tiles.indexOf(o) < 32) {
            for (int i = 0; i < rightCol.getChildren().size(); i++) {
                HBox v = (HBox) rightCol.getChildren().get(i); //get next tile box
                if (Integer.parseInt(v.getId()) == tiles.indexOf(p.getPosition())) {
                    System.out.println("Thing bought3");
                    Image img = new Image("resources/player-piece" + p.getPiece().getValue() + "-small.png");
                    ImageView igv = new ImageView(img);
                    igv.setFitWidth(10);
                    igv.setFitHeight(10);
                    ((HBox) ((VBox) ((HBox) _boardPane.getBottom()).getChildren().get(i)).getChildren().get(v.getChildren().size() - 2)).getChildren().add(igv);
                    ((VBox) _boardPane.getBottom()).getChildren().get(i).setStyle("-fx-background-color: '" + OwnedColours.valueOf(o.getGroup().getColour().name()) + "';");
                }
            }
        } else if (tiles.indexOf(o) < tiles.size()) {
            for (int i = 0; i < leftCol.getChildren().size(); i++) {
                HBox v = (HBox) leftCol.getChildren().get(i); //get next tile box
                if (Integer.parseInt(v.getId()) == tiles.indexOf(p.getPosition())) {
                    System.out.println("Thing bought4");
                    Image img = new Image("resources/player-piece" + p.getPiece().getValue() + "-small.png");
                    ImageView igv = new ImageView(img);
                    igv.setFitWidth(10);
                    igv.setFitHeight(10);
                    ((HBox) ((VBox) ((HBox) _boardPane.getBottom()).getChildren().get(10 - i)).getChildren().get(2)).getChildren().add(igv);
                    ((HBox) _boardPane.getBottom()).getChildren().get(10 - i).setStyle("-fx-background-color: '" + OwnedColours.valueOf(o.getGroup().getColour().name()) + "';");
                }
            }
        }
    }


    public void nextTurn() {
        this._dice = new Dice();
        _gameEngine.nextTurn();
        rollButton(this._dice);
        reorderPlayersSidebar();
    }

    //show a message on stage - delete message with destroyMessage()
    public void showMessage(String message) {
        _currentMsg.setText(message);
        _centerStack.getChildren().add(_currentMsg);
    }

    public void destroyMessage() {
        _currentMsg.setText("");
        _centerStack.getChildren().remove(_currentMsg);
    }

    //call this when a player lands on a tile
    public void landed(Tile t, Player p, int roll) {

        TileType type = TileType.Property;
        if (t instanceof Property) {
            type = TileType.Property;
        } else if (t instanceof Station) {
            type = TileType.Station;
        } else if (t instanceof Utility) {
            type = TileType.Utility;
        } else if (t instanceof CardTile) {
            type = TileType.Card;
        } else if (t instanceof Go) {
            type = TileType.Go;
        } else if (t instanceof GoToJail) {
            type = TileType.GoToJail;
        }
        Button ok = new Button("Ok");
        ok.getStyleClass().add("main-menu-button");
        ok.setPadding(new Insets(200, 0, 0, 0));
        ok.setOnAction((ActionEvent e) -> {
            cleanStack();
            nextTurn();
        });
        _storedStack.addAll(_centerStack.getChildren());
        switch (type) {
            case Property:
            case Station:
            case Utility:
                Ownable o = (Ownable) t;
                if (o.isOwned()) {
                    //use displayMessage, put everything before the following lines of code
                    String message = p.getName() + " paid £" + o.calculateRent(p, roll) + " to " + o.getOwner().getName();
                    displayMessage(message, 20);
                    _centerStack.getChildren().add(ok);

                    nextTurn();
                } else {
                    VBox container = new VBox();
                    container.setAlignment(Pos.CENTER);
                    VBox grey = new VBox();
                    grey.setMaxWidth(_centerStack.widthProperty().intValue());
                    grey.setMinWidth(_centerStack.widthProperty().intValue());
                    grey.setMaxHeight(_centerStack.heightProperty().intValue());
                    grey.setMinHeight(_centerStack.heightProperty().intValue());
                    grey.setStyle("-fx-background-color: '#222222';");
                    grey.setOpacity(0.5);
                    HBox closeWindow = new HBox();
                    closeWindow.setMaxWidth(_centerStack.getWidth());
                    closeWindow.setMinWidth(_centerStack.getWidth());
                    Label close = new Label("X");
                    close.getStyleClass().add("raleway");
                    close.setStyle("-fx-font-size: 50px");
                    close.setAlignment(Pos.TOP_RIGHT);
                    close.setPadding(new Insets(20, 20, 0, 0));
                    closeWindow.setAlignment(Pos.TOP_RIGHT);
                    closeWindow.getChildren().add(close);
                    VBox card = getCardStyle(t);
                    _centerStack.getChildren().add(card);
                    _centerStack.getChildren().add(grey);
                    _centerStack.getChildren().add(closeWindow);
                    grey.toFront();
                    card.toFront();
                    HBox buttons = new HBox();
                    buttons.setAlignment(Pos.CENTER);
                    buttons.setPadding(new Insets(100, 0, 0, 0));
                    container.getChildren().add(card);
                    Button buy = new Button("Buy");
                    buy.getStyleClass().add("main-menu-button");
                    container.getChildren().add(buttons);
                    buy.setOnAction((ActionEvent e) -> {
                        cleanStack();
                        if (!p.buyTile(t)) {
                            displayMessage("You don't have enough money!", 20);
                        }
                        purchase(o, p);
                        nextTurn();
                    });
                    Button auc = new Button("Auction");
                    auc.getStyleClass().add("main-menu-button");
                    container.getChildren().add(auc);
                    auc.setOnAction((ActionEvent e) -> {
                        //DO AUCTION
                        cleanStack();
                        nextTurn();
                    });
                    buttons.setSpacing(20);
                    buttons.getChildren().addAll(buy, auc);
                    _centerStack.getChildren().add(container);
                }
                break;
            case Card:
                CardTile c = (CardTile) t;
                VBox grey = new VBox();
                grey.setAlignment(Pos.CENTER);
                grey.setMaxWidth(_centerStack.widthProperty().intValue());
                grey.setMinWidth(_centerStack.widthProperty().intValue());
                grey.setMaxHeight(_centerStack.heightProperty().intValue());
                grey.setMinHeight(_centerStack.heightProperty().intValue());
                grey.setStyle("-fx-background-color: '#222222';");
                grey.setOpacity(0.5);
                HBox closeWindow = new HBox();
                closeWindow.setMaxWidth(_centerStack.getWidth());
                closeWindow.setMinWidth(_centerStack.getWidth());
                Label close = new Label("X");
                close.getStyleClass().add("raleway");
                close.setStyle("-fx-font-size: 50px");
                close.setAlignment(Pos.TOP_RIGHT);
                close.setPadding(new Insets(20, 20, 0, 0));
                closeWindow.setAlignment(Pos.TOP_RIGHT);
                closeWindow.getChildren().add(close);
                VBox card = new VBox();
                card.setMaxWidth(400);
                card.setMinWidth(400);
                card.setMaxHeight(500);
                card.setMinHeight(500);
                card.setStyle("-fx-background-color: '#ffffff';");
                card.setSpacing(30);
                Label title = new Label(c.getCardStack().getCardType().getValue());
                title.getStyleClass().add("raleway");
                title.setStyle("-fx-font-size: 20px");
                card.getChildren().add(title);
                Label question = new Label("?");
                question.getStyleClass().add("raleway");
                question.setStyle("-fx-font-size: 50px");
                card.getChildren().add(question);
                //TODO fill out label in next line
                Label message = new Label(/*In here, get the message on the card tile*/);
                message.getStyleClass().add("raleway");
                message.setStyle("-fx-font-size: 15px");
                message.setWrapText(true);
                card.getChildren().add(message);
                _centerStack.getChildren().add(card);
                _centerStack.getChildren().add(grey);
                _centerStack.getChildren().add(closeWindow);
                grey.toFront();
                card.toFront();
                _centerStack.getChildren().add(ok);
                break;
            case Go:
                displayMessage("Player " + p.getName() + " landed on go. Collect £200.", 20);
                _centerStack.getChildren().add(ok);
                break;
            case GoToJail:
                displayMessage("Go to jail!", 20);
                _centerStack.getChildren().add(ok);
                break;
        }
    }


    public void moveCurrentPlayer(int[] rollNumber) {
        int numberOfTile = (_gameEngine.getBoard().getTiles().indexOf(_gameEngine.getCurrentPlayer().getPosition()) + rollNumber[0] + rollNumber[1]) % _gameEngine.getBoard().getTiles().size();

        Tile tile = _gameEngine.getBoard().getTiles().get(numberOfTile);
        System.out.println("tile name: " + tile.getName() + " " + numberOfTile);
        _gameEngine.getCurrentPlayer().setPosition(tile);
        landed(tile, this._gameEngine.getCurrentPlayer(), rollNumber[0] + rollNumber[1]);


        //putPlayerOnTile(this._gameEngine.getCurrentPlayer());

    }


    public void rollButton(Dice dice) {
        VBox roll = new VBox();
        roll.setAlignment(Pos.CENTER);
        roll.setSpacing(50);
        Button btn = new Button("Roll");
        btn.getStyleClass().add("main-menu-button");
        btn.setOnAction((ActionEvent e) -> {
            int[] rollNumber = dice.roll();
            HBox diceRow = new HBox();
            diceRow.setSpacing(25);
            HBox dice1 = new HBox();
            Label number = new Label(String.valueOf(rollNumber[0])); //text in here is displayed, for now we'll just use numbers 1-6, i will add actual dice later
            number.getStyleClass().add("raleway");
            number.setStyle("-fx-font-size: 15px");
            dice1.setMaxWidth(50);
            dice1.setMinWidth(50);
            dice1.setMaxHeight(50);
            dice1.setMinHeight(50);
            dice1.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
            dice1.getChildren().add(number);
            dice1.setAlignment(Pos.CENTER);
            HBox dice2 = new HBox();
            Label number2 = new Label(String.valueOf(rollNumber[1])); //text in here is displayed, for now we'll just use numbers 1-6, i will add actual dice later
            number2.getStyleClass().add("raleway");
            number2.setStyle("-fx-font-size: 15px");
            dice2.setMaxWidth(50);
            dice2.setMinWidth(50);
            dice2.setMaxHeight(50);
            dice2.setMinHeight(50);
            dice2.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
            dice2.getChildren().add(number2);
            dice2.setAlignment(Pos.CENTER);
            diceRow.getChildren().addAll(dice1, dice2);
            Button close = new Button("Ok");
            close.getStyleClass().add("main-menu-button");
            close.setOnAction((ActionEvent em) -> {
                _centerStack.getChildren().removeAll(diceRow, close, btn, roll);
                moveCurrentPlayer(rollNumber);

            });
            diceRow.setAlignment(Pos.CENTER);
            diceRow.setTranslateY(230);
            close.setTranslateY(195);
            roll.getChildren().addAll(diceRow, close);
            _centerStack.getChildren().add(roll);
        });
        btn.setTranslateY(110);
        _centerStack.getChildren().add(btn);
        btn.toFront();
    }

    public VBox displayMessage(String s, int size) {
        _storedStack.addAll(_centerStack.getChildren());
        Label message = new Label(s);
        message.getStyleClass().add("raleway");
        message.setStyle("-fx-font-size: " + size + "px;");
        HBox newMessage = new HBox();
        newMessage.getChildren().add(message);
        VBox container = new VBox();
        container.setSpacing(10);
        container.getChildren().add(newMessage);
        Button ok = new Button("Ok");
        ok.setOnAction((ActionEvent e) -> cleanStack());
        ok.getStyleClass().add("main-menu-button");
        container.getChildren().add(ok);
        return container;
    }

    public void cleanStack() {
        _centerStack.getChildren().clear();
        for (Node n : _storedStack) {
            if (_centerStack.getChildren().contains(n)) {
                // do nothing
            } else {
                _centerStack.getChildren().add(n);
            }
        }
        _storedStack.clear();
    }

    public String getStyle(Tile tile) {
        String style = "";
        if (tile instanceof Ownable) {
            Ownable o = (Ownable) tile;
            style = o.getGroup().getColour().getValue();
        }
        return style;
    }

    //Move the player in GE before calling this function
    public void putPlayerOnTile(Player p) {
        HBox bottomRow = (HBox) _boardPane.getBottom();
        HBox topRow = (HBox) _boardPane.getTop();
        VBox leftCol = (VBox) _boardPane.getLeft();
        VBox rightCol = (VBox) _boardPane.getRight();
        Tile o = p.getPosition();
        if (tiles.indexOf(o) < 12) {
            for (int i = 0; i < bottomRow.getChildren().size(); i++) {
                VBox v = (VBox) bottomRow.getChildren().get(i); //get next tile box
                System.out.println("o: " + tiles.indexOf(o) + " + id: " + v.getId());
                if (Integer.parseInt(v.getId()) == tiles.indexOf(o)) {
                    System.out.println("Thing bought");
                    Image img = new Image("resources/player-piece" + p.getPiece().getValue() + "-small.png");
                    ImageView igv = new ImageView(img);
                    igv.setFitWidth(10);
                    igv.setFitHeight(10);
                    ((VBox) ((VBox) ((HBox) _boardPane.getBottom()).getChildren().get(10 - i)).getChildren().get(v.getChildren().size() - 1)).getChildren().add(igv);
                }
            }
        } else if (tiles.indexOf(o) < 21) {
            for (int i = 0; i < topRow.getChildren().size(); i++) {
                VBox v = (VBox) topRow.getChildren().get(i); //get next tile box
                if (Integer.parseInt(v.getId()) == tiles.indexOf(p.getPosition())) {
                    Image img = new Image("resources/player-piece" + p.getPiece().getValue() + "-small.png");
                    ImageView igv = new ImageView(img);
                    igv.setFitWidth(10);
                    igv.setFitHeight(10);
                    ((HBox) ((VBox) ((HBox) _boardPane.getBottom()).getChildren().get(i)).getChildren().get(v.getChildren().size() - 1)).getChildren().add(igv);
                }
            }
        } else if (tiles.indexOf(o) < 32) {
            for (int i = 0; i < rightCol.getChildren().size(); i++) {
                HBox v = (HBox) rightCol.getChildren().get(i); //get next tile box
                if (Integer.parseInt(v.getId()) == tiles.indexOf(p.getPosition())) {
                    Image img = new Image("resources/player-piece" + p.getPiece().getValue() + "-small.png");
                    ImageView igv = new ImageView(img);
                    igv.setFitWidth(10);
                    igv.setFitHeight(10);
                    ((HBox) ((VBox) ((HBox) _boardPane.getBottom()).getChildren().get(i)).getChildren().get(v.getChildren().size() - 1)).getChildren().add(igv);
                }
            }
        } else if (tiles.indexOf(o) < tiles.size()) {
            for (int i = 0; i < leftCol.getChildren().size(); i++) {
                HBox v = (HBox) leftCol.getChildren().get(i); //get next tile box
                if (Integer.parseInt(v.getId()) == tiles.indexOf(p.getPosition())) {
                    Image img = new Image("resources/player-piece" + p.getPiece().getValue() + "-small.png");
                    ImageView igv = new ImageView(img);
                    igv.setFitWidth(10);
                    igv.setFitHeight(10);
                    ((HBox) ((VBox) ((HBox) _boardPane.getBottom()).getChildren().get(10 - i)).getChildren().get(v.getChildren().size() - 1)).getChildren().add(igv);
                }
            }
        }
    }

    private void startGame() {

        for (Player player : _gameEngine.getPlayers()) {
            player.setPosition(tiles.get(0));
            putPlayerOnTile(player);
        }

        this._dice = new Dice();
        rollButton(this._dice);

//        while(true){
//
//
//            putPlayerOnTile(player);
//
//            int numberOfTile = (_gameEngine.getBoard().getTiles().indexOf(_gameEngine.getCurrentPlayer().getPosition()) + roll[0] + roll[1])%_gameEngine.getBoard().getTiles().size();
//            Tile tile = _gameEngine.getBoard().getTiles().get(numberOfTile);
//            _gameEngine.getCurrentPlayer().setPosition(tile);
//
//            landed(tile, player, roll[0]+roll[1]);
//
//            _gameEngine.nextTurn();
//
//s
//
//        }


    }


}