import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
     *
     * @param ui The UI object.
     * @return A scene containing the main menu.
     */


    public static Scene getMainMenu(UI ui, GameEngine gameEngine) {
        URL url = MainMenuScreens.class.getResource("resources/style.css");
        if (url == null) {
            System.out.println("Resource not found");
        }
        String css = url.toExternalForm();
        VBox mainMenuLayout = new VBox() {{
            getStylesheets().add(css);
            setSpacing(8);
        }};

        Image logo = new Image("resources/main-logo.png"); //set image to be  logo
        ImageView imageView = new ImageView(logo) {{ //add the image to an image view
            setFitHeight(286);
            setFitWidth(500); //formatting logo
        }};

        mainMenuLayout.getChildren().add(imageView); //add image view to the scene

        mainMenuLayout.getChildren().addAll(getMainMenuButton("New game", "new-game-button",
                e -> ui.showScene(MainMenuScreens.getNewGame(ui, gameEngine))),

                getMainMenuButton("Load game", "load-game-button",
                e -> ui.showScene(MainMenuScreens.getLoadGame(ui))),

                getMainMenuButton("Import board", "import-board-button",
                e -> ui.showScene(MainMenuScreens.getImportBoard(ui))),

                getMainMenuButton("Settings", "settings-button",
                e -> ui.showScene(MainMenuScreens.getSettings(ui))),

                getMainMenuButton("Exit", "exit-button",
                e -> ui.close()));

        mainMenuLayout.setId("pane");
        return new Scene(mainMenuLayout);
    }

    private static Button getMainMenuButton(String buttonText, String buttonId, EventHandler<ActionEvent> actionEvent) {
        return new Button() {{
            setText(buttonText);
            setId(buttonId);
            getStyleClass().add("main-menu-button");
            setSize(this, 678, 90);
            setOnAction(actionEvent);
        }};
    }

    /**
     * Returns a scene containing new game setup screen.
     * @param ui    The UI object.
     * @return A scene containing the new game setup screen.
     */
    public static Scene getNewGame(UI ui, GameEngine gameEngine) {
        return new NewGameScreen(new VBox(), ui, gameEngine);
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
