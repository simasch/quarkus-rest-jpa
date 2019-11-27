package hr;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class EmployeeRepository {

    @Inject
    EntityManager em;

    public List<Employee> findAll() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    @Transactional
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            em.persist(employee);
            return employee;
        } else {
            return em.merge(employee);
        }
    }
}
