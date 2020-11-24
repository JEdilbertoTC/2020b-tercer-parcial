package oop.exams.generator;


import oop.exams.model.Region;
import oop.exams.repository.LicensePlateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class LicensePlateGeneratorFactoryTest {


    private LicensePlateGeneratorFactory licensePlateGeneratorFactory;


    @BeforeEach
    public void setup() {
        licensePlateGeneratorFactory = new LicensePlateGeneratorFactory();
    }

    @Test
    public void givenANorthRegionState_whenGetInstance_thenNorthRegionGeneratorIsReturned() {
        // Given:
        String[] northStates = {"BCN", "BCS", "CHH", "COA", "NLE", "SON", "TAM"};

        for (String state : northStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);

            // Then:
            assertThat(instance).isInstanceOf(NorthLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenASouthRegionState_whenGetInstance_thenSouthRegionGeneratorIsReturned() {
        // Given:
        String[] southStates = {"CHP", "GRO", "MIC", "OAX"};

        for (String state : southStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);

            // Then:
            assertThat(instance).isInstanceOf(SouthLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenAEastRegionState_whenGetInstance_thenEastRegionGeneratorIsReturned() {
        // Given:
        String[] southStates = {"CAM", "ROO", "TAB", "VER", "YUC"};

        for (String state : southStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);

            // Then:
            assertThat(instance).isInstanceOf(EastLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenAWestRegionState_whenGetInstance_thenWestRegionGeneratorIsReturned() {
        // Given:
        String[] southStates = {"COL", "JAL", "NAY", "SIN"};

        for (String state : southStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);

            // Then:
            assertThat(instance).isInstanceOf(WestLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenACenterRegionState_whenGetInstance_thenCenterGeneratorIsReturned() {
        // Given:
        String[] centerStates = {"AGU", "CMX", "DUR", "GUA", "HID", "MEX", "PUE", "QUE", "SLP", "TLA", "ZAC"};

        for (String state : centerStates) {
            // When:
            LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(state);

            // Then:
            assertThat(instance).isInstanceOf(DefaultLicensePlateGenerator.class);
        }
    }

    @Test
    public void givenANorthRegionState_thenNorthRegionisReturned() {

        LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(Region.NORTH);
        assertThat(instance).isInstanceOf(NorthLicensePlateGenerator.class);

    }

    @Test
    void givenAEastRegionState_thenEastRegionisReturned() {
        LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(Region.EAST);
        assertThat(instance).isInstanceOf(EastLicensePlateGenerator.class);
    }

    @Test
    void givenAWestRegionState_thenWestRegionisReturned() {
        LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(Region.WEST);
        assertThat(instance).isInstanceOf(WestLicensePlateGenerator.class);
    }

    @Test
    void givenASouthRegionState_thenSouthRegionisReturned() {
        LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(Region.SOUTH);
        assertThat(instance).isInstanceOf(SouthLicensePlateGenerator.class);
    }

    @Test
    void givenACenterRegionState_thenCenterRegionisReturned() {
        LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(Region.CENTER);
        assertThat(instance).isInstanceOf(DefaultLicensePlateGenerator.class);
    }


    @Test
    void givenAWrongRegionState_thenDoNothing() {
        // Given:
        String[] centerStates = {"AGU1", "1CMX", "1DUR", "2GUA", "1HID", "2MEX", "3PUE", "1QUE", "1SLP", "1TLA", "1ZAC"};

        // When:
        LicensePlateGenerator instance = licensePlateGeneratorFactory.getInstance(centerStates[0]);

        //Then
        assertThat(instance).doesNotHaveSameClassAs(NorthLicensePlateGenerator.class);
        assertThat(instance).doesNotHaveSameClassAs(DefaultLicensePlateGenerator.class);
        assertThat(instance).doesNotHaveSameClassAs(WestLicensePlateGenerator.class);
        assertThat(instance).doesNotHaveSameClassAs(EastLicensePlateGenerator.class);
        assertThat(instance).doesNotHaveSameClassAs(SouthLicensePlateGenerator.class);
    }


}