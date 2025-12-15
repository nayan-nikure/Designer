package Divine.Designer.Den.Serives;

import Divine.Designer.Den.Entity.Customer;
import Divine.Designer.Den.Entity.DTO.CustomerDto.CustomerRequest;
import Divine.Designer.Den.Entity.DTO.CustomerDto.CustomerResponse;
import Divine.Designer.Den.Repository.CustomerRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSerives {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setMobile(customerRequest.getMobile());

        customer = customerRepository.save(customer);

        return convertToResponse(customer);
    }

    private CustomerResponse convertToResponse(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setMobile(customer.getMobile());
        return response;
    }

    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream().map(this::convertToResponse).toList();
    }

    public CustomerResponse getByIdCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer Not Found With Id: " + id));
        return convertToResponse(customer);
    }

    public CustomerResponse updateCustomer(Long id, CustomerRequest request) {
            Customer customer = customerRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Customer Not Found With Id: " + id));

            customer.setName(request.getName());
            customer.setMobile(request.getMobile());

            customer = customerRepository.save(customer);

            return convertToResponse(customer);
        }
    }





