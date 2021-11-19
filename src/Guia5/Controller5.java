package Guia5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class Controller5 {
	@FXML
	private TextArea Imp;
	@FXML
	private TextArea Imp1;
	@FXML
	private TextArea Imp3;
	@FXML
	private StackPane ej1;
	@FXML
	private StackPane ej2;
	@FXML
	private StackPane ej3;
	@FXML
	private TextField in1;
	@FXML
	private TextField inej2;
	@FXML
	private TextField name;
	@FXML
	private TextField code;
	@FXML
	private TextField sal;
	static List <String> listita  = new ArrayList<String>(); 
	static List <Integer> lista  = new ArrayList<Integer>(); 
	static List <Integer> pos = new ArrayList<Integer>();
	static List <Integer> neg = new ArrayList<Integer>();
	static List <empleado> listac  = new ArrayList<empleado>();
	static int cont = -1;
	private void cambiarej2(String panel, int nej) {
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(panel+".fxml")); // CAMBIA Y MUESTRA EL FXML CORRESPONDIENTE AL PANEL SELECCIONADO
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if(nej == 1)
        {
        	ej1.getChildren().removeAll();
        	ej1.getChildren().addAll(root);
        }
        else if(nej == 2)
        {
        	ej2.getChildren().removeAll();
        	ej2.getChildren().addAll(root);
        }
        else if(nej == 3)
        {
        	ej3.getChildren().removeAll();
        	ej3.getChildren().addAll(root);
        }
    }
	@FXML
	public void impej2(MouseEvent event) { 
		cambiarej2("Impimir2", 2);
    }
	@FXML
	public void inserta1(MouseEvent event) 
	{ 
        cambiarej2("Insertar1", 1);
    }
	@FXML
	public void imp1(MouseEvent event) 
	{ 
        cambiarej2("Impimir1", 1);
    }
	@FXML
	public void inserta2(MouseEvent event) { 
        cambiarej2("Insertar2", 2);
        
    }
	@FXML
	public void inserta3(MouseEvent event) { 
        cambiarej2("Insertar3", 3);
        
    }
	@FXML
	public void imp3(MouseEvent event) { 
        cambiarej2("Impimir3", 3);
        
    }
	//Ejercicio1
	public void insertar_ej1(MouseEvent event)
	{ 
		String Dato = in1.getText();
		listita.add(Dato);
		in1.setText("");
		JOptionPane.showMessageDialog(null,"Se insertó correctamente.");
	}
	//Impimir 1
	public void imprimir(MouseEvent envent)
	{
		String aux = "\nDatos: \n";
	    for (String i : listita) 
	    {
	        aux += i + "\n";
	    }
	    Imp1.setText(aux);
	}
	//Ejercicio2
	public void insertalog2(MouseEvent envent)
	{
		boolean isNumeric = false;
		//Haremos las validaciones correspondientes, verificando que los datos sean correctos
		isNumeric =  inej2.getText().matches("[0-9-]+");
		if(isNumeric == false)
		{
			JOptionPane.showMessageDialog(null, "Solo se pueden ingresar enteros");
		}
		else
		{
			cont++;
			lista.add(Integer.parseInt(inej2.getText()));
			if(lista.get(cont)< 0)
			{
				neg.add(lista.get(cont));
			}
			else
			{
				pos.add(lista.get(cont));
			}
			JOptionPane.showMessageDialog(null, "Se insertó correctamente.");
			inej2.setText("");
		}
	}
	//Inserta en el ejercicio3
	public void agregar(MouseEvent envent)
	{
		String nom;
		int id;
		float sala; 
		/*Pedis los datos*/
		nom = name.getText();
		id = Integer.parseInt(code.getText());
		sala =Float.parseFloat(sal.getText());
		empleado nuevo = new empleado(nom, id, sala); 
		listac.add(nuevo);
		JOptionPane.showMessageDialog(null, "Se insertó correctamente.");
	}
	//Ejercicio 1
	public void eliminar(MouseEvent event)
	{
		if(listita.size() > 0)
		{
			listita.remove(0);
			JOptionPane.showMessageDialog(null,"Se eliminó correctamente");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"No hay elementos en la lista");
		}
	}
	//Ejercicio2
	public void imprimir2(MouseEvent event) 
	{
		String imp = "\n\nLista Original: " + Imprimir(lista);
		imp+="\n\nLista Negativos: " + Imprimir(neg);
		imp+="\n\nLista Positivos: " + Imprimir(pos); 
		Imp.setText(imp);
	}
	//Ejercicio3
	public void Imprimir_ej3(MouseEvent event)
	{ 
		String sal = "Nombre\t\t\t\tCodigo\t\tSalario \n"; 
	    for(empleado i: listac)
	    {  
	    	sal += i.getNombre() + "\t\t" + i.getid() + "\t\t" + i.getsalario() + "\n"; 
	    } 
        Imp3.setText(sal);
    } 
	//Ejercicio3 - limpiar
	public void limpr(MouseEvent envent)
	{
		name.setText("");
		code.setText("");
		sal.setText("");
	}
	//Ejercicio2
	public static String Imprimir(List<Integer> lista)
	{
		String salL = "";
		for(Integer i: lista)
		{
			salL += i + "  ";
		}
		return salL;
	}
	//Ejercicio3
	public void nomina(MouseEvent envent)
	{
		float a = 0;
		ej3.getChildren().clear();
		for(empleado i: listac)
		{ 
			a += i.getsalario();
	    } 
		String nomim = "\n   La nomina es: " + a;
		Label nom = new Label(nomim);
		Font auxFont = nom.getFont();
		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		nom.setFont(new Font(auxFont.getStyle(), 20));
		nom.setStyle("-fx-text-fill: white");
		nom.setBackground(null);
	    ej3.getChildren().add(nom);	
	}
	
}
