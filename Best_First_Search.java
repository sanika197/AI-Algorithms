import java.util.*;


public class Main {
	public static void BestFirst(int matrix[][], int heuristic[], int src, int dest, int vert)
	{
		int visited[] = new int[vert];
		PriorityQueue<Node> pq = new PriorityQueue<Node>(vert, new Node()); //Priority Queue stores vertices
		//according to heuristic values of nodes
		int cur, adj;
		pq.add(new Node(src,heuristic[src]));
		visited[src] = 1;
		
		while(!pq.isEmpty())
		{
			Node n = pq.remove();
			cur = n.vertex;
			adj = 0;
			System.out.print(cur+" ");
			if(cur==dest) //if destination found
			{
				break;
			}
			while(adj<vert)
			{
				Node temp = new Node(adj, heuristic[adj]);
				if(matrix[cur][adj]!=Integer.MAX_VALUE && matrix[cur][adj]!=0 && visited[adj]==0)
				{
					pq.add(temp); //add node into priority queue based on it's heuristic values
					visited[adj] = 1;
				}
				adj++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int vert, edges;
		int i, j;
		int src, dest;
		ArrayList<Integer>path = new ArrayList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		vert = sc.nextInt();
		
		int matrix[][] = new int[vert][vert];
		int heuristic[] = new int[vert];
		
		System.out.println("Enter the weighted matrix: ");
		for(i=0;i<vert;i++)
		{
			for(j=0;j<vert;j++)
			{
				matrix[i][j] = sc.nextInt();  //accept graph in matrix form
				if(matrix[i][j]==0)
				{
					matrix[i][j] = Integer.MAX_VALUE;
				}
				if(i==j)
				{
					matrix[i][j] = 0;
				}
				
			}
		}
		System.out.println("Enter the Heuristic values of nodes: ");
		for(i=0;i<vert;i++)
		{
			heuristic[i] = sc.nextInt();  //accept heuristic values of each node
		}
		System.out.println("Enter the source node: ");
		src = sc.nextInt();
		
		System.out.println("Enter the destination node: ");
		dest = sc.nextInt();
		System.out.print("Path: ");
		BestFirst(matrix, heuristic, src, dest, vert);

	}
}

class Node implements Comparator<Node>
{
	int hvalue, vertex;
	
	public Node()
	{
		
	}
	
	public Node(int n, int hv)
	{
		vertex = n;
		hvalue = hv;
	}
	@Override
	public int compare(Node n1, Node n2)  
    {
        if (n1.hvalue < n2.hvalue)
            return -1;
        if (n1.hvalue > n2.hvalue)
            return 1;
        return 0;
    }
	@Override
	public boolean equals(Object obj)
    {
        if (obj instanceof Node)
        {
            Node n = (Node) obj;
            if (this.vertex == n.vertex)
            {
                return true;
            }
        }
        return false;
    }
	
}
