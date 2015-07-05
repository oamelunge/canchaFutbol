package cancha;
import java.util.ArrayList;
import java.util.List;


public class Calendario {
    
	private List<Object> horarios = new ArrayList<Object>();
	
	public void agregarReserva(Object reserva) {
		horarios.add(reserva);
		
	}

	public boolean contains(Object reserva) {
		return horarios.contains(reserva);
	}

}
