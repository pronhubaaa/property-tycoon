import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import java.net.URL;

public class MainMenuScreens {
    /**
     * Returns a scene containing the main menu.
     * @param ui    The UI object.
     * @return A scene containing the main menu.
     */


    public static Scene getMainMenu(UI ui) {
        URL url = MainMenuScreens.class.getResource("resources/style.css");
        if (url == null) {
            System.out.println("Resource not found");
        }
        String css = url.toExternalForm();
        VBox mainMenuLayout = new VBox();
        mainMenuLayout.getStylesheets().add(css);
        mainMenuLayout.setSpacing(8);

        Image logo = new Image("resources/main-logo.png"); //set image to be  logo
        ImageView imageView = new ImageView(logo); //add the image to an image view
        imageView.setFitHeight(286);
        imageView.setFitWidth(500); //formatting logo
        mainMenuLayout.getChildren().add(imageView); //add image view to the scene

        Button newGameButton = new Button();
        newGameButton.setText("New game");
        newGameButton.setId("new-game-button");
        newGameButton.getStyleClass().add("main-menu-button");
        setSize(newGameButton, 678, 90);
        newGameButton.setOnAction((ActionEvent e) -> {
            ui.showScene(MainMenuScreens.getNewGame(ui));
        });

        Button loadGameButton = new Button();
        loadGameButton.setText("Load game");
        loadGameButton.setId("load-game-button");
        loadGameButton.getStyleClass().add("main-menu-button");
        setSize(loadGameButton, 678, 90);
        loadGameButton.setOnAction((ActionEvent e) -> {
            ui.showScene(MainMenuScreens.getLoadGame(ui));
        });

        Button importBoardButton = new Button();
        importBoardButton.setText("Import board");
        importBoardButton.setId("import-board-button");
        importBoardButton.getStyleClass().add("main-menu-button");
        setSize(importBoardButton, 678, 90);
        importBoardButton.setOnAction((ActionEvent e) -> {
            ui.showScene(MainMenuScreens.getImportBoard(ui));
        });

        Button settingsButton = new Button();
        settingsButton.setText("Settings");
        settingsButton.setId("settings-button");
        settingsButton.getStyleClass().add("main-menu-button");
        setSize(settingsButton, 678, 90);
        settingsButton.setOnAction((ActionEvent e) -> {
            ui.showScene(MainMenuScreens.getSettings(ui));
        });

        Button exitButton = new Button();
        exitButton.setText("Exit");
        exitButton.setId("exit-button");
        exitButton.getStyleClass().add("main-menu-button");
        setSize(exitButton, 678, 90);
        exitButton.setOnAction((ActionEvent e) -> {
            ui.close();
        });
        mainMenuLayout.getChildren().add(newGameButton);
        mainMenuLayout.getChildren().add(loadGameButton);
        mainMenuLayout.getChildren().add(importBoardButton);
        mainMenuLayout.getChildren().add(settingsButton);
        mainMenuLayout.getChildren().add(exitButton);
        mainMenuLayout.setId("pane");
        return new Scene(mainMenuLayout);
    }

    /**
     * Returns a scene containing new game setup screen.
     * @param ui    The UI object.
     * @return A scene containing the new game setup screen.
     */
    public static Scene getNewGame(UI ui) {
        return new NewGameScreen(new VBox(), ui);
    }

    /**
     * Returns a scene containing load game screen.
     * @param ui    The UI object.
     * @return A scene containing the load game screen.
     */
    public static Scene getLoadGame(UI ui) {
        return new LoadGameScreen(new VBox());
    }

    /**
     * Returns a scene containing import board screen.
     * @param ui    The UI object.
     * @return A scene containing the import board screen.
     */
    public static Scene getImportBoard(UI ui) {
        return new ImportBoardScreen(new VBox());
    }

    /**
     * Returns a scene containing settings screen.
     * @param ui    The UI object.
     * @return A scene containing the settings screen.
     */
    public static Scene getSettings(UI ui) {
        return new SettingsScreen(new VBox());
    }

    /**
     * Sets a passed node's strictly limited width and height.
     * @param node      The UI object.
     * @param width     The determined width.
     * @param height    The determined height.
     */

    public static void setSize(Labeled node, int width, int height) {
        node.setMaxWidth(width);
        node.setMinWidth(width);
        node.setMaxHeight(height);
        node.setMinHeight(height);
    }
}
