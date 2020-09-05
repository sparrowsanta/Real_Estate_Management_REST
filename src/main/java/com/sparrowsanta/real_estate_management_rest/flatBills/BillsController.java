package com.sparrowsanta.real_estate_management_rest.flatBills;

import com.sparrowsanta.real_estate_management_rest.flatBillsDefinitions.FlatBillsDefinitions;
import com.sparrowsanta.real_estate_management_rest.flatBillsDefinitions.FlatBillsDefinitionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bills")
@RequiredArgsConstructor
public class BillsController {

    @Autowired
    private FlatBillsService flatBillsService;
    @Autowired
    private FlatBillsDefinitionsService flatBillsDefinitionsService;


    @GetMapping(value = "/getAll/{flatId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlatBillsDefinitions> getBillsDefinitions(@PathVariable(name = "flatId") long flatId) {
        return flatBillsDefinitionsService.findAllByFlatId(flatId);
    }

    @GetMapping(value = "/{billId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FlatBillsDefinitions getBillDefinitionById(@PathVariable(name = "billId") long billId) {
        return flatBillsDefinitionsService.findById(billId).get();
    }

    @GetMapping(value = "/payment/all/{flatId}/{paidFilter}/{typeFilter}/{dateFromFilter}/{dateToFilter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlatBills> getPaymentsByFlatId(@PathVariable(name = "flatId") long flatId,
                                               @PathVariable(name = "paidFilter") String paidFilter,
                                               @PathVariable(name = "typeFilter") String typeFilter,
                                               @PathVariable(name = "dateFromFilter") String dateFromFilter,
                                               @PathVariable(name = "dateToFilter") String dateToFilter) {
        return flatBillsService.getBillsByFlatIdAndFilter(flatId, paidFilter, typeFilter, dateFromFilter, dateToFilter);
    }

    @GetMapping(value = "/payment/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FlatBills getPayment(@PathVariable(name = "paymentId") long paymentId) {
        return flatBillsService.findById(paymentId).get();
    }

    @PostMapping(value = "/payment/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addNewPayment(@RequestBody FlatBills payment) {
        flatBillsService.save(payment);
        return "Ok";
    }

    @PutMapping(value = "/payment/edit/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String editMeterReading(@RequestBody FlatBills payment) {
        flatBillsService.save(payment);
        return "Ok";
    }

    @DeleteMapping(value = "/payment/delete/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delPayment(@PathVariable(name = "paymentId") long paymentId) {
        flatBillsService.delete(flatBillsService.findById(paymentId).get());
        return "Ok";
    }


    @GetMapping(value = "/billDefinitionsPerMonth/{flatId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String[]> billDefinitionsPerMonth(@PathVariable(name = "flatId") long flatId) {
        return flatBillsService.getAllBillsDefinitionPerMonth(flatId);
    }

}
