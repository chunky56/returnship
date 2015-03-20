package com.csa.returnship.stl;

import com.csa.returnship.stl.StringToLong;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringToLongTest {

    StringToLong converter;

    @Before
    public void initialize() {
        converter = new StringToLong();
    }

    @Test
    public void testConvertStringToLongInputNormal() throws Exception {
        assertEquals(converter.convertStringToLong("483"), 483);
    }

    @Test
    public void testConvertStringToLongInputZero() throws Exception {
        assertEquals(converter.convertStringToLong("0"), 0);
    }

    @Test
    public void testConvertStringToLongInputNegative() throws Exception {
        assertEquals(converter.convertStringToLong("-682"), -682);
    }

    @Test
    public void testConvertStringToLongInputLarge() throws Exception {
        assertEquals(converter.convertStringToLong("9223372036854775807"), 9223372036854775807L);
    }

    @Test
    public void testConvertStringToLongInputLargeNegative() throws Exception {
        assertEquals(converter.convertStringToLong("-9223372036854775808"), -9223372036854775808L);
    }

    @Test
    public void testConvertStringToLongInputUpperL() throws Exception {
        assertEquals(converter.convertStringToLong("942L"), 942);
    }

    @Test
    public void testConvertStringToLongInputLowerL() throws Exception {
        assertEquals(converter.convertStringToLong("754l"), 754);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertStringToLongInvalidString() {
        converter.convertStringToLong("fooball");
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertStringToLongInvalidNumberString() {
        converter.convertStringToLong("123abL");
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertStringToLongInvalidStringNumber() {
        converter.convertStringToLong("lbc123");
    }
}
