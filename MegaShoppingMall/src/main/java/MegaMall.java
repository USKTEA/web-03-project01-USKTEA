import view.MainPanel;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;

import java.util.Enumeration;

public class MegaMall {
    private JFrame frame;

    public static void setFont(FontUIResource f) {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
    }

    public static void main(String[] args) {
        Font font = new Font("NanumGothic", Font.BOLD, 16);
        setFont(new FontUIResource(font));
        MegaMall application = new MegaMall();


        application.run();
    }

    private void run() {
        initFrame();
        addContentPanel();
    }

    private void initFrame() {
        frame = new JFrame("MegapMall");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(1000, 1200, 1000, 1200);
    }

    private void addContentPanel() {
        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(false);
        frame.setVisible(true);
    }
}

//<a href="https://www.flaticon.com/kr/free-icons/" title="신화 아이콘">신화 아이콘  제작자: Freepik - Flaticon</a>
