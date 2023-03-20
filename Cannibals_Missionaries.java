import java.util.*;
public class Cannibals_Missionaries {
    public static void main(String args[]){
        BoatTrip Boat = new BoatTrip();
        //start states
        ArrayList Solution = Boat.getSolutionNode(
            new Node("Start", 3, 3, false, 1),
            new Node("End", 0, 0, true, 0));
            if(Solution.size() == 0){
                System.out.println("\n\n no solution have been founf\r\n");
            }
            else{
                for(int i=0; i<Solution.size(); i++){
                    Node s = (Node)Solution.remove(0);
                    System.out.println("the missionaries and cannibals problem\r\n");
                    System.out.println("west side --------------------East side");
                    s.Print();
                    System.out.println("The solution took  "+s.getNodeLevel()+" steps\n");
                }
            }
    }
}
