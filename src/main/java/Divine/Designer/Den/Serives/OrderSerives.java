package Divine.Designer.Den.Serives;

import Divine.Designer.Den.Entity.Customer;
import Divine.Designer.Den.Entity.DTO.OrderDto.OrderRequest;
import Divine.Designer.Den.Entity.DTO.OrderDto.OrderResponse;
import Divine.Designer.Den.Entity.GarmentType;
import Divine.Designer.Den.Entity.OrderEntity;
import Divine.Designer.Den.Repository.CustomerRepository;
import Divine.Designer.Den.Repository.GarmentTypeRepository;
import Divine.Designer.Den.Repository.OrderRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderSerives {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private GarmentTypeRepository garmentTypeRepository;


    //  public @Nullable OrderResponse createOrder(OrderRequest request) {
    public OrderResponse createOrder(OrderRequest request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        GarmentType type = garmentTypeRepository.findById(request.getGarmentTypeId())
                .orElseThrow(() -> new RuntimeException("Garment Type Not Found"));

        OrderEntity order = new OrderEntity();
        order.setOrderNo(request.getOrderNo());
        order.setOrderDate(request.getOrderDate());
        order.setTotalAmount(request.getTotalAmount());
        order.setCustomer(customer);
        order.setGarmentType(type);

        OrderEntity saved = orderRepository.save(order);

        OrderResponse response = new OrderResponse();
        response.setId(saved.getId());
        response.setOrderNo(saved.getOrderNo());
        response.setOrderDate(saved.getOrderDate());
        response.setTotalAmount(saved.getTotalAmount());
        response.setCustomerName(customer.getName());
        response.setMobile(customer.getMobile());
        response.setGarmentName(type.getGarmentName());

        return response;
    }

    public List<OrderResponse> getAllOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        List<OrderResponse> responses = new ArrayList<>();

        for (OrderEntity order : orderEntities) {
            responses.add(convertToResponse(order));
        }
        return responses;
    }

    private OrderResponse convertToResponse(OrderEntity order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setGarmentName(order.getGarmentName());
        response.setOrderNo(order.getOrderNo());
        response.setOrderDate(order.getOrderDate());
        response.setTotalAmount(order.getTotalAmount());
        response.setMobile(order.getMobile());
        response.setGarmentName(order.getGarmentName());

        // agar customer bhi chahiye ho
        if (order.getCustomer() != null) {
            response.setId(order.getCustomer().getId());
            response.setCustomerName(order.getCustomer().getName());
            response.setMobile(order.getMobile());
            response.setGarmentName(order.getGarmentName());
        }

        return response;
    }

    public  OrderResponse getById(Long id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return convertToResponse(order);
    }


    public  OrderResponse updateOrder(Long id, OrderRequest orderRequest) {
        OrderEntity order = orderRepository.findById(id)  .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));


        order.setId(order.getId());
        order.setOrderNo(orderRequest.getOrderNo());
        order.setOrderDate(orderRequest.getOrderDate());
        order.setTotalAmount(orderRequest.getTotalAmount());


        if (orderRequest.getCustomerId() != null) {
            Customer customer = customerRepository.findById(orderRequest.getCustomerId())
                    .orElseThrow(() -> new RuntimeException( "Customer not found with id: " + orderRequest.getCustomerId()));
            order.setCustomer(customer);
        }


        if (orderRequest.getGarmentTypeId() != null) {
            GarmentType garmentType = garmentTypeRepository.findById(orderRequest.getGarmentTypeId())
                    .orElseThrow(() -> new RuntimeException(
                            "Garment not found with id: " + orderRequest.getGarmentTypeId()));
            order.setGarmentType(garmentType);
        }

        OrderEntity updatedOrder = orderRepository.save(order);
        return convertToResponse(updatedOrder);
    }

    }





