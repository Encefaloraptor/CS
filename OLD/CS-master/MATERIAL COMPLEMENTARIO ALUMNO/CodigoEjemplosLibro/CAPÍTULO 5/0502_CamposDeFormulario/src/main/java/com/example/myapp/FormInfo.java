package com.example.myapp;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class FormInfo {
    private String nombre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    private Boolean acepto;
    private Integer estadoCivil;
    private Genero generoPersona;
    private Integer curso;
    private String provinciaNacimiento;
    

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Boolean getAcepto() {
        return acepto;
    }
    public void setAcepto(Boolean acepto) {
        this.acepto = acepto;
    }
    public Integer getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(Integer estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public Genero getGeneroPersona() {
        return generoPersona;
    }
    public void setGeneroPersona(Genero generoPersona) {
        this.generoPersona = generoPersona;
    }
    public Integer getCurso() {
        return curso;
    }
    public void setCurso(Integer curso) {
        this.curso = curso;
    }
    public String getProvinciaNacimiento() {
        return provinciaNacimiento;
    }
    public void setProvinciaNacimiento(String provinciaNacimiento) {
        this.provinciaNacimiento = provinciaNacimiento;
    }

    @Override
    public String toString() {
        return " nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", acepto=" + acepto
                + ", estadoCivil=" + estadoCivil + ", generoPersona=" + generoPersona + ", curso=" + curso
                + ", provinciaNacimiento=" + provinciaNacimiento + "";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FormInfo other = (FormInfo) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (fechaNacimiento == null) {
            if (other.fechaNacimiento != null)
                return false;
        } else if (!fechaNacimiento.equals(other.fechaNacimiento))
            return false;
        return true;
    }
    

}



