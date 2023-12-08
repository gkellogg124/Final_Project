// Importing necessary JavaFX classes
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

// SceneMaker class with a static method to create a Scene
public class SceneMaker {

    // Static method to create a Scene with a given StackPane
    public static Scene CreateScene(StackPane root) {
        // Creating a new Scene with the provided root and specific dimensions (800x800)
        Scene scene = new Scene(root, 800, 800);

        // Returning the created Scene
        return scene;
    }
}
