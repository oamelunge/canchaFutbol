import java.util.ArrayList;
import java.util.List;


public class Calendario {
    
	private List<Object> horarios = new ArrayList<Object>();
	
	public void agregarHorario(Object horario) {
		horarios.add(horario);
		
	}

	public boolean contains(Object horario) {
		return horarios.contains(horario);
	}

}
