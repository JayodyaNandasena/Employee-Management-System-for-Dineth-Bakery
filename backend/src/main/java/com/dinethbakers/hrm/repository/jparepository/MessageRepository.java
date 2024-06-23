package com.dinethbakers.hrm.repository.jparepository;

import com.dinethbakers.hrm.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageEntity,String> {
}
