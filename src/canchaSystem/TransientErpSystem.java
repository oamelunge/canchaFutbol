package canchaSystem;


public class TransientErpSystem implements ErpSystem {

	private CancheroSystem cancheroSystem;
	
	public TransientErpSystem(){
		cancheroSystem = new CancheroTransient(this);		
	}

	@Override
	public void beginTransaction() {
	}

	@Override
	public void commit() {
	}

	@Override
	public void close() {
	}

	@Override
	public CancheroSystem cancheroSystem() {
		// TODO Auto-generated method stub
		return cancheroSystem;
	}



}
