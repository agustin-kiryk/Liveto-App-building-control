package com.c823.consorcio.service;

import com.c823.consorcio.dto.BillPaymentDto;
import com.c823.consorcio.dto.TransactionDto;

public interface ITransactionService {


  TransactionDto sendInvoice(BillPaymentDto billPaymentDto);

  TransactionDto createTransaction(TransactionDto transactionDto);

  TransactionDto sendPayment(BillPaymentDto billPaymentDto);
}
