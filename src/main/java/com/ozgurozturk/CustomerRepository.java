package com.ozgurozturk;

        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

/**
 * Created by Ozgur on 6.06.2017.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findCustomerByUserNameAndPassword(String userName, String password);

    boolean findCustomerByUserName(String userName);

    void deleteCustomerByUserName(String userName);

    @Query("Select e from Customer e where e.name =:param1 or e.surname  like ':param2%'")
    List<Customer> test(int param1, String param2);
}

