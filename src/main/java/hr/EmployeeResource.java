package hr;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employees")
public class EmployeeResource {

    @Inject
    private EmployeeRepository repository;

    @GET
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @POST
    public Employee post(Employee employee) {
        return repository.save(employee);
    }

}