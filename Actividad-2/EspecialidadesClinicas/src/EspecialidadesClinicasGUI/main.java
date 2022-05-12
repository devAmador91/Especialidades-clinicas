package EspecialidadesClinicasGUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Amador
 */
public class main {

    public static void main(String[] args) {
        InterfazGUI interfaz = new InterfazGUI();
        final int MODULODATOSPERSONALES = 1;
        interfaz.setTitle("DPO2-DP02-2102-B1-002");
        interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interfaz.setExtendedState(6);
        interfaz.setResizable(true);
        interfaz.setLayout(new BorderLayout());
        interfaz.panelPrincipal = interfaz.crearVentanaPrincipal(MODULODATOSPERSONALES);
        interfaz.add(interfaz.panelPrincipal);
        interfaz.setVisible(true);

    }

}
