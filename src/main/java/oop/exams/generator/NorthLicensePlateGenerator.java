package oop.exams.generator;

import oop.exams.exception.BadRegionException;
import oop.exams.model.Region;
import oop.exams.repository.LicensePlateRepository;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NorthLicensePlateGenerator implements LicensePlateGenerator{
    private static final Map<String, String> regionByState = new HashMap<>();
    static {
        regionByState.put("SON", "Sonora");
        regionByState.put("CHH", "Chihuahua");
        regionByState.put("COA", "Coahuila");
        regionByState.put("NLE","Nuevo León");
        regionByState.put("TAM", "Tamaulipas");
    }
    @Override
    public String generate(String state) {
        if(!regionByState.containsKey(state)){
            throw new BadRegionException("Allowed state codes: BCN, BCS, CHH, COA, NLE, SON, TAM");
        }
        Random rnd = new Random();
        String placa= "1";
        placa+= state;
        while(placa.length()<6){

            Integer num = (int)(rnd.nextDouble() * 10.0);
            placa+= num.toString();
        }
        return placa;
    }
}
