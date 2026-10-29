package RleModels.utils.compress;

import RleModels.dto.RleDto;

import java.util.ArrayList;

public class RleModelCompressUtils {

    public static ArrayList<RleDto> convertToRleDto(String value) {
        char[] characters = value.toCharArray();
        ArrayList<RleDto> rleDtos = new ArrayList<RleDto>();
        for (char chars : characters) {
            if (!rleDtos.isEmpty() && rleDtos.getLast().getKey().equals(String.valueOf(chars))) {
                RleDto lastDto = rleDtos.getLast();
                int index = rleDtos.indexOf(lastDto);
                lastDto.increaseValue();
                rleDtos.set(index, lastDto);
            } else {
                RleDto newRleDto = new RleDto();
                newRleDto.setKey(String.valueOf(chars));
                newRleDto.setValue(1);
                rleDtos.add(newRleDto);
            }
        }
        return rleDtos;
    }

    public static String convertToString(ArrayList<RleDto> rleDtos) {
        StringBuilder convertedValue = new StringBuilder();
        for (RleDto rleDto : rleDtos) {
            convertedValue.append(String.format("%s%s", rleDto.getKey(), rleDto.getValue()));
        }
        return convertedValue.toString();
    }

}
