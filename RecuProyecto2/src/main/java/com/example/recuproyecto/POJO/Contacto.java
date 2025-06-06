package com.example.recuproyecto.POJO;

public class Contacto {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int telefono;
    private String email;

    public Contacto(int id, String nombre, String apellido1, String apellido2, int telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "----------------------------------------\n" +
                "             CONTACTO                  \n" +
                "----------------------------------------\n" +
                "ID:           " + id + "\n" +
                "Nombre:       " + nombre + "\n" +
                "Apellido 1:   " + apellido1 + "\n" +
                "Apellido 2:   " + (apellido2 != null ? apellido2 : "-") + "\n" +
                "Teléfono:     " + telefono + "\n" +
                "Email:        " + email + "\n" +
                "----------------------------------------";
    }

}
