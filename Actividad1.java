import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Usuario {
    String nombre, id;

    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }
}

class Trabajador {
    String nombre;

    public Trabajador(String nombre) {
        this.nombre = nombre;
    }
}

class Caso {
    static int contador = 1;
    int id;
    String estado;
    Usuario usuario;
    Trabajador trabajador;

    public Caso(Usuario usuario, Trabajador trabajador) {
        this.id = contador++;
        this.estado = "Abierto";
        this.usuario = usuario;
        this.trabajador = trabajador;
        System.out.println("Caso creado con ID: " + this.id);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Caso> casos = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Crear caso\n2. Ver caso\n3. Actualizar caso\n4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre del usuario: ");
                String nombreUsuario = entrada.nextLine();
                System.out.print("ID del usuario: ");
                String idUsuario = entrada.nextLine();
                Usuario usuario = new Usuario(nombreUsuario, idUsuario);

                System.out.print("Nombre del trabajador: ");
                String nombreTrabajador = entrada.nextLine();
                Trabajador trabajador = new Trabajador(nombreTrabajador);

                casos.add(new Caso(usuario, trabajador));

            } else if (opcion == 2) {
                System.out.print("Ingrese el ID del caso: ");
                int id = entrada.nextInt();
                boolean encontrado = false;
                for (Caso caso : casos) {
                    if (caso.id == id) {
                        System.out.println("Caso ID: " + caso.id + " | Estado: " + caso.estado);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) System.out.println("Caso no encontrado.");

            } else if (opcion == 3) {
                System.out.print("Ingrese el nombre del trabajador: ");
                String nombreTrabajador = entrada.nextLine();
                boolean actualizado = false;
                for (Caso caso : casos) {
                    if (caso.trabajador.nombre.equalsIgnoreCase(nombreTrabajador)) {
                        System.out.print("Nuevo estado: ");
                        caso.estado = entrada.nextLine();
                        System.out.println("Estado actualizado.");
                        actualizado = true;
                    }
                }
                if (!actualizado) System.out.println("No se encontraron casos para este trabajador.");

            } else if (opcion == 4) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
}
