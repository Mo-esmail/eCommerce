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


public class JDBCControler {
		Connection connection = null;
		//used to open and close connections in the methods
		public Statement openConnection() throws ClassNotFoundException, SQLException{
			// the mysql driver string
			Class.forName("com.mysql.jdbc.Driver");
			
			// the mysql url
			String url = "";
			
			// get the mysql database connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/souq", "root", "root");
			
			// now do whatever you want to do with the connection
			
			// ...
			Statement stmt = connection.createStatement();

			return stmt;
			
		}
		public void closeConnection() throws SQLException{
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			
		}
		public void addUser(Client user){
			
			try {
				Statement stmt =openConnection();
				String cryptpassword=cryptWithMD5(user.getPassword());
				stmt.executeUpdate("INSERT INTO souq.clients (Name, Password, FirstName, "
						+ "LastName,Age,Grade,Email) VALUES(\""+user.getName()+"\",\""+cryptpassword+"\",\""+user.getFirstName()+
						"\",\""+user.getLastName()+"\","+user.getAge()+",\""+user.getGrade()+"\",\""+user.getEmail()+"\")");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(1);
			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(2);
			} finally {
				try {
					
					closeConnection();
					
				} catch (Exception ex){
					
					ex.printStackTrace();
				}
			}	
		}
		public Client checkUserName(Client user){
			Client client = null;
			try {
				Statement stmt =openConnection();
				ResultSet result = stmt.executeQuery("SELECT * FROM souq.Clients");
				while (result.next()) {
					if(user.getName().equals(result.getString(2)))
						client= new Client(result.getString(2), result.getString(3));
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					
					closeConnection();
					
				} catch (Exception ex){
					
					ex.printStackTrace();
				}
			}
			return client;	
		}
		public void addProduct(Product product){
			
			try {
				Statement stmt =openConnection();
				stmt.executeUpdate("INSERT INTO souq.products (productname,productDescription,productImgsrc,productprice) VALUES(\""+product.getName()+"\",\""+product.getDescription()+"\",\""
				                                                                                                                    +product.getImgSrc()+"\","+product.getPrice()+")");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(1);
			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(2);
			} finally {
				try {
					
					closeConnection();
					
				} catch (Exception ex){
					
					ex.printStackTrace();
				}
			}	
		}
		public Product getProduct(String productID){
			Product product = null;
			try {
				Statement stmt =openConnection();
				ResultSet result = stmt.executeQuery("SELECT * FROM souq.products where productID="+productID);
				while (result.next()) {
					if(productID.equals(result.getString(1)))
						product= new Product(result.getInt(1),result.getString(2), result.getString(3),result.getString(4),result.getInt(5));
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					
					closeConnection();
					
				} catch (Exception ex){
					
					ex.printStackTrace();
				}
			}
			return product;
			
		}
		public ArrayList<Product> getAllProducts(){
			ArrayList<Product> products = new ArrayList<>();
			try {
				Statement stmt =openConnection();
				ResultSet result = stmt.executeQuery("SELECT * FROM souq.products");
				while (result.next()) {
						products.add(new Product(result.getInt(1),result.getString(2), result.getString(3),result.getString(4),result.getInt(5)));
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					
					closeConnection();
					
				} catch (Exception ex){
					
					ex.printStackTrace();
				}
			}
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
		   
		   
		   
		   
		   /*public void addperson(String name){
				
				try {
					Statement stmt =openConnection();
					stmt.executeUpdate("INSERT INTO souq.persons (name) VALUES(\""+name+"\")");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					System.exit(1);
				} catch (SQLException e) {
					e.printStackTrace();
					System.exit(2);
				} finally {
					try {
						
						closeConnection();
						
					} catch (Exception ex){
						
						ex.printStackTrace();
					}
				}	
			}*/
		   public static void main(String[] args) {
				JDBCControler controller = new JDBCControler();
				controller.getProduct("1");
			}
	}
