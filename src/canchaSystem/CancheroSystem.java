package canchaSystem;

import model.Reserva;

public interface CancheroSystem {

	public abstract void agregarReserva(Reserva reserva);
	public abstract boolean contains(Reserva reserva);
	public abstract Reserva obtenerReserva(long id);

}