package ma.nestideas.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.nestideas.invoicemanagement.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
