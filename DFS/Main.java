



import java.util.ArrayList;

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

        System.out.println("The BFS traversal of the graph using Queue ");
        BFS bfsExample = new BFS();
        bfsExample.bfsUsingQueue(node40);
        reset(objList);
        System.out.println();

        DFS dfsExample = new DFS();
        System.out.println("The DFS traversal of the graph using stack ");
        dfsExample.dfsUsingStack(node40);
        reset(objList);
        System.out.println();

        System.out.println("The DFS traversal of the graph using recursion ");
        dfsExample.dfs(node40);
        reset(objList);
    }
    public static void reset(ArrayList<Node> objlist) {
        for (int i = 0; i < objlist.size(); i++) {
            objlist.get(i).visited = false;
        }
    }
}
