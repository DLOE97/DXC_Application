import java.util.Scanner;
import java.util.Arrays;

public class MainApp {

    private static String[] refTable = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                        "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                         "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "(", ")", "*", "+", ",", "-", ".", "/"};

    public String[] getRefTable() {
        return refTable;
    }

    public static void main(String[] args) throws Exception {
        // Get plain text input
        Scanner plainTextScan = new Scanner(System.in);  
        System.out.println("Type in a plaintext for encoding/decoding (Text will be converted to upper case subsequently automatically):");
        String plainText = plainTextScan.nextLine();

        // Get and print out reference table to select from
        System.out.println(Arrays.toString(refTable));
        System.out.println("Next, choose any character from the reference table printed above:");
        String offsetChar = plainTextScan.nextLine();  // Read user input
        plainTextScan.close();

        // Concat offset character to plain text and pass to encode method
        String concatText = offsetChar.toUpperCase() + plainText.toUpperCase();
        Encoder encoder = new Encoder();
        String encodedText = encoder.encode(concatText);
        Decoder decoder = new Decoder();
        String decodedText = decoder.decode(encodedText);
        System.out.println("Encoded String: " + encodedText);
        System.out.println("Decoded String: " + decodedText);
    }

    public String convertStringArrayToString(String[] strArr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr)
			sb.append(str).append(delimiter);
		return sb.substring(0, sb.length());
	}
}
