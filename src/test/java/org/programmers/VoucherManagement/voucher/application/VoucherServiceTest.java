package org.programmers.VoucherManagement.voucher.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.VoucherManagement.voucher.dao.MemoryVoucherRepository;
import org.programmers.VoucherManagement.voucher.dao.VoucherRepository;
import org.programmers.VoucherManagement.voucher.domain.*;
import org.programmers.VoucherManagement.voucher.dto.CreateVoucherReq;
import static org.assertj.core.api.Assertions.assertThat;
import org.programmers.VoucherManagement.voucher.dto.GetVoucherRes;

import java.util.UUID;


public class VoucherServiceTest {
    VoucherService voucherService;
    VoucherRepository voucherRepository;

    @BeforeEach
    void init(){
        voucherRepository = new MemoryVoucherRepository();
        voucherService = new VoucherService(voucherRepository);
    }
    @Test
    @DisplayName("바우처정보를 이용해 저장 후 반환 - 성공")
    void 바우처정보를_저장후반환_성공(){
        CreateVoucherReq createVoucherReq = new CreateVoucherReq(DiscountType.FIXED,2000);
        Voucher voucher = new FixedAmountVoucher(UUID.randomUUID(),createVoucherReq.getDiscountType(),new DiscountValue(createVoucherReq.getDiscountValue()));
        GetVoucherRes getVoucherRes = GetVoucherRes.toDto(voucher);

        GetVoucherRes getVoucherResExpect = voucherService.saveVoucher(createVoucherReq);

        assertThat(getVoucherResExpect)
                .usingRecursiveComparison()
                .ignoringFields("voucherId")
                .isEqualTo(getVoucherRes);
    }

}