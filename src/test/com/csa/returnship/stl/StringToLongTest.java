package com.csa.returnship.stl;

import com.csa.returnship.stl.StringToLong;

import static org.junit.Assert.*;

public class StringToLongTest {

    @org.junit.Test
    public void testConvertStringToLong() throws Exception {
        assertEquals(StringToLong.convertStringToLong("483"), 483);
        assertEquals(StringToLong.convertStringToLong("0"), 0);
        assertEquals(StringToLong.convertStringToLong("-682"), -682);
        assertEquals(StringToLong.convertStringToLong("9223372036854775807L"), 9223372036854775807L);
        assertEquals(StringToLong.convertStringToLong("-9223372036854775808l"), -9223372036854775808L);
    }

    @org.junit.Test(expected=NumberFormatException.class)
    public void testConvertStringToLongInvalid() {
        StringToLong.convertStringToLong("fooball");
        StringToLong.convertStringToLong("123abL");
        StringToLong.convertStringToLong("lbc123");
    }
}
