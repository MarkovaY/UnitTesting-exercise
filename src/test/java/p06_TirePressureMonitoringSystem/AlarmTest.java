package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {

    Alarm alarm;
    Sensor sensor;

    @Before
    public void setUp() {
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmHasToBeOnWithLowPressure() {

        when(sensor.popNextPressurePsiValue()).thenReturn(14.00);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmHasToBeOnWithHighPressure() {

        when(sensor.popNextPressurePsiValue()).thenReturn(22.00);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmHasToBeOffWithPressureInNormalLimits() {

        when(sensor.popNextPressurePsiValue()).thenReturn(20.00);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}