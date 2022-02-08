package entity;

import javax.persistence.*;
import java.util.Collection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
public class Dossier {
    private int idDossier;
    private String nomDossier;
    private Boolean flagDossier;
    private TypeDossier typeDossierByIdTypeDossier;
    private Collection<TypeDeDocument> typeDeDocumentsByIdDossier;
    
    public Dossier(ResultSet rst)
    {
    	try 
    	{
			this.setIdDossier(rst.getInt("Id_Dossier"));
			this.setNomDossier(rst.getString("Nom_dossier"));
			this.setFlagDossier(rst.getBoolean("Flag_Dossier"));
			//this.setTypeDossierByIdTypeDossier(typeDossierByIdTypeDossier.set);
			
		} 
    	catch (SQLException e) 
    	{
			System.out.println("\nProbleme Dossier(ResultSet rst)\n");
			e.printStackTrace();
		}
    }

    /*
     * to display the Dossier object name in the comboBox
     */
    @Override
    public String toString() 
    {
		return this.getNomDossier();
    	
    }
    
    @Id
    @Column(name = "Id_Dossier")
    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    @Basic
    @Column(name = "Nom_Dossier")
    public String getNomDossier() {
        return nomDossier;
    }

    public void setNomDossier(String nomDossier) {
        this.nomDossier = nomDossier;
    }

    @Basic
    @Column(name = "Flag_Dossier")
    public Boolean getFlagDossier() {
        return flagDossier;
    }

    public void setFlagDossier(Boolean flagDossier) {
        this.flagDossier = flagDossier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dossier dossier = (Dossier) o;

        if (idDossier != dossier.idDossier) return false;
        if (nomDossier != null ? !nomDossier.equals(dossier.nomDossier) : dossier.nomDossier != null) return false;
        if (flagDossier != null ? !flagDossier.equals(dossier.flagDossier) : dossier.flagDossier != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDossier;
        result = 31 * result + (nomDossier != null ? nomDossier.hashCode() : 0);
        result = 31 * result + (flagDossier != null ? flagDossier.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Type_Dossier", referencedColumnName = "Id_Type_Dossier", nullable = false)
    public TypeDossier getTypeDossierByIdTypeDossier() {
        return typeDossierByIdTypeDossier;
    }

    public void setTypeDossierByIdTypeDossier(TypeDossier typeDossierByIdTypeDossier) {
        this.typeDossierByIdTypeDossier = typeDossierByIdTypeDossier;
    }

    @OneToMany(mappedBy = "dossierByIdDossier")
    public Collection<TypeDeDocument> getTypeDeDocumentsByIdDossier() {
        return typeDeDocumentsByIdDossier;
    }

    public void setTypeDeDocumentsByIdDossier(Collection<TypeDeDocument> typeDeDocumentsByIdDossier) {
        this.typeDeDocumentsByIdDossier = typeDeDocumentsByIdDossier;
    }
}
