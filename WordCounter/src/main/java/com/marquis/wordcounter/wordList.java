/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marquis.wordcounter;

import java.util.ArrayList;

/**
 *
 * @author marquis
 */
public class wordList {
    private ArrayList<word> lstWrds;
    
    public wordList() {
        this.lstWrds = new ArrayList<word>();
    }
    
    public wordList(ArrayList<word> lw) {
        this.lstWrds = lw;
    }
    
    public void setWordList(ArrayList<word> lw) {this.lstWrds = lw;}
    public ArrayList<word> getWordList(){return this.lstWrds;}
    
    public boolean enterWord(String ltr){//returns false if word is old, true if word is new
        word e = new word(ltr);
        if (this.lstWrds.size() == 1) {
            if (this.lstWrds.get(0).getLetters().compareTo(ltr) < 0) {
                this.lstWrds.add(e);
                return true;
            } else if (this.lstWrds.get(0).getLetters().compareTo(ltr) > 0) {
                System.out.println(ltr);
                this.lstWrds.add(0, e);
                return true;
            } else {
                this.lstWrds.get(0).incrementFrequency();
                return false;
            }
        } else if (this.lstWrds.isEmpty()) {
            this.lstWrds.add(e);
            return true;
        } else {
            int strt = 0;
            int nd = this.lstWrds.size();
            int mid = ((nd - strt) / 2) + strt;
        
            while (strt != nd) {
                if (this.lstWrds.get(mid).alphabetize(e) > 0) {
                    nd = mid;
                    mid = ((nd - strt) / 2) + strt;
                } else if (this.lstWrds.get(mid).alphabetize(e) < 0) {
                    strt = mid;
                    mid = ((nd - strt) / 2) + strt;
                } else {
                    this.lstWrds.get(mid).incrementFrequency();
                    return false;
                }//END IF ELSE BIT
                if (strt + 1 == nd) {
                    if (this.lstWrds.get(strt).alphabetize(e) > 0){
                        nd = strt;
                    } else if (this.lstWrds.get(strt).alphabetize(e) < 0) {
                        strt = nd;
                    } else {
                        this.lstWrds.get(strt).incrementFrequency();
                        return false;
                    }
                }// END IF
            }//END WHILE

            this.lstWrds.add(nd, e);
            return true;
        }//END ELSE
    }
    
    public boolean findWord(String lttrs){
        //finds lttrs in an alphabetized list
        return false;
    }
    
    public boolean alphabetizeList(){
        //alphabetizes the list
        return false;
    }
    
    public boolean frequencyList(){
        //sorts list by frequency
        return false;
    }
    
    public wordList topTenFrequency(){
        //returns top ten most frequent words
        return new wordList();
    }
    
    public String listToString(){
        String str = "A Word List:";
        int i = 1;
        for (word w : lstWrds){
            str += "\n" + i + " " + w.toString();
            i++;
        }
        return str;
    }
    
}
