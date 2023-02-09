import java.util.Arrays;

public class Decoder {
    
    MainApp app = new MainApp();
    String[] refTable = app.getRefTable();

    // Decode method
    public String decode(String encodedText){
        String offsetChar = encodedText.substring(0, 1);
        int offsetShift = Arrays.asList(refTable).indexOf(offsetChar);
        String[] arrNew = new String[encodedText.length()-1];

        // If invalid offset char, then return concatenated offset plus original plaintext
        if(offsetShift == -1){
            return encodedText;
        }
        else{
            // Loop through and find out the new positions after being shifted by offset and assign to new String array
            // Starts at i = 1 to omit offset char being put into decoded string
            for(int i=1; i < encodedText.length(); i++){
                // If string has any whitespace, copy it over
                if(encodedText.charAt(i) == ' '){
                    arrNew[i-1] = " ";
                }

                // Any character not in the reference table will mapped back to the same character.
                else if(Arrays.asList(refTable).indexOf(encodedText.substring(i, i+1)) == -1){
                    arrNew[i-1] = encodedText.substring(i, i+1);
                }

                // If all the checks are good, perform the decoding and assign to new string array to return
                else{
                    int newPosition = Arrays.asList(refTable).indexOf(encodedText.substring(i, i+1))+offsetShift;
                    if(newPosition > refTable.length-1){
                        newPosition = newPosition - refTable.length;
                    }
                    String newChar = refTable[newPosition];
                    arrNew[i-1] = newChar;
                }
                
            }
        }

        return app.convertStringArrayToString(arrNew, "");
    }

}
