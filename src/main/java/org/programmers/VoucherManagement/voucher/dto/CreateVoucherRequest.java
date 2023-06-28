package org.programmers.VoucherManagement.voucher.dto;

import org.programmers.VoucherManagement.DiscountType;

public class CreateVoucherRequest {

    private DiscountType discountType;
    private int discountValue;

    public CreateVoucherRequest(DiscountType discountType, int discountValue){
        this.discountType = discountType;
        this.discountValue = discountValue;
    }
    public int getDiscountValue() {
        return discountValue;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }
 }