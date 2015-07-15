package canchaSystem;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import model.Reserva;

public class CancheroPersistence implements CancheroSystem {

	private PersistentErpSystem parentSystem;

	public CancheroPersistence(PersistentErpSystem parentSystem) {
		this.parentSystem = parentSystem;
	}
	@Override
	public void agregarReserva(Reserva reserva) {
		//session().persist(reserva);
		session().save(reserva);
	}

	@Override
	public boolean contains(Reserva reserva) {
		return session().contains(reserva);
	}
	
	private Session session() {
		return parentSystem.session();
	}
	@Override
	public Reserva obtenerReserva(long id) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Reserva> selectedReservas = (List<Reserva>) session().createCriteria(Reserva.class)
			.add(Restrictions.eq("id",id))
			.list();
		
		if (selectedReservas.size()!=1)
			throw new RuntimeException();
		else
			return selectedReservas.get(0);
	}

}
