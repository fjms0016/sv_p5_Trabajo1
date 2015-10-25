package ejercicio1;

import java.io.*;
import java.util.Date;

public class Mensajes {
	//PDU formada por: Comando+version+secuencia+usuario
	//public static final String CRLF="\r\n";
	public static final String OK="+OK";
	public static final String ERR="-ERR";
	public static final String QUIT="QUIT";
	//public static final String PET="PET";
	protected static String ID="";
	//static int OPERACION=1;
	//static int QUIT=2;
	protected int secuencia,estado=0;
	protected String version="1";
	protected long fecha;
	private boolean salida=false;
	
	private String mensaje = "";

	
	/**
	 * @param d Datos que recibe el constructor por defecto
	 */
	public Mensajes(Datos d){

		//Servicios s = new Servicios(String.valueOf(d.getOp1()),String.valueOf(d.getOp2()));
		
		do {
		//Dependiendo de la variable est, estariamos en un estado u otro
		if(estado==0){		
			//Comprobamos que se recibe un mensaje OK
			if(d.getComando().equals(Mensajes.OK)){
				//Comprobamos si el usuario cumple nuestras condiciones
				if(this.tieneNumero(d.getUsuario())==true && d.getUsuario().length()>=6 && d.getUsuario().length()<=12){
			this.toByteArray(d, "Selecciona operacion");
			estado++;
			secuencia++;
				}
				else {
					Datos d1 = new Datos(Mensajes.ERR,d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),d.getRes());
					this.toByteArray(d1, "Usuario no valido");
					secuencia++;
				}
			}
			// Si el comando recibido no es OK mandamos un mensaje de error
			else {
				Datos d2 = new Datos(Mensajes.ERR,d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),d.getRes());
				this.toByteArray(d2,"Seleccion incorrecta");
				secuencia++;
			}
		} else 
			if(estado==1){
				//Si recibimos un OK
				if(d.getComando()==Mensajes.OK){
					//Si quiere realizar una suma
					if(d.getSigno().equals("+")){
						Servicios s = new Servicios(d.getOp1(),d.getOp2());
						Datos dat = new Datos(d.getComando(),d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),s.Suma());
						this.toByteArray(dat);
						secuencia++;
					}
					else 
					//Si quiere realizar una resta
					if(d.getSigno().equals("-")){
						Servicios s = new Servicios(d.getOp1(),d.getOp2());
						Datos dat = new Datos(d.getComando(),d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),s.Resta());
						this.toByteArray(dat);
						secuencia++;
					}
					//Si el signo es incorrecto enviamos mensaje de error
					else{
						Datos d3 = new Datos(Mensajes.ERR,d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),d.getRes());
						this.toByteArray(d3,"Signo incorrecto");	
						secuencia++;
						}	
				}
				//Si recibimos un quit, salimos
				else if (d.getComando().equals(Mensajes.QUIT)){
					estado=2;
					secuencia++;
				}
				
			}
			else
		if(estado==2){
		Datos d4 = new Datos(Mensajes.QUIT,d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),d.getRes());
		this.toByteArray(d4, "Has salido del servicio");
		salida=true;	
		}
		
		} while (salida=false);
	}
	
	
	
	/**
	 * @param data datos que pasamos para escribir en consola
	 */
	public void toByteArray(Datos data)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(29);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.writeUTF(data.getComando());
			dos.writeUTF(version);
			dos.write(secuencia);
			dos.writeUTF(data.getUsuario());
			dos.writeDouble(data.getRes());
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param dat datos que pasamos para escribir en consola
	 * @param cad cadena de caracteres que complementa a los datos
	 */
	public void toByteArray(Datos dat, String cad)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(41);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.writeUTF(dat.getComando());
			dos.writeUTF(version);
			dos.write(secuencia);
			dos.writeUTF(dat.getUsuario());
			dos.writeUTF(cad);
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param word String que pasamos para comprobar si contiene algun numero
	 * @return True si contiene algun numero el String, False si no lo lleva
	 */
	public boolean tieneNumero(String word){
		if(word.contains("1"))
			return true;
		else if (word.contains("2"))
			return true;
		else if (word.contains("3"))
			return true;
		else if (word.contains("4"))
			return true;
		else if (word.contains("5"))
			return true;
		else if(word.contains("6"))
			return true;
		else if	(word.contains("7"))
			return true;
		else if	(word.contains("8"))
			return true;
		else if	(word.contains("9"))
			return true;
		else if	(word.contains("0"))
	return true;
else
	return false;
	
}

	/**
	 * @return devuelve el valor de la variable mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje Asigna la cadena que le pasamos a la variable mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}