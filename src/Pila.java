import javax.swing.*;

public class Pila {
    private Nodo cima;
    private int tamano;

    public Pila() {
        cima = null;
        tamano = 0;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void apilar(int dato, JTextArea textArea) {
        Nodo nuevo = new Nodo(dato);
        nuevo.Siguiente = cima;
        cima = nuevo;
        tamano++;
        actualizarTextArea(textArea); // Actualiza el JTextArea cada vez que se apila
    }

    public int desapilar(JTextArea textArea) {
        if (estaVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        int dato = cima.dato;
        cima = cima.Siguiente;
        tamano--;
        actualizarTextArea(textArea); // Actualiza el JTextArea cada vez que se desapila
        return dato;
    }

    public void mostrarPila(JTextArea textArea) {
        if (estaVacia()) {
            textArea.setText("");
            JOptionPane.showMessageDialog(null, "La pila se encuentra vacía");
        } else {
            StringBuilder pilaStr = new StringBuilder();
            Nodo actual = cima;
            while (actual != null) {
                pilaStr.append(actual.dato).append("\n");
                actual = actual.Siguiente;
            }
            textArea.setText(pilaStr.toString());
        }
    }

    public void actualizarTextArea(JTextArea textArea) {
        mostrarPila(textArea);
    }
}



