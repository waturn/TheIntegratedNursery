import java.time.LocalDate;
//Author: stephen t. :)

//creating the flowering plants class that extends the plant class
public class FloweringPlants extends Plant {
    private final String flowerColor;
    private final boolean attractsPollinators;

    //creates the tree object with the given parameters
    public FloweringPlants(String genusSpecString, String commonName, PlantType plantGroup, LocalDate dateIntroduced, String flowerColor, boolean attractsPollinators) {
        super(genusSpecString, commonName, plantGroup, dateIntroduced);
        this.flowerColor = flowerColor;
        this.attractsPollinators = attractsPollinators;
    }

    //getters for the variables
    public String getFlowerColor() {
        return flowerColor;
    }

    public boolean isAttractsPollinators() {
        return attractsPollinators;

    }
}