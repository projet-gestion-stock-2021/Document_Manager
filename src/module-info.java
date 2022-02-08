module Document_Manager {

	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	requires java.desktop;
	requires dom4j;
	requires java.persistence;
	requires java.xml;
	requires jdk.compiler;
	requires jdk.javadoc;
	requires org.hibernate.orm.core;
	requires org.hibernate.orm.jpamodelgen;
	requires jdk.jpackage;
	requires java.base;
	requires org.controlsfx.controls;
	opens application to javafx.graphics, javafx.fxml;
}
