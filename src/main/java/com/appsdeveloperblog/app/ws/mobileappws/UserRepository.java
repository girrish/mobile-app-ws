package com.appsdeveloperblog.app.ws.mobileappws;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appsdeveloperblog.app.ws.mobileappws.io.entity.UserEntity;
import java.lang.String;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	public List<UserEntity> findByUserId(String userid);
}
