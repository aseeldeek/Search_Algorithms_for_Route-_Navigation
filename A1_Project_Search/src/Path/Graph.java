package Path;

import java.io.*;
import java.util.*;

class Graph {
	private static int V; // number of nodes in the graph
	private static LinkedList<Integer> adj[]; // adjacency list
	public static Queue<Integer> queue; // maintaining a queue
	
	static ArrayList<String> city2 = new ArrayList<String>(); // car walking
	static ArrayList<String> city1 = new ArrayList<String>(); // walking arieal
	
	static ArrayList<Integer> nodes1 = new ArrayList<Integer>(); // a* 2
	static ArrayList<String> MA = new ArrayList<String>();// a* 2
	static ArrayList<String> P = new ArrayList<String>(); // for a* reversed 2
	
	static ArrayList<Integer> nodes = new ArrayList<Integer>(); // a* 1
	static ArrayList<String> A = new ArrayList<String>();// a* 1
	static ArrayList<String> AR = new ArrayList<String>(); // for a* reversed 1
	
	static ArrayList<String> visited_dfs = new ArrayList<String>(); // for dfs visited
	static ArrayList<Integer> dep = new ArrayList<Integer>(); // for 
	static ArrayList<String> PD = new ArrayList<String>(); // for dfs
	static ArrayList<String> RD = new ArrayList<String>(); // for dfs
	static ArrayList<Integer> indexD = new ArrayList<Integer>(); // for dfs
	static ArrayList<Integer> finalD = new ArrayList<Integer>(); // for dfs

	
	static ArrayList<String> visited_bfs = new ArrayList<String>(); // for bfs visited
	static ArrayList<Integer> bdt = new ArrayList<Integer>(); // for bfs
	static ArrayList<String> PB = new ArrayList<String>(); // for bfs
	static ArrayList<String> RB = new ArrayList<String>(); // for bfs
	static ArrayList<Integer> indexB = new ArrayList<Integer>(); // for bfs
	static ArrayList<Integer> finalB = new ArrayList<Integer>(); // for bfs


	static double final_cost2 = 0;
	static double final_cost1 = 0;
	static double cost_dep = 0;
	static double cost_bdt = 0;

