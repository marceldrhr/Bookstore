package de.hnu.bookstore;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("service")
public class BookstoreApplication extends Application {
	
	 public BookstoreApplication() {
		 super();
	 }
	 
}
