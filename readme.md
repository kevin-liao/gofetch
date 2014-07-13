# Kevin Liao GoFetch Application

This is readme of GoFetch Application for Spider Tracks .

I am running on both Windows 7 and Mac OS X. They works for both.

## Running the application demo

Run the following commands in your terminal. It will prompt you to run the demo.

```terminal
git clone git@https://github.com/kevin-liao/gofetch.git ~/gofetch
cd gofetch
mvn exec:java
```

## Howto - Calculate Distance

- click the 'tool' menu. 
- select the 'calcuate distance' menu item.
- input the route by selecting the stations in dropdown, or you can input the route mannually.
- click the 'calculate' button. It will print the distance for the route, and it would print out an error message if the route it is invalid.

## Howto - Journey Planner

- click the 'tool' menu. 
- select the 'Journey Planner' menu item.
- select the start and end stations in dropdown.
- click the 'check' button. 

## Howto - Shortest Route

- click the 'tool' menu and select the 'Shortest Route' menu item.
- select the start and end stations in dropdown.
- click the 'check' button. 

## Finished functions and not-finished functions

- Calculate Distance. This feature is working fine.

- Journey Planner. Have some issues dealing with the requirements of a maximum or exact number of “stops" along the way. It works fine if the stops field is NOT set .

- Shortest Route. Did not fix the problem in the case of cycle. It works fine if start and end station are not the same.

- Map Administration. Not yet. User could add a new station, update the existing route information, etc..

- Interactive Map. Not yet. The station and route of map would be highlight or be sparking if it is the specific path or shortest path.

## Design

### MVC: Split the business logic apart from view. 
### Use Java Swing for the UI part.
### Use Dijkstra Algorithm to find the shortest route between two given nodes in graph.

