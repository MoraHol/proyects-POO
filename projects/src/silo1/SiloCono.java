
package silo1;
/**
* Esta clase permite crear objetos de tipo SiloCono
*
* @author 
*/
public class SiloCono extends Silo {

    private final double radio;
    private final double altura;

    /**
     * Construye un objeto de esta clase e inicializa sus atributos
     *
     * @param radio Radio del silo coníco
     * @param altura Altura del silo coníco
     */
    public SiloCono(double radio, double altura) {
// Llama al constructor de la clase padre: Silo
        super("Silo Canico");
        this.radio = radio;
        this.altura = altura;
    }

    /**
     * Calcula la superficie del cono
     */
    @Override
    public void calculaSuperficie() {
        superficie = Math.PI * radio * (radio
                + Math.sqrt(radio * radio + altura * altura));
    }

    /**
     * Calcula el volumen del cono
     */
    @Override
    public void calculaVolumen() {
        volumen = Math.PI * radio * radio * altura / 3;
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
