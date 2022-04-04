package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   02/04/22 7:04 AM  
   */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeUnderEveryEmployee {
    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");
        Map<String, List<String>> reporting = getResult(dataSet);
        System.out.println(reporting);
    }

    private static Map<String, List<String>> getResult(Map<String, String> dataSet) {
        Map<String, List<String>> reportings = new HashMap<>();

        dataSet.entrySet().stream().forEach(e -> {
            if (!reportings.containsKey(e.getValue())) {
                reportings.put(e.getValue(), new ArrayList<>());
            }
            if(e.getKey().equals(e.getValue())){
                return;
            }
            reportings.get(e.getValue()).add(e.getKey());
        });
        Map.Entry<String, String> entry = dataSet.entrySet().stream().filter(e -> {
            return e.getValue() == e.getKey();
        }).findFirst().get();
        String boss = entry.getKey();

        util(reportings, boss);
        return reportings;
    }

    private static List<String> util(Map<String, List<String>> reportings, String current) {
        if (!reportings.containsKey(current) || reportings.get(current).isEmpty()) {
            return new ArrayList<>();
        }
        List<String> subordinates = reportings.get(current);
        for (String sub : reportings.get(current)) {
            List<String> temp = util(reportings, sub);
            subordinates.addAll(temp);
        }
        reportings.put(current, subordinates);
        return subordinates;
    }

}
