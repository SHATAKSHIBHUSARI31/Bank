to compile all the java files into class file at once
--> javac *.java
to run to main program 
--> java -cp . ATM
Why -cp . is Important?
Java runtime needs to know where to look for compiled class files.
By default, it sometimes fails with folders like OneDrive folders or renamed folders, especially on Windows.

-cp . tells it:
"Classpath = Current folder".
to delete the .class file which is generated 
--> del *.class
