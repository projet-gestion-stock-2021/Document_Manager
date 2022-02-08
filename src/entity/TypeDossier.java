package entity;

import javax.persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Entity
@Table(name = "type_dossier", schema = "testdm", catalog = "")
public class TypeDossier {
    private int idTypeDossier;
    private String nomTypeDossier;
    private Boolean flagTypeDossier;
    private Collection<Dossier> dossiersByIdTypeDossier;
    
    public TypeDossier(ResultSet rst)
    {
    	try 
    	{
			this.setIdTypeDossier(rst.getInt("Id_Type_Dossier"));
			this.setNomTypeDossier(rst.getString("Nom_type_dossier"));
			this.setFlagTypeDossier(rst.getBoolean("Flag_type_dossier"));
			//this.setTypeDossierByIdTypeDossier(typeDossierByIdTypeDossier.set);
			
		} 
    	catch (SQLException e) 
    	{
			System.out.println("\nProbleme TypeDossier(ResultSet rst)\n");
			e.printStackTrace();
		}
    }
    
    /*
     * to display the TypeDossier object name in the choiceBox
     */
    @Override
    public String toString() 
    {
		return this.getNomTypeDossier();
    	
    }


    @Id
    @Column(name = "Id_Type_Dossier")
    public int getIdTypeDossier() {
        return idTypeDossier;
    }

    public void setIdTypeDossier(int idTypeDossier) {
        this.idTypeDossier = idTypeDossier;
    }

    @Basic
    @Column(name = "Nom_TypeDossier")
    public String getNomTypeDossier() {
        return nomTypeDossier;
    }

    public void setNomTypeDossier(String nomTypeDossier) {
        this.nomTypeDossier = nomTypeDossier;
    }

    @Basic
    @Column(name = "Flag_TypeDossier")
    public Boolean getFlagTypeDossier() {
        return flagTypeDossier;
    }

    public void setFlagTypeDossier(Boolean flagTypeDossier) {
        this.flagTypeDossier = flagTypeDossier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeDossier that = (TypeDossier) o;

        if (idTypeDossier != that.idTypeDossier) return false;
        if (nomTypeDossier != null ? !nomTypeDossier.equals(that.nomTypeDossier) : that.nomTypeDossier != null)
            return false;
        if (flagTypeDossier != null ? !flagTypeDossier.equals(that.flagTypeDossier) : that.flagTypeDossier != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTypeDossier;
        result = 31 * result + (nomTypeDossier != null ? nomTypeDossier.hashCode() : 0);
        result = 31 * result + (flagTypeDossier != null ? flagTypeDossier.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typeDossierByIdTypeDossier")
    public Collection<Dossier> getDossiersByIdTypeDossier() {
        return dossiersByIdTypeDossier;
    }

    public void setDossiersByIdTypeDossier(Collection<Dossier> dossiersByIdTypeDossier) {
        this.dossiersByIdTypeDossier = dossiersByIdTypeDossier;
    }
}
