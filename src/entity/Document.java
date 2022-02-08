package entity;

import java.util.*;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;

public class Document {

	private int idDocument;
	private String nomDocument;
	private StringProperty nomDocument1;
    private FileTime dateDocument;
    private StringProperty p_dateDocument;
    private LocalDate dateScan;
    private StringProperty p_dateScan;
    private Boolean flagDocument;
    private Path docPath;
    private String pathScan;
    private int id_user;
    private SimpleIntegerProperty p_id_user;
    
    public SimpleIntegerProperty getP_id_user() {
		return p_id_user;
	}

	public void setP_id_user(SimpleIntegerProperty p_id_user) {
		this.p_id_user = p_id_user;
	}

	public SimpleIntegerProperty level() { 
        if (p_id_user == null) p_id_user = new SimpleIntegerProperty(this, "id_user");
        return p_id_user; 
    }
    
    public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


	public String getPathScan() {
		return pathScan;
	}


	public void setPathScan(String pathScan) {
		this.pathScan = pathScan;
	}


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


    public Document(int idDocument, String nomDocument, FileTime dateDocument, LocalDate dateScan, Boolean flagDocument)
    {
		super();
		this.idDocument = idDocument;
		this.nomDocument = nomDocument;
		this.dateDocument = dateDocument;
		this.dateScan = dateScan;
		this.flagDocument = flagDocument;
	}
    
    public Document(ResultSet resultatRequete) 
    {
    	try 
    	{
    		this.setIdDocument(resultatRequete.getInt("Id_Document"));
    		
    		this.setNomDocument1(new SimpleStringProperty(resultatRequete.getString("Nom_Document")));
    		this.setNomDocument(resultatRequete.getString("Nom_Document"));
    		
    		this.setDateDocument(resultatRequete.getDate("DateDocument")); 
    		this.p_dateDocument = new SimpleStringProperty(resultatRequete.getDate("DateDocument").toString());
    		
    		this.setDateScan(resultatRequete.getTimestamp("DateScan"));
    		this.p_dateScan = new SimpleStringProperty(resultatRequete.getTimestamp("DateScan").toString());
    		
    		this.setFlagDocument(resultatRequete.getBoolean("Flag_document"));
    		this.setPathScan(resultatRequete.getString("pathScan"));
    		
    		this.setId_user(resultatRequete.getInt("Id_Utilisateur"));
    		this.p_id_user = new SimpleIntegerProperty(resultatRequete.getInt("Id_Utilisateur"));
    		
    		System.out.println(getNomDocument());
    	} 
    	catch (SQLException e) 
    	{
    		System.out.println("\nProbleme Document(ResultSet rst)\n");
    		e.printStackTrace();
    	}
    	//System.out.println(this.toString());
    }


	//transforme le string en une StringProperty pour pouvoir l'afficher dans la tableview
    public StringProperty documentNameProperty() { 
        if (nomDocument1 == null) nomDocument1 = new SimpleStringProperty(this, "nomDocument");
        return nomDocument1; 
    }
    
    public StringProperty documentDateScanProperty() { 
        if (p_dateScan == null) p_dateScan = new SimpleStringProperty(this, "dateScan");
        return p_dateScan; 
    }
    
    public StringProperty documentDateModifiedProperty() { 
        if (p_dateDocument == null) p_dateDocument = new SimpleStringProperty(this, "dateDocument");
        return p_dateDocument; 
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

    public void setDateDocument(FileTime dateDocument) 
    {
        this.dateDocument = dateDocument;
    }
    
    //Overload
    public void setDateDocument(Date dateDocument) 
    {
    	//OK dur de transformer un Date en Instant parce que la méthode n'est plus supportée
    	/*
    	 * 
    	 */
        this.dateDocument = FileTime.from(new java.util.Date(dateDocument.getTime()).toInstant());
    }

    public LocalDate getDateScan() 
    {
        return dateScan;
    }

    public void setDateScan(LocalDate dateScan) 
    {
        this.dateScan = dateScan;
    }
    
    //overload
    public void setDateScan(Timestamp dateScan) 
    {
        this.dateScan = dateScan.toLocalDateTime().toLocalDate();
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
    	String str = this.getNomDocument() +"\t" + this.getDateScan() +"\t"+ new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").format(Date.from(this.getDateDocument().toInstant())) 
    			 +"\t";
    	
    	if(this.getDocPath()!= null) str+= this.getDocPath().toString();
    	
		return str;
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
