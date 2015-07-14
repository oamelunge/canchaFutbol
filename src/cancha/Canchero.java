package cancha;
import java.util.ArrayList;
import java.util.List;


public class Canchero {
    
	private List<Reserva> calendario = new ArrayList<Reserva>();
	
	public void agregarReserva(Reserva reserva) {
		if(existeAlgunaReservaEnLaMismaFecha(reserva))
			validarHorarioDeNuevaReserva(reserva);
		calendario.add(reserva);
	}

	private boolean existeAlgunaReservaEnLaMismaFecha(Reserva reserva) {
		return calendario.stream().anyMatch(r-> r.obtenerFechaReserva().equals(reserva.obtenerFechaReserva()));
	}

	private void validarHorarioDeNuevaReserva(Reserva reserva) {
		if(seIntentaReservarEnUnHorarioOcupado(reserva))
			throw new RuntimeException("La hora de reserva ya esta ocupada");
		if(seIntentaReservarAMitadDeUnHorarioOcupado(reserva))
			throw new RuntimeException("Imposible Completar la reserva");
	}

	private boolean seIntentaReservarAMitadDeUnHorarioOcupado(Reserva reserva) {
		return calendario.stream().anyMatch(r-> reserva.obtenerHoraInicio().horaMilitar() >= r.obtenerHoraInicio().horaMilitar()
				                      && reserva.obtenerHoraInicio().horaMilitar() <= r.obtenerHoraFin().horaMilitar());
	}

	private boolean seIntentaReservarEnUnHorarioOcupado(Reserva reserva) {
		return calendario.stream().anyMatch(r->r.obtenerHoraInicio().horaMilitar()==reserva.obtenerHoraInicio().horaMilitar());
	}

	public boolean contains(Reserva reserva) {
		return calendario.contains(reserva);
	}

}
