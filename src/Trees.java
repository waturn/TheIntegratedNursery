import java.time.LocalDate; 


    public class Trees extends Plant{
        private double height;
        private boolean evergreen;
    
    
    public Trees(String name, String species, PlantType type, LocalDate plantedOn){
        super(name, species, type, plantedOn);
    }

    public Trees(String genusSpecString, String commonName, PlantType plantGroup, LocalDate dateIntroduced, double height, boolean evergreen) {
        super(genusSpecString, commonName, plantGroup, dateIntroduced);
        this.height = height;
        this.evergreen = evergreen;
    }

    public double getheight() {
        return height;
    }

    public boolean isEvergreen() {
        return evergreen;
    }
}