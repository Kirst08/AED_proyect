package Guia2;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class controller1_G2 {
	@FXML
	private StackPane C_add;
	@FXML
	private StackPane main_l; /*Contenedor principal*/	
	@FXML
	private TextField infija;
	@FXML
	private TextField posfija;
	@FXML
	private TextField prefija;
	
	public void prefija_(MouseEvent event)
	{
		//String textFieldValue = testField.getText();
		int tope = -1; 
		String EI = infija.getText(), EPRE = ""; 
		int l = EI.length(), i = l - 1; 
		String simb; 
		char simbolo; 
		char pila[] = new char[l]; 
		 //Infija a prefija
		while(i >= 0)
		{
			simb = (EI.substring(i, i + 1));
			simbolo = simb.charAt(0); 
			//JOptionPane.showMessageDialog(null, simbolo); 
			i--; 
			if(simbolo == ')')
			{
				tope++;
				pila[tope] = simbolo; 
			}
			else
			{
				if(simbolo == '(')
				{
					while(pila[tope] != ')')
					{
						EPRE += Character.toString(pila[tope]);
						tope--; 
					}
					tope--; 
				}
				else
				{
					if(((simbolo >= 'A') && (simbolo <= 'Z')) || ((simbolo >= 'a') && (simbolo <= 'z')))
					{
						EPRE += simbolo; 
					}
					else if((simbolo >= '0') && (simbolo <= '9'))
					{
						EPRE += simbolo; 
					}
					else
					{
						if(tope >= 0)
						{
							while(prioridad(simbolo) < prioridad(pila[tope]))
							{
								EPRE += Character.toString(pila[tope]);
								tope--;
								if(tope == -1)
								{
									break; 
								}
							}
						}
						tope++; 
						pila[tope] = simbolo;
					}
				}
			}
		}  //Fin While
		
		while(tope >= 0)
		{
			EPRE += Character.toString(pila[tope]);
			tope--; 
		}
		String PREFIJA = ""; 
		for (int j = EPRE.length() - 1; j >= 0; j--)
			PREFIJA += EPRE.substring(j, j + 1);
		
		//JOptionPane.showMessageDialog(null, PREFIJA);
		prefija.setText(PREFIJA);
	}
	public void posfija_(MouseEvent event)
	{
		int tope = -1; 
		String EI = infija.getText(), EPOS = ""; 
		int l = EI.length(); 
		String simb; 
		char simbolo; 
		char pila[] = new char[l]; 
		tope = -1; 
		int i = 0; 
		while(i < l)
		{
			//Iterar caracter por caracter
			simb = (EI.substring(i, i + 1));
			simbolo = simb.charAt(0); 
			i++; 
			if(simbolo == '(')
			{
				tope++;
				pila[tope] = simbolo; 
			}
			else
			{
				if(simbolo == ')')
				{
					while(pila[tope] != '(')
					{
						EPOS += Character.toString(pila[tope]);
						tope--; 
					}
					tope--; 
				}
				else
				{
					//Verifica si son letras
					if(((simbolo >= 'A') && (simbolo <= 'Z')) || ((simbolo >= 'a') && (simbolo <= 'z')))
					{
						EPOS += simbolo; 
					}
					//Verifica si son numeros
					else if((simbolo >= '0') && (simbolo <= '9'))
					{
						EPOS += simbolo; 
					}
					else
					{
						if(tope >= 0)
						{
							while(prioridad(simbolo) <= prioridad(pila[tope]))
							{
								EPOS += Character.toString(pila[tope]);
								tope--;
								if(tope == -1)
								{
									break; 
								}
							}
						}
						tope++; 
						pila[tope] = simbolo;
					}
				}
			}
		}  //Fin While
		
		while(tope >= 0)
		{
			EPOS += Character.toString(pila[tope]);
			tope--; 
		}		
		
		posfija.setText(EPOS);
	}
	public static int prioridad(char operador)
	{
		if(operador == '^')
			return 4; 
		else
			if(operador == '*' || operador == '/')
				return 3; 
			else
				if(operador == '+' || operador == '-')
					return 2; 
				else
					return 1;
	}
	/*Salir*/
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
