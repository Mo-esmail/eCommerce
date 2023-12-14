package eCommerce.models;

public class Product {
	String name,description,imgsrc;
	int price,ID;
	public Product(){}
	//used to get products(full info)
	public Product(int productID,String productname,String productDescription,String productImdsrc,int productprice){
		name=productname;
		description=productDescription;
		imgsrc=productImdsrc;
		price=productprice;
		ID=productID;
	}
	//used to insert products(without id)
	public Product(String productname,String productDescription,String productImdsrc,int productprice){
		name=productname;
		description=productDescription;
		imgsrc=productImdsrc;
		price=productprice;
	}
	public void setName(String productname){
		name=productname;
	}
	public String getName(){
		return name;
	}
	public void setdescription(String productdescription){
		description=productdescription;
	}
	public String getDescription(){
		return description;
	}
	public void setImgSrc(String productImdsrc){
		imgsrc=productImdsrc;
	}
	public String getImgSrc(){
		return imgsrc;
	}
	public void setPrice(int productPrice){
		price=productPrice;
	}
	public int getPrice(){
		return price;
	}
	public int getID(){
		return ID;
	}
}
