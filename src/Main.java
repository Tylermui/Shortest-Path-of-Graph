/**
COPYRIGHT (C) 2023 Shortest Path of a Graph. All Rights Reserved. 
Classes to manipulate widgets.
Solves CS317 Assignment 3 Shortest Path Algorithm
@author Tyler Mui
@version 1.01 2023-03-22
*/
/**
 * The purpose of the project is to rewrite a Breadth- 
 * First Search Algorithm that finds the shortest path
 * given an undirected graph. 
 */
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        ShortestPath graph = new ShortestPath();
        graph.readGraph();
        graph.printGraph();
        graph.shortestPath();
        
        //do a list since I think that would be easiest



    } //end of main method
} //end of class
