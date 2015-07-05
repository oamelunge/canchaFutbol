package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import cancha.HoraReserva;

public class TestObjetoHora {

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