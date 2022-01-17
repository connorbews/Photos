package Photo_Repository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Photo_List {
    private ArrayList<Photo> gallery = new ArrayList<Photo>();

    public void add_Photo(){

        /*String type_of_shoe;
        String name_of_file;
        String colorway;
        int year_of_release;
        LocalDateTime time_of_upload;
        String imagePath;
        String destinationFile = "Photo_database\\";
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Please enter the type of shoe: ");
        type_of_shoe = scanner.nextLine();
        System.out.println("Please enter the name of file: ");
        name_of_file = scanner.nextLine();
        System.out.println("Please enter the colorway of shoe: ");
        colorway = scanner.nextLine();
        System.out.println("Please enter the pathway of photo: ");
        imagePath = scanner.nextLine();
        System.out.println("Please enter the year the shoe was released: ");
        year_of_release = scanner.nextInt();
        time_of_upload = LocalDateTime.now();
        gallery.add(new Photo(type_of_shoe, colorway, year_of_release, time_of_upload, imagePath));
        System.out.println(destinationFile + name_of_file);
        Path begin = Paths.get(imagePath);
        Path end = Paths.get((destinationFile + name_of_file));
        try {
            Files.move(begin, end);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void print_Gallery(){
        for (int i = 0; i < gallery.size(); i++){
            System.out.println(gallery.get(i).getType_of_shoe());
            System.out.println(gallery.get(i).getColorway());
            System.out.println(gallery.get(i).getYear_of_release());
            System.out.println(gallery.get(i).getTime_of_upload());
            System.out.println(gallery.get(i).getImagePath());
        }
    }
}
