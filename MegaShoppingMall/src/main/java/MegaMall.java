import view.MainPanel;

import javax.swing.JFrame;
import java.io.FileNotFoundException;

public class MegaMall {
    private JFrame frame;

    public static void main(String[] args) throws FileNotFoundException {
        MegaMall application = new MegaMall();
        
        application.run();
    }

    private void run() throws FileNotFoundException {
        initFrame();
        addContentPanel();
    }

    private void initFrame() {
        frame = new JFrame("MegaMall");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 800, 500, 800);
    }

    private void addContentPanel() throws FileNotFoundException {
        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(false);
        frame.setVisible(true);
    }
}
