import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainMenuScreens {
    /**
     * Returns a scene containing the main menu.
     * @param ui    The UI object.
     * @return A scene containing the main menu.
     */
    public static Scene getMainMenu(UI ui) {
        VBox mainMenuLayout = new VBox();
        mainMenuLayout.setSpacing(8);

        Button newGameButton = new Button();
        newGameButton.setText("New game");
        newGameButton.setId("new-game-button");

        newGameButton.setOnAction((ActionEvent e) -> {
            VBox testLayout = new VBox();
            Text testText = new Text("Test");
            testLayout.setId("test-layout");
            testLayout.getChildren().add(testText);
            ui.showScene(new Scene(testLayout));
        });

        Button loadGameButton = new Button();
        loadGameButton.setText("Load game");

        Button importBoardButton = new Button();
        importBoardButton.setText("Import board");

        Button settingsButton = new Button();
        settingsButton.setText("Settings");

        Button exitButton = new Button();
        exitButton.setText("Exit");

        mainMenuLayout.getChildren().add(newGameButton);
        mainMenuLayout.getChildren().add(loadGameButton);
        mainMenuLayout.getChildren().add(importBoardButton);
        mainMenuLayout.getChildren().add(settingsButton);
        mainMenuLayout.getChildren().add(exitButton);

        return new Scene(mainMenuLayout);
    }

    /**
     * Returns a scene containing new game setup screen.
     * @param ui    The UI object.
     * @return A scene containing the new game setup screen.
     */
    public static Scene getNewGame(UI ui) { return new Scene(new VBox()); }

    /**
     * Returns a scene containing load game screen.
     * @param ui    The UI object.
     * @return A scene containing the load game screen.
     */
    public static Scene getLoadGame(UI ui) { return new Scene(new VBox()); }

    /**
     * Returns a scene containing import board screen.
     * @param ui    The UI object.
     * @return A scene containing the import board screen.
     */
    public static Scene getImportBoard(UI ui) { return new Scene(new VBox()); }

    /**
     * Returns a scene containing settings screen.
     * @param ui    The UI object.
     * @return A scene containing the settings screen.
     */
    public static Scene getSettings(UI ui) { return new Scene(new VBox()); }
}
