package entity;

import javax.persistence.*;

import application.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Collection;

@Entity
public class Niveau 
{
    private int idNiveau;
    private String nomNiveau;
    private Collection<NivScan> nivScansByIdNiveau;
    private Collection<Utilisateur> utilisateursByIdNiveau;
    
    @Override
    public String toString()
    {
		return this.getNomNiveau();
    	
    }

//	@Override
//	public Niveau fromString(String string) 
//	{
//		return niveau.getItems().stream().filter(ap -> 
//		ap.getNomNiveau().equals(string)).findFirst().orElse(null);
//	}
    
    public Niveau(ResultSet resultatRequete) 
    {
    	
    }

    public Niveau(int id) 
    {
    	Connection connectDb = DatabaseConnection.getInstance().getConnection();
    	String query = "{CALL select_niveau_byID(?)}";
    	
    	try
		{

			//Statement statement = connectDb.createStatement();
			CallableStatement stmt = connectDb.prepareCall(query);
			stmt.setInt(1, id);

			ResultSet queryResult = stmt.executeQuery();

			while(queryResult.next())
			{
				this.setIdNiveau(id);
				this.setNomNiveau(queryResult.getString("Nom_Niveau"));
			}
				
		} 
    	catch(Exception e)
		{
    		System.out.println("\nProbleme Niveau(int id) \n");
			e.printStackTrace();
			e.getCause(); 
		}
		
	}

	public Niveau() {
		// TODO Auto-generated constructor stub
	}

	@Id
    @Column(name = "Id_Niveau")
    public int getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }

    @Basic
    @Column(name = "Nom_Niveau")
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

    @OneToMany(mappedBy = "niveauByIdNiveau")
    public Collection<NivScan> getNivScansByIdNiveau() {
        return nivScansByIdNiveau;
    }

    public void setNivScansByIdNiveau(Collection<NivScan> nivScansByIdNiveau) {
        this.nivScansByIdNiveau = nivScansByIdNiveau;
    }

    @OneToMany(mappedBy = "niveauByIdNiveau")
    public Collection<Utilisateur> getUtilisateursByIdNiveau() {
        return utilisateursByIdNiveau;
    }

    public void setUtilisateursByIdNiveau(Collection<Utilisateur> utilisateursByIdNiveau) {
        this.utilisateursByIdNiveau = utilisateursByIdNiveau;
    }
}
