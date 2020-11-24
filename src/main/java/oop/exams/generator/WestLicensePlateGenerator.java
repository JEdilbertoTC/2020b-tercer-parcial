package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WestLicensePlateGenerator implements LicensePlateGenerator{
    private static final Map<String, String> regionByState = new HashMap<>();
    static {
        regionByState.put("SIN", "Sinaloa");
        regionByState.put("NAY", "Nayarit");
        regionByState.put("JAL", "Jalisco");
        regionByState.put("COL","Colima");
    }
    @Override

    public String generate(String state) {
        if(!regionByState.containsKey(state)){
            throw new BadRegionException("Allowed state codes: COL, JAL, NAY, SIN");
        }
        Random rnd = new Random();
        String placa = "2";
        while(placa.length()<2){
            Integer num = (int)(rnd.nextDouble() * 10.0);
            placa+= num.toString();
        }
        placa+= state;
        return placa;
    }
}
