package util;

import java.util.Base64;

public class Base64Decoder {

    public static String decode(String encodedText) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedText);
        return new String(decodedBytes);
    }
}
