package eCommerce.JDBCControl;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import eCommerce.models.Client;
import eCommerce.models.Product;


public class MockJDBCController {
		Connection connection = null;
		//used to open and close connections in the methods
		public Statement openConnection() throws ClassNotFoundException, SQLException{
			return null;			
		}
		public void closeConnection() throws SQLException{
			
		}
		public void addUser(Client user){
			
		}
		public Client checkUserName(Client user){
			Client client = new Client("admin", "admin");
			return client;	
		}
		public void addProduct(Product product){
			
		}
		public Product getProduct(String productID){

			return new Product(1, "asdsd", "asdasd", "asdasd", 12);
			
		}
		public ArrayList<Product> getAllProducts(){
			ArrayList<Product> products = new ArrayList<>();
			products.add(new Product(1, "asdsd", "asdasd", "asdasd", 12));
			return products;
			
		}
		private MessageDigest md;

		   public  String cryptWithMD5(String pass){
		    try {
		        md = MessageDigest.getInstance("MD5");
		        byte[] passBytes = pass.getBytes();
		        md.reset();
		        byte[] digested = md.digest(passBytes);
		        StringBuffer sb = new StringBuffer();
		        for(int i=0;i<digested.length;i++){
		            sb.append(Integer.toHexString(0xff & digested[i]));
		        }
		        return sb.toString();
		    } catch (NoSuchAlgorithmException ex) {
		    	
		    }
		        return null;


		   }
	}
