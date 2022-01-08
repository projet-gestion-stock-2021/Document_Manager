package application2;

public class Utilisateur {

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", login="
				+ login + ", mdp=" + mdp + "]";
	}


	private int idUtilisateur;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    public Utilisateur(int idUtilisateur, String nom, String prenom, String login, String mdp) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
	}
    public Utilisateur(String nom, String prenom, String login, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
	}
	
	  public Utilisateur() {
		
	}


	private Byte flagUtilisateur; private String niveau;
	  
	  public String getNiveau() { return niveau; }
	  
	  public void setNiveau(String niveau) { this.niveau = niveau; }
	 

	public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


	
	  public Byte getFlagUtilisateur() { return flagUtilisateur; }
	  
	  public void setFlagUtilisateur(Byte flagUtilisateur) { this.flagUtilisateur =
	  flagUtilisateur; }
	 

    @Override
	
	  public boolean equals(Object o) { if (this == o) return true; if (o == null
	  || getClass() != o.getClass()) return false;
	  
	  Utilisateur that = (Utilisateur) o;
	  
	  if ((idUtilisateur != that.idUtilisateur) || (nom != null ?
	  !nom.equals(that.nom) : that.nom != null) || (prenom != null ?
	  !prenom.equals(that.prenom) : that.prenom != null) || (login != null ?
	  !login.equals(that.login) : that.login != null)) return false; if (mdp !=
	  null ? !mdp.equals(that.mdp) : that.mdp != null) return false; if
	  (flagUtilisateur != null ? !flagUtilisateur.equals(that.flagUtilisateur) :
	  that.flagUtilisateur != null) return false;
	  
	  return true; }
	 

    @Override
    public int hashCode() {
        int result = idUtilisateur;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (mdp != null ? mdp.hashCode() : 0);
        result = 31 * result + (flagUtilisateur != null ? flagUtilisateur.hashCode() : 0);
        return result;
    }
}
