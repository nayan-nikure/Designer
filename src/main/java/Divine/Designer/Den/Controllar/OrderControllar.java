package Divine.Designer.Den.Controllar;

import Divine.Designer.Den.Entity.DTO.OrderDto.OrderRequest;
import Divine.Designer.Den.Entity.DTO.OrderDto.OrderResponse;
import Divine.Designer.Den.Serives.OrderSerives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderControllar {

    @Autowired
    private OrderSerives orderService;

    @PostMapping("/add{id}")
    public ResponseEntity<OrderResponse> addOrder(@RequestBody OrderRequest request){
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping("getAll")
    public  ResponseEntity<List<OrderResponse>>getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<OrderResponse>getById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderResponse> updateOrder( @PathVariable Long id,@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.updateOrder(id, orderRequest));
    }
    }


