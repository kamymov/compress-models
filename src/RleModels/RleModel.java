package RleModels;

import RleModels.dto.RleDto;
import RleModels.utils.compress.RleModelCompressUtils;

import java.util.ArrayList;

public class RleModel {

    public String compress(String value) {
        ArrayList<RleDto> arrayValues = RleModelCompressUtils.convertToRleDto(value);
        return RleModelCompressUtils.convertToString(arrayValues);
    }

    public String deCompress(String encoded) {

        return encoded;
    }
}
