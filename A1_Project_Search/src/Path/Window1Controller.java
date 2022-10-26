package Path;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class Window1Controller implements Initializable {
	 

	@FXML
	private Button backButton;
	@FXML
	private BarChart<String, Integer> barchart;
	
	GraphController g = new GraphController();


	@FXML
	void backButton(ActionEvent event) throws IOException {
		//g.ClearAcrtion(event);
		Main m = new Main();
		m.changeScene("Graph.fxml");

	}

	@SuppressWarnings("unchecked")
	void h1BarChart() {
		XYChart.Series<String, Integer> s1 = new XYChart.Series<>();
		int x = GraphController.index_source;
		s1.setName(Graph.c[x][0].dest);
		for (int i = 0; i < 20; i++) {
			if (Graph.c[x][i].cost == 0) {
				s1.getData().add(new XYChart.Data<>(Graph.c[x][i].dest, 0));
				s1.setName(Graph.c[x][i].dest);
			} else
				s1.getData().add(new XYChart.Data<>(Graph.c[x][i].dest, Graph.c[x][i].h1));
		}

		barchart.getData().addAll(s1);
		barchart.setStyle("-fx-font-family: Constantia");
		barchart.setStyle("-fx-font-style: Bold");
	}

	@SuppressWarnings("unchecked")
	void h2BarChart() {
		
		XYChart.Series<String, Integer> s1 = new XYChart.Series<>();
		int x = GraphController.index_source;
		s1.setName(Graph.c[x][0].dest);

		for (int i = 0; i < 20; i++) {

			if (Graph.c[x][i].cost == 0) {
				s1.getData().add(new XYChart.Data<>(Graph.c[x][i].dest, 0));
				s1.setName(Graph.c[x][i].dest);
			} else
				s1.getData().add(new XYChart.Data<>(Graph.c[x][i].dest, Graph.c[x][i].h2));
		}

		barchart.getData().addAll(s1);
		barchart.setStyle("-fx-font-family: Constantia");
		//barchart.setStyle("-fx-font-style: Bold");
	}

	@SuppressWarnings("unchecked")
	void CostBarChart() {
		
		XYChart.Series<String, Integer> s1 = new XYChart.Series<>();
		int x = GraphController.index_source;
		s1.setName(Graph.c[x][0].dest);
		
		for (int i = 0; i < 20; i++) {

			if (Graph.c[x][i].cost == 99999) {
				s1.getData().add(new XYChart.Data<>(Graph.c[x][i].dest, 0));
			} else if (Graph.c[x][i].cost == 0) {
				s1.getData().add(new XYChart.Data<>(Graph.c[x][i].dest, 0));
				s1.setName(Graph.c[x][i].dest);
			} else
				s1.getData().add(new XYChart.Data<>(Graph.c[x][i].dest, Graph.c[x][i].cost));
		}

		barchart.getData().addAll(s1);
		barchart.setStyle("-fx-font-family: Constantia");
		//barchart.setStyle("-fx-font-style: Bold");
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		 DropShadow borderGlow= new DropShadow();
		 borderGlow.setOffsetY(0f);
		 borderGlow.setOffsetX(0f);
		 borderGlow.setColor(Color.web("#7F8487"));  //#413F42
		 borderGlow.setWidth(50);
		 borderGlow.setHeight(50);		  
		 barchart.setEffect(borderGlow);
		if (GraphController.flag == 1) {
			h1BarChart();
		} else if (GraphController.flag == 2) {
			CostBarChart();
		} else if (GraphController.flag == 3) {
			h2BarChart();
		}
	}

}
