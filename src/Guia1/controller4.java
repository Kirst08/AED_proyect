package Guia1;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class controller4 {
	@FXML
	private StackPane C_add;
	@FXML
	private StackPane main_l; /*Contenedor principal*/
	@FXML
	private TextField direccion;
	@FXML
	private TextField extension;
	@FXML
	private TextField price;
	@FXML
	private TextField elim;
	@FXML
	private TextField ext_b;
	@FXML
	private TextField busq;
	@FXML
	private TextField price_act;
	@FXML
	private TextArea resul;
	@FXML
	private TextArea total;
	@FXML
	private RadioButton si;
	@FXML
	private RadioButton no;
	
	//Arreglo
	static int n = -1; 
	static String dir[] = new String[10];
	static float superficie[] = new float[10]; 
	static float precio[] = new float[10]; 
	static int aux;
	static char opc; 
	static int i, pos;
	static float bu_aux;
	
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
	public void Insertar(MouseEvent event) 
	{ 
        cambiarPanel("Ej4_1D");
    }
	@FXML
	public void Eliminar(MouseEvent event) 
	{ 
        cambiarPanel("Ej4_2D");
    }
	@FXML
	public void Actualizar(MouseEvent event) 
	{ 
        cambiarPanel("Ej4_3D");
    }
	@FXML
	public void Mostrar_1(MouseEvent event) 
	{ 
        cambiarPanel("Ej4_4D");
    }
	@FXML
	public void listado(MouseEvent event) 
	{ 
        cambiarPanel("Ej4_5D");
    }
	/*Salir*/
	public void Salir(MouseEvent event) {
		Parent root = null;    
	    try {
	    		root = FXMLLoader.load(getClass().getResource("../application/Menu_G1.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
	}
	//+++++++++++++++++++++++Funcionalidad+++++++++++++++++++++++++++++++++++
	public void registrar(MouseEvent event)
	{
		if(n < 9)
		{
			boolean price_ = false;
			if((direccion.getText().compareTo("") != 0) && (extension.getText().compareTo("") != 0) && (price.getText().compareTo("") != 0))
			{
				if(n == -1)
				{
					//Haremos las validaciones correspondientes, verificando que los datos sean correctos
					price_ =  price.getText().matches("[0-9.]+");
					if(price_ == false)
					{
						JOptionPane.showMessageDialog(null, "Ingrese un precio valido.");
					}
					else
					{
						n++;
						dir[n] = direccion.getText();
						precio[n] = Float.parseFloat(price.getText());
						superficie[n] = Float.parseFloat(extension.getText());
						JOptionPane.showMessageDialog(null, "Se insertó correctamente");
						direccion.setText("");
						extension.setText("");
						price.setText("");
					}
				}
				else
				{
					i = 0;
					bu_aux = Float.parseFloat(extension.getText());
					while((i <= n) && (superficie[i] < bu_aux))
					{
						i++;
						
					}
					if((i > n) || (superficie[i] > bu_aux))
					{
						pos = i *(-1);
					}
					else
					{
						pos = i;
					}
					
					if (pos > 0)
						JOptionPane.showMessageDialog(null, "El departamento ya existe.");
					else
					{
						n++;
						pos *= (-1);
						for(int j = n; j >= (pos + 1); j--)
						{
							dir[j] = dir[j - 1]; 
							superficie[j] = superficie[j - 1];
							precio[j] = precio[j - 1];
						}
						dir[pos] = direccion.getText();
						superficie[pos] = Float.parseFloat(extension.getText());
						precio[pos] = Float.parseFloat(price.getText());
						JOptionPane.showMessageDialog(null, "Se insertó correctamente");
						direccion.setText("");
						extension.setText("");
						price.setText("");
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Rellene todos los campos");
			}
				
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No hay espacio");
		}
	}
	public void remover(MouseEvent event)
	{
		  
        if(n >= 0)
        {
        	i = 0;
			bu_aux = Float.parseFloat(elim.getText());
			while((i <= n) && (superficie[i] < bu_aux))
				i++;
			if((i > n) || (superficie[i] > bu_aux))
				pos = i *(-1); 
			else
				pos = i; 
			
			if (pos < 0)
				JOptionPane.showMessageDialog(null, "No se encontró el departamento.");
			else
			{
				if(no.isSelected())
				{
					n--;
					for(int l = pos; l <= n; l++)
					{
						dir[l] = dir[l + 1]; 
						superficie[l] = superficie[l + 1];
						precio[l] = precio[l + 1]; 
					}
					JOptionPane.showMessageDialog(null, "Se eliminó correctamente.");
					elim.setText("");
				}
				else if(si.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Se renovó correctamente.");
					elim.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Escoja una opción.");
				}
			}
			
        }
        else
        {
        	JOptionPane.showMessageDialog(null, "No se hay departamentos registrados.");
        	elim.setText("");
        }
	}
	
	public void update(MouseEvent event)
	{
		if(n >= 0)
        {
        	if((busq.getText().compareTo("") != 0) && (price_act.getText().compareTo("") != 0))
			{
	        	pos = -1; i = 0;
	 			bu_aux = Float.parseFloat(busq.getText());
	 			while((i <= n) && (superficie[i] < bu_aux))
	 				i++;
	 			if((i > n) || (superficie[i] > bu_aux))
	 				pos = i *(-1); 
	 			else
	 				pos = i; 		
	 			if (pos < 0)
	 				JOptionPane.showMessageDialog(null, "No se encontró el departamento.");
	 			else
	 			{
					precio[pos] = Float.parseFloat(price_act.getText());
					JOptionPane.showMessageDialog(null, "Se actualizó correctamente");
				}
				busq.setText("");
	        	price_act.setText("");
			}
        }
        else
        {
        	JOptionPane.showMessageDialog(null, "No se hay empleados registrados.");
        	busq.setText("");
        	price_act.setText("");
        }
	}
	public void mostrar1(MouseEvent event)
	{
     	pos = -1; i = 0;
		if(n >= 0)
        {
			i = 0;
			bu_aux = Float.parseFloat(ext_b.getText());
			while((i <= n) && (superficie[i] < bu_aux))
				i++;
			if((i > n) || (superficie[i] > bu_aux))
				pos = i *(-1); 
			else
				pos = i; 
			
			if(pos < 0)
			{
				resul.setText("\t\nNO EXISTE");
			}
			else
			{
				ext_b.setText("");
				resul.setText("\n\tDIRECCIÓN: " + dir[pos] + "\n\n\tEXTENSIÓN: " + 
						superficie[pos] + "mts²\n\n\tPRECIO: $" + precio[pos]);
			}
        }
        else
        	JOptionPane.showMessageDialog(null, "No hay registro");
	}
	public void mostrar2(MouseEvent event)
	{
		String aux = "Direccion\t\tExtensión\t\tPrecio\n";
		for(int k = 0; k <= n; k++)
		{
			aux+= dir[k] + "\t\t"+ superficie[k] + "mts²\t\t$"+  precio[k] + "\n";
		}
		total.setText(aux);
	}
}
