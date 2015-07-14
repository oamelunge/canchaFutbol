package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import cancha.Canchero;
import cancha.HoraReserva;
import cancha.Reserva;


public class TestCanchaFutbol{

	/*Como cliente de la cancha de la cancha de futbol necesito agendar un 
	 * horario para poder jugar futbol
	 * */
	private HoraReserva _horaInicio;
	private HoraReserva _horaFin;
	private LocalDate _fechaReserva;
	private Reserva _reserva1;
	private Reserva _reserva2;
	private String _descripcion;
	private Canchero _canchero;

	@Test
	public void testCalendarioDebeAgregarUnaReserva() {
		_reserva1=inicializarReserva(8,30,9,30);
		_canchero = new Canchero();	
		_canchero.agregarReserva(_reserva1);
		assertTrue(_canchero.contains(_reserva1));
			
	}
	
	@Test
	public void testCalendarioNoDebePermitirAgragarUnaReservaEnUnHorarioYaReservado()
	{
		_reserva1=inicializarReserva(8,30,9,30);
		_reserva2=inicializarReserva(8,30,9,30);
		_canchero = new Canchero();
		_canchero.agregarReserva(_reserva1);

		try {
			_canchero.agregarReserva(_reserva2);
			fail();

		} catch (Exception e) {
			assertEquals("La hora de reserva ya esta ocupada", e.getMessage());
		}
	}
	
	@Test
	public void testCalendarioNoDebePermitirAgragarUnaReservaALaMitadDeUnHorariorReservado()
	{
		_reserva1=inicializarReserva(8,0,9,0);
		_reserva2=inicializarReserva(8,30,9,30);
	    _canchero = new Canchero();
		
		_canchero.agregarReserva(_reserva1);

		try {
			_canchero.agregarReserva(_reserva2);
			fail();

		} catch (Exception e) {
			assertEquals("Imposible Completar la reserva", e.getMessage());
		}
	}
	
	private Reserva inicializarReserva(int horaInicio, int minutoInicio, int horaFin, int minutoFin ) {
		_horaInicio = new HoraReserva(horaInicio,minutoInicio);
		_horaFin = new HoraReserva(horaFin,minutoFin);
		_descripcion = "Oscar Amelunge 75520286";
		_fechaReserva = LocalDate.now();
		return new Reserva(_fechaReserva,_horaInicio, _horaFin, _descripcion);
		
	}
	
	


}
