import java.io.FileNotFoundException;

public class InvalidQuizFormatException extends FileNotFoundException {
    public void printException(){
        System.out.println("Wrong file input!!!");
        System.exit(0);
    }
}
