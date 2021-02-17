package test;

import java.time.LocalDate;
import java.time.LocalTime;
import modelo.Sistema;

public class Test {

	public static void main(String[] args) throws Exception {
	
	
		Sistema sis= new Sistema();
		
		try {
		System.out.println("1-1 ");
		System.out.println("agregar SMS :");
		System.out.println(sis.agregarSMS(LocalDate.of(2020,12,10),LocalTime.of(14,36,00),151234567,159876543,"Estoy rindiendo el final 001"));
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("1-2 ");
			System.out.println("agregar SMS :");
			System.out.println(sis.agregarSMS(LocalDate.of(2020,12,10),LocalTime.of(14,36,00),151234567,1598765432,"Estoy rindiendo el final 001"));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			System.out.println("");
			System.out.println("1-3 ");
			System.out.println("Agregar Email :");
			System.out.println(sis.agregarEmail(LocalDate.of(2020,12,12), LocalTime.of(16,28) ,"001@unla.gob.ar","alumno.com.ar","Orientacion a objetos 1-Unla","Estimado alumno debe "
					+ "presentarse a rendir el final de 001 el dia 1/12 a las 9hs" ,sis.agregarAdjunto("notas","xlsx")));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("");
			System.out.println("1-4 ");
			System.out.println("Agregar Email :");
			System.out.println(sis.agregarEmail(LocalDate.of(2020,12,12), LocalTime.of(16,28) ,"001@unla.gob.ar","alumno@gmail.com.ar","Orientacion a objetos 1-Unla","Estimado alumno debe "
					+ "presentarse a rendir el final de 001 el dia 1/12 a las 9hs" ,sis.agregarAdjunto("Notas","XLSX")));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("");
		System.out.println("2-1");
		
		
		System.out.println(sis.traerMensaje(1).cambiarEstado(true));
		System.out.println(sis.traerMensaje(1));
		
		System.out.println("");
		System.out.println("2-2");
		//Traer e imprimir el Email con IdMensaje = 2 y cambiar el estado a Recibido=true
		
		
		System.out.println(sis.traerMensaje(2));
		System.out.println("Cambiar estado a recibido=true");
		System.out.println(sis.traerMensaje(2).cambiarEstado(true));
		System.out.println(sis.traerMensaje(2));
		
		//3) Agregar los siguientes objetos a la lista, al finalizar la carga, imprimirla:

		System.out.println("3");
		System.out.println(sis.agregarSMS(LocalDate.of(2020,12,11),LocalTime.of(13,19),151234567,1598765431,"Recibido OK"));
		System.out.println(sis.agregarSMS(LocalDate.of(2020,12,15),LocalTime.of(10,24),151234567,1598765430,"Gracias"));
		System.out.println(sis.agregarEmail(LocalDate.of(2020,11,10),LocalTime.of(17,15),"oo1@unla.gob.ar","alumno@gmail.com.ar","Orientación a Objetos 1 - UNLa","Se adjunta la grilla" + 
				"de inscripciones al final de Diciembre",sis.agregarAdjunto("GrillaFinales", "XLSX")));
		System.out.println(sis.agregarEmail(LocalDate.of(2020,12,11),LocalTime.of(15,12),"info@unla.gob.ar","persona@unla.gob.ar","Promocion", "Aproveche nuestras promociones",sis.agregarAdjunto(" Promociones","JPG")));

	
		System.out.println(sis.getListaMensajes());
		System.out.println("");
		//4-1) Traer e imprimir los mensajes que tengan un adjunto con extensión JPG
		
		System.out.println("Traer e imprimir los mensajes que tengan un adjunto con extensión JPG");
		System.out.println("");
		
		System.out.println("4-1");
		System.out.println("");
		System.out.println(sis.traerMensaje2("JPG"));
		
		
		System.out.println("");
		
		System.out.println("4-2");
		System.out.println(" Traer e imprimir los mensajes que se hayan enviado el día 11/12/2020 entre las 13 y las 17Hs");
		
		
		System.out.println(sis.traerMensaje(LocalDate.of(2020,12,11),LocalTime.of(13,00),LocalTime.of(17,00)));
		
		System.out.println("");
		
		System.out.println("4-3");
		
		System.out.println("Traer e imprimir los mensajes que se hayan enviado el día 20/11/2020 entre las 16 y las 18Hs y\r\n" + 
				"que tengan adjuntos con extensión XLSX");
		
		System.out.println(sis.traerMensaje(LocalDate.of(2020,11,10),LocalTime.of(16,00),LocalTime.of(18,00),"XLSX")); // modifique el dia porque no hay ningun mensaje agregado el dia 2020/11/20
		
	}//fin clase
	
	

}
