package ejercicio1;

public class Servicios {
	
	
	
	protected int est=1;
	Mensajes m=new Mensajes(null);
	Datos d=new Datos(null, null);
	
	
	public void transition(){
		switch(est){
		case 1:
			//Si recibo menos de 6 caracteres mando ERR si no OK
			m.setMensaje(null);
			//Si mando OK aumento estado
			est++;
			;
		case 2:
			//Recibo una seleccion correcta de servicio
			m.setMensaje(null);
			;
		case 3:	
			//Mando resultado
			m.setMensaje(null);
			;
			
		case 4:
			//Estado de salida
			
		}
	}
	
	
	
		
	
	
	
	
	

}
	
	

	
	
