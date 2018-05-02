import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

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
        this._boardContainer.setStyle("-fx-background-color: white;");

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

        for (int i = 0; i < rightColumn.size(); i++) {
            if (i == 0) {
                topRow.add(rightColumn.get(0));
            } else if (rightColumn.get(i) instanceof Go) {
                HBox v = new HBox();
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
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof Ownable) {
                Ownable o = (Ownable) rightColumn.get(i);
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
                v.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
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
                        _centerStack.getChildren().add(grey);
                        _centerStack.getChildren().add(closeWindow);
                        VBox card = getCardStyle(o);
                        _centerStack.getChildren().add(card);
                        closeWindow.toFront();
                        close.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent tp) {
                                _centerStack.getChildren().remove(grey);
                                _centerStack.getChildren().remove(closeWindow);
                                _centerStack.getChildren().remove(card);
                            }
                        });
                    }
                });
                v.getChildren().add(colour);
                v.getChildren().add(price);
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof TaxTile) {
                TaxTile t = (TaxTile) rightColumn.get(i);
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
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof CardTile) {
                CardTile c = (CardTile) rightColumn.get(i);
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
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof Jail) {
                HBox v = new HBox();
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
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof GoToJail) {
                HBox v = new HBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(121);
                v.setMaxHeight(121);
                v.setStyle("-fx-background-color: '#a1d87e'");
                Label goToJail = new Label("Go To Jail");
                goToJail.setStyle("-fx-font-size: 10px; -fx-font-family: 'Raleway'; -fx-font-color: white");
                v.getChildren().add(goToJail);
                rightColumnTiles.add(v);
            } else if (rightColumn.get(i) instanceof FreeParking) {
                HBox v = new HBox();
                v.setMaxWidth(121);
                v.setMinWidth(121);
                v.setMaxHeight(121);
                v.setMinHeight(121);
                Label l = new Label("Free parking");
                v.getChildren().add(l);
                rightColumnTiles.add(v);
            }
        }

        for (int i = 0; i < leftColumn.size(); i++) {
            if (i == leftColumn.size() - 1) {
                bottomRow.add(0, leftColumn.get(i));
            } else if (leftColumn.get(i) instanceof Go) {
                HBox v = new HBox();
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
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof Ownable) {
                Ownable o = (Ownable) leftColumn.get(i);
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
                v.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
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
                        _centerStack.getChildren().add(grey);
                        _centerStack.getChildren().add(closeWindow);
                        VBox card = getCardStyle(o);
                        _centerStack.getChildren().add(card);
                        closeWindow.toFront();
                        close.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent tp) {
                                _centerStack.getChildren().remove(grey);
                                _centerStack.getChildren().remove(closeWindow);
                                _centerStack.getChildren().remove(card);
                            }
                        });
                    }
                });
                v.getChildren().add(price);
                v.getChildren().add(colour);
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof TaxTile) {
                TaxTile t = (TaxTile) leftColumn.get(i);
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
                v.getChildren().add(iv);
                v.getChildren().add(l);
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof CardTile) {
                CardTile c = (CardTile) leftColumn.get(i);
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
                v.getChildren().add(l);
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof Jail) {
                HBox v = new HBox();
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
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof GoToJail) {
                HBox v = new HBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(121);
                v.setMaxWidth(121);
                v.setMinHeight(121);
                v.setMaxHeight(121);
                v.setStyle("-fx-background-color: '#a1d87e'");
                Label goToJail = new Label("Go To Jail");
                goToJail.setStyle("-fx-font-size: 10px; -fx-font-family: 'Raleway'; -fx-font-color: white");
                v.getChildren().add(goToJail);
                leftColumnTiles.add(v);
            } else if (leftColumn.get(i) instanceof FreeParking) {
                HBox v = new HBox();
                v.setMaxWidth(121);
                v.setMinWidth(121);
                v.setMaxHeight(121);
                v.setMinHeight(121);
                Label l = new Label("Free parking");
                v.getChildren().add(l);
                leftColumnTiles.add(v);
            }
        }

        for (int i = 0; i < bottomRow.size(); i++) {
            if (bottomRow.get(i) instanceof Go) {
                VBox v = new VBox();
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
                bottomRowTiles.add(v);
            } else if (bottomRow.get(i) instanceof Ownable) {
                Ownable o = (Ownable) bottomRow.get(i);
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(93);
                v.setMaxWidth(93);
                HBox colour = new HBox();
                colour.setStyle("-fx-background-color: '" + getStyle(o) + "';");
                colour.setAlignment(Pos.CENTER);
                Label l = new Label(bottomRow.get(i).getName());
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
                v.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
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
                        _centerStack.getChildren().add(grey);
                        _centerStack.getChildren().add(closeWindow);
                        System.out.println(_centerStack.getChildren().indexOf(closeWindow));
                        VBox card = getCardStyle(o);
                        _centerStack.getChildren().add(card);
                        closeWindow.toFront();
                        close.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent tp) {
                                _centerStack.getChildren().remove(grey);
                                _centerStack.getChildren().remove(closeWindow);
                                _centerStack.getChildren().remove(card);
                            }
                        });
                    }
                });
                v.getChildren().add(colour);
                v.getChildren().add(price);
                bottomRowTiles.add(v);
            } else if (bottomRow.get(i) instanceof TaxTile) {
                TaxTile t = (TaxTile) bottomRow.get(i);
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
                bottomRowTiles.add(v);
            } else if (bottomRow.get(i) instanceof CardTile) {
                CardTile c = (CardTile) bottomRow.get(i);
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(93);
                v.setMaxWidth(93);
                Label l = new Label("?");
                l.getStyleClass().add("card-text");
                v.getChildren().add(l);
                bottomRowTiles.add(v);
            } else if (bottomRow.get(i) instanceof Jail) {
                VBox v = new VBox();
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
                bottomRowTiles.add(v);
            } else if (bottomRow.get(i) instanceof GoToJail) {
                VBox v = new VBox();
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
                bottomRowTiles.add(v);
            } else if (bottomRow.get(i) instanceof FreeParking) {
                VBox v = new VBox();
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
                bottomRowTiles.add(v);
            }
        }

        for (int i = 0; i < topRow.size(); i++) {
            if (topRow.get(i) instanceof Go) {
                VBox v = new VBox();
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
                v.getChildren().add(go);
                v.getChildren().add(goImgHolder);
                topRowTiles.add(v);
            } else if (topRow.get(i) instanceof Ownable) {
                Ownable o = (Ownable) topRow.get(i);
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setMinWidth(93);
                v.setMaxWidth(93);
                HBox colour = new HBox();
                colour.setStyle("-fx-background-color: '" + getStyle(o) + "';");
                colour.setAlignment(Pos.CENTER);
                Label l = new Label(topRow.get(i).getName());
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
                v.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
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
                        _centerStack.getChildren().add(grey);
                        _centerStack.getChildren().add(closeWindow);
                        VBox card = getCardStyle(o);
                        _centerStack.getChildren().add(card);
                        closeWindow.toFront();
                        close.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent tp) {
                                _centerStack.getChildren().remove(grey);
                                _centerStack.getChildren().remove(closeWindow);
                                _centerStack.getChildren().remove(card);
                            }
                        });
                    }
                });
                v.getChildren().add(price);
                v.getChildren().add(colour);
                topRowTiles.add(v);
            } else if (topRow.get(i) instanceof TaxTile) {
                TaxTile t = (TaxTile) topRow.get(i);
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
                topRowTiles.add(v);
            } else if (topRow.get(i) instanceof CardTile) {
                CardTile c = (CardTile) topRow.get(i);
                VBox v = new VBox();
                v.getStyleClass().add("tile");
                v.setAlignment(Pos.CENTER);
                v.setMinWidth(93);
                v.setMaxWidth(93);
                Label l = new Label("?");
                l.getStyleClass().add("card-text");
                v.getChildren().add(l);
                topRowTiles.add(v);
            } else if (topRow.get(i) instanceof Jail) {
                VBox v = new VBox();
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
                topRowTiles.add(v);
            } else if (topRow.get(i) instanceof GoToJail) {
                VBox v = new VBox();
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
                topRowTiles.add(v);
            } else if (topRow.get(i) instanceof FreeParking) {
                VBox v = new VBox();
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

        VBox leftTiles = new VBox();
        for (int i = 0; i < leftColumnTiles.size(); i++) {
            leftTiles.getChildren().add(leftColumnTiles.get(i));
        }
        this._boardPane.setLeft(leftTiles);

        VBox rightTiles = new VBox();
        for (int i = 0; i < rightColumnTiles.size(); i++) {
            rightTiles.getChildren().add(rightColumnTiles.get(i));
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
        VBox card = new VBox();
        card.setMaxWidth(400);
        card.setMinWidth(400);
        card.setMaxHeight(500);
        card.setMinHeight(500);
        //add a message check here later
        _centerStack.getChildren().remove(2, _centerStack.getChildren().size());
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
            Label rentLeft = new Label( "Some Utilities owned");
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
            Label rentLeft2 = new Label( "All Utilities owned");
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


    //Function to change colour of tile when it is purchased
    public void purchase(Ownable o, Player p) {
        HBox bottomRow = (HBox) _boardPane.getBottom();
        for (int i = 0; i < bottomRow.getChildren().size(); i++) {
            VBox card = (VBox) bottomRow.getChildren().get(i);
            HBox colour = (HBox) card.getChildren().get(0);
            for (int j = 0; j < colour.getChildren().size(); j++) {
                if (colour.getChildren().get(j) instanceof Label) {
                    if (((Label) colour.getChildren().get(j)).getText() == o.getName()) {
                        ((HBox)((VBox) bottomRow.getChildren().get(i)).getChildren().get(1)).setStyle("-fx-background-color: '" + OwnedColours.valueOf(o.getGroup().getColour().toString()) + "';");
                        HBox playerRow = new HBox();
                        //Image piece = new Image(p.getPiece().getLocation());
                        //ImageView player = new ImageView(piece);
                        //player.setFitWidth(20);
                        //player.setFitHeight(20);
                        //playerRow.getChildren().add(player);
                        //((HBox)((VBox) bottomRow.getChildren().get(i)).getChildren().get(1)).getChildren().add(playerRow);
                    }
                }
            }
        }
    }

    public Button rollButton() {
        Button btn = new Button("Roll");
        btn.setId("main-menu-button");
        btn.setOnAction((ActionEvent e) -> {
            HBox diceRow = new HBox();
            diceRow.setSpacing(25);
            HBox dice1 = new HBox();
            Label number = new Label(/*code that gets dice integer*/);
            number.getStyleClass().add("raleway");
            number.setStyle("-fx-font-size: 15px");
            dice1.setMaxWidth(50);
            dice1.setMinWidth(50);
            dice1.setMaxHeight(50);
            dice1.setMinHeight(50);
            dice1.setStyle("-fx-background-color: white");
            dice1.getChildren().add(number);
            dice1.setAlignment(Pos.CENTER);
            HBox dice2 = new HBox();
            Label number2 = new Label(/*code that gets dice integer*/);
            number2.getStyleClass().add("raleway");
            number2.setStyle("-fx-font-size: 15px");
            dice2.setMaxWidth(50);
            dice2.setMinWidth(50);
            dice2.setMaxHeight(50);
            dice2.setMinHeight(50);
            dice2.setStyle("-fx-background-color: white");
            dice2.getChildren().add(number2);
            dice2.setAlignment(Pos.CENTER);
            diceRow.getChildren().addAll(dice1, dice2);
            _centerStack.getChildren().add(diceRow);
        });
        return btn;
    }

    public HBox displayMessage(String s, int size) {
        Label message = new Label(s);
        message.getStyleClass().add("raleway");
        message.setStyle("-fx-font-size: " + size + "px;");
        HBox newMessage = new HBox();
        newMessage.getChildren().add(message);
        return newMessage;
    }

    public void cleanStack() {
        _centerStack.getChildren().remove(1, _centerStack.getChildren().size());
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
