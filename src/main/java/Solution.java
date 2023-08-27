import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canCross(int[] stones) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        int finish = stones.length - 1;
        Map<String, Boolean> memo = new HashMap<>();

        return dfs(0, finish, stones, map, 0, memo);
    }

    private boolean dfs(int i, int finish, int[] stones, Map<Integer, Integer> map, int lastJumpLength, Map<String, Boolean> memo) {
        if (i == finish) {
            return true;
        }
        if(memo.containsKey(i + " " + lastJumpLength)){
            return memo.get(i + " " + lastJumpLength);
        }
        boolean result = false;
        boolean jump1More = false;
        boolean jumpSame = false;
        boolean jump1Less = false;


        if (map.containsKey(stones[i] + lastJumpLength + 1)) {
            if (map.get(stones[i] + lastJumpLength + 1) > i) {
                jump1More = dfs(map.get(stones[i] + lastJumpLength + 1), finish, stones, map, lastJumpLength + 1, memo);
            }
        }
        if (map.containsKey(stones[i] + lastJumpLength)) {
            if (map.get(stones[i] + lastJumpLength) > i) {
                jumpSame = dfs(map.get(stones[i] + lastJumpLength), finish, stones, map, lastJumpLength, memo);
            }
        }
        if (map.containsKey(stones[i] + lastJumpLength - 1) && lastJumpLength > 1) {
            if (map.get(stones[i] + lastJumpLength - 1) > i) {
                jump1Less = dfs(map.get(stones[i] + lastJumpLength - 1), finish, stones, map, lastJumpLength - 1, memo);
            }
        }

        result = jump1More || jumpSame || jump1Less;
        memo.put(i + " " + lastJumpLength, result);
        return result;

    }
}
