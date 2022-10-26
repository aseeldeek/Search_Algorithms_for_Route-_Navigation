# Search_Algorithms_for_Route-_Navigation
<h2>  🌟 Goal: </h2> 

This programming project is an implementation of search algorithms for a specific
goal of finding an optimal path between cities in Palestine.

<h2> 🌟About The Project: </h2> 

<p> ✏ The project has divided into steps. Started by collecting the data from Google Maps and other Websites, saving them into files, storing them in the implemented Graph, and then began implementing the algorithms.
<br> ✏ The Programing language used for implementing the project was Java language besides JavaFX for the program interface. 
</p>

<br>

<p> 💡 The idea was, to choose twenty different cities <i>[ Aka, Bethlehem, Dura, Haifa, Beersheba, Hebron, Jenin, Jericho, Jerusalem, Nablus, Nazareth, Qalqilya, Ramallah, Ramleh, Gaza, Safad, Rafah, Tubas, Tulkarm, and Yafa ] </i>, finding their Street Distance <b>(SD) </b>, Aerial distance (AD), Walking Distance (WD), and creating a class called City which represents the twenty cities with their information as nodes for the searching graph. The searching graph was created as an adjacency list, each node “city“ represents a vertex, and the presence of an edge between two vertices is determined if only there is a real path between the nodes. Here, the street distance (SD) determines if there is a direct path between the nodes or not, for example, if two cities have no direct path between them then that means the SD must be 0 in case this is a path from the city with itself, or in case there is no connection between the two cities, Else cases means there is an edge. The data was saved into 4 files, the first file holds the cities names, used to create a matrix of cities, the second file saves the Street Distance (SD), and the last two files contain the Aerial distance (AD) plus the Walking Distance (WD) for all cities. And every search algorithm takes the start city index and an array list of the needed goals to start the search.
</p> 

<h2>  🌟 implemented Algorithms: </h2>
 <ul>
  <li> Depth First Search  <b> (DFS) </b> </li>
  <li> Breadth First Search <b> (BFS) </b> </li>
  <li> A* Algorithm </li>
</ul>

