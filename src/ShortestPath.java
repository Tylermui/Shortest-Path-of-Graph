import java.io.*;
import java.util.*; 
/**
 * This class is the class for the Shortest Path
 * algorithm. This includes a Breadth-First Search
 * algorithm along with a method to print and 
 * read an unweighted and undirected graph.
 * @author Tyler Mui
 */
public class ShortestPath 
{
    private ArrayList<ArrayList<Integer>> adjList;
    private HashSet<Integer> uniqueNodes = new HashSet<Integer>();
    private boolean[] visited;
    private int[] visitingOrder;
    private int count = 0;
    private int numOfVertices;
    Scanner in = new Scanner(System.in);

    /**
     * This is the constructor for a Shortest Path 
     * object.
     */
    public ShortestPath() 
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    /**
     * adds an edge between the two given nodes, source and destination
     * @param src source node; node we are starting at
     * @param dest destination node; also the adjacent node 
     */
    public void addEdge(int src, int dest) 
    {
    	adjList.get(src).add(dest);
    }

    /**
     * Breadth-First Search algorithm that goes through a graph
     * and tracks the steps it takes to go from one node to another.
     * @param src source node from where we are starting at
     * @param dest destination node that we are try to end at
     * @param parent an array of parent nodes that has the predecessor of the source node
     * @param distance an array of distances to track how many steps it takes to get to a given node
     */
    public void bfs(int src, int dest, int[] parent, int[] distance)
    {
        Queue<Integer> Q = new LinkedList<>();
        visited = new boolean[uniqueNodes.size()];

        for (int j = 0; j < numOfVertices; j++)
        {
            parent[j] = -1;
        }

        Q.offer(src);
        visited[src] = true;    
        distance[src] = 0;
        
        while (!Q.isEmpty()) 
        {
            int currentVertex = Q.poll();
            for (int adj : adjList.get(currentVertex)) 
            {
                if(!visited[adj])
                {
                    visited[adj] = true;
                    Q.offer(adj);
                    distance[adj] = distance[currentVertex] + 1;
                    parent[adj] = currentVertex;
                }
                if (adj == dest)
                {
                    return;
                }
            }
        }
    }//end bfs

    /**
     * printGraph(): print the graph with a point and its adjacent vertices
     * 
     */
    public void printGraph()
    {
        System.out.println("2. Print graph");
        for (int i = 0; i < numOfVertices; i++) 
        {
            System.out.print(i + "-->");
            for (int j = 0; j < adjList.get(i).size(); j++)
            {
                System.out.print("  " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }//end printGraph

    /**
     * readGraph(): read the graph into the adjacency list from a file.
     */
    public void readGraph() 
    {
    	try 
        {
            System.out.println("1. Read graph \n");
            //reading the graph.txt file
            File file = new File("graph.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) 
            {
                String line = scanner.nextLine();
                String[] nodes = line.split(", ");
                int from = Integer.parseInt(nodes[0]);
                int to = Integer.parseInt(nodes[1]);
                addEdge(from, to);
    	        addEdge(to, from);
                uniqueNodes.add(from);
                uniqueNodes.add(to);
            }
            scanner.close();
            numOfVertices = uniqueNodes.size();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found.");
        }
    }//end readGraph()

    /**
     * shortestPath() finds the shortest path at a starting point to all other 
     * points in the undirected unweighted graph.
     */
    public void shortestPath() 
    {
        int src;
        System.out.println("\nPlease enter a starting vertex:"); 
        src = in.nextInt(); 
        System.out.println("\nThe shortest path from " + src + " to all nodes are:"); 

        for (int i = 0; i < numOfVertices; i++)
        {
            int [] parent = new int[numOfVertices];
            int [] distance = new int[numOfVertices];
            bfs(src, i, parent, distance);
            List<Integer> path = new ArrayList<>();
            int crawl = i;
            path.add(crawl);
            while (parent[crawl] != -1) {
                path.add(parent[crawl]);
                crawl = parent[crawl];
            }

            Collections.reverse(path);
            System.out.println(path);

        }

    }//end shortestPath
    
}