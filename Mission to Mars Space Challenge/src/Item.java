/**
 * Item class representing an item in the payload to be carried by the rockets
 */
class Item {
    private String name;
    private int weight;

    /**
     * Takes a String and sets it as the name of the item
     *
     * @param name a String containing the name of the item
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Takes an integer and sets it as the weight of the item
     *
     * @param weight an integer containing the weight of the item
     */
    void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Returns the name of the item
     *
     * @return a String containing the name of the item
     */
    String getName() {
        return name;
    }

    /**
     * Returns the weight of the item
     *
     * @return an integer containing the weight of the item
     */
    int getWeight() {
        return weight;
    }
}
