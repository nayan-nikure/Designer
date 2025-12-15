package Divine.Designer.Den.Entity;

import jakarta.persistence.*;

@Entity
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

       private Long id;
        private Double neck;
        private Double length;
        private Double chest;
        private Double waist;
        private Double seat;
        private Double shoulder;
        private Double cuff;


    @OneToOne
    @JoinColumn(name = "garment_id")
    private GarmentType garmentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNeck() {
        return neck;
    }

    public void setNeck(Double neck) {
        this.neck = neck;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getChest() {
        return chest;
    }

    public void setChest(Double chest) {
        this.chest = chest;
    }

    public Double getWaist() {
        return waist;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }

    public Double getSeat() {
        return seat;
    }

    public void setSeat(Double seat) {
        this.seat = seat;
    }

    public Double getShoulder() {
        return shoulder;
    }

    public void setShoulder(Double shoulder) {
        this.shoulder = shoulder;
    }

    public Double getCuff() {
        return cuff;
    }

    public void setCuff(Double cuff) {
        this.cuff = cuff;
    }

    public GarmentType getGarmentType() {

        return garmentType;
    }

    public void setGarmentType(GarmentType garmentType) {
        this.garmentType = garmentType;
    }
}

