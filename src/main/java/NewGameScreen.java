import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class NewGameScreen extends Scene {

    private static VBox rectLeft = new VBox();
    private static int playerCount = 0;
    private static int playerCountExternal = 0;
    private static boolean fullGameType = true;

    public static void addNewPlayer() {
        playerCount++;
        playerCountExternal++;
        if (playerCount > Game.getMaxPlayers()) {
            //error
        } else {
            HBox row2 = new HBox();
            row2.setPadding(new Insets(20, 0, 0, 30));
            Label player1text = new Label("Player " + playerCountExternal);
            row2.setId("players-text");
            BorderPane playerCross = new BorderPane();
            playerCross.setLeft(player1text);
            playerCross.setMaxWidth(375);
            playerCross.setMinWidth(375);
            Button deletePlayer = new Button("X");
            playerCross.setRight(deletePlayer);
            row2.getChildren().add(playerCross);

            deletePlayer.setAlignment(Pos.CENTER_RIGHT);
            deletePlayer.setId("delete-player");
            row2.getChildren().add(deletePlayer);
            deletePlayer.setOnAction((ActionEvent e) -> {
                if (playerCount == 2) {
                    // do nothing
                } else {
                    int boundary = rectLeft.getChildren().indexOf(row2);
                    if (4 * (boundary - 1) == 0) {
                        rectLeft.getChildren().remove(1, 5);
                        playerCount--;
                    } else {
                        rectLeft.getChildren().remove(boundary, boundary + 4);
                        playerCount--;
                    }
                }
            });

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
            row5.setPadding(new Insets(20, 0, 20, 30));
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

    public NewGameScreen(VBox scene, UI ui) {
        super(scene);
        scene.setId("menu-container");
        URL url = MainMenuScreens.class.getResource("resources/style.css");
        if (url == null) {
            System.out.println("Resource not found");
        }
        StackPane stack = new StackPane();
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
        Button rtnToMenu = new Button("Return to main menu");
        rtnToMenu.setId("menu-text");
        rtnToMenu.setOnAction((ActionEvent e) -> {
                ui.showScene(MainMenuScreens.getMainMenu(ui));
            });
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

        VBox rectLeftHolder = new VBox();
        rectLeftHolder.setMinHeight(800);
        rectLeftHolder.setMaxHeight(800);
        rectLeftHolder.setMinWidth(470);
        rectLeftHolder.setMaxWidth(470);
        rectLeftHolder.setId("menu-background");
        ScrollPane rectLeftScroll = new ScrollPane();
        rectLeftScroll.setId("menu-background");
        rectLeftScroll.setContent(rectLeft);
        rectLeftScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rectLeftHolder.getChildren().add(rectLeftScroll);
        rectLeft.setMinWidth(470);
        rectLeft.setMaxWidth(470);
        rectLeft.setId("menu-background");


        VBox rectRight = new VBox();
        rectRight.setPadding(new Insets(0, 0, 0, 30));
        rectRight.setSpacing(20);
        rectRight.setMinHeight(250);
        rectRight.setMinWidth(470);
        rectRight.setMaxHeight(250);
        rectRight.setMaxWidth(470);
        rectRight.setId("menu-background");


        VBox rectRightBot = new VBox();
        rectRightBot.setSpacing(20);
        rectRightBot.setPadding(new Insets(0, 0, 0, 20));
        rectRightBot.setMinHeight(520);
        rectRightBot.setMinWidth(470);
        rectRightBot.setMaxHeight(520);
        rectRightBot.setMaxWidth(470);
        rectRightBot.setId("menu-background");

        HBox row1 = new HBox();
        row1.setPadding(new Insets(20, 0, 0, 30));
        Label players = new Label("Players");
        row1.setId("players-title");
        row1.getChildren().add(players);
        rectLeft.getChildren().add(row1);

        addNewPlayer();
        addNewPlayer();

        HBox addPlayerRow = new HBox();
        Button addPlayer = new Button("Add Player");
        addPlayerRow.setPadding(new Insets(20, 30, 15 ,0));
        addPlayer.setId("add-player-button");
        addPlayerRow.getChildren().add(addPlayer);
        addPlayerRow.setAlignment(Pos.CENTER_RIGHT);
        rectLeft.getChildren().add(addPlayerRow);

        addPlayer.setOnAction((ActionEvent e) -> {
            rectLeft.getChildren().remove(addPlayerRow);
            addNewPlayer();
            rectLeft.getChildren().add(addPlayerRow);
        });

        Label board = new Label("Board");
        board.setId("players-title");
        board.setPadding(new Insets(20, 0, 0, 0));
        rectRight.getChildren().add(board);

        ObservableList<String> options = FXCollections.observableArrayList("Standard Board");

        try {
            FileReader fr = new FileReader("saved-boards.ted");
            BufferedReader br = new BufferedReader(fr);
            int lineNo = 1;
            String line;
            while((line = br.readLine()) != null) {
                if (lineNo % 2 == 0) {
                    options.add(line);
                }
                lineNo++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ComboBox dropdown = new ComboBox(options);
        dropdown.setPromptText("Standard Board");
        dropdown.setMinWidth(400);
        dropdown.setMaxWidth(400);
        dropdown.setMinHeight(40);
        dropdown.setMaxHeight(40);
        rectRight.getChildren().add(dropdown);

        Button importNewBoard = new Button("Import New Board");
        importNewBoard.setId("add-player-button");
        importNewBoard.setOnAction((ActionEvent e) -> {

           VBox importGameScreen = new VBox();
           importGameScreen.setMaxWidth(500);
           importGameScreen.setMinWidth(500);
           importGameScreen.setMaxHeight(300);
           importGameScreen.setMinHeight(300);
           importGameScreen.setId("import-game-screen");

           Label importGameTitle = new Label("Import a board");
           importGameTitle.setId("players-title");
           importGameTitle.setPadding(new Insets(30, 0, 0, 0));
           importGameScreen.getChildren().add(importGameTitle);

           HBox importRow1 = new HBox();
           Label path = new Label("Path: ");
           path.setId("time-limit");
           TextField pathToImport = new TextField();
           Image folder = new Image("resources/folder.png");
           ImageView folderView = new ImageView(folder);
           folderView.setFitHeight(20);
           folderView.setFitWidth(20);
           Button search = new Button("", folderView);
           search.setId("clear-button");
           importRow1.getChildren().addAll(path, pathToImport, search);
           importRow1.setAlignment(Pos.CENTER);
           importRow1.setPadding(new Insets(50, 0, 5, 0));

           HBox importRow2 = new HBox();
           Label importName = new Label("Name: ");
           importName.setId("time-limit");
           TextField importNameInput = new TextField();
           importRow2.getChildren().addAll(importName, importNameInput);
           importRow2.setAlignment(Pos.CENTER);

           importGameScreen.getChildren().addAll(importRow1, importRow2);

           HBox importRow3 = new HBox();
           Button applyImport = new Button("Apply");
           Button cancelImport = new Button("Cancel");
           applyImport.setId("add-player-button");
           cancelImport.setId("add-player-button");

           importRow3.getChildren().addAll(applyImport, cancelImport);
           importRow3.setAlignment(Pos.CENTER);
           importRow3.setPadding(new Insets(20, 0 , 0, 0));
           importRow3.setSpacing(10);

           importGameScreen.getChildren().add(importRow3);

           VBox menuOverlay = new VBox();
           menuOverlay.setMaxSize(1920, 1080);
           menuOverlay.setMinSize(1920, 1080);
           menuOverlay.getChildren().add(importGameScreen);
           menuOverlay.setAlignment(Pos.CENTER);
           importGameScreen.setAlignment(Pos.TOP_CENTER);
           stack.getChildren().add(menuOverlay);
           menuOverlay.toFront();

           cancelImport.setOnAction((ActionEvent em) -> {
               stack.getChildren().remove(menuOverlay);
           });



           search.setOnAction((ActionEvent im) -> {
               FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (.json)", "*.json");
               FileChooser fileChooser = new FileChooser();
               fileChooser.getExtensionFilters().add(extFilter);
               fileChooser.setTitle("Import board");
               File file = fileChooser.showOpenDialog(ui.getStage());
               pathToImport.setText(file.getAbsolutePath());
           });

           applyImport.setOnAction((ActionEvent emm) -> {
               File f = new File("saved-boards.ted");
               if(f.exists()) {
                   try {
                       FileWriter fw = new FileWriter("saved-boards.ted", true);
                       BufferedWriter bw = new BufferedWriter(fw);
                       bw.append(pathToImport.getText());
                       bw.newLine();
                       bw.append(importNameInput.getText());
                       bw.newLine();
                       bw.close();
                   } catch (IOException eq) {
                       //throw exception
                   }
               } else {
                   try {
                       FileWriter fw = new FileWriter(f);
                       PrintWriter pw = new PrintWriter(f);
                       pw.println(pathToImport.getText());
                       pw.println(importNameInput.getText());
                       pw.close();
                       fw.close();
                   } catch (Exception exc) {
                       //error
                   }
               }
               stack.getChildren().remove(menuOverlay);
           });
        });
        rectRight.getChildren().add(importNewBoard);

        HBox botRow1 = new HBox();
        botRow1.setAlignment(Pos.CENTER_LEFT);
        botRow1.setPadding(new Insets(20, 0, 0, 20));
        botRow1.setSpacing(20);
        Label boardType = new Label("Game type");
        boardType.setId("players-title");
        botRow1.getChildren().add(boardType);
        rectRightBot.getChildren().add(botRow1);
        Slider trading = new Slider();
        trading.setMax(1);
        trading.setMin(0);
        trading.setMinWidth(50);
        trading.setMaxWidth(50);
        Label tradingOn = new Label("Trading on");
        Label tradingOff = new Label("Trading off");
        tradingOn.setId("slider-text");
        tradingOff.setId("slider-text");
        botRow1.getChildren().addAll(tradingOn, trading, tradingOff);

        VBox fullGame = new VBox();
        VBox abridgedGame = new VBox();
        Label fullGameTitle = new Label("Full game");

        fullGameTitle.setId("game-type-title");
        fullGame.getChildren().add(fullGameTitle);
        fullGame.setMaxWidth(420);
        fullGame.setMinWidth(420);
        fullGame.setMaxHeight(180);
        fullGame.setMinHeight(180);
        fullGameTitle.setPadding(new Insets(20, 0, 0, 20));

        abridgedGame.setMaxWidth(420);
        abridgedGame.setMinWidth(420);
        abridgedGame.setMaxHeight(180);
        abridgedGame.setMinHeight(180);
        Label abridgedGameTitle = new Label("Abridged game");
        abridgedGameTitle.setId("game-type-title");
        abridgedGameTitle.setPadding(new Insets(20, 0, 0, 20));
        abridgedGame.getChildren().add(abridgedGameTitle);

        fullGame.setId("game-type-selected");
        abridgedGame.setId("game-type");
        rectRightBot.getChildren().add(fullGame);
        rectRightBot.getChildren().add(abridgedGame);

        Label fullGameText = new Label("Standard Property Tycoon! Play until one player emerges victorious.");
        fullGameText.setPadding(new Insets(0, 20, 0, 20));
        fullGameText.setWrapText(true);
        fullGameText.setId("game-type-text");

        Label abridgedGameText = new Label("Same as the full game, except there's a time limit. Play until time is up, the player with the most assets wins!");
        abridgedGameText.setPadding(new Insets(0, 20, 0, 20));
        abridgedGameText.setWrapText(true);
        abridgedGameText.setId("game-type-text");

        fullGame.getChildren().add(fullGameText);
        abridgedGame.getChildren().add(abridgedGameText);

        HBox timeLimitRow = new HBox();
        timeLimitRow.setSpacing(10);
        Label timeLimitText = new Label("Time limit: ");
        timeLimitText.setId("time-limit");
        TextField timeLimit = new TextField();
        timeLimit.setMinWidth(100);
        timeLimit.setMaxWidth(100);
        Label timeLimitMins = new Label("mins");
        timeLimitMins.setId("game-type-text");

        fullGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (fullGameType) {
                    //do nothing
                } else {
                    fullGameType = true;
                    fullGame.setId("game-type-selected");
                    abridgedGame.setId("game-type");
                }
            }
        });

        abridgedGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (fullGameType) {
                    abridgedGame.setId("game-type-selected");
                    fullGame.setId("game-type");
                    fullGameType = !fullGameType;
                } else {
                    //do nothing
                }
            }
        });

        timeLimitRow.getChildren().addAll(timeLimitText, timeLimit, timeLimitMins);
        timeLimitRow.setPadding(new Insets(20, 0, 0, 20));
        abridgedGame.getChildren().add(timeLimitRow);

        mainGrid.add(rectLeftHolder, 0, 0);
        mainGrid.add(rectRight, 1, 0);
        mainGrid.add(rectRightBot, 1, 0);
        mainGrid.setValignment(rectRight, VPos.TOP);
        mainGrid.setValignment(rectRightBot, VPos.BOTTOM);
        mainGrid.setGridLinesVisible(false);
        mainGrid.setAlignment(Pos.CENTER);

        holder.getChildren().add(mainGrid);
        stack.getChildren().add(root);
        scene.getChildren().add(stack);
    }
}
