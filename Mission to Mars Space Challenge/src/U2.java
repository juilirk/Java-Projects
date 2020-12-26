/**
 * U2 class representing U2-rocket, a heavier rocket
 */
class U2 extends Rocket {
    /**
     * Default constructor of U2 to initialize U2-rocket fields
     */
    U2() {
        setCost(120);
        setWeight(18000);
        setCurrentWeight(18000);
        setMaxWeight(29000);
    }

    /**
     * Returns either true or false indicating if the launch was successful or not
     * by calculating the chance of exploding using the probability equation and comparing it with a random number
     * Chance of launch explosion = 4% * (cargo carried / cargo limit)
     *
     * @return true if launch was successful, false otherwise
     */
    @Override
    public boolean launch() {
        chanceOfLaunchFailure = 0.04 * ((double) getCurrentWeight() - getWeight()) / (getMaxWeight() - getWeight());
        return chanceOfLaunchFailure <= Math.random() * 0.1;
    }

    /**
     * Returns either true or false indicating if the landing was successful or not
     * by calculating the chance of crashing using the probability equation and comparing it with a random number
     * Chance of landing crash = 8% * (cargo carried / cargo limit)
     *
     * @return true if landing was successful, false otherwise
     */
    @Override
    public boolean land() {
        chanceOfLandingFailure = 0.08 * ((double) getCurrentWeight() - getWeight()) / (getMaxWeight() - getWeight());
        return chanceOfLandingFailure <= Math.random() * 0.1;
    }
}
