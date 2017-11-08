import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import razas.Humanos;

/*
 * @author: ALBERTO REY MORENO
 * @version: 1.0 - Interfaz
 * @info: https://sites.google.com/site/5esrdes/
 */

public class VentanaPrincipal {

	// VENTANAS
	JFrame ventana;
	JPanel logo, hoja;

	// LOGO
	JLabel foto;

	// INTRODUCCION
	JLabel clasesL;
	JComboBox clases;
	JLabel nivelL, nombreL, razaL, alineamientoL;
	JTextField nivel, nombre;
	JComboBox razas;
	JComboBox alineamiento;

	// ESTADISTICAS - Fuerza, Destreza, Constitución, Sabiduría, Carisma.
	JLabel FUEL, DESL, CONL, INTL, SABL, CARL;
	JTextField FUE, DES, CON, INT, SAB, CAR;
	JTextField FUED, DESD, COND, INTD, SABD, CARD;

	// SALVACION - Fuerza, Destreza, Constitución, Sabiduría, Carisma.
	JLabel FUEL2, DESL2, CONL2, INTL2, SABL2, CARL2;
	JTextField FUES, DESS, CONS, INTS, SABS, CARS;

	// HABILIDADES - Sabiduría Pasiva (Percepción), Acrobacia,
	JLabel SABIPASIL, ACROL, ARCAL, ATLEL, ENGAL, HISTL, INTEL, INTIL, INVEL, MANOL, ANIML, MEDIL, NATUL, PERCL, INTENL,
			PERSL, RELIL, SIGIL, SOBREL;
	JTextField SABIPASI, ACRO, ARCA, ATLE, ENGA, HIST, INTE, INTI, INVE, MANO, ANIM, MEDI, NATU, PERC, INTEN, PERS,
			RELI, SIGI, SOBRE;

	// INICIATIVAS - Armadura, Iniciativa y Velocidad.
	JLabel ARMADURAL, INICIATIVAL, VELOCIDADL;
	JTextField ARMADURA, INICIATIVA, VELOCIDAD;

	// Puntos de Golpe Actuales y Puntos de Golpe Temporales
	JLabel PUNTOSACTUALESL, PUNTOSTEMPORALESL;
	JTextField PUNTOSACTUALES, PUNTOSTEMPORALES;

	// Dados de Golpe y Total
	JLabel DADOSGOLPEL, DTOTALLAB;
	JTextField DADOSGOLPE, DTOTAL;

	// Salvación de muerte - 3 Exitosos - 3 Fallidos
	JLabel SALVACIONMUERTEL, EXITOL, FALLIL;
	JTextField EXITO, FALLIDO;
	final int NUM_MAXIMO = 3;

	// TRANSFONDO
	JLabel TRASFL, PERSONL, IDEALESL, JURAMENTOSL, DEFECTOSL;
	JTextField PERSON, IDEALES, JURAMENTOS, DEFECTOS;
	JTextField transfondo;

	// RASGOS
	JLabel CARACTERISTICASL;
	JTextField CARACTERISTICAS;

	// EQUIPO
	JLabel EquipoL;
	JTextField Equipo;

	// RANURAS DE HECHIZO
	JLabel ranuraHechizos;
	JList<Object> hechizos;
	JList hechizosPersonaje;

	// APARIENCIA - CARGAR IMAGEN
	JLabel imagenL;
	Image imagenPJ;

	// ALIADOS
	JLabel aliadosL;
	JTextField aliados;

	// TESORO - INVENTARIO
	JLabel inventarioL;
	JList<Object> inventario;

	// BOTONES
	JButton calculo, escribir;

