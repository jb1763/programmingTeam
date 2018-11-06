import java.util.Arrays;
import java.util.Scanner;

public class ShortestPathTest {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			int numberOfNodes = scan.nextInt();
			int numberOfEdges = scan.nextInt();
			int numberOfQueries = scan.nextInt();
			
			if(numberOfNodes==0 && numberOfEdges==0 && numberOfQueries==0)
			{
				break;
			}
			int[][] memo = new int[numberOfNodes][numberOfNodes];
			
			Node[] nodes = new Node[numberOfNodes];
			for(int i = 0; i < numberOfNodes; i++) {
				nodes[i] = new Node(i,numberOfNodes);
			}
			for(int i = 0; i < numberOfEdges; i++) {
				int firstNode = scan.nextInt();
				int secNode = scan.nextInt();
				int weight = scan.nextInt();
				
				nodes[firstNode].setEdge(secNode, weight);
			}
			// Query
			for(int k = 0; k < numberOfQueries; k++)
			{			
				int start = scan.nextInt();
				int end = scan.nextInt();
				nodes[start].setPathVal(0);
				
				boolean changeOccurred = true;
				for(int j = 0; (j <= numberOfNodes) && changeOccurred; j++) {
					
					changeOccurred = false;
					
					if(j == numberOfNodes) {
						System.out.println("-Infinity");
						break;
					}
				
					for(int i = 0; i < numberOfNodes; i++) {
						Node curr = nodes[i];
						for(int x = 0; x < curr.edges.length; x++) {
							Node ex = nodes[x];
							int weight = curr.edges[x];
							if(weight == Integer.MAX_VALUE || curr.pathVal == Integer.MAX_VALUE) continue;
							// BREAKS
							
							if(ex.pathVal > curr.pathVal + weight) {
								ex.pathVal = curr.pathVal + weight;
								ex.setPredecessor(i);
								changeOccurred = true;
							}
							
						}
					
					}
				
				}
				
				// TODO set pathvals to inf
				Node endNode = nodes[end];
				if(endNode.pathVal != Integer.MAX_VALUE) {
					System.out.println(endNode.pathVal);
				} else {
					System.out.println("Impossible");
				}
				
				for(Node node : nodes) {
					node.pathVal = Integer.MAX_VALUE;
				}
			}
			
		}
		
	}
}

class Node {
	int nodeNumber;
	int predecessor;
	public int pathVal;
	public int[] edges;
	// index = node#, store weight
	public Node(int nodeNumber, int numberOfNodes) {
		this.nodeNumber = nodeNumber;
		this.predecessor=-1;
		this.pathVal = Integer.MAX_VALUE;
		this.edges = new int[numberOfNodes];
		Arrays.fill(this.edges, Integer.MAX_VALUE);
	}
	
	public int getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(int predecessor) {
		this.predecessor = predecessor;
	}
	public void setPathVal(int pathVal) {
		this.pathVal = pathVal;
	}
	public void setEdge(int neighbor, int weight) {
		this.edges[neighbor]=weight;
	}
}