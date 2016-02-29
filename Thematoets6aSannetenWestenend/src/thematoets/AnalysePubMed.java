/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thematoets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;

/**
 *
 * @author Sanne ten Westenend
 */
public class AnalysePubMed implements Comparable {

    private ArrayList<String> organismName = new ArrayList<String>();
    private ArrayList<String> taxId = new ArrayList<String>();
    private ArrayList<String> taxId2 = new ArrayList<String>();
    private ArrayList<String> geneId = new ArrayList<String>();
    private ArrayList<String> pubmedId = new ArrayList<String>();

    public AnalysePubMed() {
        readFile();
        readFile2();

    }

    public void readFile() {
        try {
            String filePath = "C:\\Users\\sanne\\Documents\\Thematoets6aGitHub\\taxID_to_organism_names2.txt";
            HashMap<String, String> map = new HashMap<>();

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                //String[] parts = line.split(";", 2);        //splits de regel op ; bij .csv 
                String[] parts = line.split("\t", 2);       //splits de regel op tab bij .txt    
                if (parts.length >= 2) {
                    String key = parts[0];          //geeft het tax-id
                    String value = parts[1];        //geeft het organisme
                    map.put(key, value);
                } else {
                    System.out.println("Deze regel klopt niet: " + line);
                }
            }

            for (String key : map.keySet()) {
                //System.out.println(key + "\t" + map.get(key));     //print het tax-id met het organisme
                //System.out.println(map.get(key));                  //print organismen
                String tax = key;
                String org = map.get(key);

                //System.out.println(tax); //print tax-id
                //System.out.println(org); //print het organisme
                organismName.add(org);
                taxId.add(tax);

                Collections.sort(organismName);
                Collections.sort(taxId);
            }

            reader.close();
        } catch (FileNotFoundException Exception) {

        } catch (IOException Exception) {

        }

    }

    public ArrayList<String> getOrgansimName() {
        return organismName;
    }

    public ArrayList<String> getTaxId() {
        return taxId;
    }

    public void readFile2() {
        try {
            String filePath = "C:\\Users\\sanne\\Documents\\Thematoets6aGitHub\\gene2pubmed2.txt";
            HashMap<String, String> map = new HashMap<>();

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                //String[] parts = line.split(";", 2);        //splits de regel op ; bij .csv 
                String[] parts = line.split("\t");      //splits de regel op tab bij .txt    
                if (parts.length >= 2) {
                    String key = parts[0];          //geeft het nummer
                    String value = parts[1];        //geeft het organisme
                    String value2 = parts[2];
                    map.put(key, value2);

                } else {
                    System.out.println("Deze regel klopt niet: " + line);
                }

                for (String key : map.keySet()) {

                    String taxid2 = key;
                    String pubmed = map.get(key);

                    pubmedId.add(pubmed);
                    taxId2.add(taxid2);

                }
            }
            reader.close();
        } catch (FileNotFoundException Exception) {

        } catch (IOException Exception) {

        }

    }

    public ArrayList<String> getPubMedId() {
        return pubmedId;
    }


    @Override
    public int compareTo(Object t
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
