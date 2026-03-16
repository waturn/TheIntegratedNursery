import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Author: Grayson M
 */
public class Driver {
    public static void main(String[] args) {
        /**
         * Scanner for user input.
         */
        Scanner sc = new Scanner(System.in);

        /**
         * Prompt the user for their zone and how they want to evaluate nursery experience using static methods. 
         */
        int chosenZone = promptForZone(sc);
        String chosenNurseryEval = promptForNurseryEval(sc);

        /**
         * Resolve the chosen nursery evaluation to a Predicate<Plant> for use for evaluating each plant in the list.
         */
        Predicate<Plant> evaluator = resolveEvaluator(chosenNurseryEval);

        /**
         * Create an ArrayList of type Plant to hold all the plants we will create. 
         */
        ArrayList<Plant> plantList = new ArrayList<>();

        /**
         * Make some trees and flowering plant objects from static, hardcoded data.
         */
        makeTrees(plantList);
        makeFloweringPlants(plantList);

        /**
         * Creates a new plastic plant object using user input.
         */
        Plant plastic = makePlant(sc);
        plantList.add(plastic);

        /**
         * Display the results to the user using a static method.
         */
        displayPlants(plantList, chosenZone, chosenNurseryEval, evaluator);

        sc.close();

    }

    /**
     * Static method for creating a new Plant object with the user's input.
     * It will call other static methods to prompt the user and store their inputs as variables.
     * @param sc
     * @return
     */
    private static Plant makePlant(Scanner sc) {
        String commonName = promptForCommonName(sc);
        String genusSpecies = promptForGenusSpecies(sc);
        LocalDate dateIntroduced = promptForDate(sc);

        return new Plant(genusSpecies, commonName, null, dateIntroduced);
    }

    /**
     * Static method to prompt the user for their zone.
     * @param sc
     * @return
     */
    private static int promptForZone(Scanner sc) {
        while (true) {
            System.out.println("What zone are you in?");
            String input = sc.nextLine();

            try {
                int zone = Integer.parseInt(input);
                if (zone >= 1 && zone <= 11) {
                    return zone;
                }
                System.out.println("Invalid zone.");
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid integer.");
            }

            System.out.println();
        }
    }

    /**
     * Static method to prompt the user for how they want to evaluate nursery experience for their plant.
     * @param sc
     * @return
     */
    private static String promptForNurseryEval(Scanner sc) {
        while (true) {
            System.out.println("\nHow should we evaluate nursery experience? [Enter 'least' or 'most']");
            String input = sc.nextLine().trim().toLowerCase();

            if ("least".equals(input) || "most".equals(input)) {
                return input;
            } else {
                System.out.println("Invalid input.\n");
            }

            
        }
    }

    /**
     * Static method to prompt the user for the common name of the plant.
     * @param sc
     * @return
     */
    private static String promptForCommonName(Scanner sc) {
        while (true) {
            System.out.println("\nEnter the common name of the plant.");
            String commonName = sc.nextLine().trim();

            if (Plant.validateCommonName(commonName)) {
                return commonName;
            }
        }
    }

    /**
     * Static method to prompt the user for the genus and species of the plant.
     * @param sc
     * @return
     */
    private static String promptForGenusSpecies(Scanner sc) {
        while (true) {
            System.out.println("\nEnter the scientific name of the plant. [Genus species]");
            String genusSpecies = sc.nextLine().trim();

            if (Plant.validateGenusSpecies(genusSpecies)) {
                return genusSpecies;
            }

            System.out.println();
        }
    }

    /**
     * Static method to prompt the user for the date the plant was introduced to the nursery.
     * @param sc
     * @return
     */
    private static LocalDate promptForDate(Scanner sc) {
        while (true) {
            System.out.println("\nEnter when the plant was first introduced to the nursery [YYYY-MM-DD]");
            String dateText = sc.nextLine().trim();

            try {
                return LocalDate.parse(dateText);
            } catch (DateTimeParseException ex) {
                System.out.println("Invalid date format.\n");
            }
        }
    }