	@SuppressWarnings("unchecked")
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
		queue = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w); // adding an edge to the adjacency list (edges are bidirectional in this
						// example)
	}

	public static void BFS(int n, int x) {

		boolean nodes[] = new boolean[V]; // initialize boolean array for holding the data
		// int level[] = new int[V];
		// level[n] = 0;
		//c[n][n].level = 0;
		int a = 0;
		// int p=0;

		nodes[n] = true;
		queue.add(n); // root node is added to the top of the queue

		// while (queue.size() != 0)
		while (queue.size() != 0) {
			// p=n;

			if (n == x) {
				break;
			}

			n = queue.poll(); // remove the top element of the queue

			// System.out.println("cities visited : "+n ); //print the top element of the
			// queue
			//System.out.println(n + " " + c[n][n].dest + " " + c[n][n].level);
			bdt.add(n);
			visited_bfs.add(c[n][n].dest);

			for (int i = 0; i < adj[n].size(); i++) // iterate through the linked list and push all neighbors into queue
			{
				a = adj[n].get(i);
				if (!nodes[a]) // only insert nodes into queue if they have not been explored already
				{
					//c[a][a].level = c[n][n].level + 1;
					nodes[a] = true;
					queue.add(a);
				}
			}
		}

		for (int i = bdt.size() - 1; i > -1; i--) {
			for (int j = i; j > -1; j--) {
				if (c[bdt.get(i)][bdt.get(j)].cost != 99999 && c[bdt.get(i)][bdt.get(j)].cost != 0) {
					// System.out.println("Path is:" + c[nodes1.get(i)][nodes1.get(j)].source+"
					// "+c[nodes1.get(i)][nodes1.get(j)].dest);
					if (PB.isEmpty() && indexB.isEmpty()) {
						PB.add(c[bdt.get(i)][bdt.get(j)].source);
						PB.add(c[bdt.get(i)][bdt.get(j)].dest);
						indexB.add(bdt.get(i));
						indexB.add(bdt.get(j));

					} else if (PB.get(PB.size() - 1) == c[bdt.get(i)][bdt.get(j)].source) {
						PB.add(c[bdt.get(i)][bdt.get(j)].dest);
						indexB.add(bdt.get(j));
					}

				}

			}

		}

		for (int i = PB.size() - 1; i > -1; i--) {
			RB.add(PB.get(i));
			finalB.add(indexB.get(i));

		}
		for (int i = 0; i < finalB.size() - 1; i++) {
			cost_bdt += c[finalB.get(i)][finalB.get(i + 1)].cost;

		}
		System.out.println("Visited nodes  : ");
		System.out.println(visited_bfs);
		System.out.println("Here is our path  : ");
		System.out.println(RB);
		// System.out.print(finalD);
		System.out.println("final cost is " + cost_bdt);

	}

	// ---------------------------------------------------------------------------------------------------------------------------------
	static City[][] c = new City[20][20];

	static {
		// Instantiating the objects present in the array
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				c[i][j] = new City();
			}
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------
//h1 is the ariel distance

	public static void readH1() throws FileNotFoundException {
		Scanner sc;
		sc = new Scanner(new BufferedReader(new FileReader("heuristic1.txt")));
		int rows = 20;
		int columns = 20;
		int[][] heu = new int[rows][columns];

		for (int i = 0; i < heu.length; i++) {

			for (int j = 0; j < heu[i].length; j++) {

				heu[i][j] = sc.nextInt();

				c[i][j].setH1(heu[i][j]);
			}
			sc.nextLine();
		}

	}

	// ------------------------------------------------------------------------------------
// h2 is the walking distance
	public static void readH2() throws FileNotFoundException {
		Scanner sc;
		sc = new Scanner(new BufferedReader(new FileReader("heuristic2.txt")));
		int rows = 20;
		int columns = 20;
		int[][] heu = new int[rows][columns];

		for (int i = 0; i < heu.length; i++) {

			for (int j = 0; j < heu[i].length; j++) {

				heu[i][j] = sc.nextInt();

				c[i][j].setH2(heu[i][j]);
			}
			sc.nextLine();
		}
	}

//------------------------------------------------------------------------------------   
// cost is the car distance
	public static void readCost() throws FileNotFoundException {
		Scanner sc;
		sc = new Scanner(new BufferedReader(new FileReader("cost.txt")));
		int rows = 20;
		int columns = 20;
		int[][] cost = new int[rows][columns];

		for (int i = 0; i < cost.length; i++) {

			for (int j = 0; j < cost[i].length; j++) {

				cost[i][j] = sc.nextInt();

				c[i][j].setCost(cost[i][j]);
			}
			sc.nextLine();
		}
	}
