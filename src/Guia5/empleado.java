package Guia5;

public class empleado {

	private String Nombre;
	private int id;
	private float sal_grupo;
	
	public empleado(String nomb, int idd, float sala)
	{
		Nombre = nomb;
		id = idd;
		sal_grupo = sala;
	}
	
	public void setNombre(String nomb)
	{
		Nombre = nomb;
	}
	public void setid(int idd)
	{
		id = idd;
	}
	public void setsal_grupo(float sala)
	{
		sal_grupo = sala;
	}
	public String getNombre()
	{
		return Nombre;
		
	}
	public int getid()
	{
		return id;		
	}
	public float getsalario()
	{
		return sal_grupo;
		
	}
	
}