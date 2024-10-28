import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilaGUI {
    private JTextField Input;
    private JTextArea resultado;
    private JButton apilarButton;
    private JButton MostrarInversoButton;
    private JPanel pGeneral;
    public Pila pila =new Pila();

    public PilaGUI() {
        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inp=Input.getText();
                try {
                    int valor= Integer.parseInt(inp);
                    pila.apilar(valor,resultado);
                    Input.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Ingresa un numero valido");
                }
            }

        });
        MostrarInversoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pila.estaVacia()) {
                    JOptionPane.showMessageDialog(null, "La pila está vacía.");
                    resultado.setText("");
                } else {
                    StringBuilder inversoStr = new StringBuilder();
                    while (!pila.estaVacia()) {
                        inversoStr.append(pila.desapilar(resultado)).append(" ");
                    }
                    resultado.setText("Secuencia invertida:\n" + inversoStr.toString().trim());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PilaGUI");
        frame.setContentPane(new PilaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}




