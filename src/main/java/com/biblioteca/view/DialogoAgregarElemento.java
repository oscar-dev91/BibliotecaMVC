package com.biblioteca.view;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Revista;

import javax.swing.*;
import java.awt.*;

public class DialogoAgregarElemento extends JDialog {
    // Campos comunes
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtAno;

    // Campos específicos para Libro
    private JTextField txtISBN;
    private JTextField txtPaginas;
    private JTextField txtGenero;
    private JTextField txtEditorial;

    // Campos específicos para Revista
    private JTextField txtEdicion;
    private JTextField txtCategoria;

    private Object resultado; // Puede ser Libro o Revista
    private boolean modoEdicion;
    private String tipoElemento;

    public DialogoAgregarElemento(Frame parent, String titulo, String tipo) {
        this(parent, titulo, tipo, null);
    }

    public DialogoAgregarElemento(Frame parent, String titulo, String tipo, Object elementoExistente) {
        super(parent, titulo, true);
        this.tipoElemento = tipo.toUpperCase();
        this.modoEdicion = (elementoExistente != null);

        inicializarComponentes(elementoExistente);
        pack();
        setLocationRelativeTo(parent);
    }

    private void inicializarComponentes(Object elemento) {
        JPanel panel = new JPanel(new GridLayout(10, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Campos comunes
        txtTitulo = new JTextField();
        txtAutor = new JTextField();
        txtAno = new JTextField();

        panel.add(new JLabel("Título:"));
        panel.add(txtTitulo);
        panel.add(new JLabel("Autor:"));
        panel.add(txtAutor);
        panel.add(new JLabel("Año de publicación:"));
        panel.add(txtAno);

        if ("LIBRO".equals(tipoElemento)) {
            txtISBN = new JTextField();
            txtPaginas = new JTextField();
            txtGenero = new JTextField();
            txtEditorial = new JTextField();

            panel.add(new JLabel("ISBN:"));
            panel.add(txtISBN);
            panel.add(new JLabel("Número de páginas:"));
            panel.add(txtPaginas);
            panel.add(new JLabel("Género:"));
            panel.add(txtGenero);
            panel.add(new JLabel("Editorial:"));
            panel.add(txtEditorial);

            if (modoEdicion && elemento instanceof Libro) {
                Libro libro = (Libro) elemento;
                txtTitulo.setText(libro.getTitulo());
                txtAutor.setText(libro.getAutor());
                txtAno.setText(String.valueOf(libro.getAnoPublicacion()));
                txtISBN.setText(libro.getIsbn());
                txtPaginas.setText(String.valueOf(libro.getNumeroPaginas()));
                txtGenero.setText(libro.getGenero());
                txtEditorial.setText(libro.getEditorial());
            }
        } else if ("REVISTA".equals(tipoElemento)) {
            txtEdicion = new JTextField();
            txtCategoria = new JTextField();

            panel.add(new JLabel("Número de edición:"));
            panel.add(txtEdicion);
            panel.add(new JLabel("Categoría:"));
            panel.add(txtCategoria);

            if (modoEdicion && elemento instanceof Revista) {
                Revista revista = (Revista) elemento;
                txtTitulo.setText(revista.getTitulo());
                txtAutor.setText(revista.getAutor());
                txtAno.setText(String.valueOf(revista.getAnoPublicacion()));
                txtEdicion.setText(String.valueOf(revista.getNumeroEdicion()));
                txtCategoria.setText(revista.getCategoria());
            }
        }

        // Botones
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            if (validarCampos()) {
                String titulo = txtTitulo.getText().trim();
                String autor = txtAutor.getText().trim();
                int ano = Integer.parseInt(txtAno.getText().trim());

                if ("LIBRO".equals(tipoElemento)) {
                    String isbn = txtISBN.getText().trim();
                    int paginas = Integer.parseInt(txtPaginas.getText().trim());
                    String genero = txtGenero.getText().trim();
                    String editorial = txtEditorial.getText().trim();

                    if (modoEdicion && elemento instanceof Libro) {
                        int id = ((Libro) elemento).getId();
                        resultado = new Libro(id, titulo, autor, ano, isbn, paginas, genero, editorial);
                    } else {
                        resultado = new Libro(titulo, autor, ano, isbn, paginas, genero, editorial);
                    }

                } else if ("REVISTA".equals(tipoElemento)) {
                    int edicion = Integer.parseInt(txtEdicion.getText().trim());
                    String categoria = txtCategoria.getText().trim();

                    if (modoEdicion && elemento instanceof Revista) {
                        int id = ((Revista) elemento).getId();
                        resultado = new Revista(id, titulo, autor, ano, edicion, categoria);
                    } else {
                        resultado = new Revista(titulo, autor, ano, edicion, categoria);
                    }
                }

                setVisible(false);
            }
        });

        btnCancelar.addActionListener(e -> {
            resultado = null;
            setVisible(false);
        });

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }

    private boolean validarCampos() {
        try {
            Integer.parseInt(txtAno.getText().trim());

            if ("LIBRO".equals(tipoElemento)) {
                Integer.parseInt(txtPaginas.getText().trim());
            } else if ("REVISTA".equals(tipoElemento)) {
                Integer.parseInt(txtEdicion.getText().trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Campos numéricos inválidos.",
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtTitulo.getText().trim().isEmpty() || txtAutor.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Título y Autor son obligatorios.",
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public Object mostrar() {
        setVisible(true);
        return resultado;
    }
}
