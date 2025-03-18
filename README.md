# Mower code challenge
Code challenge for SEAT:CODE, in which given the dimensions of a Grid, an object's position, and a set of movements on the grid, the expected output are Cartesian coordinates.

# Requirements

 - JDK installed

# Installation
 - Clone this repository.
 - Run on your command line on root folder 'mvn clean package -U' to download dependencies and compile the project. This will also execute the unit tests.

# Usage
 - Once compiled, the executable "mowerchallenge-1.0-SNAPSHOT.jar" will be located under the /target folder.
 - Run it from the command line using java -jar mowerchallenge-1.0-SNAPSHOT.jar.
 - Enter the size of the grid {integer} {integer} -> Example: 5 5.
 - Enter the position and direction of the lawnmower {integer} {integer} {S|N|W|E} -> Example: 3 1 N.
 - Enter the lawnmower's movements (left 'L', right 'R', move forward 'M') {R|L|M} -> Example: LMLMLMRM.

# Technical Notes:
 - This solution has been developed following the following principles:
	- Simplicity
	- Readability of the overall code
	- Encapsulation and decoupling
	- Software architecture
	- Separation of responsibilities
	- Testing

 - Note: I think it's important to consider the efficiency of searching for lawnmowers in the grid for this exercise. If there were a large number of lawnmowers and a considerable-sized grid, the search algorithm could be affected. In this exercise, i used a HashSet<Pair<Integer, Integer>> with a search cost of O(1), or O(n) if there are collisions in the hash table.

# License
 - OpenSource Licence test

# Contact
 - If you have any questions or inquiries, you can contact me via email at hidalgodeveloper@gmail.com.
