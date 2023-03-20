import java.util.*;

public class Node {
    int nMiss, nCan;
    boolean side;
    int NumOfEachAtStart = 3;
    String Name;
    int nodeLevel =0;
    Node previousnode;

    public Node(String name, int nM, int nC, boolean side, int nodeLevel){
        this(name, nM, nC, side, null, nodeLevel);
    }
    public Node(String name, int nM, int nC, boolean side, Node prevnode, int nodeLevel){
        Name = name; nMiss = nM; nCan = nC; side = side;
         previousnode = prevnode; nodeLevel = nodeLevel;
    }
    //return name of current node
    public String getNodeName(){
        return this.Name;
    }
    //return node level
    public int getNodeLevel(){
        return this.nodeLevel;
    }
    //print out previous nodes up to solution node
    public void Print(){
        int m=0;
        int c =0;
        if(previousnode != null){
            m= Math.abs(nMiss - previousnode.nMiss);
            c = Math.abs(nCan - previousnode.nCan);
            previousnode.Print();
        }
        String WhatDirection = side ? "------("+m+"M)BOAT("+c+"C)------>" : "<------("+m+"M)BOAT("+c+"C)------";
        System.out.println(nMiss + "M/" + nCan + "C " + WhatDirection + " "+(NumOfEachAtStart - nMiss) + "M/" + (NumOfEachAtStart - nCan) + "C");
    }

    public boolean Equal(Node NodeToCheck){
        return(nMiss == NodeToCheck.nMiss && nCan == NodeToCheck.nCan && side == NodeToCheck.side);
    }
    public boolean InvalidNode(){
        if(nMiss < 0 || nCan <0)
            return true;
        if(nMiss < nCan && nMiss > 0)
            return true;
        if(3 - nMiss < 3 - nCan && 3-nMiss > 0)
            return true;
        if(nMiss > NumOfEachAtStart || nCan > NumOfEachAtStart)
            return true;
        
        return false;
    }
}