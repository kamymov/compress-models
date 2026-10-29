package RleModels;

import RleModels.dto.RleDto;
import RleModels.utils.compress.RleModelCompressUtils;
import RleModels.utils.deCompress.RleDeCompressUtils;

import java.util.ArrayList;

public class RleModel {

    public String compress(String value) {
        ArrayList<RleDto> arrayValues = RleModelCompressUtils.convertToRleDto(value);
        return RleModelCompressUtils.convertToString(arrayValues);
    }

    public String deCompress(String compressed) {
        ArrayList<RleDto> rleDtos = RleDeCompressUtils.convertToRleList(compressed);
        return RleDeCompressUtils.convertToString(rleDtos);
    }
}
