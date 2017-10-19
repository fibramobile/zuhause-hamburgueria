package br.com.brunobrasilweb.springadm.service;

import br.com.brunobrasilweb.springadm.model.Customers;
import br.com.brunobrasilweb.springadm.repository.CustomersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomersService extends AbstractService<Customers, Long> {

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    protected JpaRepository<Customers, Long> getRepository() {
        return customersRepository;
    }
    /**
     * Realiza a busca de um cliente via telefone.
     * 
     * @param query
     * @return Uma lista contendo o telefone.
     */
    public List<Customers> findCustomerByPhone(String query) {
        return customersRepository.findByPhoneContainingIgnoreCase(query);
    }

}
