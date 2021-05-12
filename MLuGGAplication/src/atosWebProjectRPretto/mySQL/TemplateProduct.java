package atosWebProjectRPretto.mySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;

import org.primefaces.PrimeFaces;

import atosWebProjectRPretto.bean.ProductBean;



public class TemplateProduct {
	
	/*
    MySQLR mysqlr;
	private List<ProductBean> toReturnProducts2;
   
    public TemplateProduct() {
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
    
    
    public void insertProduct(ProductBean product) {
        String query = "INSERT INTO product (product, func, state, location, perioddays, periodhours, costperhour, costperday, client) "
                + "values ('"+product.getProduct()+"', '"+product.getState()+"', '"+product.getCostperhour()+"', '"+product.getCostperday()+"')";
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", " Dados Inseridos com Sucesso!");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Message", " Erro ao Inserir Dados!");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            System.out.println("Erro ao inserir dados!");
        }
    }
    
    public ProductBean consultProduct(int ID){
        ResultSet rs = mysqlr.executeQuery("SELECT * FROM product WHERE id=" + ID);
        ProductBean full = new ProductBean();
        if (rs != null) {
            try {
                while (rs.next()) {
                	full.setProduct(rs.getString("product"));
                	full.setState(rs.getString("state"));
                	full.setCostperday(Float.parseFloat(rs.getString("costperday")));
                	full.setCostperhour(Float.parseFloat(rs.getString("costperhour")));
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
		return full;
    }
    
    public void alterate(ProductBean product, int ID){
        int status;
        String query = "UPDATE product SET product='" +product.getProduct()+ "', "
                    + "', state='" +product.getState()+ "', "
                    + "', costperday='" +product.getCostperday()+ "', "
                    + "costperhour='" +product.getCostperhour()+ "', client='"      
                    + "WHERE id=" + ID;
        status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados alterados com sucesso!");
        } else {
            System.out.println("Erro ao alterar dados!");
        }
    }
    
    public String exclude(int ID){ 
        String query = "DELETE FROM product WHERE id=" + ID +";";
        int status = mysqlr.executeUpdate(query);
        System.out.println(query);
        System.out.println(status);
        if (status == 1) {
            System.out.println("Dados excluídos com sucesso!");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", " Dados Excluídos com Sucesso!");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "Products";
        } else {
            System.out.println("Erro ao excluir dados!");
            return null;
        }  
    } 
    
    public int getSize() {
    	int size = 0;
        ResultSet rs = mysqlr.executeQuery("SELECT * FROM product");
        if (rs != null) {
            try {
                while (rs.next()) {
                	size = size + 1;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }    			
        }
		return size;
    }
    
    public List<ProductBean> consultAllProducts(){
    	List<ProductBean>toReturnProducts2 = new ArrayList<ProductBean>();
        ResultSet rs = mysqlr.executeQuery("SELECT * FROM product");
        if (rs != null) {
            try {	
                while (rs.next()) {
                	ProductBean product = new ProductBean();
                	product.setId(Integer.parseInt(rs.getString(1)));
                	product.setProduct(rs.getString("product"));
                	product.setState(rs.getString("state"));
                	product.setCostperday(Float.parseFloat(rs.getString("costperday")));
                	product.setCostperhour(Float.parseFloat(rs.getString("costperhour")));
                	System.out.println(product.getId());
                	toReturnProducts2.add(product);
                }  
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
		return toReturnProducts2;
    }
    */
}
    
	

