public class Track implements Edge {
    private Node previousNode,nextNode;
    private String trackLabel;


   public Track(Node prev,Node next,String label){
       previousNode=prev;
       nextNode=next;
       trackLabel=label;


   }

    public String getLabel(){
    return trackLabel;
    }

    public Node getPreviousNode(){
    return previousNode;
    }

    public Node getNextNode(){
        return nextNode;
    }
}