//------------------------------------------------------------------------------------   

	public static void readCity() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("cities.txt"));
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}
		String[] arr = lines.toArray(new String[0]);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				c[i][j].setSource(arr[i]);
				c[i][j].setDest(arr[j]);

			}

		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------------
	// Second algorithm DFS
	public static void DFS(int s, int x) {

		Vector<Boolean> visited = new Vector<Boolean>(V); // Initially mark all vertices as not visited
		for (int i = 0; i < V; i++)
			visited.add(false);

		Stack<Integer> stack = new Stack<>(); // Create a stack for DFS

		stack.push(s); // Push the current source node

		while (stack.empty() == false) {

			s = stack.peek(); // Pop a vertex from stack and print it
			stack.pop();

			if (s == x) { // when reach the goal, break
				//System.out.println(s + " " + c[s][s].dest);
				dep.add(s);
				visited_dfs.add(c[s][s].dest);
				break;
			}

			if (visited.get(s) == false) // we need to print the popped item only if it is not visited.
			{
				//System.out.println(s + " " + c[s][s].dest);
				visited.set(s, true);
				dep.add(s);
				visited_dfs.add(c[s][s].dest);

			}

			// Get all adjacent vertices of the popped vertex s
			// If a adjacent has not been visited, then push it
			// to the stack.
			Iterator<Integer> itr = adj[s].iterator();

			while (itr.hasNext()) {
				int v = itr.next();
				if (!visited.get(v))
					stack.push(v);
			}

		}

		for (int i = dep.size() - 1; i > -1; i--) {
			for (int j = i; j > -1; j--) {
				if (c[dep.get(i)][dep.get(j)].cost != 99999 && c[dep.get(i)][dep.get(j)].cost != 0) {
					// System.out.println("Path is:" + c[nodes1.get(i)][nodes1.get(j)].source+"
					// "+c[nodes1.get(i)][nodes1.get(j)].dest);
					if (PD.isEmpty() && indexD.isEmpty()) {
						PD.add(c[dep.get(i)][dep.get(j)].source);
						PD.add(c[dep.get(i)][dep.get(j)].dest);
						indexD.add(dep.get(i));
						indexD.add(dep.get(j));

					} else if (PD.get(PD.size() - 1) == c[dep.get(i)][dep.get(j)].source) {
						PD.add(c[dep.get(i)][dep.get(j)].dest);
						indexD.add(dep.get(j));
					}

				}

			}

		}

		// System.out.println(PD);
		for (int i = PD.size() - 1; i > -1; i--) {
			RD.add(PD.get(i));
			finalD.add(indexD.get(i));

		}
		for (int i = 0; i < finalD.size() - 1; i++) {
			cost_dep += c[finalD.get(i)][finalD.get(i + 1)].cost;

		}
		System.out.println("Visited nodes  : ");
		System.out.println(visited_dfs);
		System.out.println("Here is our path  : ");
		System.out.println(RD);
		// System.out.print(finalD);
		System.out.println("final cost is " + cost_dep);

	}
	// ---------------------------------------------------------------------------------------------------------------------------------

	// A STAR
