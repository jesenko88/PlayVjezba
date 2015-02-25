package controllers;

import models.*;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	static String message = "Welcome to bitCoupon";
	
	
	static Form<PublicUser> input = new Form<PublicUser>(PublicUser.class);
	
	static Form<Customer> newCustomer = new Form<Customer>(Customer.class);

    public static Result index() {
    	String name = session("name");
    	if (name == null){
    		name = "Public user";	
    		return ok(index.render(message, name, input));
    	}else{
    		return redirect("/");
    	}
    }
    
    public static Result recognize(){
    	String username = newCustomer.bindFromRequest().get().username;
    	String mail = newCustomer.bindFromRequest().get().email;
    	String password = newCustomer.bindFromRequest().get().password;
    	session("name", username);
//    	return ok(index.render(message, name, input));
    	Customer.create(username, mail, password);
    	return redirect("/customers");
    }
    
    public static Result customer(){
    	String name = session("name");
    	if (name == null){
    		return redirect("/");
    	}
    	return ok(logged.render(
    		//	newCustomer
    			name
    			));  //Customer.all(name))
    }
    
    public static Result register(){
    	String username = newCustomer.bindFromRequest().get().username;
    	String email = newCustomer.bindFromRequest().get().email;
    	String password = newCustomer.bindFromRequest().get().password;
    	session("name", username);
    	Customer.create(username, email, password);
    	return redirect("/customers");
    }

    

}
