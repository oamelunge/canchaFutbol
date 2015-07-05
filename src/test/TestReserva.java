package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import cancha.HoraReserva;
import cancha.Reserva;

public class TestReserva {


	@Test
	public void testReservaDebeTenerUnaHoradeInicioyUnaHoraFin() {
		HoraReserva horaInicio = new HoraReserva(8,30);
		HoraReserva horaFin = new HoraReserva(9,30);
		LocalDate fechaReserva = LocalDate.now();
		Reserva reserva = new Reserva(fechaReserva,horaInicio, horaFin, "");
		assertEquals(horaInicio,reserva.obtenerHoraInicio());
		assertEquals(horaFin,reserva.obtenerHoraFin());
	}

	@Test
	public void testHorarioDeHoraDeInicioDebeSerMenorAHorarioHoraFin() {
		HoraReserva horaInicio = new HoraReserva(9,30);
		HoraReserva horaFin = new HoraReserva(8,30);
		LocalDate fechaReserva = LocalDate.now();
		try {
			Reserva reserva = new Reserva(fechaReserva,horaInicio, horaFin, "");
			fail();
		} catch (Exception e) {
			assertEquals("Hora de inicio no puede ser mayor a hora de fin",e.getMessage());
		}
	}

	@Test
	public void testHorarioDeHoraDeInicioNoDebeSerIgualAHorarioHoraFin() {
		HoraReserva horaInicio = new HoraReserva(9,30);
		HoraReserva horaFin = new HoraReserva(9,30);
		LocalDate fechaReserva = LocalDate.now();
		try {
			Reserva reserva = new Reserva(fechaReserva,horaInicio, horaFin, "");
			fail();
		} catch (Exception e) {
			assertEquals("Hora de inicio no puede ser igual a hora de fin",e.getMessage());
		}
	}

	@Test
	public void testReservaDebeTenerUnaDescriptiocn() {
		HoraReserva horaInicio = new HoraReserva(22,30);
		HoraReserva horaFin = new HoraReserva(23,30);
		String descripcion= "Oscar Amelunge 75520286";
		LocalDate fechaReserva = LocalDate.now();
		
		Reserva reserva = new Reserva(fechaReserva,horaInicio, horaFin, descripcion);
		
		assertEquals(horaInicio,reserva.obtenerHoraInicio());
		assertEquals(horaFin,reserva.obtenerHoraFin());
		assertEquals(descripcion,reserva.obtenerDescripcion());
		
	}
	
	@Test
	public void testReservaDebeTenerUnaFechaDeReserva()
	{
		HoraReserva horaInicio = new HoraReserva(22,30);
		HoraReserva horaFin = new HoraReserva(23,30);
		String descripcion= "Oscar Amelunge 75520286";
		LocalDate fechaReserva = LocalDate.now();
		
		Reserva reserva = new Reserva(fechaReserva,horaInicio, horaFin, descripcion);
		
		assertEquals(horaInicio,reserva.obtenerHoraInicio());
		assertEquals(horaFin,reserva.obtenerHoraFin());
		assertEquals(descripcion,reserva.obtenerDescripcion());
		assertEquals(fechaReserva,reserva.obtenerFechaReserva());
	}

}