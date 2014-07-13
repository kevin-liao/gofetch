# Kevin Liao GoFetch Application

This is readme of GoFetch Application for Spider Tracks .

I am running on both Windows 7 and Mac OS X. They works for both.

## Running the application demo

Run the following commands in your terminal. It will prompt you to run the demo.

```terminal
git clone git@https://github.com/kevin-liao/gofetch.git gofetch
cd gofetch
mvn compile
mvn exec:java
```

## Howto - Calculate Distance

- click the 'Tool' menu. 
- select the 'Calculate Distance' menu item.
- input the route by selecting the stations in dropdown, or you can input the route manually.
- click the 'calculate' button. It will print the distance for the route, and it would print out an error message if the route it is invalid.

## Howto - Journey Planner

- click the 'Tool' menu. 
- select the 'Journey Planner' menu item.
- select the start and end stations in dropdown.
- click the 'check' button. 

## Howto - Shortest Route

- click the 'Tool' menu and select the 'Shortest Route' menu item.
- select the start and end stations in dropdown.
- click the 'check' button. 

## Finished Functions

- Calculate Distance. This feature is working fine.

- Journey Planner. It works fine if the stops field is NOT set .

- Shortest Route. It works fine if start and end station are not the same.

## Unfinished functions

- Journey Planner. Have some issues dealing with the requirements of a maximum or exact number of “stops" along the way. 

- Shortest Route. Edge case. 1) If the start and end station are the same.

- Map Administration. User could add a new station, update the existing route information, etc..

- Interactive Map. The station and route of map would be highlight or be sparking if it is the specific path or shortest path.

## Design

Please find the wiki page(https://github.com/kevin-liao/gofetch/wiki) for the details.
