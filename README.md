**For Assessment 1 - Encoder Decoder, simply run the MainApp.java file.**

Step 1) Upon running the program, you will be prompted to type in any string 

Step 2) Submit selection by hitting the 'Enter' key

Step 3) Select a character to be used as the offset character

Step 4) Submit selection by hitting the 'Enter' key

Step 5) The encoded and thereafter decoded strings will be printed out automatically

<br><br><br>

**For Assessment 2 - LoginApp**

Step 1) Download the Dump20230209.sql data dump into MySQL Workbench under Server -> Data Import -> Import from Self-Contained File -> Select dump file -> Start Import

Step 2) Edit lines 125 to 128 of LoginApp.java accordingly to insert credentials of mysql url, user and password (default set is root) for connectivity.
     
Step 3) Make sure the appropriate mysql connector librarie(s) are present inside the Java Project
Step 4) Run the LoginApp.java

The two accounts which are meant to be in the data dump are (case sensitive):
1) User: admin, Password: admin123, Role: Manager
2) User: bobby, Password: 123, Role: User

Any other account combinations not matching either of these will result in an error being printed 
