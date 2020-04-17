public class Station implements Node {
    private int nodeID;
    private String nodeLabel;

    public Station(String stationName, int id){
        nodeLabel=stationName;
        nodeID=id;
    }

    public int getID(){

        return nodeID;
    }

    public String getLabel() {
        return nodeLabel;
    }

}
