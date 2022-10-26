package Path;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class GraphController implements Initializable {
	@FXML
	private Button w1Button, w2Button, cButton;
	@FXML
	private ComboBox<String> comBox;
	@FXML
	private TextArea GoalsBord;
	@FXML
	private CheckBox cCost, wCost, Adist;
	@FXML
	private ToggleGroup algorithms, cities, Data;
	@FXML
	private RadioButton rButton1, rButton2, rButton3, rButton4, b1, b2, b3;
	@FXML
    private Label t1,t2,t3,title,t4;
	@FXML
	private AnchorPane Mpage, sPage;

  

	static int index_source = 0;
	static int index_dist = 0;
	static String str = ""; // to print the cities on the interface
	static String Path[] = new String[20];
	static String Scost[] = new String[20];
	static String Visited[] = new String[20];
	static int flag = 0;
	static Graph g = new Graph(22);
	static String source = "";
	static ArrayList<Integer> goals = new ArrayList<Integer>();
	@SuppressWarnings("unchecked")
	static ArrayList<String>[] paths= new ArrayList[20];
	
	static {
	for (int i = 0; i < 20; i++) {
	    paths[i] = new ArrayList<>();
	}
	}
	static int del=0;

	public void GraphThings() {
		try {
			Graph.readH1();
			Graph.readH2();
			Graph.readCost();
			Graph.readCity();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (Graph.c[i][j].cost != 99999 && Graph.c[i][j].cost != 0) {
					g.addEdge(i, j);

				}
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Path path = Paths.get("cities.txt");
		List<String> myList = null;
		try {
			myList = Files.lines(path).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comBox.setItems(FXCollections.observableArrayList(myList));
		
		 DropShadow borderGlow= new DropShadow();
		 borderGlow.setOffsetY(0f);
		 borderGlow.setOffsetX(0f);
		 borderGlow.setColor(Color.web("#7F8487"));
		 borderGlow.setWidth(20);
		 borderGlow.setHeight(20);		  
		 Mpage.setEffect(borderGlow);
		 sPage.setEffect(borderGlow);
		 title.setEffect(borderGlow);
		 t1.setEffect(borderGlow);
		 t2.setEffect(borderGlow);
		 t3.setEffect(borderGlow);
		 t4.setEffect(borderGlow);

	}

	@FXML
	void w1Button(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Window1.fxml");
		System.out.println("Welcome to Scence1");

	}

	@FXML
	void w2Button(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Window2.fxml");

	}

	@FXML // when choosing the Start goals
	void comBox(ActionEvent event) {
		if (comBox.getSelectionModel() != null) {
			for (int i = 0; i < 20; i++) {
				if (Graph.c[i][i].source.equalsIgnoreCase(comBox.getSelectionModel().getSelectedItem())) {
					index_source = i;
					source = Graph.c[i][i].source;

				}
			}
			System.out.println(index_source);

		}

	}

	@FXML
	void SearchForGoal(ActionEvent event) { // bfs
		if (rButton1.isSelected()) {
			// for(int i=0;i<goals.size();i++) {

			for (int i = 0; i < goals.size(); i++) {
				System.out.println("BFS is Selected !");
				Graph.BFS(index_source, goals.get(i));
				Scost[i] = Double.toString(Graph.cost_bdt);
				Path[i] = (Graph.RB).toString();
				paths[i].addAll(Graph.RB);	//!//!
				Visited[i] = (Graph.visited_bfs).toString();
				Graph.visited_bfs.clear();
				Graph.queue.clear();
				Graph.bdt.clear();
				Graph.PB.clear();
				Graph.RB.clear();
				Graph.indexB.clear();
				Graph.finalB.clear();
				Graph.cost_bdt = 0;
			}

			// }

		} else if (rButton2.isSelected()) { // dfs

			for (int i = 0; i < goals.size(); i++) {
				System.out.println("DFS is Selected !");
				Graph.DFS(index_source, goals.get(i));
				Scost[i] = Double.toString(Graph.cost_dep);
				Path[i] = (Graph.RD).toString();
				paths[i].addAll(Graph.RD);
				Visited[i] = (Graph.visited_dfs).toString();
				Graph.visited_dfs.clear();
				Graph.dep.clear();
				Graph.PD.clear();
				Graph.RD.clear();
				Graph.indexD.clear();
				Graph.finalD.clear();
				Graph.cost_dep = 0;
			}

		} else if (rButton3.isSelected()) { // car - walking

			for (int i = 0; i < goals.size(); i++) {
				System.out.println("A* part1 is Selected !");
				Graph.aStarCost_H2(index_source, goals.get(i));
				Graph.city2.add(Graph.c[goals.get(i)][goals.get(i)].source);
				Graph.nodes1.add(goals.get(i));
				Graph.Path2();
				Scost[i] = Double.toString(Graph.final_cost2);
				Path[i] = (Graph.P).toString();
				paths[i].addAll(Graph.P);
				Visited[i] = (Graph.city2).toString();
				Graph.nodes1.clear();
				Graph.MA.clear();
				Graph.P.clear();
				Graph.city2.clear();
				Graph.final_cost2 = 0;

			}

		} else if (rButton4.isSelected()) { // walking - ariel

			for (int i = 0; i < goals.size(); i++) {
				System.out.println("A* part2 is Selected !");
				Graph.aStarH2_H1(index_source, goals.get(i));
				Graph.city1.add(Graph.c[goals.get(i)][goals.get(i)].source);
				Graph.nodes.add(goals.get(i));
				Graph.Path1();
				Scost[i] = Double.toString(Graph.final_cost1);
				Path[i] = (Graph.AR).toString();
				paths[i].addAll(Graph.AR);
				Visited[i] = (Graph.city1).toString();
				Graph.nodes.clear();
				Graph.AR.clear();
				Graph.A.clear();
				Graph.city1.clear();
				Graph.final_cost1 = 0;
			}

		}

	}

	@FXML
	void ActionCity(ActionEvent event) {
		RadioButton selectedRadioButton = (RadioButton) cities.getSelectedToggle();
		String toogleGroupValue = selectedRadioButton.getText();

		for (int i = 0; i < 20; i++) {
			if (Graph.c[i][i].source.equalsIgnoreCase(toogleGroupValue)) {
				index_dist = i;
			}
		}

		System.out.println(index_dist);
		str = str + toogleGroupValue + "\n";
		goals.add(index_dist);
		GoalsBord.setText(str);
	}

	@FXML
	void OptionsChoice(ActionEvent event) {
		if (b1.isSelected()) {
			flag = 1;

		} else if (b2.isSelected()) {
			flag = 2;

		} else if (b3.isSelected()) {
			flag = 3;

		}

	}

	@FXML
	void ClearAcrtion(ActionEvent event) throws IOException {
	   	str = ""; 
    	Main m = new Main();
    	m.changeScene("Graph.fxml");
		Graph.visited_bfs.clear();
		Graph.queue.clear();
		Graph.bdt.clear();
		Graph.PB.clear();
		Graph.RB.clear();
		Graph.indexB.clear();
		Graph.finalB.clear();
		Graph.cost_bdt=0;	
		Graph.visited_dfs.clear();
		Graph.dep.clear();
		Graph.PD.clear();
		Graph.RD.clear();
		Graph.indexD.clear();
		Graph.finalD.clear();
		Graph.cost_dep=0;
		Graph.nodes1.clear();
		Graph.MA.clear();
		Graph.P.clear();
		Graph.city2.clear();
		Graph.final_cost2=0;
		Graph.nodes.clear();
		Graph.AR.clear();
		Graph.A.clear();
		Graph.city1.clear();
		Graph.final_cost1=0;
		
		for(int i=0;i<goals.size();i++) {
		paths[i].clear();
		Window2Controller.cpath[i].clear();

		}
		goals.clear();
    }
   

}
