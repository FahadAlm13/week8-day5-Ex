package spring.boot.week8day4relationex.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.week8day4relationex.DTO.AddressDTO;
import spring.boot.week8day4relationex.Service.AddressService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddresses() {
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body("Address successfully added");
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body("Address successfully updated");
    }
}
