package Guia2;

import java.io.IOException;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class controller2_G2 {
	@FXML
	private StackPane C_add;
	@FXML
	private StackPane main_l; /*Contenedor principal*/	
	@FXML
	private TextField ins;
	@FXML
	private TextField elim;
	@FXML
	private TextArea most;
	
	static String datos;
	static String centros[] = new String[10];
	static int max = 10, tope = -1;
	
	private void cambiarPanel(String panel) {
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(panel+".fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        C_add.getChildren().removeAll();
        C_add.getChildren().addAll(root);
    }
	@FXML
	public void insert_p1(MouseEvent event) 
	{ 
        cambiarPanel("Insertar_1");
    }
	@FXML
	public void delete_p1(MouseEvent event) 
	{ 
        cambiarPanel("Eliminar_1");
    }
	@FXML
	public void mostrar_p1(MouseEvent event) 
	{ 
        cambiarPanel("Mostrar_1");
    }
	public void insertar_1(MouseEvent envent)
	{
		if(ins.getText().compareTo("") != 0)
		{
			if(tope < max - 1)
			{
				tope++;
				centros[tope] = ins.getText();
				JOptionPane.showMessageDialog(null, "SE INSERTÓ CORRECTAMENTE");
				ins.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "DESBORDAMIENTO DE DATOS");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "RELLENE EL CAMPO");
		}
	}
	public void eliminar_1(MouseEvent event)
	{
		if(tope != -1)
		{
			datos = centros[tope];
			tope--;
			
			elim.setText("Se eliminó " + datos);
			
		}
		else
		{
			elim.setText("La Pila está vacía");
		}
	}
	public void mostrar_1(MouseEvent event)
	{
		String sal = "";
        for(int i = 0; i <= tope; i++)
        {
        	sal+= centros[i] + "\n";
        }
        most.setText(sal);
	}
	public void Salir(MouseEvent event) {
		Parent root = null;    
	    try {
	    		root = FXMLLoader.load(getClass().getResource("../application/Menu_G2.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	
}
