package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {

    private static final double LOW_PRESSURE = 14.00;
    private static final double HIGH_PRESSURE = 22.00;
    private static final double NORMAL_PRESSURE = 20.00;
    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void setUp() {
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmHasToBeOnWithLowPressure() {

        when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmHasToBeOnWithHighPressure() {

        when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmHasToBeOffWithPressureInNormalLimits() {

        when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}