package interviews.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There is a museum organized as n-by-n rooms. Some rooms are locked and
 * inaccessible. Other rooms are open and some rooms have guards. Guards can
 * only move north, south, east and west, only through open rooms and only
 * within the museum. For each room, find the shortest distance to a guard.
 * What is the time complexity of your algorithm?
 * @author Francois Rousseau
 */
public class Museum  {
	public static void main(String[] args) {
		final int n = 5;
		final int n2 = n*n;

		final List<Room> grid = getStandardGrid(n, n2);

		// Adding the guards to a virtual root node.
		final Room root = grid.get(0);
		root.addNeighbour(grid.get(3));
		root.addNeighbour(grid.get(9));
		root.addNeighbour(grid.get(12));
		root.addNeighbour(grid.get(18));
		root.addNeighbour(grid.get(22));
		root.addNeighbour(grid.get(25));

		final int[] distance = traversal(root, n, n2);
		final List<Integer> finalRooms = new ArrayList<Integer>();
		final int finalDistance = findRooms(distance, finalRooms);
		System.out.println(finalDistance + " " + finalRooms);			
	}
	
	public static int[] traversal(Room root, int n, int n2) {
		final int[] distance = new int[n2+1];
		for(int i = 1; i < n2 + 1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		final Queue<Room> queue = new LinkedList<Room>();
		for(Room guard:root.neighbours()) {
			distance[guard.index()] = 0;
			queue.add(guard);
		}
		
		while(!queue.isEmpty()) {
			final Room room = queue.poll();
			final int new_distance = distance[room.index()] + 1;
			for(Room child:room.neighbours()) {
				// That way, we prevent adding cells already seen.
				if(distance[child.index()] > new_distance) {
					distance[child.index()] = new_distance;
					queue.add(child);
				}
			}
		}
		return distance;
	}

	protected static List<Room> getStandardGrid(int n, int n2) {
	   final List<Room> grid = new ArrayList<Room>();
	    // The first room of id 0 is a virtual one used later.
	    for(int i = 0; i < n2 + 1; i++) {
	      grid.add(new Room(i));
	    }

	    // Adding the children.
	    for(int i = 1; i < n2 + 1; i++) {
	      Room room = grid.get(i);
	      if(i%n != 1)
	        room.addNeighbour(grid.get(i-1));
	      if(i%n != 0)
	        room.addNeighbour(grid.get(i+1));
	      if(i > n)
	        room.addNeighbour(grid.get(i-n));
	      if(i <= n2 - n)
	        room.addNeighbour(grid.get(i+n));
	    }
	    return grid;
	}

	protected static int findRooms(int[] distance, List<Integer>rooms) {
		int max_distance = 0;
		for (int i = 0; i < distance.length; i++) {
			if(max_distance == distance[i]) {
			    rooms.add(i);
			}
			else if(max_distance < distance[i]) {
				max_distance = distance[i];
				rooms.clear();
			  rooms.add(i);
			}
		}
		return max_distance;
	}
}

class Room {
  private int index;
  private List<Room> neighbours;

  public Room(int index) {
    this.index = index;
    this.neighbours = new ArrayList<Room>();
  }

  public void addNeighbour(Room neighbour) {
    neighbours.add(neighbour);
  }

  public List<Room> neighbours() {
    return neighbours;
  }

  public int index() {
    return index;
  }

  public String toString(){
    return String.valueOf(index);
  }
}