package atosWebProjectRPretto.mySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.apache.el.parser.AstString;
import org.primefaces.PrimeFaces;

import atosWebProjectRPretto.bean.PersonBean;
import atosWebProjectRPretto.bean.ProductBean;


public class TemplateUser {
	/*
    MySQLR mysqlr;
    
    public TemplateUser() {
        mysqlr = new MySQLR();
    }
    
    
    public void connect() throws ClassNotFoundException{
        boolean connected = mysqlr.connect("localhost", "3306", "mlugg", "root", "1234");
        if (connected) {
            System.out.println("Base de dados conectada.");
        } else {
            System.out.println("Base de dados não conectada.");
        }
    }
    
    
    public void insertUser(PersonBean user) {
        String query = "INSERT INTO users (username, pass, email) "
                + "values ('"+user.getUsername()+"', '"+user.getPass()+"', '"+user.getEmail()+"')";
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", " Usuário Cadastrado com Sucesso!");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }
    
    public List<PersonBean> consultAllUsers(){
        ResultSet rs = mysqlr.executeQuery("SELECT * FROM users");
        List<PersonBean>toReturnPessoas = new ArrayList<PersonBean>();
        if (rs != null) {
            try {
                while (rs.next()) {
                	PersonBean pessoa = new PersonBean();
                	pessoa.setId(Integer.parseInt(rs.getString(1)));
                    pessoa.setUsername(rs.getString("username"));
                    pessoa.setEmail(rs.getString("email"));
                    toReturnPessoas.add(pessoa);
                    System.out.println();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
		return toReturnPessoas;
    }
    
    public void alterUser(PersonBean user, int ID){
        int status;
        String query = "UPDATE users SET username='" + user.getUsername() + "', "
                    + "email='" + user.getEmail() + "', pass='" + user.getPass() + "'  "
                    + "WHERE id=" + ID;
        status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados alterados com sucesso!");
        } else {
            System.out.println("Erro ao alterar dados!");
        }
    }
    
    public void excludeUser(int ID){ 
        String query = "DELETE FROM users WHERE id=" + ID;
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados excluídos com sucesso!");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "Usuário Excluído com Sucesso!");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        } else {
            System.out.println("Erro ao excluir dados!");
        }  
    } 
    
    public String consultPassbyName(String username){
        ResultSet rs = mysqlr.executeQuery("SELECT pass FROM users WHERE username='"+username+"'");
        String pass = null;
        try {
            while (rs.next()) {
                pass = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
		return pass;
    }
    */
}