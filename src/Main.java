import RleModels.RleModel;

void main() {

    RleModel rleModel = new RleModel();

    String compressedValue = rleModel.compress("AAAAAAAAAAABBBBBB");
    System.out.println("Compressed Value: " + compressedValue);
    System.out.println(rleModel.deCompress(compressedValue));
}
