package Divine.Designer.Den.Serives;

import Divine.Designer.Den.Entity.DTO.MeasurmentDto.MeasurmentRequest;
import Divine.Designer.Den.Entity.DTO.MeasurmentDto.MeasurmentRespones;
import Divine.Designer.Den.Entity.GarmentType;
import Divine.Designer.Den.Entity.Measurement;
import Divine.Designer.Den.Repository.GarmentTypeRepository;
import Divine.Designer.Den.Repository.MeasurementRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasurementSerives {
    @Autowired
    private MeasurementRepository measurementRepository;

    @Autowired
    private GarmentTypeRepository garmentTypeRepository;


    public MeasurmentRequest.MeasurementResponse addMeasurement(MeasurmentRequest measurmentRequest) {
        Measurement measurement = new Measurement();

        //request
        measurement.setId(measurmentRequest.getId());
        measurement.setNeck(measurmentRequest.getNeck());
        measurement.setLength(measurmentRequest.getLength());
        measurement.setChest(measurmentRequest.getChest());
        measurement.setWaist(measurmentRequest.getWaist());
        measurement.setSeat(measurmentRequest.getSeat());
        measurement.setShoulder(measurmentRequest.getShoulder());
        measurement.setCuff(measurmentRequest.getCuff());
        measurement = measurementRepository.save(measurement);

        //respones
        MeasurmentRequest.MeasurementResponse measurementResponse = new MeasurmentRequest.MeasurementResponse();
        measurement.setId(measurementResponse.getId());
        measurement.setNeck(measurementResponse.getNeck());
        measurement.setLength(measurementResponse.getLength());
        measurement.setChest(measurementResponse.getChest());
        measurement.setWaist(measurementResponse.getWaist());
        measurement.setSeat(measurementResponse.getSeat());
        measurement.setShoulder(measurementResponse.getShoulder());
        measurement.setCuff(measurementResponse.getCuff());
        return measurementResponse;
    }


    public List<MeasurmentRequest.MeasurementResponse> getAllMeasurement() {
        List<Measurement> list = measurementRepository.findAll();

        return list.stream().map(measurement -> {
            MeasurmentRequest.MeasurementResponse measurementResponse = new MeasurmentRequest.MeasurementResponse();

            measurementResponse.setId(measurement.getId());
            measurementResponse.setNeck(measurement.getNeck());
            measurementResponse.setLength(measurement.getLength());
            measurementResponse.setChest(measurement.getChest());
            measurementResponse.setWaist(measurement.getWaist());
            measurementResponse.setSeat(measurement.getSeat());
            measurementResponse.setShoulder(measurement.getShoulder());
            measurementResponse.setCuff(measurement.getCuff());

            if (measurement.getGarmentType() != null) {
//                res.set(m.getGarmentType().getId());
//                res.setGarmentName(m.getGarmentType().getGarmentName());
            }

            return measurementResponse;
        }).collect(Collectors.toList());
    }


    public MeasurmentRequest.MeasurementResponse getMeasurementById(Long id) {
        Measurement measurement = measurementRepository.findById(id).orElseThrow(() -> new RuntimeException("Measurement not found with id: " + id));

        MeasurmentRequest.MeasurementResponse measurementResponse = new MeasurmentRequest.MeasurementResponse();

        measurementResponse.setId(measurement.getId());
        measurementResponse.setNeck(measurementResponse.getNeck());
        measurementResponse.setLength(measurementResponse.getLength());
        measurementResponse.setChest(measurementResponse.getChest());
        measurementResponse.setWaist(measurementResponse.getWaist());
        measurementResponse.setSeat(measurementResponse.getSeat());
        measurementResponse.setShoulder(measurementResponse.getShoulder());
        measurementResponse.setCuff(measurementResponse.getCuff());

        return measurementResponse;
    }

    public MeasurmentRequest.MeasurementResponse updateMeasurement(Long id, MeasurmentRequest measurmentRequest) {
        MeasurmentRequest.MeasurementResponse response = new MeasurmentRequest.MeasurementResponse();

        response.setId(measurmentRequest.getId());
        response.setNeck(measurmentRequest.getNeck());
        response.setLength(measurmentRequest.getLength());
        response.setChest(measurmentRequest.getChest());
        response.setWaist(measurmentRequest.getWaist());
        response.setSeat(measurmentRequest.getSeat());
        response.setShoulder(measurmentRequest.getShoulder());
        response.setCuff(measurmentRequest.getCuff());

        return response;
    }


    public MeasurmentRequest.@Nullable MeasurementResponse deleteMeasurement(Long id) {
        Measurement measurement = measurementRepository.findById(id)  .orElseThrow(() -> new RuntimeException("Measurement not found with id: " + id));


        measurementRepository.delete(measurement);

        return convertToResponse(measurement);
    }

    private MeasurmentRequest.@Nullable MeasurementResponse convertToResponse(Measurement measurement) {
        MeasurmentRequest.MeasurementResponse response = new MeasurmentRequest.MeasurementResponse();

        response.setId(measurement.getId());
        response.setNeck(measurement.getNeck());
        response.setLength(measurement.getLength());
        response.setChest(measurement.getChest());
        response.setWaist(measurement.getWaist());
        response.setSeat(measurement.getSeat());
        response.setShoulder(measurement.getShoulder());
        response.setCuff(measurement.getCuff());

        return response;
    }
}




