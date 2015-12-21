import com.sun.corba.se.spi.activation.Server;
import java.awt.Desktop;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.SAXException;

public class XMLGUI extends javax.swing.JFrame  {
    
    public int current = 0;

    
    public XMLGUI() throws Exception {
        initComponents();
        bootXMLDoc();
        setXMLInstance(current);
    }
    
    public Document bootXMLDoc() throws Exception{
        File fXmlFile = new File("rapartists.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile); 
        return doc;
    }
    
    public void setXMLInstance(int current) throws Exception {  
        Document doc = bootXMLDoc();

        doc.getDocumentElement().normalize(); 
        NodeList nList = doc.getElementsByTagName("artist");

        Node nNode = nList.item(current);
        Element eElement = (Element) nNode; 
        
        txtName.setText(eElement.getElementsByTagName("name").item(0).getTextContent());
        txtImgUrl.setText(eElement.getElementsByTagName("imgUrl").item(0).getTextContent());
        txtPhone.setText(eElement.getElementsByTagName("phone").item(0).getTextContent());
        txtRecordLabel.setText(eElement.getElementsByTagName("recordLabel").item(0).getTextContent());
    }
    
    public int getXMLRootLength() throws Exception{
        Document doc = bootXMLDoc(); 
        doc.getDocumentElement().normalize(); 
        NodeList nList = doc.getElementsByTagName("artist");
        int length =  nList.getLength();
        return length;
    }
    
    public void addNewXMLNode(String rapName, String imgUrl, String phoneNum, String recordLbl) throws Exception {
        Document document = bootXMLDoc();
        Element root = document.getDocumentElement();

        Element newArtist = document.createElement("artist");

        Element name = document.createElement("name");
        name.appendChild(document.createTextNode(rapName));
        newArtist.appendChild(name);
    
        Element imgLink = document.createElement("imgUrl");
        imgLink.appendChild(document.createTextNode(imgUrl));
        newArtist.appendChild(imgLink);
    
        Element phone = document.createElement("phone");
        phone.appendChild(document.createTextNode(phoneNum));
        newArtist.appendChild(phone);
        
        Element recordLabel = document.createElement("recordLabel");
        recordLabel.appendChild(document.createTextNode(recordLbl));
        newArtist.appendChild(recordLabel);
        
        root.appendChild(newArtist);

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("rapartists.xml");
        transformer.transform(source, result);
    }
    
    public void deleteXMLNode(int current) throws Exception{
        Document doc = bootXMLDoc();
        
        Node n = doc.getDocumentElement();
        
        NodeList nList = doc.getElementsByTagName("artist");
        Node nNode = nList.item(current);
        
        n.removeChild(nNode);
        
        DOMSource source = new DOMSource(doc);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("rapartists.xml");
        transformer.transform(source, result);     
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtImgUrl = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRecordLabel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        incCurrent = new javax.swing.JButton();
        decCurrent = new javax.swing.JButton();
        addRapper = new javax.swing.JButton();
        openInBrowser = new javax.swing.JButton();
        removeRapper = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 220));
        setResizable(false);

        txtName.setEditable(false);

        jLabel1.setText("Name");

        jLabel2.setText("Image Url");

        txtImgUrl.setEditable(false);

        jLabel3.setText("Phone #");

        txtPhone.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Arial Hebrew Scholar", 1, 18)); // NOI18N
        jLabel4.setText("Rap Artist Contact Manager");

        txtRecordLabel.setEditable(false);

        jLabel5.setText("Record Label");

        incCurrent.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        incCurrent.setText(">");
        incCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incCurrentActionPerformed(evt);
            }
        });

        decCurrent.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        decCurrent.setText("<");
        decCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decCurrentActionPerformed(evt);
            }
        });

        addRapper.setText("Add Rapper");
        addRapper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRapperActionPerformed(evt);
            }
        });

        openInBrowser.setText("Open In Browser");
        openInBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openInBrowserActionPerformed(evt);
            }
        });

        removeRapper.setText("Remove Rapper");
        removeRapper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRapperActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtImgUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(decCurrent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(incCurrent))
                            .addComponent(txtRecordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addRapper)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeRapper)
                        .addGap(38, 38, 38)
                        .addComponent(openInBrowser)
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImgUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRecordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(incCurrent)
                    .addComponent(decCurrent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRapper)
                    .addComponent(openInBrowser)
                    .addComponent(removeRapper))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void decCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decCurrentActionPerformed
       if(current==0){
           return;
       }else{
           current-=1;
       }
        try {
            setXMLInstance(current);
        } catch (Exception ex) {
            Logger.getLogger(XMLGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_decCurrentActionPerformed

    private void incCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incCurrentActionPerformed
        try {
            if(current==getXMLRootLength()-1){
                return;
            }else{
                current+=1;
            }} catch (Exception ex) {
            Logger.getLogger(XMLGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setXMLInstance(current);
        } catch (Exception ex) {
            Logger.getLogger(XMLGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_incCurrentActionPerformed

    private void addRapperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRapperActionPerformed
     String name = JOptionPane.showInputDialog("Please input the name of the rapper");
     String imageUrl  = JOptionPane.showInputDialog("Please input the image url of the rapper "
             + "(You can copy the url from an image on google)");;
     String phoneNumber  = JOptionPane.showInputDialog("Please input the phone number of the rapper");;
     String recordLabel  = JOptionPane.showInputDialog("Please input the record label of the rapper");;
     
     if(name.length() == 0 || imageUrl.length() == 0 || phoneNumber.length() == 0 || recordLabel.length() == 0){
         JOptionPane.showMessageDialog(null, "Please fill all inputs!");
     }else{
         try {
             addNewXMLNode(name,imageUrl,phoneNumber,recordLabel);
         } catch (Exception ex) {
             Logger.getLogger(XMLGUI.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    }//GEN-LAST:event_addRapperActionPerformed

    private void openInBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openInBrowserActionPerformed
        try {
            File htmlFile = new File("rapartists.xml");
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException ex) {
            Logger.getLogger(XMLGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_openInBrowserActionPerformed

    private void removeRapperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRapperActionPerformed
        String rapName = txtName.getText();
        int areYouSure = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete "+rapName+" from"
                + " the registry? ");
        if(areYouSure == JOptionPane.YES_OPTION){
            try {
                deleteXMLNode(current);
                setXMLInstance(current);
            } catch (Exception ex) {
                Logger.getLogger(XMLGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_removeRapperActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XMLGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XMLGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XMLGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XMLGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new XMLGUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(XMLGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRapper;
    private javax.swing.JButton decCurrent;
    private javax.swing.JButton incCurrent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton openInBrowser;
    private javax.swing.JButton removeRapper;
    private javax.swing.JTextField txtImgUrl;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtRecordLabel;
    // End of variables declaration//GEN-END:variables
}
