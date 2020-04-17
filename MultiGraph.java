import java.util.*;

public class MultiGraph implements GraphADT{
    private List<Node> nodes = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();

    public MultiGraph() {


    }
    public void addNode(Node n) {

        nodes.add(n);
    }

    public void addEdge(Edge e) {

        edges.add(e);
    }


    public Node getNode(int nodeID) {
        Node n= null;
        for(int i=0;i<nodes.size();i++){
            if(nodeID==nodes.get(i).getID()){
                n=nodes.get(i);
                break;
            }
        }

        return n;

    }

    public Node getNodeFromName(String name) {
        name=name.toLowerCase();
        for (Node n : nodes){
            if (n.getLabel().toLowerCase().equals(name)){
                return n;
            }
        }
        return null;
    }


    public List<Node> getroute(Node currentStation, Node destinationStation){
        List<Node> visited= new ArrayList<>();
        Queue<Node> unvisited = new LinkedList<>();
        HashMap<Node, Node> path = new HashMap<>();
        Node currentStationRaw= currentStation;
        List<Node> pathNodes = new ArrayList<>();


        unvisited.add(currentStation);
        visited.add(currentStation);


        while (!unvisited.isEmpty()){
            currentStation=unvisited.remove();

            if (currentStation.equals(destinationStation)){
                break;
            }
          else {

                for (Node n: getAdjacentNodes(currentStation)){


                    if (!visited.contains(n)){

                        visited.add(n);

                        unvisited.add(n);
                        path.put(n, currentStation);

                    }
                }
            }

        }
        if (currentStation.equals(destinationStation)){

            pathNodes.add(currentStation);
            while (!currentStation.equals(currentStationRaw)){
                pathNodes.add(path.get(currentStation));
                currentStation=path.get(currentStation);
            }

            return pathNodes;
        }
            return null;




    }

    public Edge getEdge(Node node1, Node node2){
        for (Edge e : edges){

            if (node1.equals(e.getPreviousNode()) && node2.equals(e.getNextNode())) {
                return e;
            }
        }
        return null;
    }
    public boolean isEdge(Node node1, Node node2) {
        for (Edge e : edges) {
            if (node1.equals(e.getPreviousNode()) && node2.equals(e.getNextNode())) {
                return true;
            }


        }
        return false;
    }

    public List<Node> getAdjacentNodes(Node node){
        List<Node> adjacentNodes = new ArrayList<>();
        for (Node n : nodes){
            if (isEdge(n, node)){

                adjacentNodes.add(n);
            }

        }
        return adjacentNodes;
    }


}
