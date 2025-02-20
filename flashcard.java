package Programas_PA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class flashcard extends JFrame {
	public flashcard() {
	}
	private JTextArea areaPregunta;
    private JTextArea areaRespuesta;
    private JButton botonGuardar, botonSiguiente;
    private List<String[]> flashcards;
    private int indiceActual = 0;
    private static final String NOMBRE_ARCHIVO = "flashcards.txt";
    
    public void FlashcardApp() {
        setTitle("Aplicación de Flashcards");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        flashcards = new ArrayList<>();
        cargarFlashcards();
        
        JPanel panel = new JPanel(new BorderLayout());
        
        areaPregunta = new JTextArea(5, 20);
        areaRespuesta = new JTextArea(5, 20);
        panel.add(new JLabel("Pregunta:"), BorderLayout.NORTH);
        panel.add(new JScrollPane(areaPregunta), BorderLayout.CENTER);
        panel.add(new JLabel("Respuesta:"), BorderLayout.SOUTH);
        panel.add(new JScrollPane(areaRespuesta), BorderLayout.SOUTH);
        
        botonGuardar = new JButton("Guardar Flashcard");
        botonSiguiente = new JButton("Siguiente Flashcard");
        
        botonGuardar.addActionListener(e -> guardarFlashcard());
        botonSiguiente.addActionListener(e -> mostrarSiguienteFlashcard());
        
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonGuardar);
        panelBotones.add(botonSiguiente);
        
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }
    
    private void guardarFlashcard() {
        String pregunta = areaPregunta.getText().trim();
        String respuesta = areaRespuesta.getText().trim();
        if (!pregunta.isEmpty() && !respuesta.isEmpty()) {
            flashcards.add(new String[]{pregunta, respuesta});
            escribirArchivo();
            areaPregunta.setText("");
            areaRespuesta.setText("");
        }
    }
    
    private void mostrarSiguienteFlashcard() {
        if (!flashcards.isEmpty()) {
            indiceActual = (indiceActual + 1) % flashcards.size();
            String[] flashcard = flashcards.get(indiceActual);
            areaPregunta.setText(flashcard[0]);
            areaRespuesta.setText(flashcard[1]);
        }
    }
    
    private void escribirArchivo() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            for (String[] flashcard : flashcards) {
                escritor.write(flashcard[0] + "|" + flashcard[1]);
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void cargarFlashcards() {
        try (BufferedReader lector = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length == 2) {
                    flashcards.add(partes);
                }
            }
        } catch (IOException e) {
            // Si el archivo no existe aún, simplemente lo ignoramos
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FlashcardApp().setVisible(true));
    }
}