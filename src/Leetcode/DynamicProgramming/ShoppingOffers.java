package Leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingOffers {
    // https://leetcode.com/problems/shopping-offers/

    HashMap<List<Integer>, Integer> mp = new HashMap<>();

    public int multiply(List<Integer> price, List<Integer> needs) {
        int ans = 0;
        for (int i = 0; i < price.size(); i++) {
            ans += price.get(i) * needs.get(i);
        }
        return ans;
    }

    public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (mp.containsKey(needs)) return mp.get(needs);
        int res = multiply(price, needs);
        for (int i = 0; i < special.size(); i++) {
            ArrayList<Integer> new_list = new ArrayList<>(needs);
            int j = 0;
            for (j = 0; j < special.get(i).size() - 1; j++) {
                int remain = new_list.get(j) - special.get(i).get(j);
                if (remain < 0) {
                    break;
                }
                new_list.set(j, remain);
            }
            if (j == special.get(i).size() - 1) {
                res = Math.min(res, special.get(i).get(j) + helper(price, special, new_list));
            }
        }
        mp.put(needs, res);
        return res;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        mp = new HashMap<>();
        return helper(price, special, needs);
    }

    public static void main(String[] args) {

    }
}
