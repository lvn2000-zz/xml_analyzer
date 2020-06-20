# HTML analyzer program
This program make possible to compare two pages ([origin] and [other]) using attributes
 of element with **id="make-everything-ok-button"** in [origin] html and  of finding
 of similar elements in other html.

 For using program need to type in console:

 **java -jar xml_analyzer <input_origin_file_path> <input_other_sample_file_path>**

For building program need to type in console in root folder following:

**sbt assembly**

After that you could find file of program **xml_analyzer.jar** in folder **/target/scala-2.12**

Or just use existing ready to use files in folder **/files** (you can find there of example of
[origin] and [other] html files too)

Example (from root folder of project):

**cd ./files**

**java -jar xml_analyzer.jar sample-0-origin.html sample-1-evil-gemini.html**
