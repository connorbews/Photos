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
    final static String ADD_FILE = "Add File";

    public void startGUI(){
        album = new Photo_List();

        frame = new JFrame();
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        cards = new CardLayout();
        home = new JPanel(cards);


        welcomeGUI();
        private_view();
        public_view();
        addfilefunction();
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
        String imagePath0 = "C:\\Users\\klbew\\IdeaProjects\\Photos\\Photo_database\\Air_Jordan_1_University_Blue.jpg";
        String imagePath1 = "C:\\Users\\klbew\\IdeaProjects\\Photos\\Photo_database\\Air_Jordan_2_Chicago.jpg";
        String imagePath2 = "C:\\Users\\klbew\\IdeaProjects\\Photos\\Photo_database\\Air_Jordan_3_Racer_Blue.jpg";
        String imagePath3 = "C:\\Users\\klbew\\IdeaProjects\\Photos\\Photo_database\\Air_Jordan_4_oreo.jpg";
        String imagePath4 = "C:\\Users\\klbew\\IdeaProjects\\Photos\\Photo_database\\Air_Jordan_5_Raging_Bull.jpg";
        String imagePath5 = "C:\\Users\\klbew\\IdeaProjects\\Photos\\Photo_database\\Air_Jordan_6_UNC.jpg";
        JPanel private_repo = new JPanel();

        private_repo.setLayout(new GridLayout(3,2));

        BufferedImage myPicture0 = null;
        BufferedImage myPicture1 = null;
        BufferedImage myPicture2 = null;
        BufferedImage myPicture3 = null;
        BufferedImage myPicture4 = null;
        BufferedImage myPicture5 = null;
        try {
            myPicture0 = ImageIO.read(new File(imagePath0));
            myPicture1 = ImageIO.read(new File(imagePath1));
            myPicture2 = ImageIO.read(new File(imagePath2));
            myPicture3 = ImageIO.read(new File(imagePath3));
            myPicture4 = ImageIO.read(new File(imagePath4));
            myPicture5 = ImageIO.read(new File(imagePath5));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton picLabel0 = new JButton(new ImageIcon(myPicture0));
        JButton picLabel1 = new JButton(new ImageIcon(myPicture1));
        JButton picLabel2 = new JButton(new ImageIcon(myPicture2));
        JButton picLabel3 = new JButton(new ImageIcon(myPicture3));
        JButton picLabel4 = new JButton(new ImageIcon(myPicture4));
        JButton picLabel5 = new JButton(new ImageIcon(myPicture5));

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
                cards.show(home, ADD_FILE);
            }
        });

        private_repo.add(picLabel0);
        private_repo.add(picLabel1);
        private_repo.add(picLabel2);
        private_repo.add(picLabel3);
        private_repo.add(picLabel4);
        private_repo.add(picLabel5);
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
                cards.show(home, ADD_FILE);
            }
        });

        private_repo.add(picLabel);
        private_repo.add(done, BorderLayout.CENTER);
        private_repo.add(addfile, BorderLayout.CENTER);

        home.add(private_repo, PUBLIC_CARD);
    }

    public void addfilefunction() {
        JPanel addfile = new JPanel();

        addfile.setLayout(new GridLayout(4,2));

        addfile.add(new JLabel("Please enter the type of shoe: "));
        JTextField typeofshoe = new JTextField(20);
        addfile.add(typeofshoe);

        addfile.add(new JLabel("Please enter the colorway of the shoe: "));
        JTextField colorway = new JTextField(20);
        addfile.add(colorway);

        addfile.add(new JLabel("Please enter the year the shoe was released: "));
        JTextField yearofrelease = new JTextField(20);
        addfile.add(yearofrelease);

        JButton done = new JButton("Done");
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (private_true) {
                    cards.show(home, PRIVATE_CARD);
                } else {
                    cards.show(home, PUBLIC_CARD);
                }
            }
        });

        addfile.add(done);

        home.add(addfile, ADD_FILE);
    }
}


