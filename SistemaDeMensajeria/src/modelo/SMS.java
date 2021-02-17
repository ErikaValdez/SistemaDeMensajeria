package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class SMS extends Mensaje{

	private int numeroOrigen;
	private int numeroDestino;
	private String texto;
	private boolean visto;
	

	public SMS(int idMensaje, LocalDate fechaEnvio, LocalTime horaEnvio, int numeroOrigen, int numeroDestino,
			String texto, boolean visto) {
		super(idMensaje, fechaEnvio, horaEnvio);
		this.numeroOrigen = numeroOrigen;
		this.numeroDestino = numeroDestino;
		this.texto = texto;
		this.visto = visto;
	}



	public int getNumeroOrigen() {
		return numeroOrigen;
	}
	
	public void setNumeroOrigen(int numeroOrigen) {
		this.numeroOrigen = numeroOrigen;
	}


	public int getNumeroDestino() {
		return numeroDestino;
	}


	public void setNumeroDestino(int numeroDestino) {
		this.numeroDestino = numeroDestino;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}


	public boolean isVisto() {
		return visto;
	}



	public void setVisto(boolean visto) {
		this.visto = visto;
	}


	@Override
	public
	Boolean cambiarEstado(Boolean estadoNuevo) {
		boolean resultado=false;
		this.setVisto(true);
		resultado=true;
		
		return resultado;
	}



	@Override
	public String toString() {
		return "\n SMS [numeroOrigen=" + numeroOrigen + ", numeroDestino=" + numeroDestino + ", texto=" + texto
				+ ", visto=" + visto + "]";
	}
	
	
	
}
