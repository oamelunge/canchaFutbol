import static org.junit.Assert.*;

import org.junit.Test;


public class TestCanchaFutbol {

	/*Como cliente de la cancha de la cancha de futbol necesito reservar un 
	 * horario para poder jugar futbol
	 * */
	
	@Test
	public void testReservarCancha() {
		Object calendario = "horarios";
		Canchero oCanchero = new Canchero(calendario);
		assertEquals("horario reservado", oCanchero.reservarHorario() );
	}
	
	@Test
	public void testCalendarioDebeAgregarUnHorario(){
		
		Calendario oCalendario = new Calendario();
		Object horario="9 a 10";
		oCalendario.agregarHorario(horario);
		assertTrue(oCalendario.contains(horario));
			
	}

}
