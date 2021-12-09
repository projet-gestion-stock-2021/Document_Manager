package entites;

public class Parametre {
	
	private int idParametre;
    private String pathStock;
    private String pathBackup;

    public int getIdParametre() {
        return idParametre;
    }

    public void setIdParametre(int idParametre) {
        this.idParametre = idParametre;
    }

    public String getPathStock() {
        return pathStock;
    }

    public void setPathStock(String pathStock) {
        this.pathStock = pathStock;
    }

    public String getPathBackup() {
        return pathBackup;
    }

    public void setPathBackup(String pathBackup) {
        this.pathBackup = pathBackup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parametre parametre = (Parametre) o;

        if (idParametre != parametre.idParametre) return false;
        if (pathStock != null ? !pathStock.equals(parametre.pathStock) : parametre.pathStock != null) return false;
        if (pathBackup != null ? !pathBackup.equals(parametre.pathBackup) : parametre.pathBackup != null) return false;

        return true;
    }

}
