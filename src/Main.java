import RleModels.RleModel;

void main() {

    String compressedValue = RleModel.compress("AAAAAAAAAAABBBBBB");
    System.out.println("Compressed Value: " + compressedValue);
    System.out.println(RleModel.deCompress(compressedValue));
}
