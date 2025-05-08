/* Estructura de directorios:
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── biblioteca/
│   │   │   │   │   ├── model/
│   │   │   │   │   │   ├── ElementoBiblioteca.java
│   │   │   │   │   │   ├── Libro.java
│   │   │   │   │   │   ├── Revista.java
│   │   │   │   │   │   ├── DVD.java
│   │   │   │   │   │   └── dao/
│   │   │   │   │   │       ├── ElementoBibliotecaDAO.java
│   │   │   │   │   │       ├── LibroDAO.java
│   │   │   │   │   │       ├── RevistaDAO.java
│   │   │   │   │   │       ├── DVDDAO.java
│   │   │   │   │   │       └── ConexionBD.java
│   │   │   │   │   ├── view/
│   │   │   │   │   │   ├── MainFrame.java
│   │   │   │   │   │   ├── PanelPrincipal.java
│   │   │   │   │   │   ├── PanelLibros.java
│   │   │   │   │   │   ├── PanelRevistas.java
│   │   │   │   │   │   ├── PanelDVDs.java
│   │   │   │   │   │   ├── DialogoAgregarElemento.java
│   │   │   │   │   │   └── DialogoDetallesElemento.java
│   │   │   │   │   └── controller/
│   │   │   │   │       ├── BibliotecaController.java
│   │   │   │   │       ├── LibroController.java
│   │   │   │   │       ├── RevistaController.java
│   │   │   │   │       └── DVDController.java
│   │   │   │   └── Main.java
*/

package com.biblioteca;

import com.biblioteca.view.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Asegura que la interfaz gráfica se cargue en el hilo correcto
        SwingUtilities.invokeLater(() -> {
            try {
                // Opcional: usa el look and feel del sistema operativo
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                // Crear y mostrar la ventana principal
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Error al iniciar la aplicación: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
