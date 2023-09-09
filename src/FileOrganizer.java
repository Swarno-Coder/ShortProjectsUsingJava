import java.io.File;

public class FileOrganizer {
    public static void main(String[] args) {
        // Replace "sourceDir" with the directory you want to organize
        String sourceDir = "C:\\SourceDirectory";

        File directory = new File(sourceDir);

        if (!directory.isDirectory()) {
            System.out.println("Invalid source directory.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found in the source directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
                String destinationDir = sourceDir + File.separator + fileExtension;

                File destDir = new File(destinationDir);
                if (!destDir.exists()) {
                    destDir.mkdir();
                }

                File newFile = new File(destinationDir + File.separator + fileName);
                file.renameTo(newFile);

                System.out.println("Moved: " + fileName + " to " + fileExtension);
            }
        }

        System.out.println("File organization completed.");
    }
}
