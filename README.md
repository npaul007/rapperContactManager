# rapperContactManager
A contact manager built for producers, artists and record company managers who need to contact other rap artists.

##How to use it:
  1. Clone the rapperContactManager repo
  2. Once downloaded, open the folder and open the RapArtistContactManagerGenerator.jar file
  3. Click the add rapper button to add a new rapper
  4. Click the remove rapper to remove a selected rapper
  5. Use the arrows to cycle through the rappers in the registry
  6. Click the open in browser button to view the xml doc in the browser


##How it works:  

  I am using java xml parsing libraries in order to read and modify
  the rapartists.xml file. I then manipulate that data through a java
  swing GUI. The xml file is then formatted to be viewed in
  alphabetical order by rapper name through the use of an XLST style sheet
  along with some bootstrap to make it look pretty. I also allow the capability for images to be
  shown in this xml doc, users can paste an image URL of a rapper for 
  the contact manager when they’re adding a new artist to the registry

