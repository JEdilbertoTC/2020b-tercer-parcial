package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DefaultLicensePlateGenerator implements LicensePlateGenerator {
    private static final Map<String, String> regionByState = new HashMap<>();
    static {

        regionByState.put("AGU", "Aguascalientes");
        regionByState.put("CMX", "Ciudad de Mexico");
        regionByState.put("DUR", "Durango");
        regionByState.put("HID","Hidalgo");
        regionByState.put("MEX", "Mexico");
        regionByState.put("PUE","Puebla");
        regionByState.put("QUE","Queretaro");
        regionByState.put("SLP","San Luis Potosi");
        regionByState.put("TLA","Tlaxcala");
        regionByState.put("ZAC","Zacatecas");
        regionByState.put("GUA","Guanajuato");
    }

    @Override
    public String generate(String state) {
        if (!regionByState.containsKey(state))
            throw new BadRegionException("Allowed state codes: AGU, CMX, DUR, GUA, HID, MEX, PUE, QUE, SLP, TLA, ZAC");
        Random rnd = new Random();
        String placa = "5";
        while (placa.length() < 8) {
            Integer num = (int) (rnd.nextDouble() * 10.0);
            placa += num.toString();
        }
        return placa;
    }
}
