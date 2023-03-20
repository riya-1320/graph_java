import java.util.*;
public class BoatTrip {
    public int Current_Root_Node = 0;
    public ArrayList searchList = new ArrayList();
    public void SolutionProvider(){}
    //constructor to add node to the Agenda and include parent nofe if available
    private void addNodeToList(String NodeName, Node parent, int nMiss, int nCan){
        int BoatDirection = parent.side ? 1 : -1;
        String newNodeName = parent.getNodeName() + NodeName;
        Node newNode = new Node(newNodeName, parent.nMiss + nMiss * BoatDirection,parent.nCan + nCan*BoatDirection, !parent.side,parent.getNodeLevel());
        addNodeToList(newNode);
    }

    private void addNodeToList(Node newNode){
        if(newNode.InvalidNode())
            return;
        searchList.add(newNode);
    }
    //return solution node, using generateSucessors recursively
    public ArrayList getSolutionNode(Node StartNode, Node EndNode){
        boolean foundSolution = false;
        ArrayList Solution = new ArrayList();
        addNodeToList(StartNode);
        while(searchList.size() > 0 && !foundSolution){
            Node CurNode = (Node) searchList.remove(Current_Root_Node);
            if(CurNode.Equal(EndNode)){
                Solution.add(CurNode);
                foundSolution = true;
            }
            else
            {
                generateNode(CurNode);
            }
        }
        return Solution;
    }
    
    //generate list of valid nodes to check next
    private void generateNode(Node CurNode){
        int nCan, nMiss = 0;
        int nodeName = 1;
        for(int i = 0; i<=2; i++){
            for(int j =0 ; i<=2; j++){
                if(i==0 && j==0){
                    continue;
                }
                if(i+j > 2)
                    break;
                nMiss =i;
                nCan = j;
                addNodeToList("_" + nodeName++, CurNode, nMiss, nCan);
            }
        }
    }
}
