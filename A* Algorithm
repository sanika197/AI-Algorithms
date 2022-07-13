import java.util.*;

public class Main {
	public static void A_star(int matrix[][], int src, int dest, int vertices,int heuristic[])
	{
		int visited[] = new int[vertices];
		int cur, adj;
		Node empty = new Node();  //for parent of node
		Node goal = new Node();
		Node source = new Node(src, 0,heuristic[src],empty);
		PriorityQueue<Node> pq = new PriorityQueue<Node>(vertices, new Node());
		//priority Queue stores nodes according to f(n)
		//where f(n) = g(n) + h(n)
		
		pq.add(new Node(src,0,heuristic[src],empty));//set parent of source as -1
		visited[src] = 1;
		
		while(!pq.isEmpty())
		{
			Node n = pq.remove(); //get the node with minimum f(n) value
			cur = n.vertex;
			adj = 0;
			
			if(cur==dest)
			{
				goal = n;
				break;
			}
			while(adj<vertices)//expand the current node
			{
			
				if(matrix[cur][adj]!=Integer.MAX_VALUE && matrix[cur][adj]!=0 && visited[adj]==0)
				{
					Node temp = new Node(adj, n.g+matrix[cur][adj], heuristic[adj], n);
					pq.add(temp); //add the neighbors giving priority to node having minimum f(n) value
					visited[adj] = 1;
				}
				if(matrix[cur][adj]!=Integer.MAX_VALUE && matrix[cur][adj]!=0 && visited[adj]==1)
				{
					Node temp = new Node(adj, n.g+matrix[cur][adj], heuristic[adj], n); //change parent
					pq.add(temp); //add the neighbors giving priority to node having minimum f(n) value
				}
				adj++;
			}
		}
		printPath(goal, source, matrix, src);
	}
	
public static void printPath(Node goal, Node source, int matrix[][], int src)
{
	Stack<Node> path = new Stack<Node>();
	ArrayList<Integer> al = new ArrayList<Integer>();
	Node n = goal;
	int cost;
	cost = 0;
	
	while(n.vertex!=src)
	{
		path.push(n);
		n = n.parent;
	}
	path.push(source);
	
	while(path.isEmpty()==false)
	{
		al.add(path.peek().vertex);
		System.out.print("->"+path.pop().vertex);
	}
	int i;
	i = 0;
	while(i<al.size()-1) 
	{
		cost = cost + matrix[al.get(i)][al.get(i+1)];
		i++;
	}
	
	System.out.println("\nPath Length:"+cost);
}
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int i, j, vertices;
	
	//Accept the vertices in the graph
	System.out.println("Enter number of vertices: ");
	vertices = sc.nextInt();
	
	int heuristic[] = new int[vertices];
	int matrix[][] = new int[vertices][vertices];
	
	
	//Accept the graph
	System.out.println("Enter weighted matrix: ");
	for(i=0;i<vertices;i++)
	{
		for(j=0;j<vertices;j++)
		{
			matrix[i][j] = sc.nextInt();
			if(i==j)
			{
				matrix[i][j] = 0;
			}
			if(matrix[i][j]==0)
			{
				matrix[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	//Accept the heuristic values of each node
	System.out.println("Enter heuristic values of each node: ");
	for(i=0;i<vertices;i++)
	{
		heuristic[i] = sc.nextInt();
	}
	
	System.out.println("Enter source node: ");
	int src = sc.nextInt();
	System.out.println("Enter destination node: ");
	int dest = sc.nextInt();
	
	System.out.println("The shortest path is:");
	A_star(matrix, src, dest, vertices, heuristic); //function to implement A* algorithm on given graph
	}
}

class Node implements Comparator<Node>{
	int f, g, h;
	int vertex;
	Node parent;
	
	public Node()
	{
	
	}
	public Node(int n, int gvalue, int hvalue, Node p)
	{
		g = gvalue;
		h = hvalue;
		f = gvalue + hvalue;
		vertex = n;
		parent = p;
	}
	
	@Override
	public int compare(Node n1, Node n2) //to implement priority queue according to f(n)
	{
		if(n1.f<n2.f)
		{
			return -1;
		}
		else if(n1.f>n2.f)
		{
			return 1;
		}
	return 0;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Node)
		{
			Node n = (Node) obj;
			if(this.vertex == n.vertex)
			{
				return true;
			}
		}
		return false;
	}

}
