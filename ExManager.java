import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.*;
public class ExManager {
    private String path;
    private Integer num_of_nodes;
    private List<Node> nodes;


    public ExManager(String path){
        this.path = path;
        this.nodes = new ArrayList<Node>();
    }

    public Node getNode(int id) {
        for (Node node : nodes) {
            if (node.id == id) {
                return node;
            }
        }
        return null;
    }
    public int getNum_of_nodes() {
        return this.num_of_nodes;
    }

    public void update_edge(int id1, int id2, double weight){
        Node from = null;
        Integer to = id2;
        for (Node node : nodes) {
            if (node.id == id1) {
                from = node;
            }
        }
        assert from != null;
        assert id1 != id2;
        from.update_weight(to, weight);
    }

    public void read_txt() throws FileNotFoundException{
        File file = new File(this.path);
        Scanner scanner = new Scanner(file);

        // reading the first line of the file which is the number of nodes
        String line = scanner.nextLine();
        String[] line_items = line.split(" ");
        this.num_of_nodes = Integer.parseInt(line_items[0]);

        // reading the rest of the file until 'stop' and initiating the nodes
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.contains("stop")){
                break;
            }

            line_items = line.split(" ");
            System.out.println(line);
            Integer id = Integer.parseInt(line_items[0]);
            Node node = new Node(line, this.num_of_nodes);
            nodes.add(node);
        }

    }

    public void start(){
        for (Node node: nodes){

        }
    }
}
