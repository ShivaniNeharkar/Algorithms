import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class hasPath {
    public  boolean hasPathbfs(Node source, Node Destination)
    {
        BFS bfs = new BFS();
        ArrayList<Node> objlist =bfs.bfsUsingQueue(source);
        for (int i = 0; i < objlist.size(); i++) {
            if(objlist.get(i).data == Destination.data)
            {
                return true;
            }
        }
        return false;
    }
    public  boolean hasPathdfs(Node source, Node Destination)
    {
        Stack<Node> stack=new  Stack<Node>();
        stack.push(source);
        while (!stack.isEmpty())
        {
            Node current=stack.pop();
            if(!current.visited)
            {
                //System.out.print(current.data + " ");
                current.visited=true;
                if(current.data == Destination.data)
                {
                    return true;
                }
            }

            List<Node> neighboursOfCurrent = current.getNeighbours();
            for (int i = 0; i < neighboursOfCurrent.size(); i++) {
                Node n = neighboursOfCurrent.get(i);
                if(n!= null && !n.visited)
                {
                    stack.push(n);
                }
            }
        }
        return false;
    }
}
