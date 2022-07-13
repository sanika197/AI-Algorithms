import java.util.*;
import java.lang.*;

public class Main {
	
	public static int heuristic(int grid[][], int goal[][])
	{
		int i, j, count;
		count = 0;
		
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				//calculate mismatched places ignoring the blank space
				if(grid[i][j]!=0 && grid[i][j]!=goal[i][j])
				{
					count++;
				}
			}
		}
		return count;
	}
	public static int getSpace_i(int grid[][])
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(grid[i][j]==0)
				{
					return i;
				}
			}
		}
		return -1;
	}
	
	public static int getSpace_j(int grid[][])
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(grid[i][j]==0)
				{
					return j;
				}
			}
		}
		return -1;
	}
	public static void A_star(int grid[][], int goal[][])
	{
		int i, j;
		ArrayList<int[][]> visited = new ArrayList<int[][]>();
		int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
		int next[][] = new int[3][3];
		State goalSt = new State();
		State empty = new State();
		State start = new State(grid,0,heuristic(grid, goal),empty);
		int size = 362880; //9! different states
		PriorityQueue<State> pq = new PriorityQueue<State>(size, new State());
		pq.add(start);
		visited.add(grid);
		
		while(true)
		{
			State cur = pq.remove(); //get the state with minimum f(n) value
			if(cur.grid == goal)
			{
				goalSt = cur;
				break;
			}
			int itr;
			itr = 0;
			//calculate the next possible states
			int x = getSpace_i(cur.grid);
			int y = getSpace_j(cur.grid);
			while(itr<4)
			{
				i = x + dir[itr][0];
				j = y + dir[itr][1];
				next = grid;
				if(i>=0 && j>=0 && i<3 && j<3) 
				{
					next[x][y] = next[i][j];
					next[i][j] = 0;
					if(visited.contains(next)==false) //if not already visited
					{
						State child = new State(next,cur.g+1,heuristic(next,goal),cur);
						pq.add(child); //add next to the priority queue
						visited.add(next); //mark it as visited
					}
				}
				itr++;
			}
		}
		printStates(goalSt, start);
	}
	
	public static void printStates(State goalState, State start)
	{
		Stack<State> path = new Stack<State>();
		State s = goalState;
		while(s.grid!=start.grid)
		{
			path.push(s);
			s = s.parent;
		}
		path.push(start);
		while(path.isEmpty()==false)
		{
			path.peek().display();
		}
	
	}
public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	int i, j;
	int grid[][] = new int[3][3];
	int goal[][] = new int[3][3]; //Goal state
	
	System.out.println("Enter the start state: ");
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			grid[i][j] = sc.nextInt(); //input the start state from user
		}
	}
	
	System.out.println("Enter the goal state: ");
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			goal[i][j] = sc.nextInt(); //input the goal state from user
		}
	}
	A_star(grid, goal);
	
}

}

class State implements Comparator<State>{
int f, g, h;
State parent;
int grid[][] = new int[3][3];

public State()
{

}
	public State (int matrix[][],int gn, int hn, State p)
	{
		f = gn + hn;
		g = gn;
		h = hn;
		parent = p;
		grid = matrix;
	}
	public void display()
	{
		int i, j;
		for(i=0;i<3;i++)
		{
		for(j=0;j<3;j++)
		{
		System.out.print(grid[i][j]+" ");
		}
		System.out.println();
		}
	}
	@Override
	public int compare(State s1, State s2)
	{
		if(s1.f<s2.f)
		{
			return -1;
		}
		if(s1.f>s2.f)
		{
			return 1;
		}
		
		return 0;
	}
	
}

