package Divine.Designer.Den.Controllar;

import Divine.Designer.Den.Entity.DTO.GarmentTypeDto.GarmentTypeRequest;
import Divine.Designer.Den.Entity.DTO.GarmentTypeDto.GarmentTypeResponse;
import Divine.Designer.Den.Serives.GarmentTypeSerives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garmenttype")
public class GarmentTypeControllar {

    @Autowired
    private GarmentTypeSerives garmentTypeSerives;

    @PostMapping("/add")
    public ResponseEntity<GarmentTypeResponse> add(@RequestBody GarmentTypeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(garmentTypeSerives.addGarmentType(request));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<GarmentTypeResponse>>getall(){
        return ResponseEntity.ok(garmentTypeSerives.getAllGarmentTypes());
    }

    @GetMapping("/getById{id}")
    public ResponseEntity<GarmentTypeResponse>getById(@PathVariable Long id){
        return ResponseEntity.ok(garmentTypeSerives.getGarmentTypeById(id));
    }

    @PutMapping("/update{id}")
    public ResponseEntity<GarmentTypeResponse>updateId(@PathVariable Long id,@RequestBody GarmentTypeRequest garmentTypeRequest){
        return ResponseEntity.ok(garmentTypeSerives.updateGarmentType(id,garmentTypeRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        garmentTypeSerives.deleteGarmentType(id);
        return ResponseEntity.ok("Garment Type Deleted Successfully");
    }
}
