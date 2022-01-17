package Photo_Repository;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class Photo {
    private String type_of_shoe;
    private String colorway;
    private int year_of_release;
    private LocalDateTime time_of_upload;
    private String imagePath;
    private Boolean privateorpublic;

    public Photo(String type, String color, int year, LocalDateTime time, String path) {
        this.type_of_shoe = type;
        this.colorway = color;
        this.year_of_release = year;
        this.time_of_upload = time;
        this.imagePath = path;
    }

    public String getType_of_shoe() {
        return type_of_shoe;
    }

    public void setType_of_shoe(String type) {
        this.type_of_shoe = type;
    }

    public String getColorway() {
        return colorway;
    }

    public void setColorway(String colorway) {
        this.colorway = colorway;
    }

    public int getYear_of_release() {
        return year_of_release;
    }

    public void setYear_of_release(int year_of_release) {
        this.year_of_release = year_of_release;
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

    public void setPrivateorpublic(Boolean privateorpublic) {
        this.privateorpublic = privateorpublic;
    }

    public Boolean getPrivateorpublic() {
        return privateorpublic;
    }
}
