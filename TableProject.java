package layoutmanagerdemo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TableProject extends JFrame implements ActionListener {

    private Container c;
    private Font font;
    private JLabel titleLa, id, name, depart, semester, expert;
    private JTextField idt, namet, departt, semestert, expertt;
    private JButton add, update, delete, clear;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private JTable table;
    private String[] cols = {"NAME", "ID", "DEPARTMENT", "SEMESTER", "EXPERT"};
    private String[] rows = new String[5];

    TableProject() {
        initComponents();
    }

    public void initComponents() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLUE);

        font = new Font("Arial", Font.BOLD, 14);

        titleLa = new JLabel();
        titleLa.setFont(font);
        titleLa.setText("Your Data important for us.");
        titleLa.setForeground(Color.WHITE);
        titleLa.setBounds(150, 10, 300, 50);
        c.add(titleLa);

        name = new JLabel("NAME ");
        name.setFont(font);
        name.setForeground(Color.WHITE);
        name.setBounds(20, 60, 100, 50);
        c.add(name);

        namet = new JTextField();
        namet.setFont(font);
        namet.setForeground(Color.BLACK);
        namet.setBorder(null);
        namet.setHorizontalAlignment(JTextField.CENTER);
        namet.setBounds(150, 70, 250, 40);
        c.add(namet);

        add = new JButton("ADD");
        add.setBorder(null);
        add.setFont(font);
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.setBounds(470, 70, 100, 40);
        c.add(add);

        id = new JLabel("ID ");
        id.setFont(font);
        id.setForeground(Color.WHITE);
        id.setBounds(20, 130, 100, 50);
        c.add(id);

        idt = new JTextField();
        idt.setFont(font);
        idt.setForeground(Color.BLACK);
        idt.setBorder(null);
        idt.setHorizontalAlignment(JTextField.CENTER);
        idt.setBounds(150, 130, 250, 40);
        c.add(idt);

        update = new JButton("UPDATE");
        update.setBorder(null);
        update.setFont(font);
        update.setBackground(Color.WHITE);
        update.setForeground(Color.BLACK);
        update.setBounds(470, 150, 100, 40);
        c.add(update);

        depart = new JLabel("DEPARTMENT");
        depart.setFont(font);
        depart.setForeground(Color.WHITE);
        depart.setBounds(20, 200, 100, 50);
        c.add(depart);

        departt = new JTextField();
        departt.setFont(font);
        departt.setForeground(Color.BLACK);
        departt.setBorder(null);
        departt.setHorizontalAlignment(JTextField.CENTER);
        departt.setBounds(150, 200, 250, 40);
        c.add(departt);

        delete = new JButton("DELETE");
        delete.setBorder(null);
        delete.setFont(font);
        delete.setBackground(Color.WHITE);
        delete.setForeground(Color.BLACK);
        delete.setBounds(470, 240, 100, 40);
        c.add(delete);

        semester = new JLabel("SEMESTER");
        semester.setFont(font);
        semester.setForeground(Color.WHITE);
        semester.setBounds(20, 270, 100, 50);
        c.add(semester);

        semestert = new JTextField();
        semestert.setFont(font);
        semestert.setForeground(Color.BLACK);
        semestert.setBorder(null);
        semestert.setHorizontalAlignment(JTextField.CENTER);
        semestert.setBounds(150, 270, 250, 40);
        c.add(semestert);

        clear = new JButton("CLEAR");
        clear.setBorder(null);
        clear.setFont(font);
        clear.setBackground(Color.WHITE);
        clear.setForeground(Color.BLACK);
        clear.setBounds(470, 330, 100, 40);
        c.add(clear);

        expert = new JLabel("EXPERT");
        expert.setFont(font);
        expert.setForeground(Color.WHITE);
        expert.setBounds(20, 330, 100, 50);
        c.add(expert);

        expertt = new JTextField();
        expertt.setFont(font);
        expertt.setForeground(Color.BLACK);
        expertt.setBorder(null);
        expertt.setHorizontalAlignment(JTextField.CENTER);
        expertt.setBounds(150, 330, 250, 40);
        c.add(expertt);

        table = new JTable();
        table.setSelectionBackground(Color.BLUE);
        table.setSelectionForeground(Color.WHITE);
        table.setRowHeight(30);
        table.setFont(font);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(cols);
        table.setModel(model);

        scroll = new JScrollPane(table);
        scroll.setBounds(20, 400, 550, 400);
        c.add(scroll);

        add.addActionListener(this);
        clear.addActionListener(this);
        delete.addActionListener(this);
        update.addActionListener(this);

        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {

                int numOfRow = table.getSelectedRow();

                String Name = model.getValueAt(numOfRow, 0).toString();
                String Id = model.getValueAt(numOfRow, 1).toString();
                String dep = model.getValueAt(numOfRow, 2).toString();
                String sem = model.getValueAt(numOfRow, 3).toString();
                String ex = model.getValueAt(numOfRow, 4).toString();

                namet.setText(Name);
                idt.setText(Id);
                departt.setText(dep);
                semestert.setText(sem);
                expertt.setText(ex);

            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            rows[0] = namet.getText();
            rows[1] = idt.getText();
            rows[2] = departt.getText();
            rows[3] = semestert.getText();
            rows[4] = expertt.getText();

            model.addRow(rows);

        } else if (ae.getSource() == clear) {
            namet.setText("");
            idt.setText("");
            departt.setText("");
            semestert.setText("");
            expertt.setText("");

        } else if (ae.getSource() == delete) {
            int numberOFrow = table.getSelectedRow();
            if (numberOFrow >= 0) {
                model.removeRow(numberOFrow);
            } else {
                JOptionPane.showMessageDialog(null, "No row has been selected or now row exits");
            }

        } else if (ae.getSource() == update) {
            int numofrow = table.getSelectedRow();
            
           String A = namet.getText();
           String B = idt.getText();
           String C = departt.getText();
           String D = semestert.getText();
           String E = expertt.getText();
           
           model.setValueAt(A, numofrow, 0);
           model.setValueAt(B, numofrow, 1);
           model.setValueAt(C, numofrow, 2);
           model.setValueAt(D, numofrow, 3);
           model.setValueAt(E, numofrow, 4);

        }

    }

    public static void main(String[] args) {

        TableProject frame = new TableProject();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Students Registertion Project");
        frame.setSize(600, 900);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

    }

}
