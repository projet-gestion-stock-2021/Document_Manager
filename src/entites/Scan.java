package entites;

public class Scan {

	private int idScan;
    private String nomScan;

    public Scan(int idScan, String nomScan) {
		super();
		this.idScan = idScan;
		this.nomScan = nomScan;
	}
    
    public Scan(Scan s) {
    	this.idScan = s.getIdScan();
    	this.nomScan = s.getNomScan();
    }

	public int getIdScan() {
        return idScan;
    }

    public void setIdScan(int idScan) {
        this.idScan = idScan;
    }

    public String getNomScan() {
        return nomScan;
    }

    public void setNomScan(String nomScan) {
        this.nomScan = nomScan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scan scan = (Scan) o;

        if (idScan != scan.idScan) return false;
        if (nomScan != null ? !nomScan.equals(scan.nomScan) : scan.nomScan != null) return false;

        return true;
    }
}
