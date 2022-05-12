/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspecialidadesClinicasGUI;

import Datos.DatosBD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import BaseDeDatos.ConexionBD;
import Datos.Consultas;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InterfazGUI extends JFrame implements ActionListener, ItemListener {

    //Componentes
    JPanel panelPrincipal;
    //PanelNorte:
    JMenuBar barraMenu;
    JMenu archivo;
    JMenuItem nuevoRegistro;
    JMenuItem eliminarRegistro;
    JMenuItem guardarRegistro;
    JMenu edicion;
    JMenuItem copiar;
    JMenuItem cortar;
    JMenuItem pegar;
    JMenu configuracion;
    JMenuItem opciones;
    JMenuItem baseDeDatos;
    JMenuItem ayuda;
    JMenu salir;
    JMenuItem guardarYSalir;
    JComboBox<String> perfilProfesional;
    JButton altaDatosPersonales;
    JButton altaDatosProfesionales;
    JButton consultaDocente;
    JButton consultaPerfil;
    JButton expedienteClinico;
    JButton expedienteCovid;
    JButton experienciaLaboral;
    JButton proyectosInvestigacion;
    JButton jornadaLaboral;
    JButton agregar;
    JTextField materia;
    JTextArea agregado;
    JScrollPane scrollMateria;
    JButton buscarDocente;
    JButton buscarPerfil;
    JButton limpiarDatosPersonales;
    JButton guardarDatosPersonales;
    JTextField campoIDPersonales;
    JTextField campoNombrePersonales;
    JTextField campoApellidoPersonales;
    JTextField campoRFCPersonales;
    JTextField campoDireccionPersonales;
    JTextField campoEstadoCivilPersonales;
    JTextField campoTelefonoPersonales;
    JButton guardarDatosProfesionales;
    JButton limpiarDatosProfesionales;
    JTextField campoExperienciaProfesional;
    JTextField campoCedulaProfesional;
    JTextField campoEspecialidadProfesional;
    JTextField campoDireccionProfesional;
    JTextField campoEstadoCivilProfesional;
    JButton salirConsultaProfesional;
    JButton salirConsultaPersonales;
    JTextField consultaCampoID;
    JButton consultaCampoNombre;
    JButton consultaCampoApellido;
    JButton consultaCampoRFC;
    JButton consultaCampoDireccion;
    JButton consultaCampoEstadoCivil;
    JButton consultaCampoTelefono;
    JTextField campoNumeroEmpleado;
    JButton consultaCampoIDButton;
    JButton consultaPerfilCampoNombre;
    JButton consultaPerfilCampoApellido;
    JButton consultaPerfilCampoCedula;
    JButton consultaPerfilCampoGrado;
    JButton consultaPerfilCampoEspecialidad;
    JButton delete;
    JButton delete2;
    String numEmpleado;
    String nombreTabla;
    final int MODULODATOSPERSONALES = 1;
    final int MODULODATOSPROFESIONALES = 2;
    final int MODULOEXPEDIENTECLINICO = 3;
    final int MODULOEXPEDIENTECOVID = 4;
    final int MODULOEXPERIENCIALABORAL = 5;
    final int MODULOPROYECTOSINVESTIGACION = 6;
    final int MODULOJORNADALABORAL = 7;
    final int MODULOCONSULTADOCENTE = 8;
    final int MODULOCONSULTAPERFIL = 9;

    //Personalizacion
    Font fuenteFormulario;
    Font tituloFormulario;
    Font tituloConsulta;

    //Metodos de diseÃ±o de ventanas Principal la cual depeniedo de a donde pulse el usuario, se llamaran a los metodos que crearan los paneles con los distintos modulos
    public JPanel crearVentanaPrincipal(int numModulo) {
        //Declaracion de paneles a usar:
        panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelSecundario = new JPanel(new BorderLayout(50, 50));
        JPanel panelSecundario2 = new JPanel(new FlowLayout());
        JPanel panelNorte = new JPanel(new BorderLayout());
        JPanel panelLeft = new JPanel(new BorderLayout());
        JPanel panelLeft2 = new JPanel(new FlowLayout(40, 80, 100));
        JPanel panelLeft3 = new JPanel(new FlowLayout(15, 15, 15));
        JPanel panelLeft4 = new JPanel(new BorderLayout());
        JPanel panelRight = new JPanel(new BorderLayout());
        JPanel panelRight2 = new JPanel(new FlowLayout(40, 80, 100));
        JPanel panelRight3 = new JPanel(new FlowLayout(15, 15, 15));
        JPanel panelRight4 = new JPanel(new BorderLayout());
        panelLeft2.setBackground(Color.LIGHT_GRAY);
        panelLeft3.setBackground(Color.LIGHT_GRAY);
        panelRight2.setBackground(Color.LIGHT_GRAY);
        panelRight3.setBackground(Color.LIGHT_GRAY);
        panelSecundario2.setBackground(Color.LIGHT_GRAY);
        panelLeft.add(panelLeft2, BorderLayout.NORTH);
        panelLeft.add(panelLeft3, BorderLayout.CENTER);
        panelLeft.add(panelLeft4, BorderLayout.SOUTH);
        panelRight.add(panelRight2, BorderLayout.NORTH);
        panelRight.add(panelRight3, BorderLayout.CENTER);
        panelRight.add(panelRight4, BorderLayout.SOUTH);
        JPanel panelCentral = new JPanel();
        //Panel Norte menus:
        barraMenu = new JMenuBar();
        archivo = new JMenu("Archivo");
        nuevoRegistro = new JMenuItem("Nuevo Registro");
        archivo.add(nuevoRegistro);
        eliminarRegistro = new JMenuItem("Eliminar Registro");
        archivo.add(eliminarRegistro);
        guardarRegistro = new JMenuItem("Guardar Registro");
        archivo.add(guardarRegistro);
        edicion = new JMenu("Edicion");
        copiar = new JMenuItem("Copiar");
        edicion.add(copiar);
        cortar = new JMenuItem("Cortar");
        edicion.add(cortar);
        pegar = new JMenuItem("Pegar");
        edicion.add(pegar);
        configuracion = new JMenu("Configuracion");
        opciones = new JMenuItem("Opciones");
        configuracion.add(opciones);
        baseDeDatos = new JMenuItem("Base de Datos");
        configuracion.add(baseDeDatos);
        ayuda = new JMenuItem("Ayuda");
        configuracion.add(ayuda);
        salir = new JMenu("Salir");
        guardarYSalir = new JMenuItem("Guardar y Salir");
        salir.add(guardarYSalir);
        barraMenu.add(archivo);
        barraMenu.add(edicion);
        barraMenu.add(configuracion);
        barraMenu.add(salir);
        panelNorte.add(barraMenu, BorderLayout.NORTH);
        panelPrincipal.add(panelNorte, BorderLayout.NORTH);
        panelSecundario.add(panelSecundario2, BorderLayout.NORTH);
        panelSecundario.add(panelCentral, BorderLayout.CENTER);
        panelPrincipal.add(panelSecundario, BorderLayout.CENTER);
        //ComboBox Perfil Profesional
        perfilProfesional = new JComboBox<>();
        perfilProfesional.addItemListener(this);
        perfilProfesional.addItem("Medico Cirujano");
        perfilProfesional.addItem("Medico General");
        perfilProfesional.addItem("Medico Forense");
        panelSecundario2.add(perfilProfesional);
        //Botones modulos
        altaDatosPersonales = new JButton("Alta Datos Personales");
        altaDatosPersonales.addActionListener(this);
        if (numModulo == 1) {
            altaDatosPersonales.setForeground(Color.red);
        }
        panelSecundario2.add(altaDatosPersonales);
        altaDatosProfesionales = new JButton("Alta Datos Profesionales");
        altaDatosProfesionales.addActionListener(this);
        if (numModulo == 2) {
            altaDatosProfesionales.setForeground(Color.red);
        }
        panelSecundario2.add(altaDatosProfesionales);
        consultaDocente = new JButton("Consulta Docente");
        consultaDocente.addActionListener(this);
        if (numModulo == 8) {
            consultaDocente.setForeground(Color.red);
        }
        panelSecundario2.add(consultaDocente);
        consultaPerfil = new JButton("Consulta Perfil Docente");
        consultaPerfil.addActionListener(this);
        if (numModulo == 9) {
            consultaPerfil.setForeground(Color.red);
        }
        panelSecundario2.add(consultaPerfil);

        //Panel Consultas Docente Izquierda
        JLabel tituloConsultaDocente = new JLabel("Consulta Docente");
        tituloConsulta = new Font("Arial", Font.ITALIC, 25);
        tituloConsultaDocente.setFont(tituloConsulta);
        panelLeft2.add(tituloConsultaDocente);
        JLabel numeroEmpleado = new JLabel("Numero de Empleado:");
        campoNumeroEmpleado = new JTextField(15);
        buscarDocente = new JButton("Buscar");
        buscarDocente.addActionListener(this);
        panelLeft3.add(numeroEmpleado);
        panelLeft3.add(campoNumeroEmpleado);
        panelLeft4.add(buscarDocente);
        panelPrincipal.add(panelLeft, BorderLayout.WEST);

        //Panel Consultas Perfil Derecha
        JLabel tituloConsultaPerfil = new JLabel("Consulta Perfil");
        tituloConsultaPerfil.setFont(tituloConsulta);
        panelRight2.add(tituloConsultaPerfil);
        JLabel iD = new JLabel("Numero ID:");
        consultaCampoID = new JTextField(15);
        buscarPerfil = new JButton("Buscar");
        buscarPerfil.addActionListener(this);
        panelRight3.add(iD);
        panelRight3.add(consultaCampoID);
        panelRight4.add(buscarPerfil);
        panelPrincipal.add(panelRight, BorderLayout.EAST);
        //Agregar Modulos dependiendo el parametro recibido en el metodo
        if (numModulo == 1) {
            panelCentral.add(crearDatosPersonales());
        }
        if (numModulo == 2) {
            panelCentral.add(crearAltaDatosProfesionales());
        }
        if (numModulo == 3) {
            panelCentral.add(crearAltaExpedienteClinico());
        }
        if (numModulo == 4) {
            panelCentral.add(crearAltaExpedienteCovid());
        }
        if (numModulo == 5) {
            panelCentral.add(crearAltaExperienciaLaboral());
        }
        if (numModulo == 6) {
            panelCentral.add(crearAltaProyectosInvestigacion());
        }
        if (numModulo == 7) {
            panelCentral.add(crearAltaJornadaLaboral());
        }
        if (numModulo == 8) {
            panelCentral.add(crearConsultaDocente());
        }
        if (numModulo == 9) {
            panelCentral.add(crearConsultaPerfil());
        }

        return panelPrincipal;

    }

    //Modulos: 
    private JPanel crearDatosPersonales() {
        //DiseÃ±o
        JPanel panelDatosPersonales = new JPanel(new BorderLayout(0, 50));
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        JPanel panelModulos = new JPanel(new GridLayout(0, 1));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.add(Box.createRigidArea(new Dimension(25, 0)));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.add(Box.createRigidArea(new Dimension(25, 0)));
        panelDatosPersonales.add(panelLeft, BorderLayout.WEST);
        panelDatosPersonales.add(panelRight, BorderLayout.EAST);
        JPanel panelNorte = new JPanel(new FlowLayout());//Titulo
        JPanel panelSur = new JPanel(new GridLayout(1, 2));//Botones
        panelSur.setBorder(BorderFactory.createLineBorder(Color.RED));
        JPanel panelCentro1 = new JPanel(new BorderLayout());
        panelCentro1.add(panelModulos, BorderLayout.WEST);
        JPanel panelCentro2 = new JPanel(new GridLayout(7, 2, 0, 15));//Formulario
        panelCentro2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        panelDatosPersonales.add(panelSur, BorderLayout.SOUTH);
        panelCentro1.add(panelCentro2, BorderLayout.CENTER);
        panelDatosPersonales.add(panelNorte, BorderLayout.NORTH);
        panelDatosPersonales.add(panelCentro1, BorderLayout.CENTER);
        //Formulario
        JLabel tituloDatosPersonales = new JLabel("Datos Personales");
        tituloFormulario = new Font("Arial", Font.BOLD, 40);
        tituloDatosPersonales.setFont(tituloFormulario);
        panelNorte.add(tituloDatosPersonales);
        JLabel etiquetaID = new JLabel("ID:");
        fuenteFormulario = new Font("Arial", Font.ITALIC, 25);
        etiquetaID.setFont(fuenteFormulario);
        campoIDPersonales = new JTextField(20);
        campoIDPersonales.setEnabled(false);
        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setFont(fuenteFormulario);
        campoNombrePersonales = new JTextField(20);
        JLabel etiquetaApellido = new JLabel("Apellido:");
        etiquetaApellido.setFont(fuenteFormulario);
        campoApellidoPersonales = new JTextField(20);
        JLabel etiquetaRFC = new JLabel("RFC:");
        etiquetaRFC.setFont(fuenteFormulario);
        campoRFCPersonales = new JTextField(20);
        JLabel etiquetaDireccion = new JLabel("Direccion:");
        etiquetaDireccion.setFont(fuenteFormulario);
        campoDireccionPersonales = new JTextField(40);
        JLabel etiquetaEstadoCivil = new JLabel("Estado Civil:");
        etiquetaEstadoCivil.setFont(fuenteFormulario);
        campoEstadoCivilPersonales = new JTextField(10);
        JLabel etiquetaTelefono = new JLabel("Telefono:");
        etiquetaTelefono.setFont(fuenteFormulario);
        campoTelefonoPersonales = new JTextField(15);
        panelCentro2.add(etiquetaID);
        panelCentro2.add(campoIDPersonales);
        panelCentro2.add(etiquetaNombre);
        panelCentro2.add(campoNombrePersonales);
        panelCentro2.add(etiquetaApellido);
        panelCentro2.add(campoApellidoPersonales);
        panelCentro2.add(etiquetaRFC);
        panelCentro2.add(campoRFCPersonales);
        panelCentro2.add(etiquetaDireccion);
        panelCentro2.add(campoDireccionPersonales);
        panelCentro2.add(etiquetaEstadoCivil);
        panelCentro2.add(campoEstadoCivilPersonales);
        panelCentro2.add(etiquetaTelefono);
        panelCentro2.add(campoTelefonoPersonales);
        //Botones

        expedienteClinico = new JButton("Expediente Clinico");
        expedienteClinico.addActionListener(this);
        expedienteCovid = new JButton("Expediente Covid");
        expedienteCovid.addActionListener(this);
        panelModulos.add(expedienteClinico);
        panelModulos.add(expedienteCovid);

        ImageIcon iconoOriginalGuardar = new ImageIcon(getClass().getResource("/Imagenes/disquete.png"));
        int ancho = 25;
        int alto = 25;
        ImageIcon iconoNuevaGuardar = new ImageIcon(iconoOriginalGuardar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));

        guardarDatosPersonales = new JButton("Guardar");
        guardarDatosPersonales.addActionListener(this);
        guardarDatosPersonales.setIcon(iconoNuevaGuardar);
        guardarDatosPersonales.setIconTextGap(2);
        guardarDatosPersonales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardarDatosPersonales.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        guardarDatosPersonales.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        guardarDatosPersonales.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        limpiarDatosPersonales = new JButton("Limpiar");
        ImageIcon iconoOriginalLimpiar = new ImageIcon(getClass().getResource("/Imagenes/limpiar.png"));
        ImageIcon iconoLimpiar = new ImageIcon(iconoOriginalLimpiar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
        limpiarDatosPersonales.addActionListener(this);
        limpiarDatosPersonales.setIcon(iconoLimpiar);
        limpiarDatosPersonales.setIconTextGap(2);
        limpiarDatosPersonales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        limpiarDatosPersonales.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        limpiarDatosPersonales.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        limpiarDatosPersonales.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        panelSur.add(guardarDatosPersonales);
        panelSur.add(limpiarDatosPersonales);

        return panelDatosPersonales;
    }

    private JPanel crearAltaDatosProfesionales() {
        JPanel panelDatosProfesionales = new JPanel(new BorderLayout(0, 50));
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        JPanel panelModulos = new JPanel(new GridLayout(0, 1));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.add(Box.createRigidArea(new Dimension(25, 0)));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.add(Box.createRigidArea(new Dimension(25, 0)));
        panelDatosProfesionales.add(panelLeft, BorderLayout.WEST);
        panelDatosProfesionales.add(panelRight, BorderLayout.EAST);
        JPanel panelNorte = new JPanel(new FlowLayout());//Titulo
        JPanel panelSur = new JPanel(new GridLayout(1, 2));//Botones
        panelSur.setBorder(BorderFactory.createLineBorder(Color.RED));
        JPanel panelCentro1 = new JPanel(new BorderLayout());
        panelCentro1.add(panelModulos, BorderLayout.WEST);
        JPanel panelCentro2 = new JPanel(new GridLayout(5, 2, 0, 15));//Formulario
        panelCentro2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        panelDatosProfesionales.add(panelSur, BorderLayout.SOUTH);
        panelCentro1.add(panelCentro2, BorderLayout.CENTER);
        panelDatosProfesionales.add(panelNorte, BorderLayout.NORTH);
        panelDatosProfesionales.add(panelCentro1, BorderLayout.CENTER);
        //Formulario
        JLabel tituloDatosPersonales = new JLabel("Datos profesionales");
        tituloFormulario = new Font("Arial", Font.BOLD, 40);
        tituloDatosPersonales.setFont(tituloFormulario);
        panelNorte.add(tituloDatosPersonales);
        JLabel etiquetaGrado = new JLabel("Ultimo grado de estudios:");
        fuenteFormulario = new Font("Arial", Font.ITALIC, 25);
        etiquetaGrado.setFont(fuenteFormulario);
        campoExperienciaProfesional = new JTextField();
        campoExperienciaProfesional.setFont(fuenteFormulario);
        JLabel etiquetaCedula = new JLabel("Cedula Profesional:");
        etiquetaCedula.setFont(fuenteFormulario);
        campoCedulaProfesional = new JTextField(20);
        JLabel etiquetaEspecialidad = new JLabel("Especialidad:");
        etiquetaEspecialidad.setFont(fuenteFormulario);
        campoEspecialidadProfesional = new JTextField(20);
        JLabel etiquetaDireccion = new JLabel("Direccion:");
        etiquetaDireccion.setFont(fuenteFormulario);
        campoDireccionProfesional = new JTextField(40);
        JLabel etiquetaEstadoCivil = new JLabel("Estado Civil:");
        etiquetaEstadoCivil.setFont(fuenteFormulario);
        campoEstadoCivilProfesional = new JTextField(10);

        panelCentro2.add(etiquetaGrado);
        panelCentro2.add(campoExperienciaProfesional);
        panelCentro2.add(etiquetaCedula);
        panelCentro2.add(campoCedulaProfesional);
        panelCentro2.add(etiquetaEspecialidad);
        panelCentro2.add(campoEspecialidadProfesional);
        panelCentro2.add(etiquetaDireccion);
        panelCentro2.add(campoDireccionProfesional);
        panelCentro2.add(etiquetaEstadoCivil);
        panelCentro2.add(campoEstadoCivilProfesional);
        //Botones

        experienciaLaboral = new JButton("Experiencia Laboral");
        experienciaLaboral.addActionListener(this);
        proyectosInvestigacion = new JButton("Proyectos de Investigacion");
        proyectosInvestigacion.addActionListener(this);
        jornadaLaboral = new JButton("Jornada Laboral");
        jornadaLaboral.addActionListener(this);
        panelModulos.add(experienciaLaboral);
        panelModulos.add(proyectosInvestigacion);
        panelModulos.add(jornadaLaboral);

        ImageIcon iconoOriginalGuardar = new ImageIcon(getClass().getResource("/Imagenes/disquete.png"));
        int ancho = 25;
        int alto = 25;
        ImageIcon iconoNuevaGuardar = new ImageIcon(iconoOriginalGuardar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));

        guardarDatosProfesionales = new JButton("Guardar");
        guardarDatosProfesionales.addActionListener(this);
        guardarDatosProfesionales.setIcon(iconoNuevaGuardar);
        guardarDatosProfesionales.setIconTextGap(2);
        guardarDatosProfesionales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardarDatosProfesionales.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        guardarDatosProfesionales.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        guardarDatosProfesionales.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        limpiarDatosProfesionales = new JButton("Limpiar");
        ImageIcon iconoOriginalLimpiar = new ImageIcon(getClass().getResource("/Imagenes/limpiar.png"));
        ImageIcon iconoLimpiar = new ImageIcon(iconoOriginalLimpiar.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
        limpiarDatosProfesionales.addActionListener(this);
        limpiarDatosProfesionales.setIcon(iconoLimpiar);
        limpiarDatosProfesionales.setIconTextGap(2);
        limpiarDatosProfesionales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        limpiarDatosProfesionales.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        limpiarDatosProfesionales.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        limpiarDatosProfesionales.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        panelSur.add(guardarDatosProfesionales);
        panelSur.add(limpiarDatosProfesionales);

        return panelDatosProfesionales;
    }

    private JPanel crearAltaExpedienteClinico() {
        JPanel panelExpedienteClinico = new JPanel(new BorderLayout(0, 50));
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        JPanel panelModulos = new JPanel(new GridLayout(0, 1));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.add(Box.createRigidArea(new Dimension(25, 0)));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.add(Box.createRigidArea(new Dimension(25, 0)));
        panelExpedienteClinico.add(panelLeft, BorderLayout.WEST);
        panelExpedienteClinico.add(panelRight, BorderLayout.EAST);
        JPanel panelNorte = new JPanel(new FlowLayout());//Titulo
        JPanel panelSur = new JPanel(new GridLayout(1, 2));//Botones
        panelSur.setBorder(BorderFactory.createLineBorder(Color.RED));
        JPanel panelCentro1 = new JPanel(new BorderLayout());
        panelCentro1.add(panelModulos, BorderLayout.WEST);
        JPanel panelCentro2 = new JPanel(new GridLayout(7, 2, 0, 15));//Formulario
        panelCentro2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        panelExpedienteClinico.add(panelSur, BorderLayout.SOUTH);
        panelCentro1.add(panelCentro2, BorderLayout.CENTER);
        panelExpedienteClinico.add(panelNorte, BorderLayout.NORTH);
        panelExpedienteClinico.add(panelCentro1, BorderLayout.CENTER);
        //Formulario
        JLabel tituloExpedienteClinico = new JLabel("Expediente Clinico");
        tituloFormulario = new Font("Arial", Font.BOLD, 40);
        tituloExpedienteClinico.setFont(tituloFormulario);
        panelNorte.add(tituloExpedienteClinico);
        JLabel etiquetaNacimiento = new JLabel("Fecha de Nacimiento (dia/mes/año:");
        fuenteFormulario = new Font("Arial", Font.ITALIC, 25);
        etiquetaNacimiento.setFont(fuenteFormulario);
        JTextField campoNacimiento = new JTextField();//*****************************************************************
        campoNacimiento.setFont(fuenteFormulario);
        JLabel etiquetaLugarNacimiento = new JLabel("Lugar de Nacimiento:");
        etiquetaLugarNacimiento.setFont(fuenteFormulario);
        JTextField campoLugarNacimiento = new JTextField(20);
        JLabel etiquetaTipoSangre = new JLabel("Tipo de Sangre:");
        etiquetaTipoSangre.setFont(fuenteFormulario);
        JTextField campoTipoSangre = new JTextField(20);
        JLabel etiquetaSexo = new JLabel("Sexo:");
        etiquetaSexo.setFont(fuenteFormulario);
        ButtonGroup grupoBotonSexo = new ButtonGroup();
        JRadioButton sexoM = new JRadioButton("Femenino");
        JRadioButton sexoF = new JRadioButton("Masculino");
        grupoBotonSexo.add(sexoM);
        grupoBotonSexo.add(sexoF);
        JPanel radioButtonSexo = new JPanel();
        radioButtonSexo.add(sexoM);
        radioButtonSexo.add(sexoF);
        JLabel etiquetaSeguro = new JLabel("¿Cuenta con seguro medico?:");
        etiquetaSeguro.setFont(fuenteFormulario);
        ButtonGroup grupoBotonSeguro = new ButtonGroup();
        JRadioButton si = new JRadioButton("Si");
        JRadioButton no = new JRadioButton("No");
        grupoBotonSeguro.add(si);
        grupoBotonSeguro.add(no);
        JPanel radioButtonSeguro = new JPanel();
        radioButtonSeguro.add(si);
        radioButtonSeguro.add(no);
        JLabel etiquetaSeguroMedico = new JLabel("Nombre del Seguro Medico:");
        etiquetaSeguroMedico.setFont(fuenteFormulario);
        JTextField campoSeguroMedico = new JTextField(40);
        panelCentro2.add(etiquetaNacimiento);
        panelCentro2.add(campoNacimiento);
        panelCentro2.add(etiquetaLugarNacimiento);
        panelCentro2.add(campoLugarNacimiento);
        panelCentro2.add(etiquetaTipoSangre);
        panelCentro2.add(campoTipoSangre);
        panelCentro2.add(etiquetaSexo);
        panelCentro2.add(radioButtonSexo);
        panelCentro2.add(etiquetaSeguro);
        panelCentro2.add(radioButtonSeguro);
        panelCentro2.add(etiquetaSeguroMedico);
        panelCentro2.add(campoSeguroMedico);
        //Botones
        JButton alta = new JButton("Guardar");
        alta.addActionListener(this);
        JButton borrar = new JButton("Limpiar");
        borrar.addActionListener(this);
        panelSur.setBackground(Color.red);
        panelSur.add(alta);
        panelSur.add(borrar);

        return panelExpedienteClinico;
    }

    private JPanel crearAltaExpedienteCovid() {
        JPanel panelExpedienteCovid = new JPanel(new BorderLayout(0, 50));
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.add(Box.createRigidArea(new Dimension(25, 0)));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.add(Box.createRigidArea(new Dimension(25, 0)));
        panelExpedienteCovid.add(panelLeft, BorderLayout.WEST);
        panelExpedienteCovid.add(panelRight, BorderLayout.EAST);
        JPanel panelNorte = new JPanel(new FlowLayout());//Titulo
        JPanel panelSur = new JPanel(new GridLayout(1, 2));//Botones
        panelSur.setBorder(BorderFactory.createLineBorder(Color.RED));
        JPanel panelCentro1 = new JPanel(new BorderLayout());
        JPanel panelCentro2 = new JPanel(new GridLayout(2, 2, 0, 15));//Formulario
        panelCentro2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        panelExpedienteCovid.add(panelSur, BorderLayout.SOUTH);
        panelCentro1.add(panelCentro2, BorderLayout.CENTER);
        panelExpedienteCovid.add(panelNorte, BorderLayout.NORTH);
        panelExpedienteCovid.add(panelCentro1, BorderLayout.CENTER);
        //Formulario
        JLabel tituloExpedienteCovid = new JLabel("Expediente Covid");
        tituloFormulario = new Font("Arial", Font.BOLD, 40);
        tituloExpedienteCovid.setFont(tituloFormulario);
        panelNorte.add(tituloExpedienteCovid);
        JLabel etiquetaVacuna = new JLabel("Tipo de Vacuna:");
        fuenteFormulario = new Font("Arial", Font.ITALIC, 25);
        etiquetaVacuna.setFont(fuenteFormulario);
        JComboBox<String> campoVacuna = new JComboBox();//*****************************************************************
        campoVacuna.setFont(fuenteFormulario);
        campoVacuna.addItem("Phizer");
        campoVacuna.addItem("Aztraceneca");
        campoVacuna.addItem("Moderna");
        campoVacuna.addItem("Sinovac");
        campoVacuna.addItem("Sputnik");
        campoVacuna.addItem("Jhonson & Jhonson");
        JLabel etiquetaDosis = new JLabel("Dosis Aplicadas:");
        etiquetaDosis.setFont(fuenteFormulario);
        JComboBox<String> campoDosis = new JComboBox();
        campoDosis.setFont(fuenteFormulario);
        campoDosis.addItem("1");
        campoDosis.addItem("2");
        campoDosis.addItem("3");

        panelCentro2.add(etiquetaVacuna);
        panelCentro2.add(campoVacuna);
        panelCentro2.add(etiquetaDosis);
        panelCentro2.add(campoDosis);
        //Botones
        JButton alta = new JButton("Guardar");
        alta.addActionListener(this);
        panelSur.setBackground(Color.red);
        panelSur.add(alta);

        return panelExpedienteCovid;
    }

    private JPanel crearAltaExperienciaLaboral() {
        JPanel panelExperienciaLaboral = new JPanel(new BorderLayout(0, 50));
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.add(Box.createRigidArea(new Dimension(25, 0)));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.add(Box.createRigidArea(new Dimension(25, 0)));
        panelExperienciaLaboral.add(panelLeft, BorderLayout.WEST);
        panelExperienciaLaboral.add(panelRight, BorderLayout.EAST);
        JPanel panelNorte = new JPanel(new FlowLayout());//Titulo
        JPanel panelSur = new JPanel(new GridLayout(1, 2));//Botones
        panelSur.setBorder(BorderFactory.createLineBorder(Color.RED));
        JPanel panelCentro1 = new JPanel(new BorderLayout());
        JPanel panelCentro2 = new JPanel(new GridLayout(2, 2, 0, 15));//Formulario
        panelCentro2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        panelExperienciaLaboral.add(panelSur, BorderLayout.SOUTH);
        panelCentro1.add(panelCentro2, BorderLayout.CENTER);
        panelExperienciaLaboral.add(panelNorte, BorderLayout.NORTH);
        panelExperienciaLaboral.add(panelCentro1, BorderLayout.CENTER);
        //Formulario
        JLabel tituloExperienciaLaboral = new JLabel("Experiencia Laboral");
        tituloFormulario = new Font("Arial", Font.BOLD, 40);
        tituloExperienciaLaboral.setFont(tituloFormulario);
        panelNorte.add(tituloExperienciaLaboral);
        JLabel etiquetaExperiencia = new JLabel("Experiencia Laboral:");
        fuenteFormulario = new Font("Arial", Font.ITALIC, 25);
        etiquetaExperiencia.setFont(fuenteFormulario);
        JTextArea campoExperiencia = new JTextArea(5, 15);
        campoExperiencia.setFont(fuenteFormulario);
        JScrollPane scrollExperiencia = new JScrollPane(campoExperiencia);
        JLabel etiquetaTrabajoAnterior = new JLabel("Trabajo Anterior:");
        etiquetaTrabajoAnterior.setFont(fuenteFormulario);
        JTextArea campoTrabajoAnterior = new JTextArea(5, 15);
        campoTrabajoAnterior.setFont(fuenteFormulario);
        JScrollPane scrollTrabajo = new JScrollPane(campoTrabajoAnterior);
        panelCentro2.add(etiquetaExperiencia);
        panelCentro2.add(scrollExperiencia);
        panelCentro2.add(etiquetaTrabajoAnterior);
        panelCentro2.add(scrollTrabajo);

        //Botones
        JButton alta = new JButton("Guardar");
        alta.addActionListener(this);
        JButton borrar = new JButton("Limpiar");
        borrar.addActionListener(this);
        panelSur.setBackground(Color.red);
        panelSur.add(alta);
        panelSur.add(borrar);

        return panelExperienciaLaboral;
    }

    private JPanel crearAltaProyectosInvestigacion() {
        JPanel panelProyectos = new JPanel(new BorderLayout(0, 50));
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.add(Box.createRigidArea(new Dimension(25, 0)));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.add(Box.createRigidArea(new Dimension(25, 0)));
        panelProyectos.add(panelLeft, BorderLayout.WEST);
        panelProyectos.add(panelRight, BorderLayout.EAST);
        JPanel panelNorte = new JPanel(new FlowLayout());//Titulo
        JPanel panelSur = new JPanel(new GridLayout(1, 2));//Botones
        panelSur.setBorder(BorderFactory.createLineBorder(Color.RED));
        JPanel panelCentro1 = new JPanel(new BorderLayout());
        JPanel panelCentro2 = new JPanel(new GridLayout(1, 0, 0, 15));//Formulario
        panelCentro2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        panelProyectos.add(panelSur, BorderLayout.SOUTH);
        panelCentro1.add(panelCentro2, BorderLayout.CENTER);
        panelProyectos.add(panelNorte, BorderLayout.NORTH);
        panelProyectos.add(panelCentro1, BorderLayout.CENTER);
        //Formulario
        JLabel tituloProyectoInvestigacion = new JLabel("Proyecto de Investigacion");
        tituloFormulario = new Font("Arial", Font.BOLD, 40);
        tituloProyectoInvestigacion.setFont(tituloFormulario);
        panelNorte.add(tituloProyectoInvestigacion);
        JLabel etiquetaProyecto = new JLabel("Ingresar Nombre del Proyecto de InvestigaciÃ³n:");
        fuenteFormulario = new Font("Arial", Font.ITALIC, 25);
        etiquetaProyecto.setFont(fuenteFormulario);
        JTextField campoProyecto = new JTextField();

        panelCentro2.add(etiquetaProyecto);
        panelCentro2.add(campoProyecto);

        //Botones
        JButton alta = new JButton("Guardar");
        alta.addActionListener(this);
        JButton borrar = new JButton("Limpiar");
        borrar.addActionListener(this);
        panelSur.setBackground(Color.red);
        panelSur.add(alta);
        panelSur.add(borrar);

        return panelProyectos;
    }

    private JPanel crearAltaJornadaLaboral() {
        JPanel panelJornada = new JPanel(new BorderLayout(0, 50));
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.add(Box.createRigidArea(new Dimension(25, 0)));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.add(Box.createRigidArea(new Dimension(25, 0)));
        panelJornada.add(panelLeft, BorderLayout.WEST);
        panelJornada.add(panelRight, BorderLayout.EAST);
        JPanel panelNorte = new JPanel(new FlowLayout());//Titulo
        JPanel panelSur = new JPanel(new GridLayout(1, 2));//Botones
        panelSur.setBorder(BorderFactory.createLineBorder(Color.RED));
        JPanel panelCentro1 = new JPanel(new BorderLayout());
        JPanel panelCentro2 = new JPanel(new GridLayout(3, 2, 0, 15));//Formulario
        panelCentro2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        panelJornada.add(panelSur, BorderLayout.SOUTH);
        panelCentro1.add(panelCentro2, BorderLayout.CENTER);
        panelJornada.add(panelNorte, BorderLayout.NORTH);
        panelJornada.add(panelCentro1, BorderLayout.CENTER);
        //Formulario
        JLabel tituloJornada = new JLabel("Jornada Laboral");
        tituloFormulario = new Font("Arial", Font.BOLD, 40);
        tituloJornada.setFont(tituloFormulario);
        panelNorte.add(tituloJornada);
        JLabel etiquetaMateria = new JLabel("Ingrese la materia:");
        fuenteFormulario = new Font("Arial", Font.ITALIC, 25);
        etiquetaMateria.setFont(fuenteFormulario);
        materia = new JTextField(10);
        agregado = new JTextArea(5, 15);
        scrollMateria = new JScrollPane(agregado);
        agregar = new JButton("Agregar");
        agregar.addActionListener(this);

        panelCentro2.add(etiquetaMateria);
        panelCentro2.add(materia);
        panelCentro2.add(agregar);
        panelCentro2.add(scrollMateria);

        JButton alta = new JButton("Guardar");
        alta.addActionListener(this);
        JButton borrar = new JButton("Limpiar");
        borrar.addActionListener(this);
        panelSur.setBackground(Color.red);
        panelSur.add(alta);
        panelSur.add(borrar);

        return panelJornada;
    }

    private JPanel crearConsultaDocente() {
        JPanel panelDocente = new JPanel(new BorderLayout(0, 50));
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        JPanel panelModulos = new JPanel(new GridLayout(0, 1));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.add(Box.createRigidArea(new Dimension(25, 0)));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.add(Box.createRigidArea(new Dimension(25, 0)));
        panelDocente.add(panelLeft, BorderLayout.WEST);
        panelDocente.add(panelRight, BorderLayout.EAST);
        JPanel panelNorte = new JPanel(new FlowLayout());//Titulo
        JPanel panelSur = new JPanel(new GridLayout(1, 2));//Botones
        JPanel panelCentro1 = new JPanel(new BorderLayout());
        panelCentro1.add(panelModulos, BorderLayout.WEST);
        JPanel panelCentro2 = new JPanel(new GridLayout(7, 2, 0, 15));//Formulario
        panelCentro2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        panelDocente.add(panelSur, BorderLayout.SOUTH);
        panelCentro1.add(panelCentro2, BorderLayout.CENTER);
        panelDocente.add(panelNorte, BorderLayout.NORTH);
        panelDocente.add(panelCentro1, BorderLayout.CENTER);
        //Formulario
        JLabel tituloDatosPersonales = new JLabel("Consulta de Datos Personales");
        tituloFormulario = new Font("Arial", Font.BOLD, 40);
        tituloDatosPersonales.setFont(tituloFormulario);
        panelNorte.add(tituloDatosPersonales);
        JLabel etiquetaID = new JLabel("ID:");
        fuenteFormulario = new Font("Arial", Font.ITALIC, 25);
        etiquetaID.setFont(fuenteFormulario);
        consultaCampoIDButton = new JButton();
        consultaCampoIDButton.setEnabled(false);
        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setFont(fuenteFormulario);
        consultaCampoNombre = new JButton();
        consultaCampoNombre.setEnabled(false);
        JLabel etiquetaApellido = new JLabel("Apellido:");
        etiquetaApellido.setFont(fuenteFormulario);
        consultaCampoApellido = new JButton();
        consultaCampoApellido.setEnabled(false);
        JLabel etiquetaRFC = new JLabel("RFC:");
        etiquetaRFC.setFont(fuenteFormulario);
        consultaCampoRFC = new JButton();
        consultaCampoRFC.setEnabled(false);
        JLabel etiquetaDireccion = new JLabel("Direccion:");
        etiquetaDireccion.setFont(fuenteFormulario);
        consultaCampoDireccion = new JButton();
        consultaCampoDireccion.setEnabled(false);
        JLabel etiquetaEstadoCivil = new JLabel("Estado Civil:");
        etiquetaEstadoCivil.setFont(fuenteFormulario);
        consultaCampoEstadoCivil = new JButton();
        consultaCampoEstadoCivil.setEnabled(false);
        JLabel etiquetaTelefono = new JLabel("Telefono:");
        etiquetaTelefono.setFont(fuenteFormulario);
        consultaCampoTelefono = new JButton();
        consultaCampoTelefono.setEnabled(false);
        panelCentro2.add(etiquetaID);
        panelCentro2.add(consultaCampoID);
        panelCentro2.add(etiquetaNombre);
        panelCentro2.add(consultaCampoNombre);
        panelCentro2.add(etiquetaApellido);
        panelCentro2.add(consultaCampoApellido);
        panelCentro2.add(etiquetaRFC);
        panelCentro2.add(consultaCampoRFC);
        panelCentro2.add(etiquetaDireccion);
        panelCentro2.add(consultaCampoDireccion);
        panelCentro2.add(etiquetaEstadoCivil);
        panelCentro2.add(consultaCampoEstadoCivil);
        panelCentro2.add(etiquetaTelefono);
        panelCentro2.add(consultaCampoTelefono);
        //Botones con iconos

        ImageIcon iconoOriginalConsulta = new ImageIcon(getClass().getResource("/Imagenes/delete.png"));
        int ancho = 25;
        int alto = 25;
        ImageIcon iconoDelete = new ImageIcon(iconoOriginalConsulta.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
        ImageIcon iconoOriginalSalir = new ImageIcon(getClass().getResource("/Imagenes/salirPagina.png"));
        ImageIcon iconoSalir = new ImageIcon(iconoOriginalSalir.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
        delete = new JButton("Eliminar Registro");
        delete.addActionListener(this);
        delete.setIcon(iconoDelete);
        delete.setIconTextGap(2);
        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        delete.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        salirConsultaPersonales = new JButton("Salir");
        salirConsultaPersonales.addActionListener(this);
        salirConsultaPersonales.setIcon(iconoSalir);
        salirConsultaPersonales.setIconTextGap(2);
        salirConsultaPersonales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salirConsultaPersonales.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        salirConsultaPersonales.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        salirConsultaPersonales.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        panelSur.setBackground(Color.red);
        panelSur.add(delete);
        panelSur.add(salirConsultaPersonales);

        return panelDocente;
    }

    private JPanel crearConsultaPerfil() {

        JPanel panelPerfil = new JPanel(new BorderLayout(0, 50));
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        JPanel panelModulos = new JPanel(new GridLayout(0, 1));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.add(Box.createRigidArea(new Dimension(25, 0)));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.add(Box.createRigidArea(new Dimension(25, 0)));
        panelPerfil.add(panelLeft, BorderLayout.WEST);
        panelPerfil.add(panelRight, BorderLayout.EAST);
        JPanel panelNorte = new JPanel(new FlowLayout());//Titulo
        JPanel panelSur = new JPanel(new GridLayout(1, 2));//Botones
        JPanel panelCentro1 = new JPanel(new BorderLayout());
        panelCentro1.add(panelModulos, BorderLayout.WEST);
        JPanel panelCentro2 = new JPanel(new GridLayout(7, 2, 0, 15));//Formulario
        panelCentro2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        panelPerfil.add(panelSur, BorderLayout.SOUTH);
        panelCentro1.add(panelCentro2, BorderLayout.CENTER);
        panelPerfil.add(panelNorte, BorderLayout.NORTH);
        panelPerfil.add(panelCentro1, BorderLayout.CENTER);
        //Formulario
        JLabel tituloDatosPersonales = new JLabel("Consulta del Perfil Docente");
        tituloFormulario = new Font("Arial", Font.BOLD, 40);
        tituloDatosPersonales.setFont(tituloFormulario);
        panelNorte.add(tituloDatosPersonales);
        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setFont(fuenteFormulario);
        consultaPerfilCampoNombre = new JButton();
        consultaPerfilCampoNombre.setEnabled(false);
        JLabel etiquetaApellido = new JLabel("Apellido:");
        etiquetaApellido.setFont(fuenteFormulario);
        consultaPerfilCampoApellido = new JButton();
        consultaPerfilCampoApellido.setEnabled(false);
        JLabel etiquetaCedula = new JLabel("Cedula Profesional:");
        etiquetaCedula.setFont(fuenteFormulario);
        consultaPerfilCampoCedula = new JButton();
        consultaPerfilCampoCedula.setEnabled(false);
        JLabel etiquetaGrado = new JLabel("Ultimo Grado de estudios:");
        etiquetaGrado.setFont(fuenteFormulario);
        consultaPerfilCampoGrado = new JButton();
        consultaPerfilCampoGrado.setEnabled(false);
        JLabel etiquetaEspecialidad = new JLabel("Especialidad:");
        etiquetaEspecialidad.setFont(fuenteFormulario);
        consultaPerfilCampoEspecialidad = new JButton();
        consultaPerfilCampoEspecialidad.setEnabled(false);
        JLabel etiquetaExperiencia = new JLabel("Experiencia Profesional:");
        fuenteFormulario = new Font("Arial", Font.ITALIC, 25);
        etiquetaExperiencia.setFont(fuenteFormulario);
        JTextArea campoExperiencia = new JTextArea();
        campoExperiencia.setEnabled(false);
        panelCentro2.add(etiquetaNombre);
        panelCentro2.add(consultaPerfilCampoNombre);
        panelCentro2.add(etiquetaApellido);
        panelCentro2.add(consultaPerfilCampoApellido);
        panelCentro2.add(etiquetaCedula);
        panelCentro2.add(consultaPerfilCampoCedula);
        panelCentro2.add(etiquetaGrado);
        panelCentro2.add(consultaPerfilCampoGrado);
        panelCentro2.add(etiquetaEspecialidad);
        panelCentro2.add(consultaPerfilCampoEspecialidad);
        panelCentro2.add(etiquetaExperiencia);
        panelCentro2.add(campoExperiencia);

        //Botones con iconos
        ImageIcon iconoOriginalConsulta = new ImageIcon(getClass().getResource("/Imagenes/delete.png"));
        int ancho = 25;
        int alto = 25;
        ImageIcon iconoDelete = new ImageIcon(iconoOriginalConsulta.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
        ImageIcon iconoOriginalSalir = new ImageIcon(getClass().getResource("/Imagenes/salirPagina.png"));
        ImageIcon iconoSalir = new ImageIcon(iconoOriginalSalir.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
        delete2 = new JButton("Nueva Consulta");
        delete2.addActionListener(this);
        delete2.setIcon(iconoDelete);
        delete2.setIconTextGap(2);
        delete2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        delete2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        delete2.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        salirConsultaProfesional = new JButton("Salir");
        salirConsultaProfesional.addActionListener(this);
        salirConsultaProfesional.setIcon(iconoSalir);
        salirConsultaProfesional.setIconTextGap(2);
        salirConsultaProfesional.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salirConsultaProfesional.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        salirConsultaProfesional.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        salirConsultaProfesional.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        panelSur.setBackground(Color.red);
        panelSur.add(delete);
        panelSur.add(salirConsultaProfesional);

        return panelPerfil;
    }

    //Metodo para recuperar informacion de la GUI 
    public DatosBD recuperarDatosPersonalGUI() {

        DatosBD datosDocentes = new DatosBD();
        //Validar ID
        int ID = (campoIDPersonales.getText().isEmpty()) ? 0 : Integer.parseInt(campoIDPersonales.getText());
        datosDocentes.setId(ID);
        datosDocentes.setNombre(campoNombrePersonales.getText());
        datosDocentes.setApellido(campoApellidoPersonales.getText());
        datosDocentes.setRfc(campoRFCPersonales.getText());
        datosDocentes.setDireccion(campoDireccionPersonales.getText());
        datosDocentes.setEstadoCivil(campoEstadoCivilPersonales.getText());
        datosDocentes.setTelefono(campoTelefonoPersonales.getText());
        return datosDocentes;
    }

    public Consultas recuperarDatosConsultasGUI() {
        Consultas datosConsultas = new Consultas();
        numEmpleado = campoNumeroEmpleado.getText();
        datosConsultas.setId(numEmpleado);
        String ID = consultaCampoID.getText();
        datosConsultas.setNumEmpleado(ID);

        return datosConsultas;
    }

    //Eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == altaDatosPersonales) {
            panelPrincipal.removeAll();
            panelPrincipal.setVisible(false);
            panelPrincipal = crearVentanaPrincipal(MODULODATOSPERSONALES);
            panelPrincipal.setVisible(true);
            this.add(panelPrincipal);
        }

        //Evento que implementa el guardado de informacion a la base de datos cuando el usuario pulsa el boton guardar
        if (e.getSource() == guardarDatosPersonales) {
            int respuesta = JOptionPane.showConfirmDialog(panelPrincipal, "¿Esta seguro de Guardar?", "DPO2-DP02-2102-B1-002", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                ConexionBD objConexion = new ConexionBD();
                DatosBD datosDocentes = recuperarDatosPersonalGUI();
                String sentenciaInsert = String.format("INSERT INTO " + nombreTabla + " (ID, Nombre, Apellido, RFC, Direccion, EstadoCivil, Telefono)"
                        + "VALUES (null, '%s', '%s', '%s', '%s', '%s', '%s')", datosDocentes.getNombre(), datosDocentes.getApellido(), datosDocentes.getRfc(), datosDocentes.getDireccion(), datosDocentes.getEstadoCivil(), datosDocentes.getTelefono());
                //Insertar datos en base de datos
                objConexion.ejecutarSentenciaSQL(sentenciaInsert);
                JOptionPane.showMessageDialog(panelPrincipal, "Datos guardados con Exito", "DPO2-DP02-2102-B1-002", JOptionPane.INFORMATION_MESSAGE);
                String sentenciaConsultaId = String.format("SELECT * FROM " + nombreTabla + " ORDER BY id DESC LIMIT 1");
                ResultSet resultado = objConexion.consultarRegistros(sentenciaConsultaId);
                try {
                    resultado.next();
                    String nuevoID = resultado.getString("ID");
                    JOptionPane.showMessageDialog(panelPrincipal, "El Id registrado es: " + nuevoID + "", "DPO2-DP02-2102-B1-002", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(panelPrincipal, "Error: " + ex.getMessage(), "DPO2-DP02-2102-B1-002", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        if (e.getSource() == limpiarDatosPersonales) {
            campoIDPersonales.setText(null);
            campoNombrePersonales.setText(null);
            campoApellidoPersonales.setText(null);
            campoRFCPersonales.setText(null);
            campoDireccionPersonales.setText(null);
            campoEstadoCivilPersonales.setText(null);
            campoTelefonoPersonales.setText(null);
        }

        if (e.getSource() == altaDatosProfesionales) {
            panelPrincipal.removeAll();
            panelPrincipal.setVisible(false);
            panelPrincipal = crearVentanaPrincipal(MODULODATOSPROFESIONALES);
            panelPrincipal.setVisible(true);
            this.add(panelPrincipal);
        }
        if (e.getSource() == guardarDatosProfesionales) {
            int respuesta = JOptionPane.showConfirmDialog(panelPrincipal, "¿Esta seguro de Guardar?", "DPO2-DP02-2102-B1-002", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                JOptionPane.showMessageDialog(panelPrincipal, "Datos guardados con Exito", "DPO2-DP02-2102-B1-002", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getSource() == limpiarDatosProfesionales) {
            campoExperienciaProfesional.setText(null);
            campoCedulaProfesional.setText(null);
            campoEspecialidadProfesional.setText(null);
            campoDireccionProfesional.setText(null);
            campoEstadoCivilProfesional.setText(null);
        }

        if (e.getSource() == expedienteClinico) {
            panelPrincipal.removeAll();
            panelPrincipal.setVisible(false);
            panelPrincipal = crearVentanaPrincipal(MODULOEXPEDIENTECLINICO);
            panelPrincipal.setVisible(true);
            this.add(panelPrincipal);
        }
        if (e.getSource() == expedienteCovid) {
            panelPrincipal.removeAll();
            panelPrincipal.setVisible(false);
            panelPrincipal = crearVentanaPrincipal(MODULOEXPEDIENTECOVID);
            panelPrincipal.setVisible(true);
            this.add(panelPrincipal);
        }
        if (e.getSource() == experienciaLaboral) {
            panelPrincipal.removeAll();
            panelPrincipal.setVisible(false);
            panelPrincipal = crearVentanaPrincipal(MODULOEXPERIENCIALABORAL);
            panelPrincipal.setVisible(true);
            this.add(panelPrincipal);
        }
        if (e.getSource() == proyectosInvestigacion) {
            panelPrincipal.removeAll();
            panelPrincipal.setVisible(false);
            panelPrincipal = crearVentanaPrincipal(MODULOPROYECTOSINVESTIGACION);
            panelPrincipal.setVisible(true);
            this.add(panelPrincipal);
        }
        if (e.getSource() == jornadaLaboral) {
            panelPrincipal.removeAll();
            panelPrincipal.setVisible(false);
            panelPrincipal = crearVentanaPrincipal(MODULOJORNADALABORAL);
            panelPrincipal.setVisible(true);
            this.add(panelPrincipal);
        }
        if (e.getSource() == agregar) {

            agregado.setText(materia.getText());

        }
        if (e.getSource() == consultaDocente) {
            panelPrincipal.removeAll();
            panelPrincipal.setVisible(false);
            panelPrincipal = crearVentanaPrincipal(MODULOCONSULTADOCENTE);
            panelPrincipal.setVisible(true);
            this.add(panelPrincipal);
        }
        if (e.getSource() == buscarDocente) {
            int respuesta = JOptionPane.showConfirmDialog(panelPrincipal, "¿Desea ejecutar esta busqueda?", "DPO2-DP02-2102-B1-002", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                Consultas datosConsultas = recuperarDatosConsultasGUI();
                panelPrincipal.removeAll();
                panelPrincipal.setVisible(false);
                panelPrincipal = crearVentanaPrincipal(MODULOCONSULTADOCENTE);
                panelPrincipal.setVisible(true);
                this.add(panelPrincipal);
                ConexionBD objConexion = new ConexionBD();

                //Recuperar datos de base de datos:
                try {
                    String sentenciaResulset = String.format("SELECT * FROM " + nombreTabla + " WHERE id = " + datosConsultas.getId() + "");
                    ResultSet resultado = objConexion.consultarRegistros(sentenciaResulset);

                    while (resultado.next()) {
                        consultaCampoID.setText(resultado.getString("ID"));
                        consultaCampoNombre.setText(resultado.getString("Nombre"));
                        consultaCampoApellido.setText(resultado.getString("Apellido"));
                        consultaCampoRFC.setText(resultado.getString("RFC"));
                        consultaCampoDireccion.setText(resultado.getString("Direccion"));
                        consultaCampoEstadoCivil.setText(resultado.getString("EstadoCivil"));
                        consultaCampoTelefono.setText(resultado.getString("Telefono"));
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                JOptionPane.showMessageDialog(panelPrincipal, "Busqueda exitosa", "DPO2-DP02-2102-B1-002", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getSource() == consultaPerfil) {
            panelPrincipal.removeAll();
            panelPrincipal.setVisible(false);
            panelPrincipal = crearVentanaPrincipal(MODULOCONSULTAPERFIL);
            panelPrincipal.setVisible(true);
            this.add(panelPrincipal);
        }
        if (e.getSource() == buscarPerfil) {
            int respuesta = JOptionPane.showConfirmDialog(panelPrincipal, "¿Desea ejecutar esta busqueda?", "DPO2-DP02-2102-B1-002", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                Consultas datosConsultas = recuperarDatosConsultasGUI();
                panelPrincipal.removeAll();
                panelPrincipal.setVisible(false);
                panelPrincipal = crearVentanaPrincipal(MODULOCONSULTAPERFIL);
                panelPrincipal.setVisible(true);
                this.add(panelPrincipal);
                this.add(panelPrincipal);
                ConexionBD objConexion = new ConexionBD();

                //Recuperar datos de base de datos:
                try {
                    String sentenciaResulset = String.format("SELECT * FROM datosperfil WHERE id = " + datosConsultas.getNumEmpleado() + "");
                    ResultSet resultado = objConexion.consultarRegistros(sentenciaResulset);
                    while (resultado.next()) {
                        consultaPerfilCampoNombre.setText(resultado.getString("Nombre"));
                        consultaPerfilCampoApellido.setText(resultado.getString("Apellido"));
                        consultaPerfilCampoCedula.setText(resultado.getString("Cedula"));
                        consultaPerfilCampoGrado.setText(resultado.getString("Grado"));
                        consultaPerfilCampoEspecialidad.setText(resultado.getString("Especialidad"));
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                JOptionPane.showMessageDialog(panelPrincipal, "Busqueda exitosa", "DPO2-DP02-2102-B1-002", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        if (e.getSource() == salirConsultaPersonales) {
            panelPrincipal.removeAll();
            panelPrincipal.setVisible(false);
            panelPrincipal = crearVentanaPrincipal(0);
            panelPrincipal.setVisible(true);
            this.add(panelPrincipal);
        }
        if (e.getSource() == delete) {
            int respuesta = JOptionPane.showConfirmDialog(panelPrincipal, "¿Desea eliminar este registro?", "DPO2-DP02-2102-B1-002", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                ConexionBD objConexion = new ConexionBD();
                Consultas datosConsultas = recuperarDatosConsultasGUI();
                String sentenciaDelete = String.format("DELETE FROM " + nombreTabla + " WHERE id = " + datosConsultas.getNumEmpleado() + "");
                objConexion.ejecutarSentenciaSQL(sentenciaDelete);
                JOptionPane.showMessageDialog(panelPrincipal, "Registro eliminado con exito", "DPO2-DP02-2102-B1-002", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        if (e.getSource() == delete2) {
            int respuesta = JOptionPane.showConfirmDialog(panelPrincipal, "¿Desea eliminar este registro?", "DPO2-DP02-2102-B1-002", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                ConexionBD objConexion = new ConexionBD();
                Consultas datosConsultas = recuperarDatosConsultasGUI();
                String sentenciaDelete = String.format("DELETE FROM " + nombreTabla + " WHERE id = " + datosConsultas.getId() + "");
                objConexion.ejecutarSentenciaSQL(sentenciaDelete);
                JOptionPane.showMessageDialog(panelPrincipal, "Registro eliminado con exito", "DPO2-DP02-2102-B1-002", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        if (e.getSource() == salirConsultaProfesional) {
            panelPrincipal.removeAll();
            panelPrincipal.setVisible(false);
            panelPrincipal = crearVentanaPrincipal(0);
            panelPrincipal.setVisible(true);
            this.add(panelPrincipal);
        }
    }

    //Eventos del JComboBox para elegir el perfil de Docente:
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == perfilProfesional) {

            String comparacion = (String) perfilProfesional.getSelectedItem();
            String cirujano = "Medico Cirujano";
            String general = "Medico General";
            String forense = "Medico Forense";
            if (comparacion.equals(cirujano)) {
                nombreTabla = "MedicoCirujano";
            } else {
                if (comparacion.equals(general)) {
                    nombreTabla = "MedicoGeneral";
                } else {
                    if (comparacion.equals(forense)) {
                        nombreTabla = "MedicoForense";

                    }
                }
            }
        }
    }

}
