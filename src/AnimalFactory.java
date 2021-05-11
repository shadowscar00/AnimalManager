import java.util.Locale;

public class AnimalFactory {

    private static AnimalFactory instance;

    private AnimalFactory() {

    }

    public static AnimalFactory getInstance() {
        if( instance == null) {
            instance = new AnimalFactory();
        }
        return instance;
    }

    public Animal create(String animalType) throws IllegalAnimalArgumentException{
        switch ( animalType.toLowerCase()) {
            case "domesticated":
                return new DomesticAnimal("Default", "Default", true, "Default", "Default");
            case "wild":
                return new WildAnimal("Default", "Default", false, "Default", "Default");
            default:
                throw new IllegalAnimalArgumentException("Illegal type of animal sent to AnimalFactory");

        }
    }
}
