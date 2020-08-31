package com.sparrowsanta.real_estate_management_rest.meters;

import com.sparrowsanta.real_estate_management_rest.metersHistory.MetersHistory;
import com.sparrowsanta.real_estate_management_rest.metersHistory.MetersHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("meters")
@RequiredArgsConstructor
public class MetersController {

    @Autowired
    private MetersService metersService;
    @Autowired
    private MetersHistoryService metersHistoryService;


    @GetMapping(value = "/getAll/{flatId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Meters> getMeters(@PathVariable(name = "flatId") Long flatId) {
        return metersService.findAllMetersByFlatId(flatId);
    }

    @GetMapping(value = "/{meterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Meters getMeterById(@PathVariable(name = "meterId") long meterId) {
        return metersService.findById(meterId).orElse(null);
    }

    @DeleteMapping(value = "/delete/{meterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delMeter(@PathVariable(name = "meterId") long meterId) {
        metersService.delete(metersService.findById(meterId).orElse(null));
        return "Ok";
    }

    @PutMapping(value = "/edit/{meterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String editMeter(@RequestBody Meters meter) {
        metersService.save((meter));
        return "Ok";
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addMeter(@RequestBody Meters meter) {
        metersService.save(meter);
        return "Ok";

    }


    @GetMapping(value = "/reading/{readingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MetersHistory getMeterReadingById(@PathVariable(name = "readingId") long readingId) {
        return metersHistoryService.findById(readingId).get();

    }

    @GetMapping(value = "/history/{meterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MetersHistory> getMeterHistory(@PathVariable(name = "meterId") long meterId) {

        return metersHistoryService.findReadingsHistoryByMeterId(meterId);
    }


    @PutMapping(value = "/reading/edit/{readingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String editMeterReading(@RequestBody MetersHistory metersHistory) {
        metersHistoryService.save(metersHistory);
        return "Ok";
    }


    @DeleteMapping(value = "/history/delete/{readingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delMeterReading(@PathVariable(name = "readingId") long readingId) {
        metersHistoryService.delete(metersHistoryService.findById(readingId).get());
        return "Ok";
    }

    @PostMapping(value = "/reading/add", produces = "text/plain;charset=UTF-8")
    public String addMeterReading(@RequestBody MetersHistory reading) {
        metersHistoryService.save(reading);
        return "Ok";
    }


}
