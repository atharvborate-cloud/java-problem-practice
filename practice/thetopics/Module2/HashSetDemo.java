package practice.thetopics.Module2;
import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {

        HashSet<String> cities = new HashSet<>();

        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Mumbai");   // duplicate — silently ignored
        cities.add("Pune");

        System.out.println(cities.size());            // 3 — not 4
        System.out.println(cities.contains("Delhi")); // true

        cities.remove("Pune");

        // Looping
        for (String city : cities) {
            System.out.println(city);   // order not guaranteed
        }
    }
}

