package Path;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class Window2Controller implements Initializable {

	@FXML
	private Circle Aka, BeerSheba, Bethlehem, Dura, Gaza;

	@FXML
	private AnchorPane ap;
	@FXML
	private Label title;
	@FXML
	private Circle Haifa, Hebron, Jenin, Jericho, Jerusalem;

	@FXML
	private Circle Nablus, Nazareth, Qalqilya, Rafah, Ramallah;

	@FXML
	private Circle Ramleh, Safad, Tubas, Tulkarm, Yafa;

	@FXML
	private Button backButton;

	@FXML
	private TextArea costArea, pathArea, visitedArea;

	@FXML
	private ComboBox<String> selectPath;

	static int x = 0;
	static int count = 0;

	static Circle[] circles = new Circle[20];
	List<Line> lines = new ArrayList<Line>();
	static int depth = 50;  //Setting the uniform variable for the glow width and height	 

	@SuppressWarnings("unchecked")
	static ArrayList<Circle>[] cpath = new ArrayList[GraphController.goals.size()];
	static {
		for (int i = 0; i < GraphController.goals.size(); i++) {
			cpath[i] = new ArrayList<Circle>();
		}
	}

	public void setCost(String text) {
		costArea.appendText(text);
		costArea.setFont(Font.font("Constantia")); // !//!
		costArea.setStyle("-fx-text-inner-color: #16003B;"); // !//!

	}

	public void setPath(String text) {
		pathArea.appendText(text);
		pathArea.setFont(Font.font("Constantia")); // !//!
		pathArea.setStyle("-fx-text-inner-color: #16003B"); // !//!

	}

	public void setVisited(String text) {
		visitedArea.appendText(text);
		visitedArea.setFont(Font.font("Constantia")); // !//!
		visitedArea.setStyle("-fx-text-inner-color: #16003B;"); // !//!
	}

	GraphController g = new GraphController();

	@FXML
	void backButton(ActionEvent event) throws IOException {		
		g.ClearAcrtion(event);
		Main m = new Main();
		m.changeScene("Graph.fxml");

	}

	void addingPath() {
		List<String> myList = new ArrayList<String>();
		for (int i = 0; i < GraphController.goals.size(); i++) {
			myList.add(Graph.c[GraphController.goals.get(i)][GraphController.goals.get(i)].source);
		}
		selectPath.setItems(FXCollections.observableArrayList(myList));
	}

	@FXML
	void PrintPathOnMap(ActionEvent event) {

		ap.getChildren().removeAll(lines);

		if (selectPath.selectionModelProperty() != null) {
			for (int i = 0; i < GraphController.goals.size(); i++) {
				if (Graph.c[GraphController.goals.get(i)][GraphController.goals.get(i)].source
						.equalsIgnoreCase(selectPath.getSelectionModel().getSelectedItem())) {
					x = i;

				}
			}
			addline();

		}
	}

	void path() {

		circles[0] = Aka;
		circles[1] = Bethlehem;
		circles[2] = Dura;
		circles[3] = Haifa;
		circles[4] = BeerSheba;
		circles[5] = Hebron;
		circles[6] = Jenin;
		circles[7] = Jericho;
		circles[8] = Jerusalem;
		circles[9] = Nablus;
		circles[10] = Nazareth;
		circles[11] = Qalqilya;
		circles[12] = Ramallah;
		circles[13] = Ramleh;
		circles[14] = Gaza;
		circles[15] = Safad;
		circles[16] = Rafah;
		circles[17] = Tubas;
		circles[18] = Tulkarm;
		circles[19] = Yafa;

		for (int i = 0; i < GraphController.goals.size(); i++) {

			for (int j = 0; j < GraphController.paths[i].size(); j++) {

				// System.out.println(GraphController.paths[i].get(j));

				for (int k = 0; k < circles.length; k++) {

					if (GraphController.paths[i].get(j).equalsIgnoreCase(circles[k].getId())) {

						cpath[i].add(circles[k]);

					}

				}

			}

		}
	}

	void addline() {
		for (int j = 0; j < cpath[x].size() - 1; j++) {
			 int depth = 20;  //Setting the uniform variable for the glow width and height
			 
				DropShadow borderGlow = new DropShadow();
				borderGlow.setOffsetY(0f);
				borderGlow.setOffsetX(0f);
				borderGlow.setColor(Color.web("#16003B")); // #F32424
				borderGlow.setWidth(depth);
				borderGlow.setHeight(depth);
				Line line = new Line();
				line.setStartX(cpath[x].get(j).getLayoutX());
				line.setStartY(cpath[x].get(j).getLayoutY());
				line.setEndX(cpath[x].get(j + 1).getLayoutX());
				line.setEndY(cpath[x].get(j + 1).getLayoutY());
				line.setStroke(Color.RED); // FF008E F806CC
				line.setEffect(borderGlow);  // golw 
				line.setStrokeWidth(2);
				lines.add(line);
				ap.getChildren().addAll(line);

		}
	}

	void addGolwTtile() {
		DropShadow borderGlow= new DropShadow();
		borderGlow.setOffsetY(0f);
		borderGlow.setOffsetX(0f);
		borderGlow.setColor(Color.web("#413F42"));
		borderGlow.setWidth(depth);
		borderGlow.setHeight(depth);
		title.setEffect(borderGlow);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 path();
		 addingPath();
		 //addGolwTtile();
		 DropShadow borderGlow= new DropShadow();
		 borderGlow.setOffsetY(0f);
		 borderGlow.setOffsetX(0f);
		 borderGlow.setColor(Color.web("#16003B"));
		 borderGlow.setWidth(depth);
		 borderGlow.setHeight(depth);		  
		 ap.setEffect(borderGlow); 
		 addGolwTtile();

		for (int i = 0; i < GraphController.goals.size(); i++) {
			setPath((i + 1) + ") From " + GraphController.source + " to "
					+ Graph.c[GraphController.goals.get(i)][GraphController.goals.get(i)].source + ":");
			setVisited((i + 1) + ") ");
			setCost((i + 1) + ") ");
			setCost(GraphController.Scost[i] + "\n");
			setPath(GraphController.Path[i]
					+ "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			setVisited(GraphController.Visited[i]
					+ "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		}

	}

}
