import java.util.*;

public class Jug {
    public static void main(String[] args) {
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        State initial = new State(0, 0);
        queue.offer(initial);
        visited.add(initial);

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.jug4 == 2) {
                System.out.println("Solution found!");
                System.out.println(current);
                return;
            }

            for (State next : current.getNextStates()) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }

        System.out.println("Solution not found.");
    }
}

class State {
    int jug4, jug3;

    public State(int jug4, int jug3) {
        this.jug4 = jug4;
        this.jug3 = jug3;
    }

    public List<State> getNextStates() {
        List<State> nextStates = new ArrayList<>();

        // Fill jug4
        nextStates.add(new State(4, jug3));

        // Fill jug3
        nextStates.add(new State(jug4, 3));

        // Pour jug4 into jug3
        int amount = Math.min(jug4, 3 - jug3);
        nextStates.add(new State(jug4 - amount, jug3 + amount));

        // Pour jug3 into jug4
        amount = Math.min(jug3, 4 - jug4);
        nextStates.add(new State(jug4 + amount, jug3 - amount));

        // Empty jug4
        nextStates.add(new State(0, jug3));

        // Empty jug3
        nextStates.add(new State(jug4, 0));

        return nextStates;
    }

    @Override
    public String toString() {
        return "(" + jug4 + ", " + jug3 + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(jug4, jug3);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        State other = (State) obj;
        return jug4 == other.jug4 && jug3 == other.jug3;
    }
}
