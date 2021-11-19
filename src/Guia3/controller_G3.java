package Guia3;

import java.io.IOException;


import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class controller_G3
{
	@FXML
	private StackPane main_l; /*Contenedor principal*/
	@FXML
	private TextArea resultado_or;
	@FXML
	private TextArea resultado_metodos;
	
	//varibales iniciales
	@FXML
	private TextArea txtrQuitsor;
	@FXML
	public void regresar(MouseEvent event) 
	{ 
		Parent root = null;    
	    try {
	    		root = FXMLLoader.load(getClass().getResource("../application/Menu_G3.fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
	    main_l.getChildren().removeAll();
	    main_l.getChildren().addAll(root);
    }
	// funcionalidad
	public void burbuja(MouseEvent event)
	{
		 UIManager.put("OptionPane.background",new ColorUIResource(42,38,42));
		 UIManager.put("Panel.background",new ColorUIResource(42,38,42));
		int n = Integer.parseInt((String) JOptionPane.showInputDialog(null,"<html><p style = \"color: white;\"> ¿Cuántos datos va ingresar? </p></html>","Burbuja", 0,icono("/Images/ordenar.png", 40, 40), null, null));
		String nombre[] = new String[n], temp, aux = "\t      METODO BURBUJA\n\n";
		inserta(nombre);
		aux+="    Array Sin Ordenar\n\n";
		for(int i = 0; i < nombre.length; i++)
		{
			aux += "    " + nombre[i] + "\n";
		}
		for (int p = 1; p < n; p++)
		{
			for (int i = 0; i < n-1; i++)
			{
				//Ya que usamos compareTo el c�digo no funcionar� si intercambiamos 
				//minusculas por mayusculas, as� que usamos toLowerCase para
				//convertir todo a minusculas y as� se salte cualquier error
				if (nombre[i].toLowerCase().compareTo(nombre[i+1].toLowerCase()) > 0)
				{
					temp = nombre[i]; 
					nombre[i] = nombre[i+1]; 
					nombre[i+1] = temp; 
				}
				
			}
		}
		aux+="\n    Array Ordenado\n\n";
		for(int i = 0; i < nombre.length; i++)
		{
			aux += "    " + nombre[i] + "\n";
		}
		txtrQuitsor.setText(aux);
	}
	
	public void insercion(MouseEvent event)
	{
		UIManager.put("OptionPane.background",new ColorUIResource(42,38,42));
		UIManager.put("Panel.background",new ColorUIResource(42,38,42));
		int n = Integer.parseInt((String) JOptionPane.showInputDialog(null,"<html><p style = \"color: white;\"> ¿Cuántos datos va ingresar? </p></html>", "Insercion",0,icono("/Images/ordenar.png", 40, 40), null, null));
		String nombre[] = new String[n], temp, aux = "\t      INSERCION DIRECTA\n\n";
		inserta(nombre);
		int k;
		aux+="    Array Sin Ordenar\n\n";
		for(int i = 0; i < nombre.length; i++)
		{
			aux += "    " + nombre[i] + "\n";
		}
		for (int p = 1; p < n; p++)
		{
			temp = nombre[p];
			k = p-1;
			while((k >= 0) && (temp.toLowerCase().compareTo(nombre[k].toLowerCase()) < 0))
			{
				
				nombre[k+1] = nombre[k]; 
				k--; 	
			}
			nombre[k+1] = temp;
		}
		aux+="\n    Array Ordenado\n\n";
		for(int i = 0; i < nombre.length; i++)
		{
			aux += "    " + nombre[i] + "\n";
		}
		txtrQuitsor.setText(aux);
	}
	public Icon icono(String path,int width, int height)
	{
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
		return img;
	}
	public void seleccion(MouseEvent event)
	{
		UIManager.put("OptionPane.background",new ColorUIResource(42,38,42));
		UIManager.put("Panel.background",new ColorUIResource(42,38,42));
		int n = Integer.parseInt((String) JOptionPane.showInputDialog(null,"<html><p style = \"color: white;\"> ¿Cuántos datos va ingresar? </p></html>", "Selección",0,icono("/Images/ordenar.png", 40, 40), null, null));
		String nombre[] = new String[n], temp, aux = "\t   SELECCIÓN DIRECTA\n\n";
		inserta(nombre);
		int k;
		aux+="    Array Sin Ordenar\n\n";
		for(int i = 0; i < nombre.length; i++)
		{
			aux += "    " + nombre[i] + "\n";
		}
		for (int i = 0; i < n; i++)
		{
			temp = nombre[i];
			k = i;
			for (int j = i+1; j < n; j++)
			{
				//Ya que usamos compareTo el c�digo no funcionar� si intercambiamos 
				//minusculas por mayusculas, as� que usamos toLowerCase para
				//convertir todo a minusculas y as� se salte cualquier error
				if (nombre[j].toLowerCase().compareTo(temp.toLowerCase()) < 0)
				{
					temp = nombre[j]; 
					k = j;
				}
				
			}
			nombre[k] = nombre[i];
			nombre[i] = temp;
		}
		aux+="\n    Array Ordenado\n\n";
		for(int i = 0; i < nombre.length; i++)
		{
			aux += "    " + nombre[i] + "\n";
		}
		txtrQuitsor.setText(aux);
	}
	public void shell(MouseEvent event)
	{
		UIManager.put("OptionPane.background",new ColorUIResource(42,38,42));
		UIManager.put("Panel.background",new ColorUIResource(42,38,42));
		int n = Integer.parseInt((String) JOptionPane.showInputDialog(null,"<html><p style = \"color: white;\"> ¿Cuántos datos va ingresar? </p></html>","Shell",0,icono("/Images/ordenar.png", 40, 40), null, null));
		String nombre[] = new String[n], temp, aux = "\t   METODO SHELL\n\n";
		inserta(nombre);
		int ent = n+1, i;
		boolean flag;
		aux+="    Array Sin Ordenar\n\n";
		for(int d = 0; d < nombre.length; d++)
		{
			aux += "    " + nombre[d] + "\n";
		}
		while(ent > 0)
		{
			ent /= 2;
			flag = true;
			while(flag == true)
			{
				flag = false;
				i = 0;
				while((i+ent)< n)
				{
					if(nombre[i].toLowerCase().compareTo(nombre[i+ent].toLowerCase()) > 0)
					{
						temp = nombre[i];
						nombre[i] = nombre[i+ent];
						nombre[i+ent] = temp;
						flag = true;
					}
					i++;
				}
			}
		}
		aux+="\n    Array Ordenado\n\n";
		for(int f = 0; f < nombre.length; f++)
		{
			aux += "    " + nombre[f] + "\n";
		}
		txtrQuitsor.setText(aux);
	}
	
	public void quicksort(MouseEvent event)
	{
		UIManager.put("OptionPane.background",new ColorUIResource(42,38,42));
		UIManager.put("Panel.background",new ColorUIResource(42,38,42));
		int n = Integer.parseInt((String) JOptionPane.showInputDialog(null,"<html><p style = \"color: white;\"> ¿Cuántos datos va ingresar? </p></html>","Quicksort",0,icono("/Images/ordenar.png", 40, 40), null, null));
		String nombre[] = new String[n], aux = "\t METODO QUICKSORT\n\n";
		inserta(nombre);
		int ini=0,fin=n-1;
		aux+="    Array Sin Ordenar\n\n";
		for(int d = 0; d < nombre.length; d++)
		{
			aux += "    " + nombre[d] + "\n";
		}
		ReduceRecursivo(ini,fin,nombre);
		aux+="\n    Array Ordenado\n\n";
		for(int f = 0; f < nombre.length; f++)
		{
			aux += "    " + nombre[f] + "\n";
		}
		txtrQuitsor.setText(aux);
	}
	
	/*Metodo que pedirá los datos a ordenar*/
	public static void inserta(String nombre[])
	{
		UIManager.put("OptionPane.background",new ColorUIResource(42,38,42));
		UIManager.put("Panel.background",new ColorUIResource(42,38,42));
		for(int i = 0; i < nombre.length; i++)
		{
			nombre[i] = JOptionPane.showInputDialog("<html><p style = \"color: white;\"> Ingrese un nombre</p></html>");
		}
	}
	
	public static void ReduceRecursivo(int ini, int fin,String nombre[]) 
	{
		int izq,der,pos;
		String aux;
		boolean band;
		izq=ini;
		der = fin;
		pos = ini;
		band = true;
		while(band== true)
		{
			band = false;
			while((nombre[pos].toLowerCase().compareTo(nombre[der].toLowerCase()) <= 0)&& (pos!=der))
			{
				der--;
			}
			if(pos!=der)
			{
				aux= nombre[pos];
				nombre[pos]= nombre[der];
				nombre[der]=aux;
				pos=der;
				while((nombre[pos].toLowerCase().compareTo(nombre[izq].toLowerCase()) >= 0) && (pos!=izq))
				{
					izq++;
				}
				if(pos!=izq)
				{
					band = true;
					aux = nombre[pos];
					nombre[pos] = nombre[izq];
					nombre[izq] = aux;
					pos = izq;
				}
			}
		}
		if((pos-1)>ini)
			ReduceRecursivo(ini,pos-1,nombre);
		if(fin>(pos+1))
			ReduceRecursivo(ini+1,fin,nombre);
	}

	// metodos de busqueda
	
	public void desordenada(MouseEvent event)
	{
		int i = 0;
		UIManager.put("OptionPane.background",new ColorUIResource(42,38,42));
		UIManager.put("Panel.background",new ColorUIResource(42,38,42));
		int n = Integer.parseInt((String) JOptionPane.showInputDialog(null,"<html><p style = \"color: white;\"> ¿Cuántos datos va ingresar? </p></html>","desordenada",0,icono("/Images/lupa.png", 40, 40), null, null));
		String nombre[] = new String[n];
		inserta(nombre);
		
		String x = JOptionPane.showInputDialog("<html><p style = \"color: white;\"> Ingrese el elemento a buscar: </p></html>"), aux = "\n\tBUSQUEDA DESORDENADO\n\n";
		aux+="\nArreglo Ingresado:\n\n";
		for(int j = 0; j < n; j++)
		{
			aux+=nombre[j] + "\n";
		}
		while((i <= n-1) && nombre[i].equalsIgnoreCase(x) == false)
		{
			i++;
		}
		if(i >= n)
		{
			aux+= "\nNo se encontró el elemento " + x;
			txtrQuitsor.setText(aux);
		}
		else
		{
			aux+= "\nSe encontró el elemento " + x + "\n" + "En la posición " + i;
			txtrQuitsor.setText(aux);
		}
	}
	
	public void ordenada (MouseEvent event)
	{
		UIManager.put("OptionPane.background",new ColorUIResource(42,38,42));
		UIManager.put("Panel.background",new ColorUIResource(42,38,42));
		int n = Integer.parseInt((String) JOptionPane.showInputDialog(null,"<html><p style = \"color: white;\"> ¿Cuántos datos va ingresar? </p></html>","ordenada",0,icono("/Images/lupa.png", 40, 40), null, null));
		String nombre[] = new String[n];
		inserta(nombre);
		String x = JOptionPane.showInputDialog("<html><p style = \"color: white;\"> Ingrese el elemento a buscar: </p></html>"), aux = "\n\tBUSQUEDA ORDENADO\n\n";
		aux+="\nArreglo Ingresado:\n\n";
		int ini=0,fin=n-1;
		ReduceRecursivo(ini, fin, nombre);
		for(int j = 0; j < n; j++)
		{
			aux+=nombre[j] + "\n";
		}
		int i = 0;
		while(i < n && x.toLowerCase().compareTo(nombre[i].toLowerCase()) > 0)
		{
			i++;
		}
		if( i >= n || x.toLowerCase().compareTo(nombre[i].toLowerCase()) < 0)
		{
			aux+= "\nNo se encontró el elemento " + x;
			txtrQuitsor.setText(aux);
		}
		else
		{
			aux+= "\nSe encontró el elemento " + x + "\n" + "En la posición " + i;
			txtrQuitsor.setText(aux);
		}
	}
	
	public void busqueda_b(MouseEvent event)
	{
		UIManager.put("OptionPane.background",new ColorUIResource(42,38,42));
		UIManager.put("Panel.background",new ColorUIResource(42,38,42));
		int n = Integer.parseInt((String) JOptionPane.showInputDialog(null,"<html><p style = \"color: white;\"> ¿Cuántos datos va ingresar? </p></html>","Busqueda binaria",0,icono("/Images/lupa.png", 40, 40), null, null));
		String nombre[] = new String[n];
		inserta(nombre);
		String x = JOptionPane.showInputDialog("<html><p style = \"color: white;\"> Ingrese el elemento a buscar: </p></html>"), aux = "\n\tBUSQUEDA BINARIA\n\n";
		aux+="\nArreglo Ingresado:\n\n";
		int ini=0,fin=n-1, centro = 0;
		boolean flag = false;
		ReduceRecursivo(ini, fin, nombre);
		for(int j = 0; j < n; j++)
		{
			aux+=nombre[j] + "\n";
		}
		while(ini <= fin && flag == false)
		{
			centro = (ini+fin)/2;
			if(x.equalsIgnoreCase(nombre[centro]))
			{
				flag = true;
			}
			else
			{
				if(x.toLowerCase().compareTo(nombre[centro].toLowerCase()) < 0)
				{
					fin--;
				}
				else
				{
					ini++;
				}
			}
		}
		if(flag == true)
		{
			aux+= "\nSe encontró el elemento " + x + "\n" + "En la posición " + centro;
			txtrQuitsor.setText(aux);
		}
		else
		{
			aux+= "\nNo se encontró el elemento " + x;
			txtrQuitsor.setText(aux);
		}
	}
	
}

