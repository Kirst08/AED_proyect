package Guia1;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public  class Controller implements Initializable{
	/*Variables para manejar los objetos del ejercicio dos - Insertar*/
	@FXML
	private StackPane C_add;
	@FXML
	private StackPane main_l; /*Contenedor principal*/
	@FXML
	private StackPane mostrar;
	@FXML
	private TextField name_1;
	@FXML
	private TextField telefono_1;
	@FXML
	private TextField sal;
	@FXML
	private RadioButton op2;
	@FXML
	private RadioButton op1;
	@FXML
	private TextArea resul;
	@FXML
	private TextArea total;
	//Para actualizar segundo ejercicio
	@FXML
	private TextField busq;
	@FXML
	private TextField resul_act;
	@FXML
	private RadioButton opact1;
	@FXML
	private RadioButton opact2;
	
	static int n = -1, i = 0; //Controla la posicion de los arreglos
	static String nombre[] = new String[10];
	static String telefono[] = new String[10];
	static float sald[] = new float[10];
	static boolean mora[] = new boolean[10];
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   	
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
	public void panel2(MouseEvent event) 
	{ 
        cambiarPanel("/Guia1/Ej2_1D");
    }
	@FXML
	public void panel3(MouseEvent event) 
	{ 
        cambiarPanel("/Guia1/Ej2_2D");
    }
	@FXML
	public void panel4(MouseEvent event) 
	{
        cambiarPanel("/Guia1/Ej2_3D"); 
    }
	@FXML
	public void panel5(MouseEvent event) 
	{
        cambiarPanel("/Guia1/Ej2_4D"); 
    }
	@FXML
	public void panel6(MouseEvent event) 
	{
        cambiarPanel("/Guia1/Ej2_5D"); 
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
	public void mostrar(MouseEvent event)
	{
		String aux = "NOMBRE\t\t\tTELEFONO\tSALDO\tMORA\n";
		for(int k = 0; k <= n; k++)
		{
			aux+= nombre[k] + "   \t"+ telefono[k] + " | \t"+  sald[k] + " | \t"+  mora[k] + "\n";
		}
		total.setText(aux);
		
	}
	@FXML
	public void inserta(ActionEvent e)
	{	
		boolean isNumeric = false, saldo = false;
		if(n < 9)
		{
			if((name_1.getText().compareTo("") != 0) && (telefono_1.getText().compareTo("") != 0) && (sal.getText().compareTo("") != 0))
			{
				//Haremos las validaciones correspondientes, verificando que los datos sean correctos
				isNumeric =  telefono_1.getText().matches("[0-9-+ ]+") ;
				saldo =  sal.getText().matches("[0-9.]+") ;
				if(isNumeric == false || saldo == false)
				{
					JOptionPane.showMessageDialog(null, "No se pueden ingresar Letras en Telefono o Saldo");
				}
				else if(!op1.isSelected() && !op2.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Seleccione un estado moroso para el cliente");
				}
				else
				{
					n += 1;
					nombre[n] = name_1.getText();
					telefono[n] = telefono_1.getText();
					sald[n] = Float.parseFloat(sal.getText());
					if(op1.isSelected())
					{
						mora[n] = true;
					}
					else
					{
						mora[n] = false;
					}
					JOptionPane.showMessageDialog(null, "Se insertó correctamente");
					name_1.setText("");
					telefono_1.setText("");
					sal.setText("");
					op1.setSelected(false);
					op2.setSelected(false);
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
	public void Modificar(ActionEvent e)
	{	
		if(n > -1) // Verificamos si hay elementos para actualizar
		{
			if((busq.getText().compareTo("") != 0))//Si ya llenó el campo de buscar
			{
				if(i<=n)
				{	
					if(!opact1.isSelected() && !opact2.isSelected()) //Verifica si no se seleccionó un nuevo estado
					{
						JOptionPane.showMessageDialog(null, "Seleccione un estado moroso para el cliente");
					}
					else
					{
						if(opact1.isSelected())
						
						{
							mora[i] = true;
						}
						else
						{
							mora[i] = false;
						}
						JOptionPane.showMessageDialog(null, "Se actualizó correctamente");
					}
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No hay elementos para actualizar");
		}
	}
	public void Eliminar(ActionEvent e)
	{
		for(int l = i; l <= (n - 1); l++)
		{
			nombre[l] = nombre[l+1];
			telefono[l] = nombre[l+1];
			sald[l] = sald[l+1];
			mora[l] = mora[l+1];
		}
		n--;
		
		JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
	}
	public void Info(ActionEvent e)
	{
		i = 0;
		String info = "\nCLIENTE: ";
		if(n>-1)
		{
			while((i<=n) && (nombre[i].compareTo(busq.getText())) != 0)
			{
				i+=1;
			}
			if(i > n)
			{
				JOptionPane.showMessageDialog(null, "No se encontró");
			}
			else
			{
				info+=nombre[i] + "\nTELEFONO: " + telefono[i] + "\nSALDO: " 
							+ sald[i] + "\nMORA: " + mora[i]; 
				resul.setText(info);	
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "El registro está vacío");
		}
	}
	public void buscar(ActionEvent e)
	{
		i = 0;
		if(n>-1)
		{
			while((i<=n) && (nombre[i].compareTo(busq.getText())) != 0)
			{
				i+=1;
			}
			if(i > n)
			{
				JOptionPane.showMessageDialog(null, "No se encontró");
			}
			else
			{
				resul_act.setText(busq.getText());	
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "El registro está vacío");
		}
	}
	
}