package ejercicio1;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Datos {
	
	protected String codigoRecibido="";
	protected static int secuencia=0;
	protected int longitud;
	protected int secuenciaRecibida = 0;
	protected long fecha;
	protected String mensaje = "";
	protected Servicios data = null;
	protected double ope1,ope2,res;
	protected String signo,usuario,contraseña;
	
	public Datos(double op1,double op2){
		ope1=op1;
		ope2=op2;
		
	}
	
	public Datos(double op1,double op2,String sgn,double res){
		ope1=op1;
		ope2=op2;
		signo=sgn;
		res=res;
		
	}
	
	public Datos(DataInputStream dis){
		try {
			this.usuario=dis.readUTF();
			this.contraseña=dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
