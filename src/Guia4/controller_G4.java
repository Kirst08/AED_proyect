package Guia4;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class controller_G4 
{
	@FXML
	private TextArea impresion;
	@FXML
	private StackPane main_l; /*Contenedor principal*/
	@FXML
	private TextField palabra1; /*Contenedor principal*/
	
	@FXML
	public void regresar(MouseEvent event) 
	{ 
		Parent root = null;    
	    try {
	    		root = FXMLLoader.load(getClass().getResource("../application/Menu_G4.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
    }
	public void Ej1(MouseEvent event)
	{
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo:"));
		int original[] = new int[n];
		String imp = "\nArreglo original: \n\n";
		rellena(original, 0, n);
		imp += Imprimir("", original, n, 0); 
		imp += "\n\nArreglo Invertido: \n\n";
		cambia(original, 0, n-1);
		imp += Imprimir("", original, n, 0); 
		impresion.setText(imp);
	}
	public static String Imprimir(String aux, int array[], int n, int i) 
	{
		if(i < n)
	    {
			if(i<(n-1))
			{
				aux = array[i] + ", ";
			}
			else
			{
				aux = array[i] + " ";
			}
			aux += Imprimir(aux, array, n, i+1);
			return aux; 
	    }
		else
		{
			return "";
		}
	 }
	public static int cambia(int[] original, int i, int n)
	{
		if(i<(n))
		{
			int aux = original[i];
			original[i] = original[n];
			original[n] = aux;
			cambia(original, i+=1, n-=1);
			return 0;
		}		
		else
		{
			return 0;
		}
	}
	
	public static int rellena(int[] original, int i, int n)
	{
		
		if(i == (n))
		{
			
			return 0;
		}
		else
		{
			original[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
			i++;
			rellena(original, i, n);
			return 0;
		}
	}
	/*Segundo ejercicio*/
	public void Ej2(MouseEvent event)
	{
		String palabra = palabra1.getText(), xd = "\n\nPalabra original: ";
		int n = palabra.length();
		char array[] = palabra.toCharArray(); 
		xd += palabra + "\n\nPalabra inversa: " ;
		recursiva(n-1,array, 0);
		xd += Imprimir2("", array, n, 0);
		impresion.setText(xd);
	}
	public static String Imprimir2(String aux, char array[], int n, int i) 
	{
		if(i < n)
	    {
			aux = array[i]+""; 
			aux += Imprimir2(aux, array, n, i+1);
			return aux; 
	    }
		else
		{
			return "";
		}
	 }
	public static void recursiva(int n, char array[], int pos)
	{
		char aux;
		if (pos < n)
		{
			aux = array[pos];
			array[pos] = array[n];
			array[n] = aux; 
			recursiva(n-1,array, pos+1);
		}	
	}
	/*Tercer Ejercicio*/
	public void Ej3(MouseEvent event)
	{
		int elemento = 0; 
		float producto = 1;
		String Sal = "\n\nElementos dado: \n\n";
		Sal += producto_recursivo(elemento, producto, Sal, 1);
		impresion.setText(Sal);
	}
	public static String producto_recursivo(int elemento, float producto, String Sal, int i)
	{
		if(i <= 10)
		{
			elemento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento: " + i));
			producto *= elemento;
			if(i < 10)
			{
				Sal = elemento + ", ";
			}
			else
			{
				Sal = elemento + "";
			}
			Sal += producto_recursivo(elemento,producto, Sal, i+=1);
			return Sal;
		}
		else 
		{
			Sal = "\n\n El producto es: " + producto;
			return Sal;
		}
	}
	/*Cuarto Ejercicio*/
	public void Ej4(MouseEvent event)
	{
		String mensaje = palabra1.getText();
		int espacios = Espacios(mensaje, 0, 0);
		String imp = "\nFrase Ingresada: " + mensaje + "\n\nCantidad de Espacios: " + espacios;
		impresion.setText(imp);
	}
	public static int Espacios(String mensaje, int i, int c)
	{
		if (i == (mensaje.length() - 1))
		{
			return c;			
		}
		else
		{
			if (mensaje.charAt(i) == ' ') 
			{
				c++;  	
			}
			c =  Espacios(mensaje, i+1, c);				
			return c;
		} 
	}
	/*Quinto ejercicio*/
	public void Ej5(MouseEvent event)
	{
		String year = CalcularInteres(2021,(float) 400.0, (float)500.0,(float) 4.0,(float) 2.3, "Año    Cta.Pedro    Cta. Juan\n2021    400.00    500.00\n"); 
		impresion.setText(year);
	}
	public static String CalcularInteres(int year, float ct_1, float ct_2, float i_1, float i_2, String sal)
	{
		DecimalFormat frmt = new DecimalFormat("#.###");
		if(ct_1 > ct_2)
			return sal;
		else
		{
			ct_1 += (ct_1 * (i_1 / 100)); 
			ct_2 += (ct_2 * (i_2 / 100));
			year++; 
			String sl = year + "    " +  frmt.format(ct_1)  + "    " + frmt.format(ct_2) + "\n";
			sal += CalcularInteres(year, ct_1, ct_2, i_1, i_2, sl); 
			return sal; 
		}
	}
}
