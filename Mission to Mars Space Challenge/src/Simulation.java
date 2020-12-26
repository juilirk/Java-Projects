import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simulation class to generate payload, load it into rockets and run simulation
 */
class Simulation {
    /**
     * Loads all items to be carried in the mission from a text file and
     * returns an ArrayList of Items as the payload for the rockets
     * Each line in the text file consists of the item name followed by '=' then its weight in kg
     *
     * @param filePath a String containing the path to the text file containing the list of items to be carried
     * @return an ArrayList of Item objects containing the items
     * @throws FileNotFoundException if text file containing list of items is not found
     */
    ArrayList<Item> loadItems(String filePath) throws FileNotFoundException {
        ArrayList<Item> payload = new ArrayList<>();
        try {
            File manifest = new File(filePath);
            Scanner manifestScanner = new Scanner(manifest);
            String[] payloadItem;
            while (manifestScanner.hasNextLine()) {
                Item item = new Item();
                payloadItem = manifestScanner.nextLine().split("=");
                item.setName(payloadItem[0]);
                item.setWeight(Integer.parseInt(payloadItem[1]));
                payload.add(item);
            }
            manifestScanner.close();
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter weights in numeric format!");
        } catch (IndexOutOfBoundsException iob) {
            System.out.println("Please separate payload item name and weight with '='");
        }
        return payload;
    }

    /**
     * Takes an ArrayList of Items (payload) and loads them into U1 rockets
     * and returns an ArrayList of U1 rockets
     *
     * @param payload an ArrayList of Item objects to be carried
     * @return an ArrayList of Rocket objects containing the payload
     */
    ArrayList<Rocket> loadU1(ArrayList<Item> payload) {
        ArrayList<Rocket> u1Rockets = new ArrayList<>();
        Rocket u1Rocket = new U1();
        for (Item item : payload) {
            if (u1Rocket.canCarry(item)) {
                u1Rocket.carry(item);
            } else {
                u1Rockets.add(u1Rocket);
                u1Rocket = new U1();
                u1Rocket.carry(item);
            }
        }
        if (payload.size() != 0) {
            u1Rockets.add(u1Rocket);
        }
        return u1Rockets;
    }

    /**
     * Takes an ArrayList of Items (payload) and loads them into U2 rockets
     * and returns an ArrayList of U2 rockets
     *
     * @param payload an ArrayList of Item objects to be carried
     * @return an ArrayList of Rocket objects containing the payload
     */
    ArrayList<Rocket> loadU2(ArrayList<Item> payload) {
        ArrayList<Rocket> u2Rockets = new ArrayList<>();
        Rocket u2Rocket = new U2();
        for (Item item : payload) {
            if (u2Rocket.canCarry(item)) {
                u2Rocket.carry(item);
            } else {
                u2Rockets.add(u2Rocket);
                u2Rocket = new U2();
                u2Rocket.carry(item);
            }
        }
        if (payload.size() != 0) {
            u2Rockets.add(u2Rocket);
        }
        return u2Rockets;
    }

    /**
     * Takes an ArrayList of Rockets and attempts launching and landing them until both are successful for each rocket
     * and keeps track of the total budget required to send all the rockets safely to Mars and returns it
     *
     * @param rockets an ArrayList of Rockets to be sent to Mars
     * @return an integer depicting total budget required to send all rockets (including the crashed ones) to Mars
     */
    int runSimulation(ArrayList<Rocket> rockets) {
        int totalBudget = 0;
        for (Rocket rocket : rockets) {
            do {
                totalBudget += rocket.getCost();
            } while (!(rocket.launch() && rocket.land()));
        }
        return totalBudget;
    }
}