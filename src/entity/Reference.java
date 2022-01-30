package entity;

import javax.persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Entity
public class Reference implements Comparable<Reference>
{
    private int idReference;
    private String nomReference;
    private Collection<Typer> typersByIdReference;

    public Reference(ResultSet rst) 
    {
    	try 
    	{
			this.setIdReference(rst.getInt("Id_Reference"));
			this.setNomReference(rst.getString("Nom_Reference"));

		} 
    	catch (SQLException e) 
    	{
			System.out.println("\nProbleme Reference(ResultSet rst)\n");
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

    /*
     * to display the Tags object name in the comboBox
     */
    @Override
    public String toString() 
    {
		return this.getNomReference();
    	
    }
    
	@Id
    @Column(name = "Id_Reference")
    public int getIdReference() {
        return idReference;
    }

    public void setIdReference(int idReference) {
        this.idReference = idReference;
    }

    @Basic
    @Column(name = "Nom_Reference")
    public String getNomReference() {
        return nomReference;
    }

    public void setNomReference(String nomReference) {
        this.nomReference = nomReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reference reference = (Reference) o;

        if (idReference != reference.idReference) return false;
        if (nomReference != null ? !nomReference.equals(reference.nomReference) : reference.nomReference != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReference;
        result = 31 * result + (nomReference != null ? nomReference.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "referenceByIdReference")
    public Collection<Typer> getTypersByIdReference() {
        return typersByIdReference;
    }

    public void setTypersByIdReference(Collection<Typer> typersByIdReference) {
        this.typersByIdReference = typersByIdReference;
    }

    //sinon Caused by: java.lang.ClassCastException: class entity.Reference cannot be cast to class java.lang.Comparable
	@Override
	public int compareTo(Reference tag) 
	{
		// we sort objects on the basis of Student Name using compareTo of String Class
		return this.getNomReference().compareTo(tag.getNomReference());
	}
}
