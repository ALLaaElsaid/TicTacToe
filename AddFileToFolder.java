
import java.io.File;
import java.io.IOException;

public class AddFileToFolder {
    public static void main(String[] args) {
        // The path to the folder where you want to add the file
        String folderPath = "D:\\Network Programming\\TicTacToeGUI";

        // The name of the file you want to add
        String fileName = "YourJavaFile.java";

        // Create a File object for the directory
        File directory = new File(folderPath);

        // Create the directory if it does not exist
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create a File object for the file to be added
        File file = new File(directory, fileName);

        // Create the file in the directory
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

