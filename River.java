import java.util.*;
public class River {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        System.out.println("State Space");
        System.out.println("");
        System.out.println("B ML CL MR CR");
        State root = new State (0,3,3, map, null);
        System.out.println("** BFS Search**");
        BFS(root);
    }

    public static class State
    {
        int nBoatStatus;
        int nCanibalsLeft;
        int nMisionaryLeft;
        int nCanibalsRight; 
        int nMisionaryRight;

        State oParent = null;
        ArrayList<State> childState = new ArrayList<State>();
        public State (int b, int m,int c,HashMap<String, Integer> map, State parent)
        {
            map.put (""+b*m*c, 1);
            nBoatStatus = b;
            nCanibalsLeft = c;
            nMisionaryLeft = m;
            nCanibalsRight = 3 - c;
            nMisionaryRight = 3 - m;
            oParent = parent;
            System.out.println(b +" "+m+" "+c+""+(3-m)+ " "+(3-c));
            int nC = nCanibalsLeft;
            int nM = nMisionaryLeft;
            if (nBoatStatus == 1)
            {
                nC = nCanibalsRight;
                nM = nMisionaryRight;
            }
            if(nC >= 2)
            {
                if (nBoatStatus == 0) //boat on left
                {
                    String str = ""+1+nM+(nC-2);
                    if(ValidateNewState(nM, (nC- 2)) && !map.containsKey(str))
                        childState.add(new State(1,nM,nC-2,map,this));
                }
                else //boat on right
                {
                    String str = ""+0+(3-nM)+(3-(nC -2));
                    if (ValidateNewState((3-nM), 3-(nC -2)) && !map. containsKey(str))
                    childState.add(new State(0, 3-nM, 3-(nC -2) , map, this));
                }
            }
            if (nM >= 2)
            {
                if (nBoatStatus == 0) //boat on left
                {
                    String str = ""+ 1+ (nM -2)+nC;
                    if(ValidateNewState((nM -2), nC) && !map.containsKey(str))
                        childState.add(new State(1,nM-2,nC,map,this));
                }
                else //boat on right
                {
                    String str = ""+ 0+(3-(nM-2))+(3-nC);
                    if(ValidateNewState((3-(nM-2)), (3-nC)) && !map.containsKey(str))
                        childState.add(new State(0,3-(nM-2),3-nC,map,this));
                }
            }
            if(nM>=1 && nC >=1)
            {   
                if(nBoatStatus == 0)//Boat on right
                {
                    String str = "" +1+(nM -1) + (nC -1);
                    if(ValidateNewState((nM -1), (nC -1)) && !map.containsKey(str))
                        childState.add(new State(1,nM -1,nC -1,map, this));
                }else //boat on right
                    {
                        String str = ""+ 0 + (3 -(nM -1))+ (3-(nC -1));
                        if (ValidateNewState(3 -(nM -1), 3- (nC -1)) && !map.containsKey(str))
                            childState. add(new State(0,3 -(nM -1),3-(nC -1) ,map, this));
                    }
            }

            if (nM>=1) {
                if (nBoatStatus == 0) //boat on left
                {
                    String str= ""+ 1+(nM -1) +nC;
                    if (ValidateNewState(nM -1, nC) && !map.containsKey(str)) 
                        childState.add (new State (1,nM -1,nC, map, this));
                }else //boat on right
                {
                    String str = ""+ 0+(3 -(nM -1))+(3-nC);
                    if(ValidateNewState(3 - (nM -1),3-nC) && !map. containsKey(str))
                        childState. add(new State(0,3 -(nM -1),3-nC, map, this));
                }
            }
            if(nC >=1){
                if(nBoatStatus == 0) //boat on left
                {
                    String str = ""+ 1+ nM+ (nC -1);
                    if(ValidateNewState(nM, nC -1) && !map. containsKey(str))
                        childState.add (new State(1, nM, nC-1, map, this));
                }else//boat in right
                {
                    String str = ""+ 0+ (3 -nM) +(3-(nC -1));
                    if(ValidateNewState(3 -nM, 3-(nC -1)) && !map. containsKey(str)) 
                        childState.add(new State (0,3 -nM, 3-(nC -1), map, this));
                }
            }
        }
    }
            //constructor state end
        // validate number of cannibalsdoes not exceed missionaries on any side.
        public static boolean ValidateNewState(int M, int C)
        {

            if(C > M && M != 0)
                return false;
            else if(3-C > 3-M && 3-M != 0)
            {
                return false;
            }
            return true;
        }
    ///this function returns sun of misplaces cannibals and missionaries
    
    private static void BFS(State RealRoot) 
    {
        ArrayList<State> Frontier = new ArrayList<State>();
        ArrayList<State> Reached = new ArrayList<State>();

        Frontier.add(RealRoot) ;
        boolean bFound = false;
        State goal = null;
        for(int i = 0; i < Frontier.size(); i++)
        {
            State root = Frontier.remove(i) ;
            i--;
            if(root.nMisionaryRight == 3 && root.nCanibalsRight == 3)// if current node is the solution state
            {
                goal = root;
                bFound = true;
                break;
            }
            Reached.add(root);
            for(int j = 0; j < root.childState.size(); j++)// add shilds to the frontier
            {
                Frontier.add(root. childState.get(j));
            }
            }
    System.out.println("BFS SEARCH");
    if(bFound && goal!= null){
        while(goal != null){
            System.out.println("" + StringMultiplier("C", goal.nCanibalsLeft)
            +StringMultiplier("M",goal.nMisionaryLeft)
            + "~~~~"
            +StringMultiplier("C",goal.nCanibalsRight)+StringMultiplier("M",goal.nMisionaryRight));
            goal = goal.oParent;
        }
    }
    }
    public static String StringMultiplier(String str, int n){
        String newstr = "";
        for(int p=0; p<n; p++){
            newstr = newstr + str;
        }
        return newstr;
    }
}

