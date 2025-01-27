package com.jazz_harmony_helper.jazz_harmony_helper_application.key;

import com.jazz_harmony_helper.jazz_harmony_helper_application.scale.Interval;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class KeyFactoryTest {

//    @BeforeEach
//    void setUp() {
//
//    }
//
//    @CsvSource({
//            "C,DORIAN",
//            "C_DOUBLE_SHARP,LYDIAN",
//            "C_DOUBLE_FLAT,PHRYGIAN",
//            "A_FLAT,MINOR",
//            "C,MAJOR"
//    })
//    @ParameterizedTest
//    public void shouldGenerateKeysSuccessfully(
//            MajorKeySignature majorKeySignature,
//            KeyRelativeModality keyRelativeModality
//    ) {
//        Key key = KeyFactory.getKey(majorKeySignature, keyRelativeModality);
//        assertEquals(keyRelativeModality, key.getModality());
//        assertEquals(majorKeySignature, key.getKeySignature());
//        assertNotNull(key.getNoteAbstractMap().get(Interval.PERFECT_FIFTH));
//    }
//
//    @Test
//    public void shouldAlwaysReturnSameInstance() {
//        MajorKeySignature majorKeySignature = MajorKeySignature.F_SHARP;
//        KeyRelativeModality keyRelativeModality = KeyRelativeModality.MAJOR;
//
//        Key key = KeyFactory.getKey(majorKeySignature, keyRelativeModality);
//        Key key2 = KeyFactory.getKey(majorKeySignature, keyRelativeModality);
//
//        assertEquals(key, key2);
//    }
}
