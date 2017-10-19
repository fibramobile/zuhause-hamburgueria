package br.com.brunobrasilweb.springadm.repository;

import br.com.brunobrasilweb.springadm.model.Customers;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
    
    List<Customers> findByPhoneContainingIgnoreCase(String phone);

}
