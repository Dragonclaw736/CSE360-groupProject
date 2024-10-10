package application.Core;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 * The Navigation class is responsible for managing and navigating between different scenes in the application.
 * It stores registered scenes by name and allows switching between them using the primary stage.
 */
public class Navigation {

    // The primary stage of the application (where scenes will be set and displayed)
    private static Stage primaryStage;

    // A map to store scenes by name for easy access
    private static final HashMap<String, Scene> scenes = new HashMap<>();

    /**
     * Sets the primary stage for the application. 
     * Typically, this method is called once during the application's initialization.
     */
    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    /**
     * Registers a scene with a specific name to enable navigation to it later.
     */
    public static void registerScene(String name, Scene scene) {
        scenes.put(name, scene);
    }

    /**
     * Navigates to a scene by its registered name.
     * If the scene exists, it is set on the primary stage and displayed.
     */
    public static void navigateTo(String sceneName) {
        Scene scene = scenes.get(sceneName); // Retrieve the scene by name
        if (scene != null) {
            primaryStage.setScene(scene);    // Set the scene to the primary stage
            primaryStage.show();             // Show the stage with the new scene
        } else {
            // Print an error message if the scene is not found
            System.out.println("Scene '" + sceneName + "' not found.");
        }
    }

    /**
     * Removes a registered scene by its name.
     * This is optional and can be used to free up resources or manage scenes dynamically.
     */
    public static void removeScene(String name) {
        scenes.remove(name);
    }

    /**
     * Clears all registered scenes.
     * This can be useful when resetting or shutting down the application.
     */
    public static void clearAllScenes() {
        scenes.clear();
    }
}
