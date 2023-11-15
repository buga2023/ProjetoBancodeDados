package model;

public class JavaBeans {
   private String idcon;
   private String  fone;
   private String email;
   private String nome;
   
   
public String getIdcon() {
	return idcon;
}
public void setIdcon(String idcon) {
	this.idcon = idcon;
}
public String getFone() {
	return fone;
}
public void setFone(String fone) {
	this.fone = fone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public JavaBeans() {
	super();
	
}
public JavaBeans(String idcon, String fone, String email, String nome) {
	super();
	this.idcon = idcon;
	this.fone = fone;
	this.email = email;
	this.nome = nome;
}
   
}
