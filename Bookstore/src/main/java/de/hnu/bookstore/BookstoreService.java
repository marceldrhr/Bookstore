package de.hnu.bookstore;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Stateless
@LocalBean
@Path("book")
public class BookstoreService {
    
	@PersistenceContext(unitName="BookDB")
    private EntityManager em;
	
    @GET
    @Path("{bookId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@PathParam("bookId") long bookId) {
    	return em.find(Book.class, bookId);
    }

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book createBook(String json) {
    	Jsonb jsonb = JsonbBuilder.create();
    	Book b = jsonb.fromJson(json, Book.class);
    	em.persist(b);
    	return b;
    }
}
