package com.sparrowsanta.real_estate_management_rest.meters;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("meters")
@RequiredArgsConstructor
public class MetersController {
    //standardJpa package
    @Autowired
    private MetersService metersService;


    @GetMapping(value = "/getAll/{flatId}", produces = "text/plain;charset=UTF-8")
    public List<Meters> getMeters(@PathVariable(name = "flatId") Long flatId) {
        System.out.println(metersService.findAllMetersByFlatId(flatId));
//        return metersService.findAllMetersByFlatId(flatId);
        return null;
    }

    @GetMapping(value = "/{meterId}", produces = "text/plain;charset=UTF-8")
    public Meters getMeterById(@PathVariable(name = "meterId") long meterId) {

        return metersService.findById(meterId).orElse(null);
    }

    @DeleteMapping(value = "/delete/{meterId}", produces = "text/plain;charset=UTF-8")
    public String delMeter(@PathVariable(name = "meterId") long meterId) {
        metersService.delete(metersService.findById(meterId).orElse(null));
        return "Ok";
    }

    @PutMapping(value = "/edit/{meterId}", produces = "text/plain;charset=UTF-8")
    public String editMeter(@RequestBody Meters meter) {
        metersService.save((meter));
        return "Ok";
    }

    @PostMapping(value = "/add", produces = "text/plain;charset=UTF-8")
    public String addMeter(@RequestBody Meters meter) {
        metersService.save(meter);
        return "Ok";

    }


//    @GetMapping(value = "/reading/{readingId}", produces = "text/plain;charset=UTF-8")
//    public String getMeterReadingById(@PathVariable(name = "readingId") long readingId) {
//        MetersHistory reading = testData.getMetersHistory().stream()
//                .filter(m -> m.getId() == readingId)
//                .findFirst()
//                .orElse(null);
//
//        return new GsonBuilder()
//                .setDateFormat("MM-dd-yyyy")
//                .create()
//                .toJson(reading);
//
//    }
//


//
//    @PutMapping(value = "/reading/edit/{readingId}", produces = "text/plain;charset=UTF-8")
//    public String editMeterReading(@RequestBody String meter) {
//        testData.editReading(meter);
//        return new Gson().toJson("Ok");
//    }
//



//    }

//    @GetMapping(value = "/history/{meterId}", produces = "text/plain;charset=UTF-8")
//    public String getMeterHistory(@PathVariable(name = "meterId") long meterId) {
//
//        return new Gson().toJson(testData.getMetersHistory().stream().filter(x -> x.getMeterId() == meterId)
//                .sorted((x, y) -> y.getMeterReadingDate().compareTo(x.getMeterReadingDate()))
//                .collect(Collectors.toList()));
//    }
//
//    @DeleteMapping(value = "/history/delete/{readingId}", produces = "text/plain;charset=UTF-8")
//    public String delMeterReading(@PathVariable(name = "readingId") long readingId) {
//        testData.deleteMeterReading(readingId);
//        return new Gson().toJson("Ok");
//    }
//
//    @PostMapping(value = "/reading/add", produces = "text/plain;charset=UTF-8")
//    public String addMeterReading(@RequestBody String reading) {
//        testData.addReading(reading);
//        return new Gson().toJson("Ok");
//    }





}
