package Divine.Designer.Den.Controllar;

import Divine.Designer.Den.Entity.Customer;
import Divine.Designer.Den.Entity.DTO.CustomerDto.CustomerRequest;
import Divine.Designer.Den.Entity.DTO.CustomerDto.CustomerResponse;
import Divine.Designer.Den.Entity.DTO.OrderDto.OrderRequest;
import Divine.Designer.Den.Entity.DTO.OrderDto.OrderResponse;
import Divine.Designer.Den.Serives.CustomerSerives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerControllar {
    @Autowired
    private CustomerSerives customerSerives;

    @PostMapping("/add")
    public ResponseEntity<CustomerResponse> add(@RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerSerives.addCustomer(customerRequest));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return ResponseEntity.ok(customerSerives.getAllCustomers());
    }

    @GetMapping("getby/{id}")
    public ResponseEntity<CustomerResponse> getByIdCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerSerives.getByIdCustomer(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest request) {
        return ResponseEntity.ok(customerSerives.updateCustomer(id, request));
    }

}
