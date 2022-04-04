package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   01/04/22 11:09 PM  
   */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCashFlow {
    public static void main(String[] args) {
        int[][] trasnaction = {{1, 5, 8}, {8, 9, 8}, {2, 3, 9}, {4, 3, 1}};
        MinCashFlow minCashFlow = new MinCashFlow();
        System.out.println(minCashFlow.minTransfers(trasnaction));
    }

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balance = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            int from = transactions[i][0];
            int to = transactions[i][1];
            int amount = transactions[i][2];
            balance.put(from, balance.getOrDefault(from, 0) - amount);
            balance.put(to, balance.getOrDefault(to, 0) + amount);
        }
        PriorityQueue<Integer> debitor = new PriorityQueue<>((i1, i2) -> {
            return Integer.compare(i2, i1);
        });

        PriorityQueue<Integer> creditor = new PriorityQueue<>((i1, i2) -> {
            return Integer.compare(i2, i1);
        });


        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> setToRemove = new HashSet<>();
        balance.entrySet().stream().forEach(e -> {
            if (map.containsKey(-1 * e.getValue())) {
                setToRemove.add(e.getKey());
                setToRemove.add(map.get(-1 * e.getValue()));
                map.remove(-1 * e.getValue());
            } else {
                map.put(e.getValue(), e.getKey());
            }
        });
        int count = setToRemove.size() / 2;
        balance.entrySet().stream().forEach(e -> {
            if (setToRemove.contains(e.getKey())) {
                return;
            }
            if (e.getValue() < 0) {
                debitor.add(-1 * e.getValue());
            } else {
                creditor.add(e.getValue());
            }
        });


        while (!debitor.isEmpty() && !creditor.isEmpty()) {
            count++;
            int debit = debitor.poll();
            int credit = creditor.poll();
            if (credit > debit) {
                creditor.add(credit - debit);
            } else if (debit > credit) {
                debitor.add(debit - credit);
            }
        }
        return count;
    }
}
