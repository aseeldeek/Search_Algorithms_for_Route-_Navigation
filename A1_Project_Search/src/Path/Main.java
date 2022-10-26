package Path;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.fxml.FXMLLoader;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.Interpolator;


public class Main extends Application {
	public static Stage stg;

	@Override
	public void start(Stage primaryStage) {
		try {
			stg = primaryStage;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Graph.fxml"));
			Parent root = loader.load();
			GraphController ctrl = (GraphController) loader.getController(); // connecting
			ctrl.GraphThings(); // always executes
			primaryStage.getIcons().add(new Image(getClass().getResource("palestine.png").toURI().toString()));
			Scene scene = new Scene(root, 903, 715);
			primaryStage.setTitle("Travel Palestine!");
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeScene(String fxml) throws IOException {
		stg.getScene().setFill(new LinearGradient(
		        0, 0, 1, 1, true,                      //sizing
		        CycleMethod.NO_CYCLE,                  //cycling
		        new Stop(0, Color.web("#DDDDDD")),     //colors
		        new Stop(1, Color.web("#DDDDDD"))));
		
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
		pane.translateXProperty().set(stg.getHeight());
		pane.setTranslateX(100);		
	
		Timeline time= new Timeline();
		KeyValue kv=new KeyValue(pane.translateXProperty(),0,Interpolator.EASE_IN);
		KeyFrame kf=new KeyFrame(Duration.seconds(1),kv);
		time.getKeyFrames().add(kf);
		time.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
