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
    
    public boolean mergeSort(int lft, int rght, boolean type){
        //type == true if alphabetize, type == false if frequency
        if (rght > lft) {
            int mddl = (lft + rght)/2;
            this.mergeSort(lft, mddl, type);
            this.mergeSort(mddl+1, rght, type);
            this.merge(lft, mddl, rght, type);
        }
        return false;
    }
    
    public void merge(int lft, int mddl, int rght, boolean type){
        int ndx1 = lft;
        int ndx2 = mddl+1;
        word tmp;
        //System.out.println(ndx1 + " " + ndx2 + " " + rght);
        if (type) {//alphabetize
            while ((ndx1 < ndx2)&&(ndx2 <= rght)) {
                if (this.lstWrds.get(ndx1).alphabetize(this.lstWrds.get(ndx2)) < 0) {
                    ndx1++;
                } else if (this.lstWrds.get(ndx1).alphabetize(this.lstWrds.get(ndx2)) > 0) {
                    tmp = this.lstWrds.get(ndx2);
                    this.lstWrds.remove(ndx2);
                    this.lstWrds.add(ndx1, tmp);
                    ndx1++;
                    ndx2++;
                } else {
                    //this is where it will merge words that are the same
                }
            }
        } else {//frequency
            while ((ndx1 < ndx2)&&(ndx2 <= rght)) {
                if (this.lstWrds.get(ndx1).freqCompare(this.lstWrds.get(ndx2))) {
                    ndx1++;
                } else {
                    tmp = this.lstWrds.get(ndx2);
                    this.lstWrds.remove(ndx2);
                    this.lstWrds.add(ndx1, tmp);
                    ndx1++;
                    ndx2++;
                }
            }
        }
        System.out.println(this.listToString());
    }
    
    public ArrayList<word> topTenFrequency(){
        int sz = this.lstWrds.size()-1;
        this.mergeSort(0, sz, false);
        ArrayList<word> tptn = new ArrayList();
        for (int i = sz; (i > sz - 10) && (i >= 0); i--) {
            tptn.add(this.lstWrds.get(i));
        }
        return tptn;
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
