import view.MainPanel;

import javax.swing.JFrame;
import java.io.IOException;

public class MegaMall {
    JFrame frame;

    public static void main(String[] args) throws IOException {
        MegaMall application = new MegaMall();
        
        application.run();
    }

    private void run() throws IOException {
        initFrame();
        addContentPanel();
    }

    private void initFrame() {
        frame = new JFrame("MegaShoppingMall");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 800, 500, 800);
    }

    private void addContentPanel() throws IOException {
        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(false);
        frame.setVisible(true);
    }
}
