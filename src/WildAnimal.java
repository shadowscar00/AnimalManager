public class WildAnimal extends Animal{
    private String animalHabitat; //eg: Jungle, Forest, Savannah, Prairie
    private String animalRegion; //eg: United States, Subsaharan Africa, Antarctica

    public WildAnimal(){

    }

    public WildAnimal(String newAnimalName, String newDietType, boolean newIsDomesticated, String newAnimalHabitat, String newAnimalRegion) throws IllegalAnimalArgumentException{
        super(newAnimalName, newDietType, newIsDomesticated);
        this.setAnimalHabitat(newAnimalHabitat);
        this.setAnimalRegion(newAnimalRegion);
    }

    public String getAnimalHabitat(){
        return animalHabitat;
    }

    public void setAnimalHabitat(String newAnimalHabitat) throws IllegalAnimalArgumentException{
        if (newAnimalHabitat == null || newAnimalHabitat.length() < 1)
            throw new IllegalAnimalArgumentException("You must enter a habitat for this animal!");
        this.animalHabitat = newAnimalHabitat;

    }

    public String getAnimalRegion(){
        return animalRegion;
    }

    public void setAnimalRegion(String newAnimalRegion) throws IllegalAnimalArgumentException{
        if (newAnimalRegion == null || newAnimalRegion.length() < 1)
            throw new IllegalAnimalArgumentException("You must enter a region for this animal!");
        this.animalRegion = newAnimalRegion;

    }

    public String toString(){
        return super.toString() + "Wild Animal [Animal Habitat=" + animalHabitat + ", Animal Region=" + animalRegion + "]";
    }
}
