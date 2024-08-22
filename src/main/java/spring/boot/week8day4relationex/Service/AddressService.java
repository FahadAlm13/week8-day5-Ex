package spring.boot.week8day4relationex.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.week8day4relationex.API.ApiException;
import spring.boot.week8day4relationex.DTO.AddressDTO;
import spring.boot.week8day4relationex.Model.Address;
import spring.boot.week8day4relationex.Model.Teacher;
import spring.boot.week8day4relationex.Repository.AddressRepository;
import spring.boot.week8day4relationex.Repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        Address address = new Address(null, addressDTO.getStreet(), addressDTO.getArea(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null) {
            throw new ApiException("Address not found");
        }
        address.setStreet(addressDTO.getStreet());
        address.setArea(addressDTO.getArea());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(address);
    }
}
