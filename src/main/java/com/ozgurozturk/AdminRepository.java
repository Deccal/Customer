package com.ozgurozturk;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ozgur on 7.06.2017.
 */

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {

    Admin findAdminByAdminUserNameAndAdminPassword(String userName,String password);
}
