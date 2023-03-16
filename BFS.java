import java.util.*;


public class BFS {
    public  ArrayList<Node> bfsUsingQueue(Node source)
    {
        ArrayList<Node> bfsList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()) {
            Node current = queue.remove();
            if(!current.visited) {
                System.out.print(current.data + " ");
                bfsList.add(current);
                current.visited = true;
                for(int i=0;i<current.neighbours.size();i++) {
                    if(!current.neighbours.get(i).visited)
                        queue.add(current.neighbours.get(i));
                }
            }
        }
        return bfsList;
    }

}
