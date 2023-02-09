**For Assessment 2 - LoginApp**

Step 1) Download the Dump20230209.sql data dump into MySQL Workbench under Server -> Data Import -> Import from Self-Contained File -> Select dump file -> Start Import

Step 2) Edit lines 125 to 128 of LoginApp.java accordingly to insert credentials of mysql url, user and password (default set is root) for connectivity.
     
Step 3) Make sure the appropriate mysql connector librarie(s) are present inside the Java Project
Step 4) Run the LoginApp.java

The two accounts which are meant to be in the data dump are (case sensitive):
1) User: admin, Password: admin123, Role: Manager
2) User: bobby, Password: 123, Role: User

Any other account combinations not matching either of these will result in an error being printed 
