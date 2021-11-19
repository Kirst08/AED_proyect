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

public class controller3 {
	@FXML
	private StackPane C_add;
	@FXML
	private StackPane main_l; /*Contenedor principal*/
	@FXML
	private TextField name;
	@FXML
	private TextField direccion;
	@FXML
	private TextField edad_;
	@FXML
	private TextField anti;
	@FXML
	private RadioButton fem;
	@FXML
	private RadioButton mas;
	@FXML
	private TextField elim;
	@FXML
	private TextField name_b;
	@FXML
	private TextField busq;
	@FXML
	private TextField age_act;
	@FXML
	private TextArea resul;
	@FXML
	private TextArea total;
	
	
	//Arreglo
	static String nombre[] = new String[10];
	static String dir[] = new String[10];
	static int edad[] = new int[10];
	static char sex[] = new char[10];
	static int an[] = new int[10];
	static int i = 0, pos, n = - 1;
	
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
        cambiarPanel("Ej3_1D");
    }
	@FXML
	public void Eliminar(MouseEvent event) 
	{ 
        cambiarPanel("Ej3_2D");
    }
	@FXML
	public void Actualizar(MouseEvent event) 
	{ 
        cambiarPanel("Ej3_3D");
    }
	@FXML
	public void Mostrar_1(MouseEvent event) 
	{ 
        cambiarPanel("Ej3_4D");
    }
	@FXML
	public void listado(MouseEvent event) 
	{ 
        cambiarPanel("Ej3_5D");
    }
	//+++++++++++++++++++++++Funcionalidad+++++++++++++++++++++++++++++++++++
	public void registrar(MouseEvent event)
	{
		if(n < 9)
		{
			boolean age = false, ant = false;
			if((name.getText().compareTo("") != 0) && (direccion.getText().compareTo("") != 0) && (edad_.getText().compareTo("") != 0) && (anti.getText().compareTo("") != 0))
			{
				if(n == -1)
				{
					//Haremos las validaciones correspondientes, verificando que los datos sean correctos
					age =  edad_.getText().matches("[0-9]+") ;
					ant =  anti.getText().matches("[0-9]+") ;
					if(age == false || ant == false)
					{
						JOptionPane.showMessageDialog(null, "Ingrese una edad valida.");
					}
					else if(!fem.isSelected() && !mas.isSelected())
					{
						JOptionPane.showMessageDialog(null, "Seleccione un sexo.");
					}
					else
					{
						n++;
						nombre[n] = name.getText();
						dir[n] = direccion.getText();
						edad[n] = Integer.parseInt(edad_.getText());
						if(fem.isSelected())
						{
							sex[n] = 'F';
						}
						else if(mas.isSelected())
						{
							sex[n] = 'M';
						}
						an[n] = Integer.parseInt(anti.getText());
						JOptionPane.showMessageDialog(null, "Se insertó correctamente");
						name.setText("");
						direccion.setText("");
						edad_.setText("");
						anti.setText("");
						fem.setSelected(false);
						mas.setSelected(false);
					}
				}
				else
				{
					//Haremos las validaciones correspondientes, verificando que los datos sean correctos
					age =  edad_.getText().matches("[0-9]+") ;
					ant =  anti.getText().matches("[0-9]+") ;
					if(age == false || ant == false)
					{
						JOptionPane.showMessageDialog(null, "Ingrese una edad valida.");
					}
					else if(!fem.isSelected() && !mas.isSelected())
					{
						JOptionPane.showMessageDialog(null, "Seleccione un sexo.");
					}
					else
					{
						i = 0;
						while((i <= n) && (nombre[i].compareTo(name.getText()) < 0))
							i++;
						if((i > n) || (nombre[i].compareTo(name.getText()) > 0))
							pos = i *(-1); 
						else
							pos = i; 
						
						if (pos > 0)
							JOptionPane.showMessageDialog(null, "El Empleado ya existe");
						else
						{
							n++;
							pos *= (-1);
							for(int j = n; j >= (pos + 1); j--)
							{
								nombre[j] = nombre[j - 1]; 
								dir[j] = dir[j - 1]; 
								edad[j] = edad[j - 1];
								an[j] = an[j - 1];
								sex[j] = sex[j - 1];
							}
							nombre[pos] = name.getText();
							dir[pos] = direccion.getText();
							edad[pos] = Integer.parseInt(edad_.getText());
							if(mas.isSelected())
							{
								sex[pos] = 'M';
							}
							else if(fem.isSelected())
							{
								sex[pos] = 'F';
							}
							an[pos] = Integer.parseInt(anti.getText());
							JOptionPane.showMessageDialog(null, "Se insertó correctamente");
							name.setText("");
							direccion.setText("");
							edad_.setText("");
							anti.setText("");
							fem.setSelected(false);
							mas.setSelected(false);
						}
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
			String aux = elim.getText();
			while((i <= n) && (nombre[i].compareTo(aux)) < 0)
				i++;
			if((i > n) || (nombre[i].compareTo(aux) > 0))
				pos = i *(-1); 
			else
				pos = i; 
			if(pos < 0)
			{
				JOptionPane.showMessageDialog(null, "No se encontró ese registro");
				elim.setText("");
			}
			else
			{
				n--;
				for(int l = pos; l <= n; l++)
				{
					nombre[l] = nombre[l + 1]; 
					dir[l] = dir[l + 1]; 
					edad[l] = edad[l + 1];
					an[l] = an[l + 1]; 
					sex[l] = sex[l+1];
				}
				JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
				elim.setText("");
			}
			
        }
        else
        {
        	JOptionPane.showMessageDialog(null, "No se hay empleados registrados.");
        	elim.setText("");
        }
	}
	public void update(MouseEvent event)
	{
		if(n >= 0)
        {
        	if((name_b.getText().compareTo("") != 0) && (age_act.getText().compareTo("") != 0))
			{
	        	pos = -1; i = 0;
	        	while((i <= n) && (nombre[i].compareTo(name_b.getText()) < 0))
					i++;
				if((i > n) || (nombre[i].compareTo(name_b.getText()) > 0))
					pos = i *(-1); 
				else
					pos = i; 
				if(pos < 0)
				{
					JOptionPane.showMessageDialog(null, "No se encotró el cliente.");
				}
				else
				{
					an[pos] = Integer.parseInt(age_act.getText());
					JOptionPane.showMessageDialog(null, "Se actualizó correctamente");
				}
				name_b.setText("");
	        	age_act.setText("");
			}
        }
        else
        {
        	JOptionPane.showMessageDialog(null, "No se hay empleados registrados.");
        	name_b.setText("");
        	age_act.setText("");
        }
	}
	public void mostrar1(MouseEvent event)
	{
     	pos = -1; i = 0;
		if(n >= 0)
        {
			while((i <= n) && (nombre[i].compareTo(busq.getText()) < 0))
					i++;
			if((i > n) || (nombre[i].compareTo(busq.getText()) > 0))
				pos = i *(-1); 
			else
				pos = i; 
			if(pos < 0)
			{
				resul.setText("\t\nNO EXISTE");
			}
			else
			{
				busq.setText("");
				resul.setText("\tNOMBRE: " + nombre[pos] + 
						"\n\tDireccion: " + dir[pos] + "\n\tEDAD: " + 
						edad[pos] + "\n\tSEXO: " + sex[pos] + "\n\tANTIG: " + an[pos]);
			}
        }
        else
        	JOptionPane.showMessageDialog(null, "No hay registro");
	}
	public void mostrar2(MouseEvent event)
	{
		String aux = "Nombre\t\t\tDireccion\t\tEdad\t\tSex\t\tAntig.\n";
		for(int k = 0; k <= n; k++)
		{
			aux+= nombre[k] + "\t"+ dir[k] + "\t\t"+  edad[k] + "\t\t\t"+  sex[k] + "\t\t\t"+ an[k] + "\n";
		}
		total.setText(aux);
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
}
