package entites;

import java.util.*;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Document {
	
	private int idDocument;
    private String nomDocument;
    private Date dateDocument;
    private Timestamp dateScan;
    private Boolean flagDocument;
    
    


    public Document(int idDocument, String nomDocument, Date dateDocument, Timestamp dateScan, Boolean flagDocument) {
		super();
		this.idDocument = idDocument;
		this.nomDocument = nomDocument;
		this.dateDocument = dateDocument;
		this.dateScan = dateScan;
		this.flagDocument = flagDocument;
	}

	public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    public String getNomDocument() {
        return nomDocument;
    }

    public void setNomDocument(String nomDocument) {
        this.nomDocument = nomDocument;
    }


    public Date getDateDocument() {
        return dateDocument;
    }

    public void setDateDocument(Date dateDocument) {
        this.dateDocument = dateDocument;
    }


    public Timestamp getDateScan() {
        return dateScan;
    }

    public void setDateScan(Timestamp dateScan) {
        this.dateScan = dateScan;
    }

    public Boolean getFlagDocument() {
        return flagDocument;
    }

    public void setFlagDocument(Boolean flagDocument) {
        this.flagDocument = flagDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (idDocument != document.idDocument) return false;
        if (nomDocument != null ? !nomDocument.equals(document.nomDocument) : document.nomDocument != null)
            return false;
        if (dateDocument != null ? !dateDocument.equals(document.dateDocument) : document.dateDocument != null)
            return false;
        if (dateScan != null ? !dateScan.equals(document.dateScan) : document.dateScan != null) return false;
        if (flagDocument != null ? !flagDocument.equals(document.flagDocument) : document.flagDocument != null)
            return false;

        return true;
    }



}
