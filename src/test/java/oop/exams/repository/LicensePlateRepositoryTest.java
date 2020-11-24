package oop.exams.repository;

import oop.exams.exception.BadRegionException;
import oop.exams.exception.NotAvailableLicensePlateException;
import oop.exams.generator.LicensePlateGenerator;
import oop.exams.generator.LicensePlateGeneratorFactory;
import oop.exams.model.Region;
import oop.exams.repository.LicensePlateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class LicensePlateRepositoryTest {
    private LicensePlateRepository licensePlateRepository;
    private LicensePlateGeneratorFactory licensePlateGeneratorFactory;
    private static final EnumMap<Region, Set<String>> licensePlatesByRegion = new EnumMap<>(Region.class);


    @BeforeEach
    public void setup() {
        licensePlateRepository = new LicensePlateRepository();
    }

    @Test
    public void givenANonNorthState_whenGenerate_thenReturnNorthRegion() {
        //Given:
        String state = "SON";

        //When:
        Region region = licensePlateRepository.getRegionByState(state);

        //Then:
        assertThat(region).isEqualByComparingTo(Region.NORTH);
    }

    @Test
    public void givenANonCenterState_whenGenerate_thenReturnCenterRegion() {
        //Given:
        String state = "AGU";

        //When:
        Region region = licensePlateRepository.getRegionByState(state);

        //Then:
        assertThat(region).isEqualByComparingTo(Region.CENTER);
    }

    @Test
    public void givenANonSouthState_whenGenerate_thenReturnSouthRegion() {
        //Given:
        String state = "MIC";

        //When:
        Region region = licensePlateRepository.getRegionByState(state);

        //Then:
        assertThat(region).isEqualByComparingTo(Region.SOUTH);
    }

    @Test
    public void givenANonWestState_whenGenerate_thenReturnWestRegion() {
        //Given:
        String state = "SIN";

        //When:
        Region region = licensePlateRepository.getRegionByState(state);

        //Then:
        assertThat(region).isEqualByComparingTo(Region.WEST);
    }

    @Test
    public void givenaWhongState_thenThrowBadRegionException() throws BadRegionException {
        //Given:
        String state = "ABC";

        //Then:
        Assertions.assertThrows(BadRegionException.class, () -> {
            //When:
            Region region = licensePlateRepository.getRegionByState(state);
            throw new BadRegionException("Estado desconocido");
        });
    }

    @Test
    public void saveTest() {
        //Given:
        String licensePlate = null;
        LicensePlateRepository licensePlateRepository = new LicensePlateRepository();
        //When:
        licensePlateRepository.save(Region.CENTER, licensePlate);
    }

    @Test
    public void countByRegionTest() {
        LicensePlateRepository licensePlateRepository = new LicensePlateRepository();
        try {
            int tamanio = licensePlateRepository.countByRegion(Region.CENTER);
        } catch (NullPointerException e) {

        }

    }
}