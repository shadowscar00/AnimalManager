import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageAnimals {

    public static void main(String[] args) {

        ArrayList<Animal> animalArray = new ArrayList<Animal>();
        Scanner input = new Scanner(System.in);
        final File animalFile = new File("animals.dat");

        if (animalFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animals.dat"))) {
                Animal tempAnimal;
                while ((tempAnimal = (Animal) ois.readObject()) != null) {
                    animalArray.add(tempAnimal);
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage() + "\n");
            } catch (IOException ex) {
                System.out.println(ex.getMessage() + "\n");
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + "\n");
            }
        }

        int menuChoice = 0;
        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Add a new animal.");
            System.out.println("2. View all animals.");
            System.out.println("3. View only domestic animals.");
            System.out.println("4. View only wild animals.");
            System.out.println("5. Exit the program.");

            try {
                menuChoice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Please only enter numeric values for your menu choice");
            }

            if (menuChoice == 1) {
                Animal tempAnimal = new Animal();
                boolean error = false;
                do {
                    try {
                        System.out.println("Please enter the name of your animal: ");
                        tempAnimal.setAnimalName(input.nextLine());
                        error = false;
                    } catch (IllegalAnimalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        error = true;
                    }
                } while (error == true);

                do {
                    try {
                        System.out.println("Please enter the diet type of your animal: ");
                        tempAnimal.setDietType(input.nextLine());
                        error = false;
                    } catch (IllegalAnimalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        error = true;
                    }
                } while (error == true);

                do {
                    try {
                        System.out.println("Is your animal domesticated? Please enter 'true' or 'false': ");
                        tempAnimal.setDomesticated(Boolean.parseBoolean(input.nextLine()));
                        error = false;
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        error = true;
                    }
                } while (error == true);
                if (tempAnimal.getDomesticated() == true) {
                    DomesticAnimal tempDomestic = new DomesticAnimal();
                    try {
                        tempDomestic.setAnimalName(tempAnimal.getAnimalName());
                        tempDomestic.setDietType(tempAnimal.getDietType());
                        tempDomestic.setDomesticated(tempAnimal.getDomesticated());
                    } catch (IllegalAnimalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    do {
                        try {
                            System.out.println("Please enter the breed of your animal: ");
                            tempDomestic.setAnimalBreed(input.nextLine());
                            error = false;
                        } catch (IllegalAnimalArgumentException ex) {
                            System.out.println(ex.getMessage());
                            error = true;
                        }
                    } while (error == true);

                    do {
                        try {
                            System.out.println("Please enter your animal's purpose (example: companionship, milk, wool, meat): ");
                            tempDomestic.setAnimalPurpose(input.nextLine());
                            error = false;
                        } catch (IllegalAnimalArgumentException ex) {
                            System.out.println(ex.getMessage());
                            error = true;
                        }
                    } while (error == true);
                    animalArray.add(tempDomestic);
                    menuChoice = 0;

                } else {
                    WildAnimal tempWild = new WildAnimal();
                    try {
                        tempWild.setAnimalName(tempAnimal.getAnimalName());
                        tempWild.setDietType(tempAnimal.getDietType());
                        tempWild.setDomesticated(tempAnimal.getDomesticated());

                    } catch (IllegalAnimalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    do {
                        try {
                            System.out.println("Please enter your animal's habitat (example: jungle, plains, mountains, reefs): ");
                            tempWild.setAnimalHabitat(input.nextLine());
                            error = false;
                        } catch (IllegalAnimalArgumentException ex) {
                            System.out.println(ex.getMessage());
                            error = true;
                        }
                    } while (error == true);
                    do {
                        try {
                            System.out.println("Please enter your animal's region (example: Western Europe, Indian Ocean, Central Africa): ");
                            tempWild.setAnimalRegion(input.nextLine());
                            error = false;
                        } catch (IllegalAnimalArgumentException ex) {
                            System.out.println(ex.getMessage());
                            error = true;
                        }
                    } while (error == true);
                    animalArray.add(tempWild);

                    menuChoice = 0;

                }


            } else if (menuChoice == 2) {
                if (animalArray.isEmpty())
                    System.out.println("Sorry! There are no animals to list.");
                else {
                    for (int i = 0; i < animalArray.size(); i++)
                        System.out.println(animalArray.get(i).toString());
                }
                menuChoice = 0;
            } else if (menuChoice == 3) {
                for (int i = 0; i < animalArray.size(); i++) {
                    if (animalArray.get(i).getDomesticated() == true) {
                        System.out.println(animalArray.get(i).toString());
                    }
                }

                menuChoice = 0;

            } else if (menuChoice == 4) {
                for (int i = 0; i < animalArray.size(); i++) {
                    if (animalArray.get(i).getDomesticated() == false) {
                        System.out.println(animalArray.get(i).toString());
                    }
                }

                menuChoice = 0;

            } else if (menuChoice == 5) {
                if (animalArray.isEmpty()) {
                    System.out.println("Thank you for using the Animal Manager :)");
                    System.exit(-1);
                } else {
                    try (FileOutputStream fos = new FileOutputStream(animalFile);
                         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                        for (int i = 0; i < animalArray.size(); i++) {
                            oos.writeObject(animalArray.get(i));
                        }
                        System.out.println("Your animals have been saved! Thank you for using the Animal Manager :)");
                        System.exit(-1);
                    } catch (FileNotFoundException ex) {
                        System.out.println("File animals.dat not found");
                    } catch (IOException ex) {
                        System.out.println("Input/Output error");
                        System.out.println(ex.getMessage());
                    }

                }

            } else {
                System.out.println("Invalid value. Please enter a value of 1 - 5");
                menuChoice = 0;
            }
        } while (menuChoice == 0);

        input.close();

    }
}
