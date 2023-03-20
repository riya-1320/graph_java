import java.util.HashSet;
import java.util.Stack;

public class CannibalsAndMissionaries {

    static class State {
        int[] left, right;
        boolean boatLeft;

        public State(int[] left, int[] right, boolean boatLeft) {
            this.left = left;
            this.right = right;
            this.boatLeft = boatLeft;
        }

        public boolean isValid() {
            // Check if there are more cannibals than missionaries on either side
            return (left[0] == 0 || left[0] >= left[1]) &&
                   (right[0] == 0 || right[0] >= right[1]);
        }

        public boolean isGoal() {
            // Check if all missionaries and cannibals have crossed the river
            return left[0] == 0 && left[1] == 0 && left[2] == 0 &&
                   right[0] == 3 && right[1] == 3 && right[2] == 1;
        }

        public State cross(int m, int c) {
            // Create a new state by crossing the river with m missionaries and c cannibals
            int[] newLeft = {left[0] - m, left[1] - c, 1 - left[2]};
            int[] newRight = {right[0] + m, right[1] + c, 1 - right[2]};
            return new State(newLeft, newRight, !boatLeft);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State other = (State) obj;
            return left[0] == other.left[0] && left[1] == other.left[1] && left[2] == other.left[2] &&
                   right[0] == other.right[0] && right[1] == other.right[1] && right[2] == other.right[2] &&
                   boatLeft == other.boatLeft;
        }

        @Override
        public int hashCode() {
            int hash = 17;
            hash = 31 * hash + left[0];
            hash = 31 * hash + left[1];
            hash = 31 * hash + left[2];
            hash = 31 * hash + right[0];
            hash = 31 * hash + right[1];
            hash = 31 * hash + right[2];
            hash = 31 * hash + (boatLeft ? 1 : 0);
            return hash;
        }
    }

    public static void main(String[] args) {
        // Initialize the starting state
        State start = new State(new int[]{3, 3, 1}, new int[]{0, 0, 0}, true);

        // Use a stack to perform a depth-first search
        Stack<State> stack = new Stack<>();
        stack.push(start);

        // Use a set to keep track of visited states
        HashSet<State> visited = new HashSet<>();
        visited.add(start);

        while (!stack.isEmpty()) {
            State current = stack.pop();

            if (current.isGoal()) {
                // Print the solution
                System.out.println("Solution:");
                printPath(current);
                return;
            }

            // Generate all possible next states
            for (int m = 0; m <= 2; m++) {
                for (int c = 0; c <= 2; c++) {
                    if (m + c >= 1
