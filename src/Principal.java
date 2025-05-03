import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el límite de la tarjeta: ");
        double limite = lectura.nextDouble();
        GiftCard tarjeta = new GiftCard(limite);

        int salir = 1;
        while(salir != 0) {

            if(tarjeta.getSaldo() == 0){
                System.out.println("Compra finalizada: saldo gotado");
                break;
            }

            if(tarjeta.getCantidadDeCompras() >= 3){
                System.out.println("Compra finalizada: puedes comprar un máx. de 3 productos con tu Gift Card");
                break;
            }
            System.out.println("Escriba la descripción de la compra:");
            String descripcion = lectura.next();

            System.out.println("Escriba el valor de la compra:");
            double valor = Double.valueOf(lectura.next());

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjeta.lanzarCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
            } else {
                System.out.println("Saldo insuficiente para la compra");
            }
            System.out.println("\nEscriba 0 para salir o 1 para continuar");
            salir = lectura.nextInt();
        }
        System.out.println("\n***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        Collections.sort(tarjeta.getListaDeCompras());
        for (Compra compra : tarjeta.getListaDeCompras()) {
            System.out.println(compra.getDescripcion() + " - " +compra.getValor());
        }
        System.out.println("\n***********************");
        System.out.println("\nSaldo de la tarjeta: " +tarjeta.getSaldo());
    }

}
