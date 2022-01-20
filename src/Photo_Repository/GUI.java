package Photo_Repository;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.*;

public class GUI {
    private static JFrame frame;
    private boolean private_true;
    private boolean delete = false;
    private int deleteIndex;
    protected static JPanel home;
    protected static CardLayout cards;
    protected static Photo_List priv_album;
    protected static Photo_List pub_album;
    public static int WIDTH = 1024;
    public static int HEIGHT = 768;
    final static String WELCOME_CARD = "Welcome Card";
    final static String PRIVATE_CARD = "Private Card";
    final static String PUBLIC_CARD = "Public Card";
    final static String DELETE_CARD = "Delete Card";

    public void startGUI(){
        priv_album = new Photo_List();
        pub_album = new Photo_List();

        frame = new JFrame();
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        cards = new CardLayout();
        home = new JPanel(cards);


        welcomeGUI();
        public_view();
        double_Check();
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
        int length = priv_album.get_Length();
        int i = 0;

        JPanel private_repo = new JPanel();

        private_repo.setLayout(new GridLayout(length / 2,3));

        ArrayList<BufferedImage> myPicture = new ArrayList<BufferedImage>();
        ArrayList<String> imagePath = new ArrayList<String>();
        ArrayList<JButton> btns = new ArrayList<JButton>();

         while (i < length){
            imagePath.add(priv_album.index_ReturnDestination(i));
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
            deleteIndex = i;
            btns.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (delete) {
                        cards.show(home, DELETE_CARD);
                    } else {
                        System.out.println("I dont want to delete");
                    }
                }
            });
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

        JCheckBox checkBox = new JCheckBox("Delete");

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    delete = true;
                } else {
                    delete = false;
                }
            }
        });

        private_repo.add(done, BorderLayout.CENTER);
        private_repo.add(addfile, BorderLayout.CENTER);
        private_repo.add(checkBox, BorderLayout.CENTER);

        home.add(private_repo, PRIVATE_CARD);

    }

    public void public_view(){
        int length = pub_album.get_Length();
        int i = 0;

        JPanel public_repo = new JPanel();

        public_repo.setLayout(new GridLayout(length / 2,3));

        ArrayList<BufferedImage> myPicture = new ArrayList<BufferedImage>();
        ArrayList<String> imagePath = new ArrayList<String>();
        ArrayList<JButton> btns = new ArrayList<JButton>();

        while (i < length){
            imagePath.add(pub_album.index_ReturnDestination(i));
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
            deleteIndex = i;
            btns.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (delete) {
                        cards.show(home, DELETE_CARD);
                    } else {
                        System.out.println("I dont want to delete");
                    }
                }
            });
            public_repo.add(btns.get(i));
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

        JCheckBox checkBox = new JCheckBox("Delete");

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    delete = true;
                } else {
                    delete = false;
                }
            }
        });

        public_repo.add(done, BorderLayout.CENTER);
        public_repo.add(addfile, BorderLayout.CENTER);
        public_repo.add(checkBox, BorderLayout.CENTER);

        home.add(public_repo, PUBLIC_CARD);
    }

    public void double_Check(){
        JPanel deletePhoto = new JPanel();

        JLabel warning = new JLabel("Are you sure you want to delete this file?");

        JButton yes = new JButton("YES!");
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (private_true) {
                    priv_album.remove_Photo(deleteIndex);
                    private_view();
                    cards.show(home, PRIVATE_CARD);
                } else {
                    pub_album.remove_Photo(deleteIndex);
                    public_view();
                    cards.show(home, PUBLIC_CARD);
                }

            }
        });

        JButton no = new JButton("NO!");
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (private_true) {
                    cards.show(home, PRIVATE_CARD);
                } else {
                    cards.show(home, PUBLIC_CARD);
                }

            }
        });

        deletePhoto.add(warning, BorderLayout.PAGE_START);
        deletePhoto.add(yes, BorderLayout.LINE_START);
        deletePhoto.add(no, BorderLayout.LINE_END);

        home.add(deletePhoto, DELETE_CARD);
    }

    public void filechooserfunction() {

        JFileChooser selector = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        selector.setMultiSelectionEnabled(true);

        selector.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png"));

        int temp_dialog = selector.showSaveDialog(null);

        if (temp_dialog == JFileChooser.APPROVE_OPTION) {
            // get the selelcted files
            File files[] = selector.getSelectedFiles();

            int t = 0;
            // set text to blank

            // set the label to the path of the selected files
            while (t < files.length){
                if (private_true) {
                    priv_album.add_Photo(files[t].getAbsolutePath(), private_true, files[t].getName());
                } else {
                    pub_album.add_Photo(files[t].getAbsolutePath(), private_true, files[t].getName());
                }
                t++;
            }
            if (private_true) {
                priv_album.print_Gallery();
                private_view();
                cards.show(home, PRIVATE_CARD);
            } else {
                pub_album.print_Gallery();
                public_view();
                cards.show(home, PUBLIC_CARD);
            }

        }
        // if the user cancelled the operation
        else
            System.out.println("cancelled");

    }
}


