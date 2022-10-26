# Search_Algorithms_for_Route-_Navigation
<h2>  🌟 Goal: </h2> 
This programming project is an implementation of search algorithms for a specific
goal of finding an optimal path between cities in Palestine.
<h2> 🌟 Specifications </h2> 
<p> ✏ We have a graph with each node representing a location (City) in
Palestine. 
<br> ✏ The directed edge between nodes (A --> B) represents the existence of a path
between A and B and the link is labelled by the cost of moving from A to B by car
(CarDist(A,B). One of the nodes is a start node (S) and another is the goal (G).
<br> ✏  For each pair of nodes we have: CarDist(A,B), WalkDist(A,B) plus for each node n we
have h1(n): the aerial (straight line distance) between n and G, which is an admissible
heuristic. 
<br> ✏  Another heuristic h2(n) is the Walking distance from n to G. Clearly, h2
dominates h1. So for each city pair we have W,X,Y are street distance (km), Aerial
distance (km), Walking Distance (KM). 
<br> ✏  One of the nodes is start node. One or more are
goal nodes (e.g. A is start, D,E are goals).  </p>
<br>
💡 For experimentation you need to select at least 20 Palestinian cities (Historical
Palestine). The start city is one closest to your residence (selectable). The goal is
selectable
