package TestStoreStrings;

import java.util.ArrayList;

public class TestStoreStrings {
    public static void main(String[] args) {
        ArrayList<String> states = new ArrayList<String>(5);
        states.add(0, "Virginia");
        states.add(1, "New York");
        states.add(2, "Michigan");
        states.add(3, "Indiana");
        states.add(4, "Missouri");
        states.sort(null);

        for (String state : states) {
            System.out.println(state);
        }

        if (StoreStrings.duplicateString(states)) {
            System.out.println(
                    "Error! Contains more than one entry of the same state in the list. Must have only one entry for the state in the list");
        } else {
            System.out.println(StoreStrings.count(states));
        }
    }

}
