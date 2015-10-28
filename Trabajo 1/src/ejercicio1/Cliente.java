package ejercicio1;

public interface Cliente {
	public byte MSG_INICIO=0x01;
	public byte MSG_OPERACION=0x02;
	public byte MSG_FIN=0x04;
	
	/**
	 * M�todo para autenticar un usuario
	 */
	public void login();
	/**
	 * @param men cadena de caracteres que manda el cliente
	 */
	public void envia(String men);
	/**
	 * @return devuelve cadena de caracteres recibida de servidor
	 */
	public String recibe();
	/**
	 * M�todo para seleccionar la operacion que quiere realizar el cliente
	 */
	public void seleccionOperacion();

	/**
	 * M�todo para indicar que el cliente quiere salir
	 */
	public void salir();
	
}