package Programas_PA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tarea03_Layout extends JFrame implements ActionListener {
    static JLabel La, Lb, Lc;
    static JButton Bcalcular, Bsalir;
    static JTextField Ta, Th, Tb;

    public Tarea03_Layout() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
        this.setTitle("Layout FlowLayout Center");
        this.setBounds(10, 10, 550, 100);

        
        La = new JLabel("Altura-->");
        Lb = new JLabel("Base -->");
        Lc = new JLabel("El área --> ");
        Th = new JTextField(10); 
        Tb = new JTextField(10);
        Ta = new JTextField(10);
        Ta.setEditable(false);
        Bcalcular = new JButton("Calcular");
        Bsalir = new JButton("Salir");

       
        Bcalcular.addActionListener(this);
        Bsalir.addActionListener(this);

        
        this.add(La);
        this.add(Th);
        this.add(Lb);
        this.add(Tb);
        this.add(Bcalcular);
        this.add(Lc);
        this.add(Ta);
        this.add(Bsalir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Bcalcular) {
            try {
                double h = Double.parseDouble(Th.getText());
                double b = Double.parseDouble(Tb.getText());
                double a = (h * b) / 2;
                Ta.setText(String.valueOf(a));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos");
            }
        } else if (e.getSource() == Bsalir) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Tarea03_Layout ventana = new Tarea03_Layout();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
