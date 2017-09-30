package br.com.brunobrasilweb.springadm.repository;

import br.com.brunobrasilweb.springadm.model.Order;
import br.com.brunobrasilweb.springadm.model.Status;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author João Bonin
 * @since 28/09/2017
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    List<Order> findByDateBetweenAndStatusOrderByDateAsc(Date startDate, Date finalDate, Status status);

    
}
