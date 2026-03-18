package org.example.PracticaMercadona;

import java.util.Objects;

public class Cliente {
    private String usuario;
    private String contrasenya;
    private String direccion;
    private Pedido pedido;
    private boolean promociones;

    public Cliente(String usuario, String contrasenya, Pedido pedido, boolean promociones) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        direccion = "Calle falsa, 123";
        this.pedido = pedido;
        this.promociones = promociones;
    }

    public Cliente(String usuario,String contrasenya){
        this.usuario = usuario;
        this.contrasenya = contrasenya;
    }

    public void crearPedido(){

    }

    public void insertarProducto(Producto producto){

    }

    public boolean isPromociones() {
        return promociones;
    }

    public void setPromociones(boolean promociones) {
        this.promociones = promociones;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "usuario='" + usuario + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", direccion='" + direccion + '\'' +
                ", pedido=" + pedido +
                ", promociones=" + promociones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return promociones == cliente.promociones && Objects.equals(usuario, cliente.usuario) && Objects.equals(contrasenya, cliente.contrasenya) && Objects.equals(direccion, cliente.direccion) && Objects.equals(pedido, cliente.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, contrasenya, direccion, pedido, promociones);
    }
}
