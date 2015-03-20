package com.csa.returnship.stl;

import com.csa.returnship.stl.StringToLong;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringToLongTest {

    @Test
    public void testConvertStringToLongInputNormal() throws Exception {
        assertEquals(StringToLong.convertStringToLong("483"), 483);
    }

    @Test
    public void testConvertStringToLongInputZero() throws Exception {
        assertEquals(StringToLong.convertStringToLong("0"), 0);
    }

    @Test
    public void testConvertStringToLongInputNegative() throws Exception {
        assertEquals(StringToLong.convertStringToLong("-682"), -682);
    }

    @Test
    public void testConvertStringToLongInputLarge() throws Exception {
        assertEquals(StringToLong.convertStringToLong("9223372036854775807"), 9223372036854775807L);
    }

    @Test
    public void testConvertStringToLongInputLargeNegative() throws Exception {
        assertEquals(StringToLong.convertStringToLong("-9223372036854775808"), -9223372036854775808L);
    }

    @Test
    public void testConvertStringToLongInputUpperL() throws Exception {
        assertEquals(StringToLong.convertStringToLong("942L"), 942);
    }

    @Test
    public void testConvertStringToLongInputLowerL() throws Exception {
        assertEquals(StringToLong.convertStringToLong("754l"), 754);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertStringToLongInvalidString() {
        StringToLong.convertStringToLong("fooball");
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertStringToLongInvalidNumberString() {
        StringToLong.convertStringToLong("123abL");
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertStringToLongInvalidStringNumber() {
        StringToLong.convertStringToLong("lbc123");
    }
}