//------------------------------------------------------------------------------------   

	// walking arial
	public static double aStarH2_H1(int start, int goal) {

		// This contains the distances from the start node to all other nodes
		int[] distances = new int[20];
		// Initializing with a distance of "Infinity"
		Arrays.fill(distances, Integer.MAX_VALUE);
		// The distance from the start node to itself is of course 0
		distances[start] = 0;

		// This contains the priorities with which to visit the nodes, calculated using
		// the heuristic.
		double[] priorities = new double[20];
		// Initializing with a priority of "Infinity"
		Arrays.fill(priorities, Integer.MAX_VALUE);
		// start node has a priority equal to straight line distance to goal. It will be
		// the first to be expanded.
		priorities[start] = c[start][goal].h2;

		// This contains whether a node was already visited
		boolean[] visited = new boolean[20];

		// While there are nodes left to visit...
		while (true) {

			// ... find the node with the currently lowest priority...
			double lowestCost = Integer.MAX_VALUE;
			int lowestCost_index = -1;
			for (int i = 0; i < priorities.length; i++) {
				// ... by going through all nodes that haven't been visited yet
				if (priorities[i] < lowestCost && !visited[i]) {
					lowestCost = priorities[i];
					lowestCost_index = i;
				}
			}

			if (lowestCost_index == -1) {
				// There was no node not yet visited --> Node not found
				return -1;
			} else if (lowestCost_index == goal) {
				// Goal node found
				System.out.println("Goal node found! " + c[lowestCost_index][lowestCost_index].source);
				return distances[lowestCost_index];
			}

			// System.out.println("Visiting node " + lowestCost_index + " " + c[lowestCost_index][lowestCost_index].source
		//			+ " with currently lowest cost of " + lowestCost);

			// ...then, for all neighboring nodes that haven't been visited yet....
			for (int i = 0; i < 20; i++) {
				if (c[lowestCost_index][i].h1 != 0 && c[lowestCost_index][i].cost != 99999 && !visited[i]) {
					// ...if the path over this edge is shorter...
					if (distances[lowestCost_index] + c[lowestCost_index][i].h1 < distances[i]) {
						// ...save this path as new shortest path
						distances[i] = distances[lowestCost_index] + c[lowestCost_index][i].h1;
						// ...and set the priority with which we should continue with this node
						priorities[i] = distances[i] + c[i][goal].h2;
					//	System.out.println("Updating distance of node " + i + " " + c[i][i].source + " to "
						//		+ distances[i] + " and cost to " + priorities[i]);
						final_cost1 = distances[goal];

					}
				}
			}

			// Lastly, note that we are finished with this node.
			visited[lowestCost_index] = true;
			city1.add(c[lowestCost_index][lowestCost_index].source);
			nodes.add(lowestCost_index);
			
		}

	}

	// ------------------------------------------------------------------------------------

	public static double aStarCost_H2(int start, int goal) {


		// This contains the distances from the start node to all other nodes
		int[] distances = new int[20];
		// Initializing with a distance of "Infinity"
		Arrays.fill(distances, Integer.MAX_VALUE);
		// The distance from the start node to itself is of course 0
		distances[start] = 0;

		// This contains the priorities with which to visit the nodes, calculated using
		// the heuristic.
		double[] priorities = new double[20];
		// Initializing with a priority of "Infinity"
		Arrays.fill(priorities, Integer.MAX_VALUE);
		// start node has a priority equal to straight line distance to goal. It will be
		// the first to be expanded.
		priorities[start] = c[start][goal].h2;

		// This contains whether a node was already visited
		boolean[] visited = new boolean[20];

		// While there are nodes left to visit...
		while (true) {

			// ... find the node with the currently lowest priority...
			double lowestCost = Integer.MAX_VALUE;
			int lowestCost_index = -1;
			for (int i = 0; i < priorities.length; i++) {
				// ... by going through all nodes that haven't been visited yet
				if (priorities[i] < lowestCost && !visited[i]) {
					lowestCost = priorities[i];
					lowestCost_index = i;
				}
			}

			if (lowestCost_index == -1) {
				// There was no node not yet visited --> Node not found
				return -1;
			} else if (lowestCost_index == goal) {
				// Goal node found

				System.out.println(c[lowestCost_index][lowestCost_index].source + " GOAL FOUND! ");
				return distances[lowestCost_index];
			}

			//System.out.println("Visiting node " + lowestCost_index + " " + c[lowestCost_index][lowestCost_index].source
				//	+ " with currently lowest cost of " + lowestCost);

			// ...then, for all neighboring nodes that haven't been visited yet....
			for (int i = 0; i < 20; i++) {
				if (c[lowestCost_index][i].cost != 0 && c[lowestCost_index][i].cost != 99999 && !visited[i]) {
					// ...if the path over this edge is shorter...
					if (distances[lowestCost_index] + c[lowestCost_index][i].cost < distances[i]) {
						// ...save this path as new shortest path
						distances[i] = distances[lowestCost_index] + c[lowestCost_index][i].cost;
						// ...and set the priority with which we should continue with this node
						priorities[i] = distances[i] + c[i][goal].h2;
						//System.out.println("Updating distance of node " + i + " " + c[i][i].source + " to "
							//	+ distances[i] + " and cost " + priorities[i]);
						final_cost2 = distances[goal];
					}
				}
			}

			// Lastly, note that we are finished with this node.
			visited[lowestCost_index] = true;
			city2.add(c[lowestCost_index][lowestCost_index].source);
			nodes1.add(lowestCost_index);

			
		}
		
		

	}
	
	
	// ---------------------------------------------------------------------------------------------------------------------------------
	//A star 1 path:
		public static void Path1() {
			for (int i = nodes.size() - 1; i > -1; i--) {
				for (int j = i; j > -1; j--) {
					if (c[nodes.get(i)][nodes.get(j)].cost != 99999 && c[nodes.get(i)][nodes.get(j)].cost != 0) {
						//System.out.println("Path is:" + c[nodes1.get(i)][nodes1.get(j)].source+" "+c[nodes1.get(i)][nodes1.get(j)].dest);
						if (A.isEmpty()) {
							A.add(c[nodes.get(i)][nodes.get(j)].source);
							A.add(c[nodes.get(i)][nodes.get(j)].dest);

						} else if (A.get(A.size() - 1) == c[nodes.get(i)][nodes.get(j)].source) {
							A.add(c[nodes.get(i)][nodes.get(j)].dest);

						}

					}

				}

			}

			System.out.println("Here is our path ! : ");
			for (int i = A.size() - 1; i > -1; i--) {
				AR.add(A.get(i));
			}
			System.out.print(AR);
		}

	
	// ---------------------------------------------------------------------------------------------------------------------------------
