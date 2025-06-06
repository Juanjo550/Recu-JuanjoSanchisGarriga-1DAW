package com.example.recuproyecto.DAO;

import com.example.recuproyecto.POJO.Contacto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    // Insertar nuevo contacto
    public void insertar(Contacto contacto) {
        String sql = "INSERT INTO Contacto (nombre, apellido1, apellido2, telefono, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, contacto.getNombre());
            stmt.setString(2, contacto.getApellido1());
            stmt.setString(3, contacto.getApellido2());
            stmt.setInt(4, contacto.getTelefono());
            stmt.setString(5, contacto.getEmail());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                contacto.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todos los contactos
    public List<Contacto> obtenerTodos() {
        List<Contacto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Contacto";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contacto c = new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getInt("telefono"),
                        rs.getString("email")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Obtener contacto por nombre
    public List<Contacto> obtenerPorNombre(String nombre) {
        List<Contacto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Contacto WHERE nombre = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Contacto contacto = new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getInt("telefono"),
                        rs.getString("email")
                );
                lista.add(contacto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Obtener contacto por email
    public Contacto obtenerPorEmail(String email) {
        String sql = "SELECT * FROM Contacto WHERE email = ?";
        Contacto contacto = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                contacto = new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getInt("telefono"),
                        rs.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacto;
    }

    // Actualizar contacto
    public boolean actualizar(Contacto contacto) {
        String sql = "UPDATE Contacto SET nombre = ?, apellido1 = ?, apellido2 = ?, telefono = ?, email = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contacto.getNombre());
            stmt.setString(2, contacto.getApellido1());
            stmt.setString(3, contacto.getApellido2());
            stmt.setInt(4, contacto.getTelefono());
            stmt.setString(5, contacto.getEmail());
            stmt.setInt(6, contacto.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar contacto por número de teléfono
    public boolean eliminarPorTelefono(int telefono) {
        String sql = "DELETE FROM Contacto WHERE telefono = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, telefono);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

