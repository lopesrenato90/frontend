import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListFrame extends JFrame {
    private final JList<String> colorJList;
    private final JList<String> sizeJList;
    private static final String[] colorNames = {
        "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", 
        "Light Gray", "Magenta", "Orange", "Pink", "Red", 
        "White", "Yellow"
    };
    private static final Color[] colors = {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, 
        Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, 
        Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };
    private static final String[] sizeNames = {"Small", "Medium", "Big"};

    public ListFrame() {
        super("List Test");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        colorJList = new JList<>(colorNames);
        colorJList.setVisibleRowCount(5);
        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(colorJList));

        sizeJList = new JList<>(sizeNames);
        sizeJList.setVisibleRowCount(3);
        sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(sizeJList));

        colorJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int selectedIndex = colorJList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    getContentPane().setBackground(colors[selectedIndex]);
                }
            }
        });

        sizeJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                switch (sizeJList.getSelectedIndex()) {
                    case 0:
                        setSize(350, 150);
                        break;
                    case 1:
                        setSize(550, 350);
                        break;
                    case 2:
                        setSize(750, 550);
                        break;
                    default:
                        setSize(350, 150);
                        break;
                }
            }
        });

        setSize(350, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListFrame());
    }
}
