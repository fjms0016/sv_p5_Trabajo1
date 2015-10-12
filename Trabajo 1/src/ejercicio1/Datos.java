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
	
	public Datos(String datos, byte[] bytedata){
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

}
