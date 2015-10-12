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
	private String mensaje = "";
	private Servicios data = null;
	private double op1,op2,res;
	private String sgn;
	
	public void datosrec(Servicios data){
		op1=data.ope1;
		op2=data.ope2;
		sgn=data.signo;
		res=data.res;
		//en servicios necesito los datos hay que mandarlos
		
	}

}
