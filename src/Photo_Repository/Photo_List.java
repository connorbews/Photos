package Photo_Repository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Photo_List {
    private ArrayList<Photo> gallery;

    public Photo_List(){
        gallery = new ArrayList<Photo>();
    }

    public void add_Photo(String reference, Boolean priv_or_pub, String name_of_file){
        LocalDateTime time_of_upload = LocalDateTime.now();
        String destinationFile = "Photo_database\\";

        Photo temp = new Photo(time_of_upload, reference, (destinationFile + name_of_file), priv_or_pub);

        gallery.add(temp);
        Path begin = Paths.get(reference);
        Path end = Paths.get((destinationFile + name_of_file));
        try {
            Files.move(begin, end);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print_Gallery(){
        for (int i = 0; i < gallery.size(); i++){
            System.out.println(gallery.get(i).getTime_of_upload());
            System.out.println(gallery.get(i).getImagePath());
        }
    }

    public int get_Length() {
        return gallery.size();
    }

    public String index_ReturnImagePath (int index) {
        return gallery.get(index).getImagePath();
    }

    public String index_ReturnDestination (int index) {
        return gallery.get(index).getDestination();
    }
}
