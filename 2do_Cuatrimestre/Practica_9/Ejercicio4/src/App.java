/*
    Crear una aplicación java de consola para un supermercado, donde se hace un 20% de
descuento a los clientes cuya compra supere los $ 1.000 en las áreas de frutas, verduras y
abarrotes. ¿Cuál será el total que pagará una persona por su compra?, se debe mostrar el
nombre del cliente, producto, precio, cantidad, descuento y total a pagar.
Crear los métodos que consideres necesarios para la resolución de esta aplicación.
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        comprar();
    }
    
    public static void datosCliente() {
        try (Scanner leer = new Scanner(System.in)) {
            System.out.println("Ingresar el nombre del cliente");
            String nombre = leer.nextLine();

            System.out.println("\nNombre: " + nombre);
        }
    }

    public static void comprar() {
        try (Scanner leer = new Scanner(System.in)) {
            System.out.println("Hay un 20% de descuento en: frutas, verduras y abarrotes gastando más de $1000 \nIngrese el producto que desee comprar");
            System.out.println("Disponemos de: fruta, verdura, abarrote, carne, pollo, pezcado, postre");
            
            

            System.out.println("Cuandos productos desea comprar?");
            int cantidad = leer.nextInt(); 
            String[] producto = new String[cantidad];
            producto[0] = leer.nextLine();/*Sin esta linea no me funciona el siguiente scan, igualmente no retorna nada */

            for (int i = 0; i < cantidad; i++) {
                System.out.println("Escriba el producto " + (i + 1));
                producto[i] = leer.nextLine();
            }
            
            Double suma = 0.0;

            for (String j : producto) {
                System.out.println("Ingrese el monto de " + j);
                Double monto = leer.nextDouble();
                suma += monto;  
            }
            
            Double descuento = 0.0;

            for (int h = 0; h < producto.length; h++){
                if (producto[h].equals("fruta") || producto[h].equals("verdura") || producto[h].equals("abarrote")) {
                    if (suma >= 1000) {
                        descuento = (suma * 20) / 100;
                    }
                }
            }
            
            Double precioFinal = suma - descuento;
            
            System.out.println("");
            datosCliente();
            System.out.println("Productos:");
            for (String k : producto) {
                System.out.println(k);
            }
        
            System.out.println("Precio inicial: $" + suma);
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Descuento: $" + descuento);
            System.out.println("Precio final: $" + precioFinal);
        }
    }
}