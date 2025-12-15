package Divine.Designer.Den.Entity.DTO.GarmentTypeDto;

public class GarmentTypeResponse {

    private Long id;
    private String garmentName;
    private String garmentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGarmentName() {
        return garmentName;
    }

    public void setGarmentName(String garmentName) {
        this.garmentName = garmentName;
    }

    public String getGarmentType() {
        return garmentType;
    }

    public void setGarmentType(String garmentType) {
        this.garmentType = garmentType;
    }
}
