package spring.boot.week8day4relationex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.week8day4relationex.Model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressById(Integer id);
}
