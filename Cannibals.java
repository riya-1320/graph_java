import java.util.Stack;
//hello

public class Cannibals {
    
    // Define the initial state of the problem
    static int initialMissionaries = 3;
    static int initialCannibals = 3;
    static int initialBoat = 0; // 0 for left bank, 1 for right bank
    
    // Define the goal state of the problem
    static int goalMissionaries = 0;
    static int goalCannibals = 0;
    static int goalBoat = 1;
    
    static Stack<String> path = new Stack<String>();
    
    public static void main(String[] args) {
        dfs(initialMissionaries, initialCannibals, initialBoat);
    }
    
    public static void dfs(int missionaries, int cannibals, int boat) {
        if (missionaries == goalMissionaries && cannibals == goalCannibals && boat == goalBoat) {
            System.out.println(path.toString());
            return;
        }
        
        // Try all possible moves
        if (boat == 0) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (i + j >= 1 && i + j <= 2 && i <= missionaries && j <= cannibals) {
                        path.push(String.format("(%d,%d,%d)", Integer.valueOf(missionaries - i), Integer.valueOf(cannibals - j),Integer.valueOf(1)));
                        dfs(missionaries - i, cannibals - j, 1);
                        path.pop();
                    }
                }
            }
        } else {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (i + j >= 1 && i + j <= 2 && (initialMissionaries - (missionaries - i)) >= (initialCannibals - (cannibals - j))) {
                        path.push(String.format("(%d,%d,%d)", Integer.valueOf(missionaries + i), Integer.valueOf(cannibals + j), Integer.valueOf(0)));
                        dfs(missionaries + i, cannibals + j, 0);
                        path.pop();
                    }
                }
            }
        }
    }
}
