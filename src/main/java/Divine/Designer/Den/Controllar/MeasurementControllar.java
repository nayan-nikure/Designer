package Divine.Designer.Den.Controllar;

import Divine.Designer.Den.Entity.DTO.MeasurmentDto.MeasurmentRequest;
import Divine.Designer.Den.Serives.MeasurementSerives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/measurement")
public class MeasurementControllar {

    @Autowired
     private MeasurementSerives measurementSerives;

    @PostMapping("/add")
    public ResponseEntity<MeasurmentRequest.MeasurementResponse> add(@RequestBody MeasurmentRequest measurementRequest) {
        MeasurmentRequest.MeasurementResponse response = measurementSerives.addMeasurement(measurementRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<MeasurmentRequest.MeasurementResponse>> getAll() {
        return ResponseEntity.ok(measurementSerives.getAllMeasurement());
    }

    @GetMapping("/getById{id}")
    public ResponseEntity<MeasurmentRequest.MeasurementResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(measurementSerives.getMeasurementById(id));
    }
    @PutMapping("/update{id}")
    public ResponseEntity<MeasurmentRequest.MeasurementResponse> update( @PathVariable Long id,@RequestBody MeasurmentRequest measurmentRequest) {
        return ResponseEntity.ok(  measurementSerives.updateMeasurement(id, measurmentRequest));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MeasurmentRequest.MeasurementResponse> delete(
            @PathVariable Long id) {

        return ResponseEntity.ok(measurementSerives.deleteMeasurement(id));
    }
}