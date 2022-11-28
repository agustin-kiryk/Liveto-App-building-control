package com.c823.consorcio.controller;

import com.c823.consorcio.dto.BillPaymentDto;
import com.c823.consorcio.dto.TransactionDto;
import com.c823.consorcio.service.ITransactionService;
import com.c823.consorcio.service.Impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

  @Autowired
  private ITransactionService transactionService;

  @PostMapping("/billPayment")
  public ResponseEntity<TransactionDto> billPayment(@RequestBody BillPaymentDto billPaymentDto){
   TransactionDto result = transactionService.sendInvoice(billPaymentDto);
   return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }



}
