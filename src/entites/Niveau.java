package entites;

//import javax.persistence.*;
//import java.util.Collection;


public class Niveau {
    private int idNiveau;
    private String nomNiveau;
    //private Collection<NivScan> nivScansByIdNiveau;
    //private Collection<Utilisateur> utilisateursByIdNiveau;


    public int getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }


    public String getNomNiveau() {
        return nomNiveau;
    }

    public void setNomNiveau(String nomNiveau) {
        this.nomNiveau = nomNiveau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Niveau niveau = (Niveau) o;

        if (idNiveau != niveau.idNiveau) return false;
        if (nomNiveau != null ? !nomNiveau.equals(niveau.nomNiveau) : niveau.nomNiveau != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNiveau;
        result = 31 * result + (nomNiveau != null ? nomNiveau.hashCode() : 0);
        return result;
    }


//    public Collection<NivScan> getNivScansByIdNiveau() {
//        return nivScansByIdNiveau;
//    }
//
//    public void setNivScansByIdNiveau(Collection<NivScan> nivScansByIdNiveau) {
//        this.nivScansByIdNiveau = nivScansByIdNiveau;
//    }


//    public Collection<Utilisateur> getUtilisateursByIdNiveau() {
//        return utilisateursByIdNiveau;
//    }
//
//    public void setUtilisateursByIdNiveau(Collection<Utilisateur> utilisateursByIdNiveau) {
//        this.utilisateursByIdNiveau = utilisateursByIdNiveau;
//    }
}
