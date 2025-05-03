import java.util.ArrayList;
import java.util.List;

public class GiftCard {
    private  double limite;
    private double saldo;
    private List<Compra>  listaDeCompras;
    private int cantidadDeCompras = 0;

    public GiftCard(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaDeCompras = new ArrayList<>();
    }
    public boolean lanzarCompra(Compra compra) {
        if (this.saldo >= compra.getValor() && cantidadDeCompras <3) {
            this.saldo -= compra.getValor();
            this.listaDeCompras.add(compra);
            cantidadDeCompras++;
            return true;
        }
        return false;
    }



//getters


    public int getCantidadDeCompras() {
        return cantidadDeCompras;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }
}
