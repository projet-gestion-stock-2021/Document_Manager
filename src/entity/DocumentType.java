package entity;

import java.sql.Date;
import java.util.Objects;

public class DocumentType {
	private int idDocumentTem;
	private String NomDocumentTem;
	private Date dateDocumentTem;
	public int getIdDocumentTem() {
		return idDocumentTem;
	}
	public void setIdDocumentTem(int idDocumentTem) {
		this.idDocumentTem = idDocumentTem;
	}
	public String getNomDocumentTem() {
		return NomDocumentTem;
	}
	public void setNomDocumentTem(String nomDocumentTem) {
		NomDocumentTem = nomDocumentTem;
	}
	public Date getDateDocumentTem() {
		return dateDocumentTem;
	}
	public void setDateDocumentTem(Date dateDocumentTem) {
		this.dateDocumentTem = dateDocumentTem;
	}
	@Override
	public int hashCode() {
		return Objects.hash(NomDocumentTem, dateDocumentTem, idDocumentTem);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentType other = (DocumentType) obj;
		return Objects.equals(NomDocumentTem, other.NomDocumentTem)
				&& Objects.equals(dateDocumentTem, other.dateDocumentTem) && idDocumentTem == other.idDocumentTem;
	}
	@Override
	public String toString() {
		return "Parametre [idDocumentTem=" + idDocumentTem + ", NomDocumentTem=" + NomDocumentTem + ", dateDocumentTem="
				+ dateDocumentTem + "]";
	}
	public DocumentType(int idDocumentTem, String nomDocumentTem, Date dateDocumentTem) {
		super();
		this.idDocumentTem = idDocumentTem;
		NomDocumentTem = nomDocumentTem;
		this.dateDocumentTem = dateDocumentTem;
	}

}
