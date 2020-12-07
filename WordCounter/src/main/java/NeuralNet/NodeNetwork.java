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
public class NodeNetwork {
    ArrayList<Nodes> layerIn;
    ArrayList<Nodes> layerA;
    ArrayList<Nodes> layerB;
    ArrayList<Nodes> layerC;
    ArrayList<Nodes> layerOut;
    
    public NodeNetwork (ArrayList<Nodes> in, ArrayList<Nodes> a, ArrayList<Nodes> b, 
            ArrayList<Nodes> c, ArrayList<Nodes> out) {
        this.layerIn = in;
        this.layerA = a;
        this.layerB = b;
        this.layerC = c;
        this.layerOut = out;
    }
}
