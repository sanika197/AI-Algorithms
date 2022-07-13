//Water Jug Problem

import java.util.*;

class Node{ //A node representing both jug1 and jug2
	int x, y;
	Node()
	{
		x = 0;
		y = 0;
	}
	
}
class WaterJug{
	void nextStates(int visited[][], int jug1, int jug2, Stack<Node> st, int goal)
	{
		Node cur;
		cur = st.peek();
		int flag = 0;
		while(!st.isEmpty())
		{
			if(cur.x<jug1)  //Fill jug1 completely
			{
				Node temp = new Node();
				if(visited[jug1][cur.y]==0) {
					flag = 1;
					temp.x = jug1;
					temp.y = cur.y;
					st.push(temp);
					visited[temp.x][temp.y] = 1;
					if(temp.x==goal)
					{
						break;
					}
				}
				cur = st.peek();
			}
			
			if(cur.y<jug2)  //Fill jug2 completely
			{
				Node temp = new Node();
				if(visited[cur.x][jug2]==0) {
					flag = 1;
					temp.y = jug2; 
					temp.x = cur.x;
					st.push(temp);
					visited[temp.x][temp.y] = 1;
					if(temp.x==goal)
					{
						break;
					}
				}
				cur = st.peek();
			}
			if(cur.x>0) //Empty jug1 onto the ground
			{
				Node temp = new Node();
				if(visited[0][cur.y]==0) {
					flag = 1;
					temp.x = 0;
					temp.y = cur.y;
					st.push(temp);
					visited[temp.x][temp.y] = 1;
					if(temp.x==goal)
					{
						break;
					}
				}
				cur = st.peek();
			}
			if(cur.y>0)  //Empty jug2 onto the ground
			{
				Node temp = new Node();
				if(visited[cur.x][0]==0) {
					flag = 1;
					temp.y = 0;
					temp.x = cur.x;
					st.push(temp);
					visited[temp.x][temp.y] = 1;
					if(temp.x==goal)
					{
						break;
					}
				}
				cur = st.peek();
			}
			if((cur.x+cur.y>=jug1) && cur.y>0)  //Pour water from jug2 to jug1 until jug1 is filled
			{
				Node temp = new Node();
				int j2;
				j2 = cur.y-(jug1-cur.x);
				if(visited[jug1][j2]==0) {
					flag = 1;
					temp.y = j2;
					temp.x = jug1;
					st.push(temp);
					visited[temp.x][temp.y] = 1;
					if(temp.x==goal)
					{
						break;
					}
				}
				cur = st.peek();
			}
			if((cur.x+cur.y>=jug2) && cur.x>0)  //Pour water from jug1 to jug2 until jug2 is full
			{
				Node temp = new Node();
				int j1;
				j1 = cur.x-(jug2-cur.y);
				if(visited[j1][jug2]==0) {
					flag = 1;
					temp.x = j1;
					temp.y = jug2;
					st.push(temp);
					visited[temp.x][temp.y] = 1;
					if(temp.x==goal)
					{
						break;
					}
				}
				cur = st.peek();
			}
			if((cur.x+cur.y<=jug1) && cur.y > 0)  //Pour water from jug2 to jug1 until until jug2 is empty
			{
				Node temp = new Node();
				int j1;
				j1 = cur.x + cur.y;
				if(visited[j1][0]==0) {
					flag = 1;
					temp.x = j1;
					temp.y = 0;
					st.push(temp);
					visited[temp.x][temp.y] = 1;
					if(temp.x==goal)
					{
						break;
					}
				}
				cur = st.peek();
				
			}
			if((cur.x+cur.y<=jug2) && cur.x>0)  //Pour water from jug1 to jug2 until jug1 is empty
			{
				Node temp = new Node();
				int j2 = cur.x+cur.y;
				if(visited[0][j2]==0) {
					flag = 1;
					temp.y = j2;
					temp.x = 0;
					st.push(temp);
					visited[temp.x][temp.y] = 1;
					if(temp.x==goal)
					{
						break;
					}
				}
				cur = st.peek();
			}
			if(flag == 0 && !st.isEmpty())  //If no rule is applicable and stack is not empty
			{
				st.pop();
			}	
		}
		Node n = new Node();
		ArrayList<Node> al = new ArrayList<Node>();
		while(!st.isEmpty())
		{
			n = st.pop();
			al.add(n);	
		}
		System.out.println("Jug1"+" "+"Jug2");
		for(int i=al.size()-1;i>=0;i--)
		{
			System.out.println(al.get(i).x+"\t"+al.get(i).y);
		}	
	}
}
public class Main {

	public static void main(String[] args) {
		int jug1, jug2, goal;
		Scanner sc = new Scanner(System.in);
		Stack<Node> st = new Stack<Node>();  //Stack to hold the states of jug1 and jug2
		
		//Accept input from user
		System.out.println("Enter capacity of Jug1: ");
		jug1 = sc.nextInt();
		System.out.println("Enter capacity of Jug2: ");
		jug2 = sc.nextInt();
		System.out.println("Enter final amount of water to be present in Jug1: ");
		goal = sc.nextInt();
		int visited[][] = new int[jug1+1][jug2+1];  //declare visited matrix to keep a track of states visited
		
		Node init = new Node(); //initially both the jugs are empty
		st.push(init);  // push initial state onto the stack
		visited[0][0] = 1;
		WaterJug wj  = new WaterJug();
		wj.nextStates(visited, jug1, jug2, st, goal);
		
	}

}


