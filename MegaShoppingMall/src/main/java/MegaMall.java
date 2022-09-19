import view.ContentPanel;

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 800, 500, 800);
    }

    private void addContentPanel() {
        ContentPanel contentPanel = new ContentPanel();
        frame.add(contentPanel);
        frame.setVisible(false);
        frame.setVisible(true);
    }
}
