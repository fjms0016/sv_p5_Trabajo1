package ejercicio1;

import java.io.*;

public class Datos {
	
	private double op1,op2,result;
	private String comando,signo,usuario;

	
	//Constructor para inicializar los datos
	/**
	 * @param cmd comandos del protocolo. Puede ser OK,ERR o QUIT
	 * @param usu cadena de caracteres con el usuario
	 * @param ope1 primer operador del calculo
	 * @param ope2 segundo operador del calculo
	 * @param sig signo de la operacion
	 * @param res resultado de la operacion
	 */
	public Datos(String cmd,String usu,double ope1, double ope2, String sig, double res)
	{
		this.op1=ope1;
		this.op2=ope2;
		this.comando=cmd;
		this.signo=sig;
		this.usuario=usu;
		result=res;
	}
		
	
	//Constructor para recibir los datos
	/**
	 * @param dis conjunto de datos que recibimos en un objeto DataInputStream
	 */
	public Datos (DataInputStream dis){
		try {
			this.op1= dis.readDouble();
			this.op2=dis.readDouble();
			this.comando=dis.readUTF();
			this.signo=dis.readUTF();
			this.usuario=dis.readUTF();
			this.result=dis.readDouble();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.op1=0.0;
			this.op2=0.0;
			this.comando=Mensajes.ERR;
			this.signo=" ";
			this.usuario=" ";
			this.result=0.0;
			e.printStackTrace();
		}
			Datos d= new Datos(comando,usuario,op1,op2,signo,result);
			Mensajes m =new Mensajes(d);
	}
	
	
	/**
	 * @param dos datos que mandamos en un objeto DataOutputStream
	 */
	public void toByteArray (DataOutputStream dos){
		try {
			dos.writeUTF(comando);
			dos.writeDouble(this.op1);
			dos.writeUTF(signo);
			dos.writeDouble(this.op2);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	public String toString()
	{
		return  op1+" "+op2;
		
	}

	/**
	 * @return devuelve el valor de la variable op1
	 */
	public double getOp1() {
		return op1;
	}

	/**
	 * @param op1 Asigna el valor que le pasamos a la variable op1
	 */
	public void setOp1(double op1) {
		this.op1 = op1;
	}

	/**
	 * @return devuelve el valor de la variable op1
	 */
	public double getOp2() {
		return op2;
	}

	/**
	 * @param op2 Asigna el valor que le pasamos a la variable op1
	 */
	public void setOp2(double op2) {
		this.op2 = op2;
	}

	/**
	 * @return devuelve el valor de la variable comando
	 */
	public String getComando() {
		return comando;
	}
	

	/**
	 * @return devuelve el valor de la variable usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * @return devuelve el valor de la variable signo
	 */
	public String getSigno() {
		return signo;
	}
	
	/**
	 * @return devuelve el valor de la variable result
	 */
	public double getRes() {
		return result;
	}



}