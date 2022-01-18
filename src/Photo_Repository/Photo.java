package Photo_Repository;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;

//import org.json.simple.JSONObject;

public class Photo {

    private LocalDateTime time_of_upload;
    private String imagePath;
    private String destination;
    private Boolean privateorpublic;

    public Photo(LocalDateTime time, String path, String destination, Boolean privateorpublic) {
        this.time_of_upload = time;
        this.imagePath = path;
        this.destination = destination;
        this.privateorpublic = privateorpublic;
    }

    public LocalDateTime getTime_of_upload() {
        return time_of_upload;
    }

    public void setTime_of_upload(LocalDateTime time_of_upload) {
        this.time_of_upload = time_of_upload;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPrivateorpublic(Boolean privateorpublic) {
        this.privateorpublic = privateorpublic;
    }

    public Boolean getPrivateorpublic() {
        return privateorpublic;
    }

    /*public void jsonsave(){


    }*/
}
