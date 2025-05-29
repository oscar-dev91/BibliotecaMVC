// Controlador: RevistaController.java
package com.biblioteca.controller;

import com.biblioteca.model.Revista;
import com.biblioteca.model.dao.RevistaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RevistaController extends BibliotecaController<Revista> {
    private RevistaDAO revistaDAO;

    public RevistaController() throws SQLException {
        super(new RevistaDAO());
        this.revistaDAO = (RevistaDAO) this.dao;
    }

    public List<Revista> buscarPorCriterio(String criterio) {
        try {
            return revistaDAO.buscarPorCriterio(criterio);
        } catch (SQLException e) {
            System.err.println("Error al buscar revistas por criterio: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
