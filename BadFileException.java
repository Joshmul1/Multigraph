public class BadFileException extends Exception{

    public BadFileException(String errorMessage){

        System.out.println("Error with file input:");
        System.out.println("The reason this occurred is because "+ errorMessage);
        System.exit(1);

    }


}
