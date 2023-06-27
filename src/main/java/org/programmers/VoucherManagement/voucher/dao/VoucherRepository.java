package org.programmers.VoucherManagement.voucher.dao;

import org.programmers.VoucherManagement.voucher.domain.Voucher;

import java.util.List;

public interface VoucherRepository {
    Voucher save(Voucher voucher);
    List<Voucher> findAll();
}