//A star 2 path:
	public static void Path2() {
		for (int i = nodes1.size() - 1; i > -1; i--) {
			for (int j = i; j > -1; j--) {
				if (c[nodes1.get(i)][nodes1.get(j)].cost != 99999 && c[nodes1.get(i)][nodes1.get(j)].cost != 0) {
					//System.out.println("Path is:" + c[nodes1.get(i)][nodes1.get(j)].source+" "+c[nodes1.get(i)][nodes1.get(j)].dest);
					if (MA.isEmpty()) {
						MA.add(c[nodes1.get(i)][nodes1.get(j)].source);
						MA.add(c[nodes1.get(i)][nodes1.get(j)].dest);

					} else if (MA.get(MA.size() - 1) == c[nodes1.get(i)][nodes1.get(j)].source) {
						MA.add(c[nodes1.get(i)][nodes1.get(j)].dest);

					}

				}

			}

		}

		System.out.println("Here is our path ! : ");
		for (int i = MA.size() - 1; i > -1; i--) {
			P.add(MA.get(i));
		}
		System.out.print(P);
	}

	// ---------------------------------------------------------------------------------------------------------------------------------

	@SuppressWarnings("resource")
	public static void main(String args[]) {

		try {
			readH1();
			readH2();
			readCost();
			readCity();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Graph graph = new Graph(22);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (c[i][j].cost != 99999 && c[i][j].cost != 0) {
					graph.addEdge(i, j);

					
				}
			}
		}

		System.out.println("Please enter the source: ");
		Scanner sor = new Scanner(System.in);
		String begin = sor.nextLine();
		System.out.println("Please enter the destination: ");
		Scanner des = new Scanner(System.in);
		String end = des.nextLine();
		int index_source = 0;
		int index_dest = 0;
		for (int i = 0; i < 20; i++) {
			if (c[i][i].source.equalsIgnoreCase(begin)) {
				index_source = i;
			}
			if (c[i][i].source.equalsIgnoreCase(end)) {
				index_dest = i;

			}

		}

		System.out.println("The Breadth First Traversal of the graph is as follows :");

		BFS(index_source, index_dest);
		
		System.out.println("\n------------------------------------------------\n");

		///////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("The Depth First Traversal of the graph is as follows :");

		DFS(index_source, index_dest);

		///////////////////////////// A star walking ariel

		System.out.println("\n------------------------------------------------\n");
		aStarH2_H1(index_source, index_dest);
		System.out.println("Visited cities: ");
		city1.add(c[index_dest][index_dest].source);
		System.out.print("city1"+ city1);
		nodes1.add(index_dest);

		System.out.println("\n final cost is: " + final_cost1);
		Path1();

		////////////////////// a star cost walking

		System.out.println("\n------------------------------------------------\n");
		aStarCost_H2(index_source, index_dest);
		System.out.println("Visited cities: ");
		city2.add(c[index_dest][index_dest].source);
		System.out.print("city2" + city2);
		nodes1.add(index_dest);
		System.out.println("\n final cost is: " + final_cost2);
		Path2();
		
		
		

	}
}