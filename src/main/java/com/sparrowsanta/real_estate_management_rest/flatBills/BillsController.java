package com.sparrowsanta.real_estate_management_rest.flatBills;

import com.sparrowsanta.real_estate_management_rest.flatBillsDefinitions.FlatBillsDefinitions;
import com.sparrowsanta.real_estate_management_rest.flatBillsDefinitions.FlatBillsDefinitionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/payment/all/{flatId}/{filter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlatBills> getPaymentsByFlatId(@PathVariable(name = "flatId") long flatId,
                                               @PathVariable(name = "filter") String filter) {
        return flatBillsService.getBillsByFlatIdAndFilter(flatId, filter);
    }


}
