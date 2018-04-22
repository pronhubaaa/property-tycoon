import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {
    private Stage _primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this._primaryStage = primaryStage;
        GameEngine gameEngine = new GameEngine();
        UI ui = new UI(primaryStage, gameEngine);
    }

    public static void main(String[] args) {
        checker();

        launch(args);
    }


    public static void checker(){

    }
}
