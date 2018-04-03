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
            ui.showScene(MainMenuScreens.getNewGame(ui));
        });

        Button loadGameButton = new Button();
        loadGameButton.setText("Load game");
        loadGameButton.setId("load-game-button");
        loadGameButton.setOnAction((ActionEvent e) -> {
            ui.showScene(MainMenuScreens.getLoadGame(ui));
        });

        Button importBoardButton = new Button();
        importBoardButton.setText("Import board");
        importBoardButton.setId("import-board-button");
        importBoardButton.setOnAction((ActionEvent e) -> {
            ui.showScene(MainMenuScreens.getImportBoard(ui));
        });

        Button settingsButton = new Button();
        settingsButton.setText("Settings");
        settingsButton.setId("settings-button");
        settingsButton.setOnAction((ActionEvent e) -> {
            ui.showScene(MainMenuScreens.getSettings(ui));
        });

        Button exitButton = new Button();
        exitButton.setText("Exit");
        exitButton.setId("exit-button");
        exitButton.setOnAction((ActionEvent e) -> {
            ui.close();
        });

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
    public static Scene getNewGame(UI ui) {
        return new NewGameScreen(new VBox());
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
}
