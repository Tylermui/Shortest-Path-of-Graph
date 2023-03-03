import java.io.*;
import java.util.*; 
public class ShortestPath 
{
    List<List<Integer>> adjList;
    HashSet<Integer> uniqueNodes = new HashSet<Integer>();
    Scanner in = new Scanner(System.in);

    public ShortestPath() 
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    /**
     * adds an edge between the two nodes, source and destination
     * @param src source node; node we are starting at
     * @param dest destination node; also the adjacent node 
     */
    public void addEdge(int src, int dest) 
    {
    	adjList.get(src).add(dest);
    }

    /**
     * printGraph(): print the graph with a point and its adjacent vertices
     */
    public void printGraph()
    {
        System.out.println("2. Print graph");
        for (int i = 0; i < uniqueNodes.size(); i++) 
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
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found.");
        }
    }//end readGraph()

    /**
     * shortestPath() finds the shortest path at a starting point to all other 
     * points in the undirected graph.
     */
    public void shortestPath() 
    {
        int startingVertex;
        
        System.out.println("\nPlease enter a starting vertex:");
        startingVertex = in.nextInt();
        System.out.println("\nThe shortest path from " + startingVertex + " to all nodes are:");

        for (int i = 0; i < uniqueNodes.size(); i++)
        {

            System.out.println("");
        }


    }//end shortestPath

}