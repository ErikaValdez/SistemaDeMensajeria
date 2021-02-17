package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Email extends Mensaje {

		
		private String origen;
		private String destino;
		private String	asunto;
		private String cuerpo;
		private boolean recibido;
		private Adjunto adjunto;
		
		
		public Email(int idMensaje, LocalDate fechaEnvio, LocalTime horaEnvio, String origen, String destino,
				String asunto, String cuerpo, boolean recibido, Adjunto adjunto) {
			super(idMensaje, fechaEnvio, horaEnvio);
			this.origen = origen;
			this.destino = destino;
			this.asunto = asunto;
			this.cuerpo = cuerpo;
			this.recibido = recibido;
			this.adjunto = adjunto;
		}

		
	


		public String getOrigen() {
			return origen;
		}


		public void setOrigen(String origen) {
			this.origen = origen;
		}


		public String getDestino() {
			return destino;
		}


		public void setDestino(String destino) {
			this.destino = destino;
		}


		public String getAsunto() {
			return asunto;
		}


		public void setAsunto(String asunto) {
			this.asunto = asunto;
		}


		public String getCuerpo() {
			return cuerpo;
		}


		public void setCuerpo(String cuerpo) {
			this.cuerpo = cuerpo;
		}


		public boolean isRecibido() {
			return recibido;
		}


		public void setRecibido(boolean recibido) {
			this.recibido = recibido;
		}


		public Adjunto getAdjunto() {
			return adjunto;
		}


		public void setAdjunto(Adjunto adjunto) {
			this.adjunto = adjunto;
		}


		@Override
		public
		Boolean cambiarEstado(Boolean estadoNuevo) {
			boolean resultado =false;
			this.setRecibido(true);
			resultado=true;
			
			return resultado;
		}





		@Override
		public String toString() {
			return "\n Email [origen=" + origen + ", destino=" + destino + ", asunto=" + asunto + ", cuerpo=" + cuerpo
					+ ", recibido=" + recibido + ", adjunto=" + adjunto + "]";
		}
		
		
		

}
