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
	/*
	@Test
	public void testHoraInicioDeReservaDebeSerMayora5_59AM()
	{
		Reserva reserva = new Reserva();
		reserva.asignarHoraDeInicio(6);
		assertEquals(6,reserva.obtenerHoraInicio());
	}
	*/
	//HORAS DE RESERVA
	@Test
	public void testHoradeReservaDeveSerMayor5()
	{
		
		try {
			HoraReserva horaReserva = new HoraReserva(5,0);
			fail();
		} catch (Exception e) {
			assertEquals("No se aceptan horas de reservas menores a 6:00",e.getMessage());
		}
		
	}
	
	
	@Test
	public void testHoradeReservaDeveSerMenorA24()
	{
		
		try {
			HoraReserva horaReserva = new HoraReserva(24,0);
			fail();
		} catch (Exception e) {
			assertEquals("No se aceptan horas de reservas mayores a 23:00",e.getMessage());
		}
		
	}
	@Test
	public void testHoraReservaDebeSerAsignada()
	{
		HoraReserva horaReserva = new HoraReserva(7,0);
		assertEquals(7,horaReserva.obtenerHora());
	}
	
	//Minutos de reserva
	@Test
	public void testMinutosDeReservaDebenSer0()
	{
		try {
			HoraReserva horaReserva = new HoraReserva(7,3);
			fail();
		} catch (Exception e) {
			assertEquals("Minuto de reserva debe ser 0 o 30",e.getMessage());
		}
	}

	@Test
	public void testMinutosDeReservaDebenSer30()
	{
		
			HoraReserva horaReserva = new HoraReserva(7,30);
			assertEquals(30,horaReserva.obtenerMinuto());
	}

}
