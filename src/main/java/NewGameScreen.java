import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.net.URL;
import java.util.ArrayList;

public class NewGameScreen extends Scene {

    private VBox rectLeft = new VBox();
    private int playerCount = 0;

    public void addNewPlayer() {
        if (playerCount > 7) {
            //error
        } else {
            HBox row2 = new HBox();
            row2.setPadding(new Insets(20, 0, 0, 30));
            int playerNum = 1;
            Label player1text = new Label("Player " + playerNum);
            row2.setId("players-text");
            row2.getChildren().add(player1text);
            rectLeft.getChildren().add(row2);

            HBox row3 = new HBox();
            row3.setPadding(new Insets(20, 0, 0, 30));
            Label nameText = new Label("Name: ");
            row3.setId("players-text");
            row3.getChildren().add(nameText);
            TextField nameEntry = new TextField();
            row3.getChildren().add(nameEntry);
            row3.setAlignment(Pos.CENTER_LEFT);
            rectLeft.getChildren().add(row3);

            HBox row4 = new HBox();
            row4.setPadding(new Insets(20, 0, 0, 30));
            Label playerType = new Label("Type: ");
            row4.setId("players-text");
            Slider humanAi = new Slider();
            humanAi.setMax(1);
            humanAi.setMin(0);
            Label person = new Label("Person");
            Label AI = new Label("AI");
            person.setId("slider-text");
            AI.setId("slider-text");
            person.setPadding(new Insets(0, 0, 0, 12));
            row4.getChildren().addAll(playerType, person, humanAi, AI);
            row4.setAlignment(Pos.CENTER_LEFT);
            rectLeft.getChildren().add(row4);

            HBox row5 = new HBox();
            row5.setPadding(new Insets(20, 0, 0, 30));
            row5.setAlignment(Pos.CENTER_LEFT);
            Label pieces = new Label("Piece: ");
            pieces.setPadding(new Insets(0, 5, 0, 0));
            pieces.setId("players-text");
            row5.getChildren().add(pieces);
            HBox piecesList = new HBox();
            piecesList.setAlignment(Pos.CENTER_LEFT);
            ScrollPane scroll = new ScrollPane();
            for (int i = 0; i < 8; i++) {
                Image img = new Image("resources/icon.png");
                ImageView v = new ImageView(img);
                v.setFitHeight(50);
                v.setFitWidth(50);
                piecesList.getChildren().add(v);
            }
            scroll.setMaxHeight(70);
            scroll.setMinHeight(70);
            scroll.setMaxWidth(300);
            scroll.setMinWidth(300);
            scroll.setContent(piecesList);
            row5.getChildren().add(scroll);
            rectLeft.getChildren().add(row5);
        }
    }

    public NewGameScreen(VBox scene) {
        super(scene);
        scene.setId("menu-container");
        URL url = MainMenuScreens.class.getResource("resources/style.css");
        if (url == null) {
            System.out.println("Resource not found");
        }
        String css = url.toExternalForm();
        scene.getStylesheets().add(css);
        BorderPane root = new BorderPane();
        VBox holder = new VBox();
        HBox newGameScreen = new HBox();
        holder.getChildren().add(newGameScreen);
        root.setCenter(holder);
        StackPane top = new StackPane();
        top.setMaxHeight(50);
        top.setMinHeight(50);
        root.setTop(top);
        newGameScreen.setSpacing(600);
        newGameScreen.setId("new-game-screen-top");
        Image smallLogo = new Image("resources/icon.png");
        ImageView imageView1 = new ImageView(smallLogo);
        imageView1.setFitHeight(100);
        imageView1.setFitWidth(100);
        newGameScreen.getChildren().add(imageView1);
        Label rtnToMenu = new Label("Return to main menu");
        rtnToMenu.setId("menu-text");
        newGameScreen.getChildren().add(rtnToMenu);
        HBox secondLayer = new HBox();
        secondLayer.setSpacing(200);
        secondLayer.setAlignment(Pos.CENTER);
        secondLayer.setId("new-game-screen-top");
        Label blank = new Label("");
        secondLayer.getChildren().add(blank);
        Label setup = new Label("Game Setup");
        setup.setId("setup-text");
        secondLayer.getChildren().add(setup);
        Button startGame = new Button("Start Game");
        startGame.setId("start-game-button");
        secondLayer.getChildren().add(startGame);
        holder.getChildren().add(secondLayer);
        StackPane separator = new StackPane();
        separator.setMaxHeight(20);
        separator.setMinHeight(20);
        holder.getChildren().add(separator);

        GridPane mainGrid = new GridPane();

        ColumnConstraints colConst = new ColumnConstraints();
        colConst.setMaxWidth(500);
        colConst.setMinWidth(500);
        mainGrid.getColumnConstraints().add(colConst);
        ColumnConstraints colConst2 = new ColumnConstraints();
        colConst2.setMaxWidth(500);
        colConst2.setMinWidth(500);
        mainGrid.getColumnConstraints().add(colConst2);


        rectLeft.setMinHeight(800);
        rectLeft.setMaxHeight(800);
        rectLeft.setMinWidth(470);
        rectLeft.setMaxWidth(470);
        rectLeft.setId("menu-background");


        VBox rectRight = new VBox();
        rectRight.setMinHeight(300);
        rectRight.setMinWidth(470);
        rectRight.setMaxHeight(300);
        rectRight.setMaxWidth(470);
        rectRight.setId("menu-background");


        VBox rectRightBot = new VBox();
        rectRightBot.setMinHeight(470);
        rectRightBot.setMinWidth(470);
        rectRightBot.setMaxHeight(470);
        rectRightBot.setMaxWidth(470);
        rectRightBot.setId("menu-background");

        HBox row1 = new HBox();
        row1.setPadding(new Insets(20, 0, 0, 30));
        Label players = new Label("Players");
        row1.setId("players-title");
        row1.getChildren().add(players);
        rectLeft.getChildren().add(row1);

        addNewPlayer();

        HBox addPlayerRow = new HBox();
        Button addPlayer = new Button("Add Player");
        addPlayerRow.setPadding(new Insets(30, 20, 0 ,0));
        addPlayer.setId("add-player-button");
        addPlayerRow.getChildren().add(addPlayer);
        addPlayerRow.setAlignment(Pos.CENTER_RIGHT);
        rectLeft.getChildren().add(addPlayerRow);

//        ArrayList<Node> menuSection = new ArrayList<Node>();
//        menuSection.add(row1);
//        menuSection.add(row2);
//        menuSection.add(row3);
//        menuSection.add(row4);
//        menuSection.add(row5);
//        menuSection.add(addPlayerRow);
        rectLeft.getChildren().add(new StackPane());

        addPlayer.setOnAction((ActionEvent e) -> {
            rectLeft.getChildren().remove(addPlayer);
            addNewPlayer();
            rectLeft.getChildren().add(addPlayer);
        });

        mainGrid.add(rectLeft, 0, 0);
        mainGrid.add(rectRight, 1, 0);
        mainGrid.add(rectRightBot, 1, 0);
        mainGrid.setValignment(rectRight, VPos.TOP);
        mainGrid.setValignment(rectRightBot, VPos.BOTTOM);
        mainGrid.setGridLinesVisible(false);
        mainGrid.setAlignment(Pos.CENTER);

        holder.getChildren().add(mainGrid);

        scene.getChildren().add(root);
    }
}
