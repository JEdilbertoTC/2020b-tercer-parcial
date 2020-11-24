package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EastLicensePlateGenerator implements LicensePlateGenerator {
    private static final Map<String, String> regionByState = new HashMap<>();

    static {
        regionByState.put("VER", "Veracruz");
        regionByState.put("TAB", "Tabasco");
        regionByState.put("CAM", "Campeche");
        regionByState.put("YUC", "Yucatán");
        regionByState.put("ROO", "Quintana Roo");
    }

    @Override
    public String generate(String state) {
        if (!regionByState.containsKey(state)) {
            throw new BadRegionException("Allowed state codes: CAM, ROO, TAB, VER, YUC");
        }
        Random rnd = new Random();
        String placa = "3";
        while(placa.length() <3) {
            Integer num = (int) (rnd.nextDouble() * 10.0);
            placa += num.toString();
        }
        placa += "Z";
        return placa;
    }
}
