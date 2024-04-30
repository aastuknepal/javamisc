import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.HashMap;


public class Homework {

    // Remove Duplicate from arraylist
    public static ArrayList<Object> removeDuplicates(ArrayList<Object> list) {
        ArrayList<Object> uniqueList = new ArrayList<>();

        HashSet<Object> seen = new HashSet<>();

        for (Object element : list) {
            if (!seen.contains(element)) {
                uniqueList.add(element);
                seen.add(element);
            }
        }

        return uniqueList;
    }

    public static HashSet<Object> duplicateSet(ArrayList<Object> list) {
        HashSet<Object> duplicateSet = new HashSet<>();

        HashSet<Object> present = new HashSet<>();

        for (Object element : list) {
            if (present.contains(element)) {
                duplicateSet.add(element);
            } else {
                present.add(element);
            }
        }

        return duplicateSet;
    }

    // Removing character 

    public static ArrayList<String> removeChar(String pattern, ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).replace(pattern, ""));
        }
        return list;
    }

    // Growing List
    public static ArrayList<String> returnGrowingNumList(int max) {
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < i; j++) {
                stringBuilder.append(i).append(" ");
            }
            resultList.add(stringBuilder.toString().trim());
        }
        return resultList;
    }


    // Unique pattern
    public static HashMap<String, Integer> uniqueValues(HashMap<Integer, String> a_map) {
        HashMap<String, Integer> to_ret = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String value : a_map.values()) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
        for (HashMap.Entry<Integer, String> entry : a_map.entrySet()) {
            if (countMap.get(entry.getValue()) == 1) {
                to_ret.put(entry.getValue(), entry.getKey());
            }
        }

        return to_ret;
    }

    // Concatenation
    public static HashMap<String, Integer> concatenateMap(ArrayList<HashMap<String, Integer>> mapList) {
        HashMap<String, Integer> concatenatedMap = new HashMap<>();
        for (HashMap<String, Integer> map : mapList) {
            for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
                if (!concatenatedMap.containsKey(entry.getKey())) {
                    concatenatedMap.put(entry.getKey(), entry.getValue());
                }
            }
        }

        return concatenatedMap;
    }


    public static void main(String[] args) {
        // Usage of duplicate removal

        System.out.println("Removing Duplicate from Arraylist");
        ArrayList<Object> inputList = new ArrayList<>(Arrays.asList(2, 4, 5, 3, 3, 5, 4, 4, 5, 6, 2));
        ArrayList<Object> result = removeDuplicates(inputList);
        System.out.println("Duplicates removed arraylist: " + result);
        System.out.println("______________________________________________________");



           // Usage of printing Duplicate set
           System.out.println("Printing Duplicate from Arraylist");
           ArrayList<Object> inputdup = new ArrayList<>(Arrays.asList(2, 4, 5, 3, 3, 5));
           HashSet<Object> duplicataval = duplicateSet(inputdup);
           System.out.println("Duplicate elements are: " + duplicataval);
           System.out.println("______________________________________________________");


        // Usage of char removal
        System.out.println("Removing given character");     
        ArrayList<String> inplist = new ArrayList<>(Arrays.asList("adndj", "adjdlaa", "aa", "djoe"));
        String pattern = "a";
        ArrayList<String> resultchr = removeChar(pattern, inplist);
        System.out.println("Output: " + resultchr);
        System.out.println("______________________________________________________");


          // Usage of Growing lIst
          System.out.println("Growing list");     
          int max1 = 7;
          System.out.println("Given: " + max1);
          System.out.println("Result: " + returnGrowingNumList(max1));
          System.out.println("______________________________________________________");



        // Usage of unique map
        System.out.println("Unique Map");     
          HashMap<Integer, String> inputMap1 = new HashMap<>();
          inputMap1.put(0, "M");
          inputMap1.put(2, "M");
          inputMap1.put(3, "M");
          inputMap1.put(5, "M");
          inputMap1.put(6, "k");
          inputMap1.put(7, "g");
          inputMap1.put(9, "M");
          System.out.println("Given input: " + inputMap1);
          System.out.println("Output: " + uniqueValues(inputMap1));
          System.out.println("______________________________________________________");


        // Usage of concatenation
        System.out.println("Concatenation");     
        ArrayList<HashMap<String, Integer>> mapList1 = new ArrayList<>();
        mapList1.add(new HashMap<>() {{
            put("b", 55);
            put("t", 20);
            put("f", 26);
            put("n", 87);
            put("o", 93);
        }});
        mapList1.add(new HashMap<>() {{
            put("s", 95);
            put("f", 9);
            put("n", 11);
            put("o", 71);
        }});
        mapList1.add(new HashMap<>() {{
            put("f", 89);
            put("n", 82);
            put("o", 29);
        }});
        System.out.println("Given Lists: " + mapList1);
        System.out.println("Result: " + concatenateMap(mapList1));
        System.out.println("______________________________________________________");



    

    }
}
