import java.util.HashMap;
/**
 * Author: Grayson M
 * 
 * The Zone class represents a zone a plant can grow in. It is defined by a zone number, a low temperature in Fahrenheit, and a high temperature in Fahrenheit. 
 * The class provides getters for all variables and a static method to initialize a map of zones for use in other classes.
 */
public class Zone {

    /**
     * The zone number. Can be from 1-11.
     */
    private final int zoneNumber;

    /**
     * The Low temperature for this zone, in Fahrenheit.
     */
    private final int lowTempF;

    /**
     * The High temperature for this zone, in Fahrenheit.
     */
    private final int highTempF;

    /**
     * Private constructor for the Zone class.
     * @param zoneNumber
     * @param lowTempF
     * @param highTempF
     */
    private Zone(int zoneNumber, int lowTempF, int highTempF) {
        this.zoneNumber = zoneNumber;
        this.lowTempF = lowTempF;
        this.highTempF = highTempF;
    }

    /**
     * Getters and setters for all methods.
     * @return
     */
    public int getZoneNumber() {
        return zoneNumber;
    }
    public int getLowTempF() {
        return lowTempF;
    }
    public int getHighTempF() {
        return highTempF;
    }

    /**
     * Static method of type HashMap to initialize a map of zones. This method will be called in the Plant class.
     * @return
     */
    private static HashMap<Integer, Zone> initialiseZones() {
        HashMap<Integer, Zone> zones = new HashMap<>();
        zones.put(1, new Zone(1, -60, -50));
        zones.put(2, new Zone(2, -50, -40));
        zones.put(3, new Zone(3, -40, -30));
        zones.put(4, new Zone(4, -30, -20));
        zones.put(5, new Zone(5, -20, -10));
        zones.put(6, new Zone(6, -10, 0));
        zones.put(7, new Zone(7, 0, 10));
        zones.put(8, new Zone(8, 10, 20));
        zones.put(9, new Zone(9, 20, 30));
        zones.put(10, new Zone(10, 30, 40));
        zones.put(11, new Zone(11, 40, 50));
        return zones;
    }

    /**
     * A static final HashMap to hold the zones initialized by the initialiseZones method. 
     */
    private static final HashMap<Integer, Zone> zones = initialiseZones();

    /**
     * Getter for the zones map.
     * @return
     */
    public static HashMap<Integer, Zone> getZones() {
        return zones;
    }
}
