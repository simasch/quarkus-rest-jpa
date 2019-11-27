package hr;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
public class EmployeeResource {

    @GET
    public List<Employee> getAll() {
        return Employee.listAll();
    }

    @POST
    @Transactional
    public Employee post(Employee employee) {
        employee.persistAndFlush();
        return employee;
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response put(@PathParam("id") Long id, Employee employee) {
        Employee employeeFromDatabase = Employee.findById(id);
        if (employeeFromDatabase == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            employeeFromDatabase.setName(employee.getName());
            return Response.noContent().build();
        }
    }

}