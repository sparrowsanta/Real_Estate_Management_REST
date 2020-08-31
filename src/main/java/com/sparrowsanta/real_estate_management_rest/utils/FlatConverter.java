package com.sparrowsanta.real_estate_management_rest.utils;

import com.sparrowsanta.real_estate_management_rest.flat.Flat;
import com.sparrowsanta.real_estate_management_rest.flat.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class FlatConverter implements Converter<String, Flat> {

    @Autowired
    private FlatService flatService;

    @Override
    public Flat convert(String source) {
        Flat flat = flatService.getOne(Long.parseLong(source));
        return flat;
    }

}
