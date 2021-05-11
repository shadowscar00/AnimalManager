public class IllegalAnimalArgumentException extends Exception{
    public IllegalAnimalArgumentException(){
        super("Illegal value sent to the method for animal.");
    }
    public IllegalAnimalArgumentException(String msg) {
        super(msg);
    }
}
