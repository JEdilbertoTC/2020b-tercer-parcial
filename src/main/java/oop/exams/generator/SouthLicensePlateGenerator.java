package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SouthLicensePlateGenerator implements LicensePlateGenerator {
    private static final Map<String, String> regionByState = new HashMap<>();
    static {
        regionByState.put("MIC", "Michoacán");
        regionByState.put("GRO", "Guerrero");
        regionByState.put("OAX", "Oaxaca");
        regionByState.put("CHP","Chiapas");
    }
    @Override
    public String generate(String state) {
        if(!regionByState.containsKey(state))
            throw new BadRegionException("Allowed state codes: CHP, GRO, MIC, OAX");
        String placa = "4";
        Random rnd = new Random();
        placa+= state;
        while(placa.length() <7){
            Integer num = (int)(rnd.nextDouble() * 10.0);
            placa+= num.toString();
        }
        return placa;
    }
}
