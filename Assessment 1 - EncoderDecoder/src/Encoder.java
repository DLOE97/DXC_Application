import java.util.Arrays;

public class Encoder {

    MainApp app = new MainApp();
    String[] refTable = app.getRefTable();

    // Encode method
    public String encode(String plainText){
        String offsetChar = plainText.substring(0, 1);
        int offsetShift = Arrays.asList(refTable).indexOf(offsetChar);
        String[] arrNew = new String[plainText.length()];

        // If invalid offset char, then return concatenated offset plus original plaintext
        if(offsetShift == -1){
            return plainText;
        }
        else{
            //Keep offsetchar as first character
            arrNew[0] = offsetChar;

            //Loop through and find out the new positions after being shifted by offset and assign to new String array
            for(int i=1; i < plainText.length(); i++){
                // If string has any whitespace, copy it over
                if(plainText.charAt(i) == ' '){
                    arrNew[i] = " ";
                }

                // Any character not in the reference table will mapped back to the same character.
                else if(Arrays.asList(refTable).indexOf(plainText.substring(i, i+1)) == -1){
                    arrNew[i] = plainText.substring(i, i+1);
                }

                // If all the checks are good, perform the encoding and assign to new string array to return
                else{
                    int newPosition = Arrays.asList(refTable).indexOf(plainText.substring(i, i+1))-offsetShift;
                    if(newPosition < 0){
                        newPosition = refTable.length + newPosition;
                    }
                    String newChar = refTable[newPosition];
                    arrNew[i] = newChar;
                }
                
            }
        }

        return app.convertStringArrayToString(arrNew, "");
    }
}
