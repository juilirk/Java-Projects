import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Driver class to run simulations and determine which type of rocket to use
 */
public class Main {
    public static void main(String[] args) {
        Simulation marsSimulation = new Simulation();
        //ArrayLists to store payloads of both phases
        ArrayList<Item> phaseOnePayload = new ArrayList<>();
        ArrayList<Item> phaseTwoPayload = new ArrayList<>();
        int u1Budget = 0;
        int u2Budget = 0;
        //Load Phase-1 payload from text file
        try {
            phaseOnePayload = marsSimulation.loadItems("specs/phase-1.txt");
        } catch (FileNotFoundException fnf) {
            System.out.println("Phase-1 Payload file not found!");
        }
        //Load Phase-2 payload from text file
        try {
            phaseTwoPayload = marsSimulation.loadItems("specs/phase-2.txt");
        } catch (FileNotFoundException fnf) {
            System.out.println("Phase-2 Payload file not found!");
        }
        //Load payloads into U1 Rockets for both phases
        ArrayList<Rocket> u1RocketsPhaseOne = marsSimulation.loadU1(phaseOnePayload);
        ArrayList<Rocket> u1RocketsPhaseTwo = marsSimulation.loadU1(phaseTwoPayload);
        //Run simulations and track budget required for U1 rocket
        u1Budget += marsSimulation.runSimulation(u1RocketsPhaseOne);
        u1Budget += marsSimulation.runSimulation(u1RocketsPhaseTwo);
        //Load payloads into U2 Rockets for both phases
        ArrayList<Rocket> u2RocketsPhaseOne = marsSimulation.loadU2(phaseOnePayload);
        ArrayList<Rocket> u2RocketsPhaseTwo = marsSimulation.loadU2(phaseTwoPayload);
        //Run simulations and track budget required for U1 rocket
        u2Budget += marsSimulation.runSimulation(u2RocketsPhaseOne);
        u2Budget += marsSimulation.runSimulation(u2RocketsPhaseTwo);
        System.out.println("Budget required for sending U1 Rockets: $" + u1Budget + " million.");
        System.out.println("Budget required for sending U2 Rockets: $" + u2Budget + " million.");
        //Display which rocket type to use
        if (u1Budget < u2Budget) {
            System.out.println("\nIt is cheaper to use U1 Rockets.");
        } else if (u2Budget < u1Budget) {
            System.out.println("\nIt is cheaper to use U2 Rockets.");
        } else {
            System.out.println("Both cost the same. It is okay to use either.");
        }
    }
}
