package entites;

import java.sql.Timestamp;

public class Document {

	private int idDocument;
    private String nomDocument;
    private Timestamp dateDocument;
    private Timestamp dateScan;
    private Byte flagDocument;


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


    public Timestamp getDateDocument() {
        return dateDocument;
    }

    public void setDateDocument(Timestamp dateDocument) {
        this.dateDocument = dateDocument;
    }


    public Timestamp getDateScan() {
        return dateScan;
    }

    public void setDateScan(Timestamp dateScan) {
        this.dateScan = dateScan;
    }

    public Byte getFlagDocument() {
        return flagDocument;
    }

    public void setFlagDocument(Byte flagDocument) {
        this.flagDocument = flagDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if ((idDocument != document.idDocument) || (nomDocument != null ? !nomDocument.equals(document.nomDocument) : document.nomDocument != null) || (dateDocument != null ? !dateDocument.equals(document.dateDocument) : document.dateDocument != null)
				|| (dateScan != null ? !dateScan.equals(document.dateScan) : document.dateScan != null)) return false;
        if (flagDocument != null ? !flagDocument.equals(document.flagDocument) : document.flagDocument != null)
            return false;

        return true;
    }




}
