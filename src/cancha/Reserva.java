package cancha;

import java.time.LocalDate;

public class Reserva {

	private HoraReserva horaInicio;
	private HoraReserva horaFin;
	private String descripcion;
	private LocalDate fechaReserva;
	
	

	public Reserva(LocalDate _fechaReserva, HoraReserva _horaInicio, HoraReserva _horaFin, String _descripcion) {
		validarHorarios(_horaInicio, _horaFin);
		this.horaInicio=_horaInicio;
		this.horaFin=_horaFin;
		this.descripcion=_descripcion;
		this.fechaReserva=_fechaReserva;
	}



	private void validarHorarios(HoraReserva _horaInicio, HoraReserva _horaFin) {
		if(_horaInicio.obtenerHora()>_horaFin.obtenerHora())
			throw new RuntimeException("Hora de inicio no puede ser mayor a hora de fin");
		if(_horaInicio.obtenerHora()==_horaFin.obtenerHora())
			throw new RuntimeException("Hora de inicio no puede ser igual a hora de fin");
	}



	public HoraReserva obtenerHoraInicio() {
		return this.horaInicio;
	}



	public HoraReserva obtenerHoraFin() {
		return this.horaFin;
	}



	public String obtenerDescripcion() {
		return this.descripcion;
	}



	public LocalDate obtenerFechaReserva() {
		return this.fechaReserva;
	}

}
