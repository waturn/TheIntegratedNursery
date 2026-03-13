import java.time.LocalDate;
import java.util.HashMap;

/**
 * The Plant class represents a plant with its genus name, common name, plant group, date first introduced, and zones it can grow in.
 * Each plant is assigned a unique ID starting from 4901.
 * The class provides getters and setters for all variables and a method for assigning zones to the plant.
 */
public class Plant {

    /**
     * Unique id for each plant. Starts at 4901 and increments up.
     */
    private long id;

    /**
     * Helper variable for incrementing id. 
     * Is incremented in the constructor to ensure each object gets a unique id.
     */
    private static long nextId = 4901;

    /**
     * The genus name of the plant.
     */
    private String genusSpecies;

    /**
     * The common name of the plant.
     */
    private String commonName;

    /**
     * The plant group of the plant, represented as an enum.
     */
    private PlantType plantGroup;

    /**
     * The date the plant was first introduced.
     */
    private LocalDate dateIntroduced;

    /**
     * A map of zones for the Plant class.
     * The key is the zone number and the value is the Zone object.
     */
    private HashMap<Integer, Zone> zones = new HashMap<>();

    /**
     * Constructor for the Plant class.
     * @param genusSpecies
     * @param commonName
     * @param plantGroup
     * @param dateIntroduced
     */
    public Plant(String genusSpecies, String commonName, PlantType plantGroup, LocalDate dateIntroduced) {
        this.id = nextId++;
        this.genusSpecies = genusSpecies;
        this.commonName = commonName;
        this.plantGroup = plantGroup;
        this.dateIntroduced = dateIntroduced;
    }

    /**
     * Getters and setters for all variables.
     * @return
     */
    private long getId() {
        return id;
    }
    private String getGenusSpecies() {
        return genusSpecies;
    }
    private String getCommonName() {
        return commonName;
    }
    private PlantType getPlantGroup() {
        return plantGroup;
    }
    private LocalDate getDateIntroduced() {
        return dateIntroduced;
    }
    private HashMap<Integer, Zone> getZones() {
        return zones;
    }
    private long setId(long id) {
        this.id = id;
        return id;
    }
    private String setGenusSpecies(String genusSpecies) {
        this.genusSpecies = genusSpecies;
        return genusSpecies;
    }
    private String setCommonName(String commonName) {
        this.commonName = commonName;
        return commonName;
    }
    private PlantType setPlantGroup(PlantType plantGroup) {
        this.plantGroup = plantGroup;
        return plantGroup;
    }
    private LocalDate setDateIntroduced(LocalDate dateIntroduced) {
        this.dateIntroduced = dateIntroduced;
        return dateIntroduced;
    }

    /**
     * Adds a zone to the plant's zones map using the zone number.
     * The method retrieves the Zone object from the Zone class's static zones map.
     * @param zoneNumber
     */
    public void addZone(int zoneNumber) {
        Zone z = Zone.getZones().get(zoneNumber);
        if (z == null) {
            throw new IllegalArgumentException("Invalid zone number: " + zoneNumber);
        } else {
            zones.put(zoneNumber, z);
        }
    }
}