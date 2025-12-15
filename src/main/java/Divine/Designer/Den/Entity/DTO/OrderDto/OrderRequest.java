package Divine.Designer.Den.Entity.DTO.OrderDto;

import java.time.LocalDate;

public class OrderRequest {
    private String orderNo;
    private LocalDate orderDate;
    private Double totalAmount;
    private Long customerId;
    private Long garmentTypeId;
    private String moblie ;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getGarmentTypeId() {
        return garmentTypeId;
    }

    public void setGarmentTypeId(Long garmentTypeId) {
        this.garmentTypeId = garmentTypeId;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }
}


