import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class FrmJuego extends JFrame {

    private Dado dado1=new Dado(); /* Atributo para almacenar el primer dado */
    private Dado dado2=new Dado(); /* Atributo para almacenar el segundo dado */
    private Random r = new Random(); /* Atributo para generar numeros aleatorios */
    private JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas; /* Atributos para almacenar los JLabel de los dados, lanzamientos y cenas */

    private int lanzamientos,cenas; /* Atributo para almacenar el numero de lanzamientos y cenas */
    
    

    /* Metodo constructor */
    public FrmJuego(){
        setSize(500,300); /* Establece el tamaño de la ventana */
        setTitle("Juguemos a los dados"); /* Establece el titulo de la ventana */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* Establece la operacion de cierre de la ventana */
        setLayout(null);

        String archivoImagen="imagenes/1.jpg"; /* Ruta de la imagen del dado */
        ImageIcon imgDado=new ImageIcon(getClass().getResource(archivoImagen)); /* Crea un objeto ImageIcon con la imagen del dado */
        
        lblDado1=new JLabel(imgDado); /* Crea un JLabel con la imagen del dado */
        lblDado1.setBounds(10, 10, imgDado.getIconWidth(), imgDado.getIconHeight()); /* Establece la posicion y el tamaño del JLabel */
        add(lblDado1); /* Agrega el JLabel a la ventana */

        lblDado2=new JLabel(imgDado); /* Crea un JLabel con la imagen del dado */
        lblDado2.setBounds(20+imgDado.getIconWidth(), 10, imgDado.getIconWidth(), imgDado.getIconHeight()); /* Establece la posicion y el tamaño del JLabel */
        add(lblDado2); /* Agrega el JLabel a la ventana */

        JLabel LblTituloLanzamiento=new JLabel("Lanzamiento"); /* Crea un JLabel con el texto "Lanzamiento" */
        LblTituloLanzamiento.setBounds(30+2*imgDado.getIconWidth(), 10, 100, 25); /* Establece la posicion y el tamaño del JLabel */
        add(LblTituloLanzamiento); /* Agrega el JLabel a la ventana */

        lblLanzamientos= new JLabel("0"); /* Crea un JLabel con el texto "0" */
        lblLanzamientos.setBounds(30+2*imgDado.getIconWidth(), 45, 100, 100); /* Establece la posicion y el tamaño del JLabel */
        lblLanzamientos.setFont(new Font("Impact", Font.BOLD, 72)); /* Establece la fuente del JLabel */
        lblLanzamientos.setBackground(new Color(0,0,0)); /* Establece el color de fondo del JLabel */
        lblLanzamientos.setForeground(new Color(0,255,0)); /* Establece el color del texto del JLabel */
        lblLanzamientos.setOpaque(true); /* Establece el JLabel como opaco para que se vea el color de fondo */
        lblLanzamientos.setHorizontalAlignment(JLabel.RIGHT); /* Establece la alineacion horizontal del texto del JLabel */
        add(lblLanzamientos); /* Agrega el JLabel a la ventana */



        JLabel LblTituloCenas=new JLabel("Cenas"); /* Crea un JLabel con el texto "Cenas" */
        LblTituloCenas.setBounds(140+2*imgDado.getIconWidth(), 10, 100, 25); /* Establece la posicion y el tamaño del JLabel */
        add(LblTituloCenas); /* Agrega el JLabel a la ventana */

        lblCenas= new JLabel("0"); /* Crea un JLabel con el texto "0" */
        lblCenas.setBounds(140+2*imgDado.getIconWidth(), 45, 100, 100); /* Establece la posicion y el tamaño del JLabel */
        lblCenas.setFont(new Font("Impact", Font.BOLD, 72)); /* Establece la fuente del JLabel */
        lblCenas.setBackground(new Color(0,0,0)); /* Establece el color de fondo del JLabel */
        lblCenas.setForeground(new Color(0,255,0)); /* Establece el color del texto del JLabel */
        lblCenas.setOpaque(true); /* Establece el JLabel como opaco para que se vea el color de fondo */
        lblCenas.setHorizontalAlignment(JLabel.RIGHT); /* Establece la alineacion horizontal del texto del JLabel */
        add(lblCenas); /* Agrega el JLabel a la ventana */

        JButton btnIniciar=new JButton("Iniciar"); /* Crea un JButton con el texto "Iniciar" */
        btnIniciar.setBounds(10, 20+imgDado.getIconHeight(), 100, 25); /* Establece la posicion y el tamaño del JButton */
        add(btnIniciar); /* Agrega el JButton a la ventana */

        JButton btnLanzar=new JButton("Lanzar"); /* Crea un JButton con el texto "Lanzar" */
        btnLanzar.setBounds(10, 55+imgDado.getIconHeight(), 100, 25); /* Establece la posicion y el tamaño del JButton */
        add(btnLanzar); /* Agrega el JButton a la ventana */


        // Eventos de los botones
        btnIniciar.addActionListener(e-> {
            iniciar();
        });

        btnLanzar.addActionListener(e-> {
            lanzar();
        });

    }

    private void iniciar(){
        lanzamientos=0; /* Reinicia el numero de lanzamientos */
        cenas=0; /* Reinicia el numero de cenas */
        lblLanzamientos.setText(String.valueOf(lanzamientos)); /* Actualiza el JLabel de lanzamientos */
        lblCenas.setText(String.valueOf(cenas)); /* Actualiza el JLabel de cenas */
    }

    private void lanzar(){
        dado1.lanzar(r);
        dado2.lanzar(r);

        dado1.mostrarDado(lblDado1);
        dado2.mostrarDado(lblDado2);

        lanzamientos++;
        lblLanzamientos.setText(String.valueOf(lanzamientos));

        if(dado1.getNumero()+dado2.getNumero()>=11){
            cenas++;
            lblCenas.setText(String.valueOf(cenas));
        }
    }
}
