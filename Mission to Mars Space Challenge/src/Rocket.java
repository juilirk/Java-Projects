/**
 * Rocket class implementing methods in SpaceShip interface and providing helper methods for Rocket attributes
 */
class Rocket implements SpaceShip {
    private int cost;
    private int weight;
    private int currentWeight;
    private int maxWeight;
    double chanceOfLaunchFailure;
    double chanceOfLandingFailure;

    /**
     * Returns either true or false indicating if the launch was successful or not
     * When U1 and U2 classes extend the Rocket class, they will override this method
     * to return true or false based on the actual probability of launch success/failure of each type
     * For now, they will always return true
     *
     * @return true to indicate launch is successful
     */
    @Override
    public boolean launch() {
        return true;
    }

    /**
     * Returns either true or false indicating if the landing was successful or not
     * When U1 and U2 classes extend the Rocket class, they will override this method
     * to return true or false based on the actual probability of landing success/failure of each type
     * For now, they will always return true
     *
     * @return true to indicate landing is successful
     */
    @Override
    public boolean land() {
        return true;
    }

    /**
     * Takes an Item as an argument and returns true if the rocket can carry the item
     * or false if it will exceed the weight limit
     *
     * @param item an Item object containing the item to be carried
     * @return true if the rocket can carry the item or false if it will exceed the weight limit
     */
    @Override
    public boolean canCarry(Item item) {
        return getCurrentWeight() + item.getWeight() <= getMaxWeight();
    }

    /**
     * Takes an Item object and updates the current weight of the rocket
     *
     * @param item an Item object containing the item to be carried
     */
    @Override
    public void carry(Item item) {
        currentWeight += item.getWeight();
        setCurrentWeight(currentWeight);
    }

    /**
     * Returns the cost of the rocket
     *
     * @return an integer containing the cost of the rocket
     */
    int getCost() {
        return cost;
    }

    /**
     * Takes an integer and sets it as the cost of the rocket
     *
     * @param cost an integer containing the cost of the rocket
     */
    void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Returns the weight of the rocket
     *
     * @return an integer representing the weight of the rocket
     */
    int getWeight() {
        return weight;
    }

    /**
     * Takes an integer and sets it as the weight of the rocket
     *
     * @param weight an integer representing the weight of the rocket
     */
    void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Returns the current weight of the rocket
     *
     * @return an integer representing the weight of the rocket
     */
    int getCurrentWeight() {
        return currentWeight;
    }

    /**
     * Takes an integer and sets it as the current weight of the rocket
     *
     * @param currentWeight an integer representing the current weight of the rocket
     */
    void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    /**
     * Returns the maximum weight of the rocket (with cargo)
     *
     * @return an integer representing the maximum weight of the rocket
     */
    int getMaxWeight() {
        return maxWeight;
    }

    /**
     * Takes an integer and sets it as the maximum weight of the rocket
     *
     * @param maxWeight an integer representing the maximum weight of the rocket
     */
    void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
