package web.jaxrs;

import fizzbuzz.FizzBuzzer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/fizzbuzz")
public class FizzBuzzService {
    private final FizzBuzzer fizzBuzzer;

    public FizzBuzzService() {
        fizzBuzzer = new FizzBuzzer();
    }

    @GET
    @Path("/one")
    public String string(){
        return fizzBuzzer.fizzBuzzer(15);
    }
    @GET
    @Path("/{number}")
    public String getFizzOrBuzz(@PathParam("number") int number){
        return fizzBuzzer.fizzBuzzer(number);
    }
}
