package Guia1;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class controller1 {
	@FXML
	private StackPane C_add;
	@FXML
	private StackPane main_l; /*Contenedor principal*/
	@FXML
	private TextField name;
	@FXML
	private TextField Sem;
	@FXML
	private TextField Prom;
	@FXML
	private TextField elim;
	@FXML
	private TextField name_act;
	@FXML
	private TextField prom_act;
	@FXML
	private TextField sem_act;
	@FXML
	private TextField name_bus;
	@FXML
	private TextArea result;
	@FXML
	private TextArea lista;
	
	//Arreglo
	static String nombre[] = new String[10];
	static int sem[] = new int[10];
	static float prom[] = new float[10];
	static int n = -1, i = 0;
	
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
        cambiarPanel("Ej1_1D");
    }
	@FXML
	public void Eliminar(MouseEvent event) 
	{ 
        cambiarPanel("Ej1_2D");
    }
	@FXML
	public void Actualizar(MouseEvent event) 
	{ 
        cambiarPanel("Ej1_3D");
    }
	@FXML
	public void Mostrar_1(MouseEvent event) 
	{ 
        cambiarPanel("Ej1_4D");
    }
	@FXML
	public void listado(MouseEvent event) 
	{ 
        cambiarPanel("Ej1_5D");
    }
	//+++++++++++++++++++++++Funcionalidad+++++++++++++++++++++++++++++++++++
	public void registrar(MouseEvent event)
	{
		boolean isNumeric = false, v_prom = false;
		if(n < 9) /*Verifica si el arreglo tiene espacio*/
		{
			if((name.getText().compareTo("") != 0) && (Sem.getText().compareTo("") != 0) && (Prom.getText().compareTo("") != 0))
			{
				//Haremos las validaciones correspondientes, verificando que los datos sean correctos
				isNumeric =  Sem.getText().matches("[0-9]+") ;
				v_prom =  Prom.getText().matches("[0-9.]+") ;
				if(isNumeric == false || v_prom == false)
				{
					JOptionPane.showMessageDialog(null, "No se pueden ingresar Letras en Semestre o Prom.");
				}
				else
				{
					n++;
					nombre[n] = name.getText();
					sem[n] = Integer.parseInt(Sem.getText());
					prom[n] = Float.parseFloat(Prom.getText());
					JOptionPane.showMessageDialog(null, "Se insertó correctamente");
					name.setText("");
					Prom.setText("");
					Sem.setText("");
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No hay espacio");
		}
	}
	public void remover(MouseEvent event)
	{
		i = 0;
		if(elim.getText().compareTo("") != 0)
		{
			String aux = elim.getText();
			//Buscar el elemento
			while((i<=n) && (nombre[i].compareTo(aux)) != 0)
			{
				i++;
			}
	
			if(i > n)
			{
				JOptionPane.showMessageDialog(null, "No se encontró el estudiante.");
			}
			else
			{
				for(int l = i; l <= (n - 1); l++)
				{
					nombre[l] = nombre[l+1];
					prom[l] = prom[l+1];
					sem[l] = sem[l+1];
				}
				n--;
			
				JOptionPane.showMessageDialog(null, aux + " se eliminó correctamente.");
				elim.setText("");
			}
		}
	}
	public void modificar(MouseEvent event)
	{
		i = 0;
		if((name_act.getText().compareTo("") != 0) && (prom_act.getText().compareTo("") != 0) && (sem_act.getText().compareTo("") != 0))
		{
			while((i<=n) && (nombre[i].compareTo(name_act.getText())) != 0)
			{
				i++;
			}
			if(i > n)
			{
				JOptionPane.showMessageDialog(null, "No se encontró el estudiante " + name_act.getText());
			}
			else
			{
				sem[n] = Integer.parseInt(sem_act.getText());
				prom[n] = Float.parseFloat(prom_act.getText());
				JOptionPane.showMessageDialog(null, "El estudiante " + name_act.getText() + " se actualizó correctamente");
			}
		}
	}
	public void Buscar(MouseEvent event)
	{
		while((i<=n) && (nombre[i].compareTo(name_bus.getText()) != 0))
		{
			i++;
		}
		if(i > n)
		{
			result.setText("\n\n\tNO SE ENCONTRÓ.");
			name_bus.setText("");
		}
		else
		{
			result.setText("\n\tNOMBRE: " + nombre[i] + 
					"\n\n\tNo. Semestres: " + sem[i] + 
					"\n\n\tPromedio T: " + prom[i]);
			name_bus.setText("");
		}
	}
	public void listar(MouseEvent event)
	{
		String aux = "NOMBRE\t\t\t  No. SEMESTRE\t  PROM. T\n";
		for(int k = 0; k <= n; k++)
		{
			aux+= nombre[k] + "\t\t  "+ sem[k] + "\t\t\t  "+  prom[k] +  "\n";
		}
		lista.setText(aux);
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
