package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

	List<Mensaje> listaMensajes = new ArrayList <Mensaje>();
	
	
	
	public List<Mensaje> getListaMensajes() {
		return listaMensajes;
	}


	public void setListaMensajes(List<Mensaje> listaMensajes) {
		this.listaMensajes = listaMensajes;
	}

	public Adjunto agregarAdjunto(String nombre,String extension) {
		Adjunto adjunto = new Adjunto (nombre,extension);
		
		return adjunto;
	}
	

	public boolean agregarEmail(LocalDate fechaEnvio,LocalTime horaEnvio,String origen,String destino,String asunto,String cuerpo,Adjunto adjunto) throws Exception {
		boolean resultado = false;
		
		int idMensaje =1;
		if(!listaMensajes.isEmpty() ) {
			idMensaje= listaMensajes.get(listaMensajes.size()-1).getIdMensaje() + 1;
		
		}
		Email email= new Email(idMensaje,fechaEnvio,horaEnvio,this.validarEmail(origen),this.validarEmail(destino),asunto,cuerpo,false,adjunto);
		listaMensajes.add(email);
		resultado =true;
		
		return resultado;
	}
	
	public String validarEmail(String destino) throws Exception {
		String cadena= destino;
		int pos= cadena.indexOf("@");		
		if(pos==-1) {
			throw new Exception("Error al ingresar destino, asegurese de insertar ----> @    ");
		}else {
			return cadena;
		}
	}
	

	
	public boolean agregarSMS(LocalDate fechaEnvio,LocalTime horaEnvio, int numeroOrigen,int numeroDestino,String texto) throws Exception {
		boolean resultado=false;
		
		int idMensaje =1;
		if(!listaMensajes.isEmpty()) {
			idMensaje= listaMensajes.get(listaMensajes.size()-1).getIdMensaje() +1;
		}
		SMS sms= new SMS(idMensaje,fechaEnvio,horaEnvio,numeroOrigen,this.validarNumeroDestino(numeroDestino),texto,false);
		listaMensajes.add(sms);
		resultado= true;
		
		return resultado;
		
	}
	
	public int validarNumeroDestino(int numeroDestino)throws Exception{
	int retorno = numeroDestino;
	
	if(String.valueOf(numeroDestino).length()==10 ) {
		retorno = numeroDestino;
	}else {
		throw new  Exception("Error Ingrese 10 numeros");
	}
		
	return retorno;
		
	}
	
	
	
	
	
	
	
	
	
	public Mensaje traerMensaje(int idMensaje) {
		Mensaje mensaje = null;
		int i=0;
		while(mensaje==null && i<listaMensajes.size()){
			if(listaMensajes.get(i).getIdMensaje()==idMensaje) {
				mensaje= listaMensajes.get(i);
			}
			i++;
		}
		return mensaje;
	}
	
	/*+ traerMensaje(String extension) : Mensaje --retorna una lista del tipo Mensaje con aquellos que
	tengan adjuntos con la extension que ingresa como parámetro.*/
	

	public List<Mensaje> traerMensaje2(String extension){
		
		List<Mensaje> lis= new ArrayList<Mensaje>();
		Mensaje email=null;
		int i=0;
		for(i=0 ; i<listaMensajes.size();i++) {
			if(listaMensajes.get(i) instanceof Email) {
				if(((Email) listaMensajes.get(i)).getAdjunto().getExtension().equals(extension)) {
				email = listaMensajes.get(i);
				lis.add(email);
				}
			}
		}
		return lis;
	}
	
		
		
	
	
	//+ traerMensaje(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta) : Mensaje //retorna
    //una lista del tipo Mensaje con aquellos que tengan fecha y hora dentro de los parámetros
   //ingresados.

	
	public List<Mensaje> traerMensaje(LocalDate fecha,LocalTime horaDesde,LocalTime horaHasta) {
		List<Mensaje> lstMensajes= new ArrayList <Mensaje>();
		Mensaje mensaje=null;
		
		for (int i=0; i<listaMensajes.size(); i++) {
			if(listaMensajes.get(i).getFechaEnvio().equals(fecha)) {
				if(listaMensajes.get(i).getHoraEnvio().isAfter(horaDesde)) {
					if(listaMensajes.get(i).getHoraEnvio().isBefore(horaHasta)) {
						mensaje=listaMensajes.get(i);
						lstMensajes.add(mensaje);
					}
				}
			}
		}
		
		return lstMensajes;
		
		
	}
	
	
	/* + traerMensaje(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta, String extension) :
Mensaje //retorna una lista del tipo Mensaje con aquellos que tengan fecha y hora dentro de los
parámetros ingresados y además contentan adjuntos con la extensión ingresada como
parámetro.

*/
	
	
	
	/*public List<Mensaje> traerMensaje(LocalDate fecha,LocalTime horaDesde,LocalTime horaHasta,String extension) {
		Mensaje mensaje=null;
		Email email= null;
		//int i=0;
		List<Mensaje> nuevaLista= new ArrayList<Mensaje>();
		
		for (int i=0; i<listaMensajes.size(); i++) {
			if(listaMensajes.get(i).getFechaEnvio().equals(fecha)) {
				if(listaMensajes.get(i).getHoraEnvio().isAfter(horaDesde)) {
					if(listaMensajes.get(i).getHoraEnvio().isBefore(horaHasta)){
						if(listaMensajes.get(i) instanceof Email ){
							if(email.getAdjunto().getExtension().equals(extension)) {
								mensaje=listaMensajes.get(i);
								nuevaLista.add(mensaje);
						
							}
						}
					}
				}
			}
		}
		
		return nuevaLista;
	}
	*/
	

	
	
	public List<Mensaje> traerMensaje(LocalDate fecha,LocalTime horaDesde,LocalTime horaHasta,String extension){
		List<Mensaje> lis= this.traerMensaje(fecha, horaDesde, horaHasta);
		List<Mensaje> lis2= new ArrayList<Mensaje>();
		Mensaje email=null;
		int i=0;
		for(i=0 ; i<lis.size();i++) {
			if(((Email) lis.get(i)).getAdjunto().getExtension().equals(extension)) {
				email = lis.get(i);
				lis2.add(email);
			}
		}
		return lis2;
	}
	
}//fin de  la clase
