package Divine.Designer.Den.Serives;

import Divine.Designer.Den.Entity.DTO.GarmentTypeDto.GarmentTypeRequest;
import Divine.Designer.Den.Entity.DTO.GarmentTypeDto.GarmentTypeResponse;
import Divine.Designer.Den.Entity.GarmentType;
import Divine.Designer.Den.Repository.GarmentTypeRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarmentTypeSerives {

 @Autowired
    private GarmentTypeRepository garmentTypeRepository;


    public GarmentTypeResponse addGarmentType(GarmentTypeRequest request) {
        GarmentType garmentType = new GarmentType();
        garmentType.setGarmentName(request.getGarmentName());
        garmentType.setGarmentType(request.getGarmentType());

        garmentType = garmentTypeRepository.save(garmentType);

        return convertToResponse(garmentType); // Correct return
    }
    private GarmentTypeResponse convertToResponse(GarmentType garmentType) {
            GarmentTypeResponse response = new GarmentTypeResponse();
            response.setId(garmentType.getId());
            response.setGarmentName(garmentType.getGarmentName());
            response.setGarmentType(garmentType.getGarmentType());
            return response;
        }


    public @Nullable List<GarmentTypeResponse> getAllGarmentTypes() {
        return garmentTypeRepository.findAll().stream().map(this::convertToResponse)
                .toList();
    }


    public @Nullable GarmentTypeResponse getGarmentTypeById(Long id) {
        GarmentType garmentType=garmentTypeRepository.findById(id).orElseThrow(()->new RuntimeException("Garment Type not found with id:  "+id));
        return convertToResponse(garmentType);
    }

    public @Nullable GarmentTypeResponse updateGarmentType(Long id, GarmentTypeRequest garmentTypeRequest) {
        GarmentType garmentType=garmentTypeRepository.findById(id).orElseThrow(()->new RuntimeException("garment type not found with: " +id));
        garmentType.setGarmentName(garmentType.getGarmentName());
        garmentType.setGarmentType(garmentType.getGarmentType());
        return  convertToResponse(garmentType);

    }


    public void deleteGarmentType(Long id) {
            GarmentType garmentType = garmentTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Garment Type not found with id: " + id));
            garmentTypeRepository.delete(garmentType);
        }

    }





