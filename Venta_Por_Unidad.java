package Cordiprogramas;

public class Venta_Por_Unidad {
	private int cant;
    private int precio_total;
    private Productos prod; 

    public Venta_Por_Unidad(Productos prod, int cant) {
        this.prod = prod;
        this.cant = cant;
        this.precio_total = this.cant * prod.getPrecio(); 
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
        this.precio_total = this.cant * prod.getPrecio(); 
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(int precio_total) {
        this.precio_total = precio_total;
    }

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
}
