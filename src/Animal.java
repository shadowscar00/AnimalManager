import java.io.Serializable;

public class Animal implements Serializable {
    private String animalName; //Tiger, Dog, etc
    private String dietType; //Carnivore, herbivore, omnivore, pescivore
    private boolean isDomesticated; //true for domestic, false for wild
    private static final long serialVersionUID = 1L;

    public Animal(){

    }

    public Animal(String newAnimalName, String newDietType, boolean newIsDomesticated) throws IllegalAnimalArgumentException{
        this.setAnimalName(newAnimalName);
        this.setDietType(newDietType);
        this.setDomesticated(newIsDomesticated);
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String newAnimalName) throws IllegalAnimalArgumentException{
        if (newAnimalName == null || newAnimalName.length() < 1)
            throw new IllegalAnimalArgumentException("You must enter an Animal Name!");
        this.animalName = newAnimalName;

    }

    public String getDietType(){
        return dietType;
    }

    public void setDietType(String newDietType) throws IllegalAnimalArgumentException{
        if (newDietType == null || newDietType.length() < 1)
            throw new IllegalAnimalArgumentException("You must enter a diet type for this animal!");
        this.dietType = newDietType;
    }



    public boolean getDomesticated(){
        return isDomesticated;
    }

    public void setDomesticated(boolean newIsDomesticated) {
        this.isDomesticated = newIsDomesticated;
    }

    public String toString(){
        return "Animal [Animal Name=" + animalName + ", Animal Diet=" + dietType + ", Domesticated=" + isDomesticated + "]";
    }

}
