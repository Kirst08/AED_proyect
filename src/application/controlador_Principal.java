package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class controlador_Principal  implements Initializable 
{
	@FXML
	private StackPane main_l; /*Contenedor principal*/
	@FXML
	private TextField usuario;
	@FXML
	private TextField contra;
	@FXML
	private StackPane C_add; 
    @FXML
    private ProgressBar myProgressBar;
    @FXML
    private Pane nodes;
    @FXML
    private Text nodo_info;
    @FXML
	private TextField noditos;
    
	static int y = 90, x = 375, nivel = 0;
	static Arbol raiz;
	static char dato;
	static boolean init = false;
	@Override
    public void initialize(URL url, ResourceBundle rb) {
	   
    }   	
	//Para la pantalla principal
	private void cambiarPanel(String panel) {
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(panel+".fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        main_l.getChildren().removeAll();
        main_l.getChildren().addAll(root);
    }
	@FXML
	public void panel2(MouseEvent event) 
	{ 
        cambiarPanel("Presentacion");
    }
	@FXML
	public void Log(MouseEvent event) 
	{ 
        cambiarPanel("LogIn");
    }
	//Para la pantalla principal
	public void Pres_Regresar(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("Introduccion.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void Log_Regresar(MouseEvent event) {
		Parent root = null;
		
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("Introduccion.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void Loguear(MouseEvent event) {
		Parent root = null;
	    try {
	    		root = FXMLLoader.load(getClass().getResource("Menu.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    
	    if(usuario.getText().equalsIgnoreCase("Admin") && contra.getText().equalsIgnoreCase("123"))
	    { 
	    	main_l.getChildren().removeAll();
		    main_l.getChildren().addAll(root);	    
	    }
	    else
	    {
	    	JOptionPane.showMessageDialog(null, "Los datos son incorrectos.");
	    }
	    
	}
	public void Guia1(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("Menu_G1.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	/********************************Ejercicios de la Guia #1******************************/
	public void OR_1(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia1/Ejercicio_1D.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void OR_2(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia1/Ejercicio_2D.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void OR_3(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia1/Ejercicio_3D.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void OR_4(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia1/Ejercicio_4D.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	/*+++++++++++++++++++++++++++++++++++++++Guia #2++++++++++++++++++++++++++++++++++++++++++*/
	public void Guia2(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("Menu_G2.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void Conv(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia2/Ejercicio_1G2.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void Pilas(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia2/Ejercicio_2G2.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void Colas(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia2/Ejercicio_3G2.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	/***********************************Ejercicios de la Guia #3************************************/
	public void Guia3(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("Menu_G3.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void ordenar(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia3/ordenar.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	@FXML
	public void buscar(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia3/busqueda.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	/***********************************Ejercicios de la Guia #4************************************/
	public void Guia4(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("Menu_G4.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	@FXML
	public void Ej1_G4(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia4/Ej1_G4.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void Ej2_G4(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia4/Ej2_G4.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void Ej3_G4(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia4/Ej3_G4.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void Ej4_G4(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia4/Ej4_G4.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void Ej5_G4(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia4/Ej5_G4.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	/***********************************Ejercicios de la Guia #5************************************/
	public void Guia5(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("Menu_G5.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void Ej1_G5(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia5/Ej1_G5.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    C_add.getChildren().removeAll();
	    C_add.getChildren().addAll(root);
	}
	public void Ej2_G5(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia5/Ej2_G5.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    C_add.getChildren().removeAll();
	    C_add.getChildren().addAll(root);
	}
	public void Ej3_G5(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("/Guia5/Ej3_G5.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    C_add.getChildren().removeAll();
	    C_add.getChildren().addAll(root);
	}
	/***********************************Ejercicios de la Guia #6************************************/
	public void Guia6(MouseEvent event) {
		Parent root = null;
	        
	    try {
	    		root = FXMLLoader.load(getClass().getResource("Menu_G6.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	public void Nodo(MouseEvent event) {
		
		Arbol principal = new Arbol(' ');
		raiz = null;
		y = 90;
		x = 355;
		nodes.getChildren().clear();
		insertarnodo(principal);
	}
	public void insertarnodo(Arbol r)
    {
        String opc;
        if(raiz == null) 
        {
	        dato = JOptionPane.showInputDialog("Ingrese el nodo raiz: ").charAt(0);
	        Arbol nuevo = new Arbol(dato);
	        raiz = nuevo;
	        nivel = 1;
	        dibuja(raiz.nodo + "");
	        insertarnodo(raiz);
        }
        else 
        {
            opc = JOptionPane.showInputDialog("¿Desea ingresar nodo en la izquierda de " + r.nodo + "? Si/No");
            if(opc.equalsIgnoreCase("si"))
            {
                dato = JOptionPane.showInputDialog("Ingrese el nodo: ").charAt(0);
                Arbol nuevo = new Arbol(dato);
                r.Izq = nuevo;
                x-=110;
                y+=60;
                lineas(x, x+110, y, y-40);
                dibuja(dato + "");
                insertarnodo(r.Izq);
            }
            else 
            {
                r.Izq = null;
            }
            opc = JOptionPane.showInputDialog("¿Desea ingresar nodo en la derecha de "+r.nodo + "? Si/No");
            if(opc.equalsIgnoreCase("si"))
            {
                dato = JOptionPane.showInputDialog("Ingrese el nodo: ").charAt(0);
                Arbol nuevo = new Arbol(dato);
                r.Der = nuevo;
                x+=110;
                y+=60;
                lineas(x, x-110, y, y-40);
                dibuja(dato + "");            
                insertarnodo(r.Der );
            }
            else 
            {
                r.Der = null;
                x+=50;
            } 
            y-=60;
            nivel++;
        }
    }
	public void dibuja(String text)
	{
		Ellipse ola = new Ellipse();
		ola.setFill(Color.DARKSLATEBLUE);
	    Label nom = new Label("" + text);
		Font auxFont = nom.getFont();
		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		nom.setFont(new Font(auxFont.getStyle(), 20));
		nom.setStyle("-fx-text-fill: white");
		nom.setBackground(null);
		nodes.getChildren().add(ola);
	    nodes.getChildren().add(nom);
	    ola.setCenterX(x-5);
	    nom.setLayoutY(y - 15);
	    nom.setLayoutX(x-11);
		ola.setCenterY(y);
		ola.setRadiusX(20);
		ola.setRadiusY(20);  
	}
	
	public void lineas(int x1, int x2, int y1, int y2)
	{
		Line line = new Line();
		line.setStyle("-fx-stroke: white");
		nodes.getChildren().add(line);
		line.setStartX(x1);
		line.setStartY(y1);
		line.setEndX(x2);
		line.setEndY(y2);
	}
	/*Salir*/
	public void Salir_G1(MouseEvent event) {
		Parent root = null;    
	    try {
	    		root = FXMLLoader.load(getClass().getResource("../application/Menu.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}

}
