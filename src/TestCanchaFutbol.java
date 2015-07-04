import static org.junit.Assert.*;

import org.junit.Test;


public class TestCanchaFutbol {

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
	public void testCalendarioDebeAgregarUnaReserva(){
		
		Calendario oCalendario = new Calendario();
		Object reserva="9 a 10";
		oCalendario.agregarReserva(reserva);
		assertTrue(oCalendario.contains(reserva));
			
	}
	
	/*
	@Test
	public void testCalendarioNoDeberiaPermitirAgregar2HorariosEnLaMismaHora()
	{
		//Horarios hora inicio
		//horarios hora fin
		//Descripcion
	}*/
	
	@Test
	public void testReservaDebeTenerUnaHoradeInicio()
	{
		Reserva reserva = new Reserva();
		reserva.asignarHoraDeInicio(6);
		assertEquals(6,reserva.obtenerHoraInicio());
	}

}
