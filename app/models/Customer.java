package models;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Customer extends Model {
	
	@Id
	public int id;
	
	
	public String username;
	
	public String email;
	
	public String password;
	
	
	public Customer(String username, String email, String password){
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	static Finder<Integer, Customer> find = new Finder<Integer,Customer>(
			Integer.class, Customer.class);
	
	public static void create(Customer c){
		c.save();
	}
	
	public static void create(String username,String email, String password){
		new Customer(username, email, password).save();
	}
	
	public static List<Customer> all(String username){
		return find.where().eq("username", username).findList();
	}
	
	public static void delete(int id){
		find.byId(id).delete();
	}

}
