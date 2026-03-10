import java.util.Random; /* Importa la clase Random para generar numeros aleatorios */
import javax.swing.JLabel; /* Importa la clase JLabel para mostrar el numero del dado */
import javax.swing.ImageIcon;
public class Dado {

    private int numero; /* Atributo para almacenar el numero del dado */

    public void lanzar(Random r) { /* Metodo para lanzar el dado */
        numero = r.nextInt(6) + 1; /* Genera un numero aleatorio entre 1 y 6 y lo asigna al atributo numero */
    }

    public int getNumero() { /* Metodo para obtener el numero del dado */
        return numero;
    }

    public void mostrarDado(JLabel lblDado) { /* Metodo para mostrar el numero del dado */
        String archivoImagen="imagenes/"+numero+".jpg"; /* Ruta de la imagen del dado */
        ImageIcon imgDado=new ImageIcon(getClass().getResource(archivoImagen)); /* Crea un objeto ImageIcon con la imagen del dado */
        lblDado.setIcon(imgDado); /* Establece la imagen del dado en el JLabel */

    }
}
