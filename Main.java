// Importing necessary JavaFX classes
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

// Main class extending from Application for JavaFX
public class Main extends Application {

    // Overriding the start method from Application
    @Override
    public void start(Stage primaryStage) {
        // Creating an instance of the MemoryMatchGame
        MemoryMatchGame game = new MemoryMatchGame();

        // Creating a root StackPane for the Scene
        StackPane root = new StackPane();

        // Adding the game content to the StackPane
        root.getChildren().add(game.createContent());

        // Creating a Scene with the specified root and dimensions
        Scene scene = SceneMaker.CreateScene(root);

        // Setting the title of the primary stage
        primaryStage.setTitle("Memory Match Game");

        // Setting the scene of the primary stage
        primaryStage.setScene(scene);

        // Displaying the primary stage
        primaryStage.show();
    }

    // Main method serving as the entry point of the application
    public static void main(String[] args) {
        // Launching the JavaFX application
        launch(args);
    }
}
