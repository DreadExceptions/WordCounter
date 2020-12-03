/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marquis.wordcounter;

/**
 *
 * @author marquis
 */
public class word {
    private String letters;
    private int length;
    private int syllables; //number of groups of a,e,i,o,u
    private int frequency;//number of times the word appears
    
    public word (String lttrs) {
    this.letters = lttrs;
    this.length = this.letters.length();
    this.syllables = 0;
    this.frequency = 1;
    this.setSyllables();
    }//end constructor
    
    public word (String lttrs, int lngth, int sllbls, int frqncy){
    this.letters = lttrs;
    this.length = lngth;
    this.syllables = sllbls;
    this.frequency = frqncy;
    }//end constructor
    
    public void setLetters(String lttrs) {this.letters = lttrs;}
    public void setLength() {this.length = letters.length();}
    public void setSyllables() {
        this.syllables = 0;
        for (int i = 0; i < this.length; i++){//iterate through word
            if ((letters.charAt(i) == 'a' || 
                    letters.charAt(i) == 'e' ||  
                    letters.charAt(i) == 'i' || 
                    letters.charAt(i) == 'o' ||
                    letters.charAt(i) == 'u' ||
                    letters.charAt(i) == 'y') && 
                    (((i+1) >= letters.length()) || (
                    letters.charAt(i+1) != 'a' &&
                    letters.charAt(i+1) != 'e' &&  
                    letters.charAt(i+1) != 'i' && 
                    letters.charAt(i+1) != 'o' &&
                    letters.charAt(i+1) != 'u' &&
                    letters.charAt(i+1) != 'y'))) {
                this.syllables++;
            }//end if
        }//end for loop to iterate through word
    }//end setSyllables
    public void setFrequency(int frqnc){this.frequency = frqnc;}
    
    public String getLetters() {return this.letters;}
    public int getLength() {return this.length;}
    public int getSyllables() {return this.syllables;}
    public int getFrequency() {return this.frequency;}
    
    public void incrementFrequency(){this.frequency++;}
    public void addFrequency(int frqnc){this.frequency += frqnc;}
    
    public int alphabetize(word diff){ //if "this" comes first, then false.
        return this.getLetters().compareTo(diff.getLetters());
        }
    
    public boolean freqCompare(word diff){
        if (this.getFrequency() > diff.getFrequency()) {
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public String toString(){
        return this.letters + " has " + this.length + " Letter(s) and " + this.syllables + 
                " Syllable(s) and occurs " + this.frequency + " time(s)";
    }
    
}
