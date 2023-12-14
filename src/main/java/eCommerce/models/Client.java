package eCommerce.models;

public class Client {
	private int id,age;
	private String name,password,FirstName,LastName,Grade,Email;
	public Client(){
		
	}
	public Client(String clientName,String clientPassword){
		name=clientName;
		password=clientPassword;
	}
	public Client(String clientName,String clientPassword,int clientAge,String clientFirstName,String clientLastName,String clientGrade,String clientEmail){
		name=clientName;
		password=clientPassword;
		age=clientAge;
		setFirstName(clientFirstName);
		setLastName(clientLastName);
		setGrade(clientGrade);
		setEmail(clientEmail);
	}
	public void setId(int clientId){
		id=clientId;
	}
	public int getId() {
		return id;
	}
	public void setName(String clientName){
		name=clientName;
	}
	public void setPassword(String clientpassword){
		password=clientpassword;
	}
	public void setAge(int clientAge){
		age=clientAge;
	}
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	public int getAge(){
		return age;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
