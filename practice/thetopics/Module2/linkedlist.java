package practice.thetopics.Module2;
import java.util.LinkedList;

public class linkedlist {

    public static void main(String[] args) {
        LinkedList<String> List = new LinkedList<>();

        List.add("Atharv");
        List.addFirst("Virat");  // ADD at the beggining
        List.addLast("Dhoni");   // Add at last
        List.removeFirst();         // remove from the first
        System.out.println(List.getFirst()); // prints first




    }

}
