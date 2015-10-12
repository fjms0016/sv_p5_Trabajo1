package ejercicio1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

public class Mensajes {
	
	//public static final String CRLF="\r\n";
	public static final String OK="+OK";
	protected static String ID="";
	//public static final String QUIT="QUIT";
	public static final String ERR="-ERR";
	/*public static final String SOL="SOL";
	public static final String PET="PET";
	
	static int OPERACION=1;
	static int EXIT=2;*/
	protected String codigoRecibido="";
	protected static int secuencia=0;
	protected int longitud;
	protected int secuenciaRecibida = 0;
	protected long fecha;
	private String mensaje = "";
	private Servicios data = null;
	
	
	public  Mensajes(Servicios s,int e){
		Date f=new Date();
		fecha=f.getTime();
		
		int estado=e;
		//Forma cadena de texto
		if(estado==1){
		mensaje=OK+" "+secuencia+" date= "+fecha+" "+"selecciona servicio";
		longitud=mensaje.length();
		mensaje=mensaje+" "+longitud;
		}
		else if(estado==2){
			mensaje=OK+" "+secuencia+" date= "+fecha+" "+"dame los operadores";
			longitud=mensaje.length();
			mensaje=mensaje+" "+longitud;
		}
		
		else if(estado==3){
			mensaje=OK+" "+secuencia+" date= "+fecha+" "+"el resultado es"+""+s.toString();
			longitud=mensaje.length();
			mensaje=mensaje+" "+longitud;
		}
		
		else if(estado==4){
			mensaje=OK+" "+secuencia+" date= "+fecha+" "+"Has salido";
			longitud=mensaje.length();
			mensaje=mensaje+" "+longitud;
		}
		secuencia++;
		
	}
	
	public byte[] toByteArray()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(5);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.writeUTF(mensaje);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public Mensajes(String datos, byte[] bytedata){
		ByteArrayInputStream bais = new ByteArrayInputStream(bytedata);

		DataInputStream dis = new DataInputStream(bais);
		try {
			this.secuenciaRecibida = dis.readInt();
			this.fecha = dis.readLong();
			this.mensaje=dis.readUTF();
		} catch (IOException ex) {
		}

		
		
		
		String [] campos=datos.split(" ");
		
		if (campos.length==9){
			codigoRecibido=campos[0];
			secuenciaRecibida=Integer.parseInt(campos[1]);
			fecha=Long.parseLong(campos[4]);
			data=new Servicios(Double.parseDouble(campos[5]),Double.parseDouble(campos[6]),campos[7], Double.parseDouble(campos[8]));
		}
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
