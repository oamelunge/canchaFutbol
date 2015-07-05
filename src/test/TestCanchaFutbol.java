package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cancha.Calendario;
import cancha.Canchero;


public class TestCanchaFutbol{

	/*Como cliente de la cancha de la cancha de futbol necesito agendar un 
	 * horario para poder jugar futbol
	 * */
	
	
	
	
	
	@Test
	public void testAgendarrCancha() {
		Object calendario = "horarios";
		Canchero oCanchero = new Canchero(calendario);
		assertEquals("horario reservado", oCanchero.reservarHorario() );
	}

	@Test
	public void testCalendarioDebeAgregarUnaReserva() {
		
		Calendario oCalendario = new Calendario();
		Object reserva="9 a 10";
		oCalendario.agregarReserva(reserva);
		assertTrue(oCalendario.contains(reserva));
			
	}
	
	


}
