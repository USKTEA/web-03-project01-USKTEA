import view.MainPanel;

import javax.swing.JFrame;

public class MegaMall {
    JFrame frame;

    public static void main(String[] args) {
        MegaMall application = new MegaMall();
        
        application.run();
    }

    private void run() {
        initFrame();
        addContentPanel();
    }

    private void initFrame() {
        frame = new JFrame("MegaShoppingMall");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 800, 500, 800);
    }

    private void addContentPanel() {
        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(false);
        frame.setVisible(true);
    }
}
