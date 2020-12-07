/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NeuralNet;

import java.util.ArrayList;

/**
 *
 * @author marquis
 */
public class Nodes {
    
    ArrayList<Double> weights;
    double val;
    
    /*
    val is the value of the node.
    nodes is an array of weights that correspond to the next layer. 
    */
    
    public Nodes (ArrayList<Double> nc, double vl) {
        this.weights = nc;
        this.val = vl;
    }
    
}