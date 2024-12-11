import space.Mission;

public class Main {
    public static void main(String[] args) {
        // Create instances of Mission
        Mission mission1 = new Mission("Mars", 500.0f);
        Mission mission2 = new Mission("Venus", 400.0f);
        Mission mission3 = new Mission("Mars", 500.0f); 
        Mission mission4 = new Mission("Jupiter", 600.0f);

        // Compare using compareTo()
        System.out.println("Comparing missions by cost and destination:");
        System.out.println("mission1 vs mission2: " + mission1.compareTo(mission2));
        System.out.println("mission1 vs mission3: " + mission1.compareTo(mission3)); 
        System.out.println("mission2 vs mission4: " + mission2.compareTo(mission4)); 

        // Check equality using equals()
        System.out.println("\nChecking equality of missions:");
        System.out.println("mission1 equals mission2: " + mission1.equals(mission2)); 
        System.out.println("mission1 equals mission3: " + mission1.equals(mission3)); 
        System.out.println("mission2 equals mission4: " + mission2.equals(mission4)); 

        // Compute and print hash codes
        System.out.println("\nHash codes of missions:");
        System.out.println("mission1 hashCode: " + mission1.hashCode()); 
        System.out.println("mission2 hashCode: " + mission2.hashCode()); 
        System.out.println("mission3 hashCode: " + mission3.hashCode()); 
        System.out.println("mission4 hashCode: " + mission4.hashCode()); 

        // Display the missions
        System.out.println("\nMission details:");
        System.out.println(mission1);
        System.out.println(mission2);
        System.out.println(mission3);
        System.out.println(mission4);
    }
}
