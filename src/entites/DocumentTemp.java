package entites;

import java.sql.Timestamp;

public class DocumentTemp {

	 private int idDocumentTemp;
	    private String nomDocumentTemp;
	    private Timestamp dateDocumentTemp;

	    public int getIdDocumentTemp() {
	        return idDocumentTemp;
	    }

	    public void setIdDocumentTemp(int idDocumentTemp) {
	        this.idDocumentTemp = idDocumentTemp;
	    }

	    public String getNomDocumentTemp() {
	        return nomDocumentTemp;
	    }

	    public void setNomDocumentTemp(String nomDocumentTemp) {
	        this.nomDocumentTemp = nomDocumentTemp;
	    }


	    public Timestamp getDateDocumentTemp() {
	        return dateDocumentTemp;
	    }

	    public void setDateDocumentTemp(Timestamp dateDocumentTemp) {
	        this.dateDocumentTemp = dateDocumentTemp;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        DocumentTemp that = (DocumentTemp) o;

	        if (idDocumentTemp != that.idDocumentTemp) return false;
	        if (nomDocumentTemp != null ? !nomDocumentTemp.equals(that.nomDocumentTemp) : that.nomDocumentTemp != null)
	            return false;
	        if (dateDocumentTemp != null ? !dateDocumentTemp.equals(that.dateDocumentTemp) : that.dateDocumentTemp != null)
	            return false;

	        return true;
	    }
}
