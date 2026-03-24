package org.example.preExamen;

import java.util.*;

public class Usuario implements Acciones{

    static Scanner teclado = new Scanner(System.in);

    private String nombre_usuario;
    private String contrasenya;
    private Map<Evento,Integer> carritoCompra;

    public Usuario(String nombre_usuario, String contrasenya) {
        this.nombre_usuario = nombre_usuario;
        this.contrasenya = contrasenya;
        carritoCompra = new HashMap<>();
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Map<Evento, Integer> getCarritoCompra() {
        return carritoCompra;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "nombre_usuario='" + nombre_usuario + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", carritoCompra=" + carritoCompra +
                '}';
    }

    @Override
    public void pagar() {

    }

    @Override
    public boolean autenticarse(Set<Usuario> usuariosRegistrados) {
        System.out.println("BIENVENIDO A TICKET MUTXA");
        System.out.println();

        String usuario = "";
        String contrasenya = "";

        System.out.println("Inicia sesion");

        fuera:
        while(true){
            System.out.println("Usuario:");
            usuario = teclado.nextLine();
            System.out.println("Contraseña:");
            contrasenya = teclado.nextLine();

            for (Usuario miniUsuario : usuariosRegistrados){
                if (miniUsuario.getNombre_usuario().equals(usuario) && miniUsuario.getContrasenya().equals(contrasenya)){
                    System.out.println("BIENVENIDO");
                    break fuera;
                }else {
                    System.out.println("Credenciales no válidas");

                }


            }
        }
        this.nombre_usuario = usuario;
        this.contrasenya = contrasenya;
        System.out.println("Hola "+usuario+". Elige un evento para iniciar la compra:");

        return true;
    }

    public void anyadirAlCarrito(Evento evento,int cantidad){

    }

    public void setCarrito(Map<Evento, Integer> carritoCompra) {
        this.carritoCompra = carritoCompra;
    }

    public void verCarrito(){

    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre_usuario, usuario.nombre_usuario) && Objects.equals(contrasenya, usuario.contrasenya);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre_usuario, contrasenya);
    }
}
