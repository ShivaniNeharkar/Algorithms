import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS
{
    // Iterative DFS using stack
    public  void dfsUsingStack(Node source)
    {
        Stack<Node> stack=new  Stack<Node>();
        stack.push(source);
        while (!stack.isEmpty())
        {
            Node current=stack.pop();
            if(!current.visited)
            {
                System.out.print(current.data + " ");
                current.visited=true;
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
    }
    // Recursive DFS
    public  void dfs(Node node)
    {
        System.out.print(node.data + " ");
        List<Node> neighbours=node.getNeighbours();
        node.visited=true;
        for (int i = 0; i < neighbours.size(); i++) {
            Node n=neighbours.get(i);
            if(n!=null && !n.visited)
            {
                dfs(n);
            }
        }
    }


}
