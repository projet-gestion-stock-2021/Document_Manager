package entity;

import java.util.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Document {

	private int idDocument;
	private String nomDocument;
	private StringProperty nomDocument1;
    private FileTime dateDocument;
    private LocalDate dateScan;
    private Boolean flagDocument;
    private Path docPath;
    
    public Document(Path filePath)
    {
    	this.idDocument = 0;
    	this.nomDocument = filePath.getFileName().toString();
    	this.setNomDocument1(new SimpleStringProperty((String) filePath.getFileName().toString())) ;
    	try 
    	{
			this.dateDocument = Files.getLastModifiedTime(filePath);
		} 
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	this.dateScan = LocalDate.now();
    	
    	this.flagDocument = false;
    	
    	this.setDocPath(filePath.toAbsolutePath());
    }


    public Document(int idDocument, String nomDocument, FileTime dateDocument, LocalDate dateScan, Boolean flagDocument) {
		super();
		this.idDocument = idDocument;
		this.nomDocument = nomDocument;
		this.dateDocument = dateDocument;
		this.dateScan = dateScan;
		this.flagDocument = flagDocument;
	}
    
    //transforme le string en une StringProperty pour pouvoir l'afficher dans la tableview
    public StringProperty documentNameProperty() { 
        if (nomDocument1 == null) nomDocument1 = new SimpleStringProperty(this, "nomDocument");
        return nomDocument1; 
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


    public FileTime getDateDocument() 
    {
 	    
        return dateDocument;
    }
    
    public String simpleDateFormat() 
    {
    	String pattern = "yyyy-MM-dd HH:mm:ss";
 	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
 	    
		return simpleDateFormat.format( getDateDocument() );
    }

    public void setDateDocument(FileTime dateDocument) {
        this.dateDocument = dateDocument;
    }


    public LocalDate getDateScan() {
        return dateScan;
    }

    public void setDateScan(LocalDate dateScan) {
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

        if ((idDocument != document.idDocument) || (nomDocument != null ? !nomDocument.equals(document.nomDocument) : document.nomDocument != null) || (dateDocument != null ? !dateDocument.equals(document.dateDocument) : document.dateDocument != null)
				|| (dateScan != null ? !dateScan.equals(document.dateScan) : document.dateScan != null)) return false;
        if (flagDocument != null ? !flagDocument.equals(document.flagDocument) : document.flagDocument != null)
            return false;

        return true;
    }

    public String toString()
    {
		return this.getNomDocument() +"\t" + this.getDateScan() +"\t"+ new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").format(Date.from(this.getDateDocument().toInstant())) 
 +"\t"+ this.getDocPath().toString();
    	
    }


	public StringProperty getNomDocument1() {
		return nomDocument1;
	}


	public void setNomDocument1(StringProperty nomDocument1) {
		this.nomDocument1 = nomDocument1;
	}


	public Path getDocPath() {
		return docPath;
	}


	public void setDocPath(Path docPath) {
		this.docPath = docPath;
	}
    


}
