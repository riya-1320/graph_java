import java.util.*;
public class Waterjug {
    public static boolean solution(int j1, int j2, int tar){
        if(j1+j2 < tar){
            return false;
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(0);
        
        while(! q.isEmpty()){
            
            int current = q.remove();
            if(current == tar){
                return true;
            }
            int direction[] = {j1,-j1,j2,-j2};
            for(int i : direction){
                int total = current+i;
                if(total<0 || total > j1+j2){
                    continue;
                }
                if(total == tar){
                    return true;
                }
                if(!vis.contains(total)){
                    q.add(total);
                    vis.add(total);
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        int cap1 = 4;
        int cap2 = 3;
        int target = 2;
        System.out.println(solution(cap1, cap2, target));
    }
}