	public VentanaPrincipal() {

		ventana = new JFrame();
		ventana.setTitle("Hoja de personajes - V1.0 - ALBERTO REY MORENO");
		ventana.setBounds(100, 100, 600, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {

		ventana.setLayout(new GridLayout(2, 1));

		// PANELES
		logo = new JPanel(new GridBagLayout());
		hoja = new JPanel(new GridBagLayout());

		ventana.add(logo);
		ventana.add(hoja);

		// DECLARACION DE CLASES
		clasesL = new JLabel("Clase");
		clases = new JComboBox();
		
		String[] arrayClases = {" - Elija - ", "Bárbaro", "Luchador","Monje","Paladín","Bardo","Ranger","Pícaro","Clérigo","Druida","Hechicero","Brujo","Mago"};
		for (int i = 0; i < arrayClases.length; i++) {
			clases.addItem(arrayClases[i]);
		}

		// DECLARACION DE VARIABLES

		// INTRODUCCION

		nivelL = new JLabel("Nivel");
		nivel = new JTextField("");

		nombreL = new JLabel("Nombre");
		nombre = new JTextField("");

		// RAZAS - Dracónidos - Elfos - Enanos - Gnomos - Humanos - Medianos - Medio
		// Elfos - Medio Orcos - Tiflins
		razaL = new JLabel("Raza");
		razas = new JComboBox();
		String[] arrayRazas = { "- Elija -", "Dracónidos", "Elfos", "Enanos", "Gnomos", "Humanos", "Medianos", "Medio Elfos", "Medio Orcos", "Tiflins" };
		
		for (int i = 0; i < arrayRazas.length; i++) {
			razas.addItem(arrayRazas[i]);
		}

		// ALINEAMIRNTOS -
		alineamientoL = new JLabel("Alineamiento");
		alineamiento = new JComboBox();
		
		String[] arrayAlineamientos = {" - Elija - ", "Legal Bueno", "Legal Neutral", "Legal Malvado", "Neutral Bueno", "Verdadero Neutral", "Neutral Malvado", "Caótico Bueno", "Caótico Neutral", "Caótico Malvado"};
		for (int i = 0; i < arrayAlineamientos.length; i++) {
			alineamiento.addItem(arrayAlineamientos[i]);
		}

		// CARACTERISTICAS

		FUEL = new JLabel("FUERZA");
		FUE = new JTextField("0");
		FUED = new JTextField("");
		FUE.setEditable(false);

		DESL = new JLabel("DESTREZA");
		DES = new JTextField("0");
		DESD = new JTextField("");
		DES.setEditable(false);

		CONL = new JLabel("CONSTITUCION");
		CON = new JTextField("0");
		COND = new JTextField("");
		CON.setEditable(false);

		INTL = new JLabel("INTELIGENCIA");
		INT = new JTextField("0");
		INTD = new JTextField("");
		INT.setEditable(false);

		SABL = new JLabel("SABIDURIA");
		SAB = new JTextField("0");
		SABD = new JTextField("");
		SAB.setEditable(false);

		CARL = new JLabel("CARISMA");
		CAR = new JTextField("0");
		CARD = new JTextField("");
		CAR.setEditable(false);

		calculo = new JButton("Calcular tiradas");
		escribir = new JButton("Completar personaje");

		// SALVACIONES
		FUEL2 = new JLabel("FUERZA");
		DESL2 = new JLabel("DESTREZA");
		CONL2 = new JLabel("CONSTITUCION");
		INTL2 = new JLabel("INTELIGENCIA");
		SABL2 = new JLabel("SABIDURIA");
		CARL2 = new JLabel("CARISMA");

		// LOGO

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("img/logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(img.getScaledInstance(400, 200, Image.SCALE_SMOOTH));
		foto = new JLabel(icon);
		foto.setBounds(0, 0, icon.getIconHeight(), icon.getIconWidth());
		logo.add(foto);

		// INTRODUCCION DEL PERSONAJE
		GridBagConstraints settingsPj = new GridBagConstraints();
		settingsPj.gridx = 0;
		settingsPj.gridy = 0;
		settingsPj.gridwidth = 6;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(clasesL, settingsPj);

		settingsPj = new GridBagConstraints();
		settingsPj.gridx = 0;
		settingsPj.gridy = 1;
		settingsPj.gridwidth = 6;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(clases, settingsPj);

		settingsPj = new GridBagConstraints();
		settingsPj.gridx = 0;
		settingsPj.gridy = 2;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(nivelL, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 1;
		settingsPj.gridy = 2;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.gridwidth = 2;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(nombreL, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 3;
		settingsPj.gridy = 2;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.gridwidth = 1;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(razaL, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 4;
		settingsPj.gridy = 2;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.gridwidth = 2;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(alineamientoL, settingsPj);

		// INTRODUCCION - EDITABLES

		settingsPj = new GridBagConstraints();
		settingsPj.gridx = 0;
		settingsPj.gridy = 3;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(nivel, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 1;
		settingsPj.gridy = 3;
		settingsPj.gridwidth = 2;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(nombre, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 3;
		settingsPj.gridy = 3;
		settingsPj.gridwidth = 1;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(razas, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 4;
		settingsPj.gridy = 3;
		settingsPj.gridwidth = 2;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(alineamiento, settingsPj);

		// ESTADISTICAS

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 0;
		settingsPj.gridy = 4;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(FUEL, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 1;
		settingsPj.gridy = 4;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(DESL, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 2;
		settingsPj.gridy = 4;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(CONL, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 3;
		settingsPj.gridy = 4;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(INTL, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 4;
		settingsPj.gridy = 4;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(SABL, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 5;
		settingsPj.gridy = 4;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(CARL, settingsPj);

		// ESTADISTICAS - NO EDITABLES

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 0;
		settingsPj.gridy = 5;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(FUE, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 1;
		settingsPj.gridy = 5;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(DES, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 2;
		settingsPj.gridy = 5;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(CON, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 3;
		settingsPj.gridy = 5;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(INT, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 4;
		settingsPj.gridy = 5;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(SAB, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 5;
		settingsPj.gridy = 5;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(CAR, settingsPj);

		// ESTADISTICAS - EDITABLES

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 0;
		settingsPj.gridy = 6;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(FUED, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 1;
		settingsPj.gridy = 6;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(DESD, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 2;
		settingsPj.gridy = 6;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(COND, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 3;
		settingsPj.gridy = 6;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(INTD, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 4;
		settingsPj.gridy = 6;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(SABD, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 5;
		settingsPj.gridy = 6;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(CARD, settingsPj);

		// ESTADISTICAS - DADOS

		settingsPj = new GridBagConstraints();
		settingsPj.gridx = 0;
		settingsPj.gridy = 7;
		settingsPj.gridwidth = 6;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(calculo, settingsPj);

		// SALVACION

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 0;
		settingsPj.gridy = 11;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(FUEL2, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 1;
		settingsPj.gridy = 11;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(DESL2, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 2;
		settingsPj.gridy = 11;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(CONL2, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 3;
		settingsPj.gridy = 11;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(INTL2, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 4;
		settingsPj.gridy = 11;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(SABL2, settingsPj);

		settingsPj = new GridBagConstraints();

		settingsPj.gridx = 5;
		settingsPj.gridy = 11;
		settingsPj.fill = GridBagConstraints.HORIZONTAL;
		settingsPj.anchor = GridBagConstraints.CENTER;
		settingsPj.insets = new Insets(1, 1, 1, 1);
		hoja.add(CARL2, settingsPj);

	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
	}

}
