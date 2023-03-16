



import java.util.*;

public class Main {
   public static void main(String arg[])
    {

        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node40 =new Node(40);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);
        Node node80 =new Node(80);

        ArrayList<Node> objList = new ArrayList<>();

        objList.add(node10);
        objList.add(node20);
        objList.add(node30);
        objList.add(node40);
        objList.add(node50);
        objList.add(node60);
        objList.add(node70);
        objList.add(node80);

        // Directed
        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);

        // Include this and You get Undirected
        node70.addneighbours(node50);
        node70.addneighbours(node60);
        node60.addneighbours(node30);
        node50.addneighbours(node20);
        node60.addneighbours(node20);
        node30.addneighbours(node20);
        node10.addneighbours(node20);
        node30.addneighbours(node10);
        node20.addneighbours(node40);
        node10.addneighbours(node40);



//        System.out.println("The BFS traversal of the graph using Queue ");
//        BFS bfsExample = new BFS();
//        bfsExample.bfsUsingQueue(node10);
//        reset(objList);
//        System.out.println();
//
        DFS dfsExample = new DFS();
        System.out.println("The DFS traversal of the graph using stack ");
        System.out.println(dfsExample.dfsUsingStack(node40));
        reset(objList);
        System.out.println();
//
//        System.out.println("The DFS traversal of the graph using recursion ");
//        dfsExample.dfs(node40);
//        reset(objList);
//        System.out.println();
//
//        System.out.println("How many connected Components are there? "+ numberOfConnectedComponents(objList));
//        reset(objList);
//        System.out.println();

//        System.out.println("What is the Largest Connected Component? " );
//        reset(objList);
//        largestConnectedComponent(objList);
//        reset(objList);
//        System.out.println();

        HashMap<Node,Integer> distFromSource= new HashMap<>();
        Queue<Node> visitedNodesFromSource = new LinkedList<>();
        System.out.println("SHortrst between 40 and 70" );
        System.out.println(explore(node40,node70,distFromSource,visitedNodesFromSource));
        System.out.println();
        reset(objList);





    }
    public static void reset(ArrayList<Node> objlist) {
        for (int i = 0; i < objlist.size(); i++) {
            objlist.get(i).visited = false;
        }
    }
    public static int numberOfConnectedComponents(ArrayList<Node> objList){
       DFS dfs = new DFS();
       int count =0;
       for( int i=0;i<objList.size();i++)
       {
           if(!objList.get(i).visited)
           {
               System.out.println("Hey starting with "+ objList.get(i).data);
               dfs.dfsUsingStack(objList.get(i));
               System.out.println();
               count++;
           }

       }
       return count;
    }


    public static void largestConnectedComponent(ArrayList<Node> objList) {
       DFS dfs = new DFS();
       int highestCount=0 ;

       for(int i=0;i<objList.size();i++) {
           if(!objList.get(i).visited)
           {
               //System.out.println((dfs.dfsUsingStack(objList.get(i)).size()));
               int size = dfs.dfsUsingStack(objList.get(i)).size();
               highestCount = Math.max(size,highestCount);

           }

       }
        System.out.println(highestCount);
    }


    public static int explore(Node source, Node destination, HashMap<Node,Integer> distFromSource, Queue<Node> visitedNodesFromSource) {
       distFromSource.put(source,0);
       source.visited = true;
       visitedNodesFromSource.add(source);
       while(!visitedNodesFromSource.isEmpty()) {
           Node current = visitedNodesFromSource.remove();
           for(int i=0;i<current.neighbours.size();i++) {
               if(!current.neighbours.get(i).visited) {
                   visitedNodesFromSource.add(current.neighbours.get(i));
                   distFromSource.put(current.neighbours.get(i),1+(int)(distFromSource.get(current)));
                   current.neighbours.get(i).visited = true;
               }
           }

       }
        return distFromSource.get(destination);
    }




}
