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

public class controller3_G2 {
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
	
	static int fin = -1, n = 10, opc, frente = -1; 
	static String colac[] = new String[n], dato;
	
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
	public void insert_c1(MouseEvent event) 
	{ 
        cambiarPanel("Insertar_2");
    }
	@FXML
	public void delete_c1(MouseEvent event) 
	{ 
        cambiarPanel("Eliminar_2");
    }
	@FXML
	public void mostrar_c1(MouseEvent event) 
	{ 
        cambiarPanel("Mostrar_2");
    }
	public void insertar_1(MouseEvent envent)
	{
		if(ins.getText().compareTo("") != 0)
		{
			if((fin == n-1) && frente == 0 || (fin + 1) == frente)
			{
				JOptionPane.showMessageDialog(null, "La cola está llena");
				ins.setText("");
			}
			else
			{
				if(fin == (n-1))
				{
					fin = 0;
				}
				else
				{
					fin++;
				}
				colac[fin] = ins.getText();
				if(frente == -1)
				{
					frente = 0;
				}
				ins.setText("");
				JOptionPane.showMessageDialog(null, "SE INSERTÓ CORRECTAMENTE");
			}
		}
	}
	public void eliminar_1(MouseEvent event)
	{
		if(frente == -1)
		{
			elim.setText("La Cola está vacía.");
		}
		else
		{
			dato = colac[frente];
			dato = colac[frente];
			if (frente == fin)
			{
				frente = -1;
				fin = -1;
			}
			else if (frente == (n-1))
			{
				frente = 0;
			}
			else 
			{
				frente++;
			}
			elim.setText(dato +" se eliminó correctamente ");
		}
	}
	public void mostrar_1(MouseEvent event)
	{
		 String sal = "";
	        if(frente == -1)
	        {
	        	most.setText("La Cola está vacía.");
	        }
	        else
	        {
	        	for(int i = frente; i <= fin; i++)
		        {
		        	sal+= colac[i] + "\n";
		        }
	        	most.setText(sal);
	        }
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
