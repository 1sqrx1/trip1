import javax.swing.*;

public class Main extends JFrame {
    private JPanel jforma;

    Main(){
        setContentPane(jforma);
        setTitle("Trip");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();



        Trip.Start();

    }
}