/**
 * U1 class representing U1-rocket, a lightweight rocket
 */
class U1 extends Rocket {
    /**
     * Default constructor of U1 to initialize U1-rocket fields
     */
    U1() {
        setCost(100);
        setWeight(10000);
        setCurrentWeight(10000);
        setMaxWeight(18000);
    }

    /**
     * Returns either true or false indicating if the launch was successful or not
     * by calculating the chance of exploding using the probability equation and comparing it with a random number
     * Chance of launch explosion = 5% * (cargo carried / cargo limit)
     *
     * @return true if launch was successful, false otherwise
     */
    @Override
    public boolean launch() {
        chanceOfLaunchFailure = 0.05 * ((double) getCurrentWeight() - getWeight()) / (getMaxWeight() - getWeight());
        return chanceOfLaunchFailure <= Math.random() * 0.1;
    }

    /**
     * Returns either true or false indicating if the landing was successful or not
     * by calculating the chance of crashing using the probability equation and comparing it with a random number
     * Chance of landing crash = 1% * (cargo carried / cargo limit)
     *
     * @return true if landing was successful, false otherwise
     */
    @Override
    public boolean land() {
        chanceOfLandingFailure = 0.01 * ((double) (getCurrentWeight() - getWeight()) / (getMaxWeight() - getWeight()));
        return chanceOfLandingFailure <= Math.random() * 0.1;
    }
}
