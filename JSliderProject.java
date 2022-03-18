package layoutmanagerdemo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderProject extends JFrame implements ChangeListener {

    private Container c;
    private ImageIcon icon;
    private JLabel red, green, blue, preview;
    private JSlider sl1, sl2, sl3;
    private JTextField tf1, tf2, tf3;
    private JPanel panel;
    private Font font;
    private JButton btn;

    JSliderProject() {
        initComponents();
    }

    public void initComponents() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLUE);

        icon = new ImageIcon(getClass().getResource("windows2.png"));
        this.setIconImage(icon.getImage());

        font = new Font("Arial", Font.BOLD, 20);

        red = new JLabel();
        red.setText("RED");
        red.setFont(font);
        red.setBackground(Color.BLUE);
        red.setOpaque(true);
        red.setBounds(30, 30, 100, 50);
        red.setForeground(Color.WHITE);
        c.add(red);

        sl1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
        sl1.setBackground(Color.BLUE);
//        sl1.setMinorTickSpacing(1);
//        sl1.setMajorTickSpacing(5);
//        sl1.setPaintTicks(true);
        // sl1.setPaintLabels(true);
        sl1.setForeground(Color.WHITE);
        sl1.setBounds(150, 30, 300, 50);
        c.add(sl1);

        tf1 = new JTextField();
        tf1.setBorder(null);
        tf1.setFont(font);
        tf1.setHorizontalAlignment(JTextField.CENTER);
        tf1.setBounds(480, 30, 100, 50);
        tf1.setText("10");
        c.add(tf1);

        green = new JLabel();
        green.setText("GREEN");
        green.setFont(font);
        green.setBackground(Color.BLUE);
        green.setOpaque(true);
        green.setBounds(30, 100, 100, 50);
        green.setForeground(Color.WHITE);
        c.add(green);

        sl2 = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
        sl2.setBackground(Color.BLUE);
//        sl2.setMinorTickSpacing(1);
//        sl2.setMajorTickSpacing(5);
//        sl2.setPaintTicks(true);
        // sl2.setPaintLabels(true);
        sl2.setForeground(Color.WHITE);
        sl2.setBounds(150, 100, 300, 50);
        c.add(sl2);

        tf2 = new JTextField();
        tf2.setBorder(null);
        tf2.setFont(font);
        tf2.setHorizontalAlignment(JTextField.CENTER);
        tf2.setBounds(480, 100, 100, 50);
        tf2.setText("10");
        c.add(tf2);

        blue = new JLabel();
        blue.setText("BLUE");
        blue.setFont(font);
        blue.setBackground(Color.BLUE);
        blue.setOpaque(true);
        blue.setBounds(30, 170, 100, 50);
        blue.setForeground(Color.WHITE);
        c.add(blue);

        sl3 = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
        sl3.setBackground(Color.BLUE);
//        sl3.setMinorTickSpacing(1);
//        sl3.setMajorTickSpacing(5);
//        sl3.setPaintTicks(true);
        // sl3.setPaintLabels(true);
        sl3.setForeground(Color.WHITE);
        sl3.setBounds(150, 170, 300, 50);
        c.add(sl3);

        tf3 = new JTextField();
        tf3.setBorder(null);
        tf3.setFont(font);
        tf3.setText("10");
        tf3.setHorizontalAlignment(JTextField.CENTER);
        tf3.setBounds(480, 170, 100, 50);
        c.add(tf3);

        panel = new JPanel();
        panel.setBounds(620, 30, 330, 250);
        panel.setBackground(Color.WHITE);
        c.add(panel);

        preview = new JLabel();
        preview.setFont(font);
        preview.setText("Preview");
        preview.setBounds(770, 270, 100, 50);
        preview.setForeground(Color.WHITE);
        c.add(preview);

        btn = new JButton("Choose a Colors");
        btn.setFont(font);
        btn.setBounds(30, 230, 550, 50);
        btn.setBackground(Color.RED);
        btn.setBorder(null);
        btn.setForeground(Color.WHITE);
        c.add(btn);
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Color color = JColorChooser.showDialog(null, "Select a color", Color.BLACK);
                panel.setBackground(color);
                
            }
        
        
        });

        sl1.addChangeListener(this);
        sl2.addChangeListener(this);
        sl3.addChangeListener(this);

    }

    @Override
    public void stateChanged(ChangeEvent ce) {

        int red = sl1.getValue();
        int green = sl2.getValue();
        int blue = sl3.getValue();

        tf1.setText("" + red);
        tf2.setText("" + green);
        tf3.setText("" + blue);

        Color color = new Color(red, green, blue);
        panel.setBackground(color);

    }

    public static void main(String[] args) {

        JSliderProject frame = new JSliderProject();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Color Chooser");
        frame.setSize(1000, 350);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

}
