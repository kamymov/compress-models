package RleModels.utils.deCompress;

import RleModels.dto.RleDto;

import java.util.ArrayList;
import java.util.Objects;

public class RleDeCompressUtils {
    private static void addToRleDtosList(ArrayList<RleDto> rleDtos, StringBuilder key, StringBuilder value) {
        if (!key.isEmpty() && !value.isEmpty()) {
            RleDto newRleValue = new RleDto();
            newRleValue.setKey(key.toString());
            newRleValue.setValue(Integer.valueOf(value.toString()));
            rleDtos.add(newRleValue);
            key.setLength(0);
            value.setLength(0);
        }
    }

    public static ArrayList<RleDto> convertToRleList(String compressedValue) {
        char[] compressChars = compressedValue.toCharArray();
        ArrayList<RleDto> rleDtos = new ArrayList<>();
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        for (char compressChar : compressChars) {
            if (Character.isDigit(compressChar)) {
                value.append(compressChar);
            } else {
                // Add to List prev values
                addToRleDtosList(rleDtos, key, value);
                key.append(compressChar);
            }
        }
        // Add to List last values
        addToRleDtosList(rleDtos, key, value);
        return rleDtos;
    }

    public static String convertToString(ArrayList<RleDto> rleDtos) {
        StringBuilder deCompressedValue = new StringBuilder();
        for (RleDto rleDto : rleDtos) {
            for (int i = 0; i < rleDto.getValue(); i++) {
                deCompressedValue.append(rleDto.getKey());
            }
        }
        return deCompressedValue.toString();
    }

}
