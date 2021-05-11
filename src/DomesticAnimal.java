public class DomesticAnimal extends Animal{
    private String animalBreed; //Labrador Retriever, Highland cow, Domestic Shorthair
    private String animalPurpose; //Meat, milk, companionship, pest control

    public DomesticAnimal(){

    }

    public DomesticAnimal(String newAnimalName, String newDietType, boolean newIsDomesticated, String newAnimalBreed, String newAnimalPurpose) throws IllegalAnimalArgumentException{
        super(newAnimalName, newDietType, newIsDomesticated);
        this.setAnimalBreed(newAnimalBreed);
        this.setAnimalPurpose(newAnimalPurpose);
    }

    public String getAnimalBreed(){
        return animalBreed;
    }

    public void setAnimalBreed(String newAnimalBreed) throws IllegalAnimalArgumentException{
        if (newAnimalBreed == null || newAnimalBreed.length() < 1)
            throw new IllegalAnimalArgumentException("You must enter a breed for this animal!");
        this.animalBreed = newAnimalBreed;
    }

    public String getAnimalPurpose(){
        return animalPurpose;
    }

    public void setAnimalPurpose(String newAnimalPurpose) throws IllegalAnimalArgumentException{
        if (newAnimalPurpose == null || newAnimalPurpose.length() < 1)
            throw new IllegalAnimalArgumentException("You must enter a purpose for this animal!");
        this.animalPurpose = newAnimalPurpose;
    }

    public String toString(){
        return super.toString() + "Domesticated Animal [Animal Breed=" + animalBreed + ", Animal Purpose=" + animalPurpose + "]";
    }
}
