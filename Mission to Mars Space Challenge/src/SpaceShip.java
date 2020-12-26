/**
 * SpaceShip interface containing signatures of methods to be implemented by Rocket class
 */
interface SpaceShip {
    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    void carry(Item item);
}
