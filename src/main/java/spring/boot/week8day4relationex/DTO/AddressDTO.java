package spring.boot.week8day4relationex.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;

    @NotEmpty(message = "Street shouldn't be null")
    private String street;

    @NotEmpty(message = "Area shouldn't be null")
    private String area;

    @NotNull(message = "Building Number shouldn't be null")
    private Integer buildingNumber;

}
