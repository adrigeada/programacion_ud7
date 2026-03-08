package org.example.EjercicioFuncionario;

import java.util.Objects;

public class Informe {
    private int codigo;
    private String descripcion;
    private TipoInforme tipo;

    public Informe(int codigo,String descripcion,TipoInforme tipo){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public TipoInforme getTipo() {
        return tipo;
    }

    public void setTipo(TipoInforme tipo) {
        this.tipo = tipo;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Informe informe = (Informe) o;
        return codigo == informe.codigo && Objects.equals(descripcion, informe.descripcion) && tipo == informe.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descripcion, tipo);
    }
}
