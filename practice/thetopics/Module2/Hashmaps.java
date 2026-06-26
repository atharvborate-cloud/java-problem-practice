package practice.thetopics.Module2;
import java.util.HashMap;

public class Hashmaps {
    public static void main(String[] args) {
        HashMap<String, Integer> marks = new HashMap<>();

        marks.put("Atharv", 100);
        marks.put("Jayesh ", 95);
        marks.put("Nilesh ", 85);
        marks.put("Priya", 78);
        marks.put("Virat", 90);

        System.out.println(marks.get("Rahul"));        // 92
        System.out.println(marks.get("Unknown"));      // null — key not found

        // Safe access with default
        System.out.println(marks.getOrDefault("Unknown", 0));  // 0

        // Checking
        System.out.println(marks.containsKey("Priya"));    // true
        System.out.println(marks.containsValue(92));       // true

        // Removing
        marks.remove("Priya");

        // Size
        System.out.println(marks.size());   // 2

        // Looping — most important
        for (String key : marks.keySet()) {
            System.out.println(key + " → " + marks.get(key));
        }

        // Loop over entries (cleaner)
        for (var entry : marks.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

    }

}