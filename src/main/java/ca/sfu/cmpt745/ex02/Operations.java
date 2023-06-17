package ca.sfu.cmpt745.ex02;

import org.apache.commons.math3.analysis.function.Add;

class Subtract1 implements Operation {
    public Subtract1(int[] target) {
        this.target = target;
    }
    int[] target;
    @Override
    public void run() {
        this.target[0] -= 1;
    }


}

class Add1 implements Operation {
    public Add1(int[] target) {
        this.target = target;
    }
    int[] target;
    @Override
    public void run() {
        this.target[0] += 1;
    }


}

class AddConstant implements Operation {
    int constant;
    int[] target;
    public AddConstant(int constant , int[] target) {
        this.target = target;
        this.constant = constant;
    }
    public AddConstant(int[] target){
        this.target = target;
    }

    @Override
    public void run() {
        this.target[0] += this.constant;
    }
}

public final class Operations {
    public static Operation createOperation(int code, int[] store) {
        switch(code) {
            case 0:
                return new Add1(store);
            case 1:
                return new Subtract1(store);
            case 2:
                return new AddConstant(17, store);
            default:
                throw new IllegalArgumentException("Invalid Operation selected: " + code);
        }

    }
}
