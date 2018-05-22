
package silo1;

/**
 * Esta clase permite crear objetos de tipo SiloCilindro
 *
 * @author 
 */
public class SiloCilindro extends Silo {

    private final double radio;
    private final double altura;

    /**
     * Construye un objeto de esta clase e inicializa sus atributos
     *
     * @param radio Radio del silo cilíndrico
     * @param altura Altura del silo cilíndrico
     */
    public SiloCilindro(double radio, double altura) {
// Llama al constructor de la clase padre: Silo
        super("Silo Cilindrico");
        this.radio = radio;
        this.altura = altura;
    }

    /**
     * Calcula la superficie del cilindro
     */
    @Override
    public void calculaSuperficie() {
        superficie = 2 * Math.PI * radio * (radio + altura);
    }

    /**
     * Calcula el volumen del cilindro
     */
    @Override
    public void calculaVolumen() {
        volumen = Math.PI * radio * radio * altura;
    }

    /**
     * Genera una cadena con los valores de los atributos de la clase
     *
     * @return Una cadena con los valores de los atributos de la clase
     */
    @Override
    public String toString() {
        return super.toString() + ", radio = " + radio + ", altura = "
                + altura + ", superficie = " + superficie + ", volumen = "
                + volumen;
    }
}
