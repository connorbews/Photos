package Photo_Repository;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.*;

public class GUI {
    private static JFrame frame;
    private boolean private_true;
    protected static JPanel home;
    protected static CardLayout cards;
    protected static Photo_List album;
    public static int WIDTH = 1024;
    public static int HEIGHT = 768;
    final static String WELCOME_CARD = "Welcome Card";
    final static String PRIVATE_CARD = "Private Card";
    final static String PUBLIC_CARD = "Public Card";

    public void startGUI(){
        album = new Photo_List();

        frame = new JFrame();
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        cards = new CardLayout();
        home = new JPanel(cards);


        welcomeGUI();
        public_view();
        private_view();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(home);
        frame.pack();
        frame.setVisible(true);
    }

    public void welcomeGUI(){
        JPanel welcomeScreen = new JPanel();

        welcomeScreen.setLayout(new BoxLayout(welcomeScreen, BoxLayout.Y_AXIS));

        welcomeScreen.add(new JLabel("Welcome to your personal Image repository!"));
        welcomeScreen.add(new JLabel("Would you like to view your private or public repository?"));
        JButton privateButton = new JButton("PRIVATE");
        JButton publicButton = new JButton("PUBLIC");
        welcomeScreen.add(privateButton);
        welcomeScreen.add(publicButton);
        private_or_public(privateButton, publicButton);
        home.add(welcomeScreen, WELCOME_CARD);
    }

    public void private_or_public(JButton private_selected, JButton public_selected) {
        private_selected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                private_true = true;
                cards.show(home, PRIVATE_CARD);
            }
        });

        public_selected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                private_true = false;
                cards.show(home, PUBLIC_CARD);
            }
        });
    }

    public void private_view(){
        int length = album.get_Length();
        int i = 0;

        JPanel private_repo = new JPanel();

        private_repo.setLayout(new GridLayout(length / 2,3));

        ArrayList<BufferedImage> myPicture = new ArrayList<BufferedImage>();
        ArrayList<String> imagePath = new ArrayList<String>();
        ArrayList<JButton> btns = new ArrayList<JButton>();
        System.out.println(length);
         while (i < length){
            imagePath.add(album.index_ReturnDestination(i));
            i++;
         }
         i = 0;

        while (i < length){
            try {
                System.out.println(imagePath.get(i));
                myPicture.add(ImageIO.read(new File(imagePath.get(i))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        i = 0;

        while (i < length){
            btns.add(new JButton(new ImageIcon(myPicture.get(i))));
            private_repo.add(btns.get(i));
            i++;
        }
        i = 0;

        JButton done = new JButton("Done");

        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(home, WELCOME_CARD);
            }
        });

        JButton addfile = new JButton("Add File");

        addfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filechooserfunction();
            }
        });

        private_repo.add(done, BorderLayout.CENTER);
        private_repo.add(addfile, BorderLayout.CENTER);

        home.add(private_repo, PRIVATE_CARD);
    }

    public void public_view(){
        String imagePath = "C:\\Users\\klbew\\IdeaProjects\\Photos\\Photo_database\\Air_Jordan_1_University_Blue.jpg";

        JPanel private_repo = new JPanel();

        private_repo.setLayout(new BoxLayout(private_repo, BoxLayout.Y_AXIS));
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JButton picLabel = new JButton(new ImageIcon(myPicture));
        picLabel.setPreferredSize(new Dimension(20, 20));
        JButton done = new JButton("Done");
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(home, WELCOME_CARD);
            }
        });

        JButton addfile = new JButton("Add File");

        addfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filechooserfunction();
            }
        });

        private_repo.add(picLabel);
        private_repo.add(done, BorderLayout.CENTER);
        private_repo.add(addfile, BorderLayout.CENTER);

        home.add(private_repo, PUBLIC_CARD);
    }

    public void filechooserfunction() {

        JFileChooser selector = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        selector.setMultiSelectionEnabled(true);

        int temp_dialog = selector.showSaveDialog(null);

        if (temp_dialog == JFileChooser.APPROVE_OPTION) {
            // get the selelcted files
            File files[] = selector.getSelectedFiles();

            int t = 0;
            // set text to blank

            // set the label to the path of the selected files
            while (t < files.length){
                album.add_Photo(files[t].getAbsolutePath(), private_true, files[t].getName());
                t++;
            }
            album.print_Gallery();
            home.remove(2);
            private_view();
            cards.show(home, PRIVATE_CARD);
        }
        // if the user cancelled the operation
        else
            System.out.println("cancelled");

    }
}


