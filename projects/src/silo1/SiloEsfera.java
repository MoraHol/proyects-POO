
package silo1;

/**
 * Esta clase permite crear objetos de tipo SiloEsfera
 *
 * @author 
 */
public class SiloEsfera extends Silo {

    private final double radio;
    /**
     * Construye un objeto de esta clase e inicializa sus atributos
     * @param radio Radio del silo esférico
    */
    public SiloEsfera(double radio) {
    // Llama al constructor de la clase padre: Silo
            super("Silo Esferico");
            this.radio = radio;
    }

    /**
     * Calcula la superficie de la esfera
     */
    @Override
    public void calculaSuperficie() {
        superficie = 4 * Math.PI * radio * radio;
    }

    /**
     * Calcula el volumen de la esfera
     */
    @Override
    public void  calculaVolumen() {
        volumen = 4 * Math.PI * radio * radio * radio / 3;
    }

    /**
     * Genera una cadena con los valores de los atributos de la clase
     *
     * @return Una cadena con los valores de los atributos de la clase
     */
    @Override
    public String toString() {
        return super.toString() + ", radio = " + radio + ", superficie = "
                + superficie + ", volumen = " + volumen;
    }
}