    /**
     * Static method to add a range of zones to a plant.
     * @param plant
     * @param firstZone
     * @param lastZone
     */
    private static void addZones(Plant plant, int firstZone, int lastZone) {
        for (int z = firstZone; z <= lastZone; z++) {
            plant.addZone(z);
        }
    }

    /**
     * Static method to create hardcoded tree objects and add them to plants.
     * @param plants
     */
    private static void makeTrees(ArrayList<Plant> plants) {
        Trees maple = new Trees(
            "Acer palmatum",
            "Bloodgood Japanese Maple",
            PlantType.GYMNOSPERM,
            LocalDate.of(2022, 6, 2),
            25.0,
            true
        );
        addZones(maple, 6, 8);
        plants.add(maple);

        Trees hemlock = new Trees(
            "Tsuga canadensis",
            "Hemlock Tree",
            PlantType.GYMNOSPERM,
            LocalDate.of(2013, 1, 23),
            10.0,
            true
        );
        addZones(hemlock, 3, 7);
        plants.add(hemlock);
    }

    /**
     * Static method to create hardcoded flowering plant objects and add them to plants.
     * @param plants
     */
    private static void makeFloweringPlants(ArrayList<Plant> plants) {
        FloweringPlants jasmine = new FloweringPlants(
            "Murraya paniculata",
            "Orange Jasmine",
            PlantType.ANGIOSPERM,
            LocalDate.of(2007, 3, 2),
            "white",
            true
        );
        addZones(jasmine, 9, 9);
        plants.add(jasmine);

        FloweringPlants lily = new FloweringPlants(
            "Convallaria majalis",
            "Lily-of-the-Valley",
            PlantType.ANGIOSPERM,
            LocalDate.of(2011, 10, 5),
            "white, pink, or red",
            true
        );
        addZones(lily, 5, 8);
        plants.add(lily);
    }

    /**
     * Static method to resolve the user's choice of nursery evaluation to a Predicate<Plant> for use in evaluating each plant in the list.
     * @param evaluatorType
     * @return
     */
    private static Predicate<Plant> resolveEvaluator(String evaluatorType) {
        if ("least".equals(evaluatorType)) {
            return Plant.evaluators.get("least_experienced");
        }
        return Plant.evaluators.get("most_experienced");
    }

    /**
     * Static method to display the results to the user.
     * @param plants
     * @param userZone
     * @param evaluatorType
     * @param evaluator
     */
    private static void displayPlants(ArrayList<Plant> plants, int userZone, String evaluatorType, Predicate<Plant> evaluator) {
        System.out.println("\n--------------- RESULTS -------------\n");

        String evalPrint = evaluatorType + " experience";

        for (Plant p : plants) {
            System.out.println(p.getId());
            System.out.println(p);

            String className = p.getClass().getSimpleName();
            if ("Trees".equals(className)) {
                className = "Tree";
            } else if ("FloweringPlants".equals(className)) {
                className = "FloweringPlant";
            }
            System.out.println("Type: " + className);

            System.out.println("introduced on " + p.getDateIntroduced());

             if (p instanceof Trees) {
                Trees tree = (Trees) p;
                String speed = tree.getheight() >= 20.0 ? "fast" : "slow";
                System.out.println("a " + speed + " growing tree");
            } else if (p instanceof FloweringPlants) {
                FloweringPlants fp = (FloweringPlants) p;
                String feature = fp.isAttractsPollinators() ? "pollinator-friendly" : "ornamental";
                System.out.println(feature + " plant with " + fp.getFlowerColor() + " colors");
            }
            
            System.out.println(evalPrint + ": " + evaluator.test(p));
            System.out.println("good for your zone: " + p.growInZone(userZone) + "\n");
        }
    }
}
