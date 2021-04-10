package org.nerdcore.StackStudy;

public class SetOfStacks<T> {

    private int stackSize;
    private Stack<T>[] stackSet;

    public SetOfStacks(int stackSize) {
        this.stackSize = stackSize;
        stackSet = new Stack[1];
        stackSet[0] = new Stack<>();
    }

    public SetOfStacks(){
        this(10);
    }

    public void push(T data){
        if(stackSet[0].isFull(stackSize)){
            Stack<T>[] newStackSet = new Stack[stackSet.length+1];
            System.arraycopy(stackSet, 0, newStackSet, 1, stackSet.length);
            stackSet = newStackSet;
            stackSet[0] = new Stack<>();
        }
        stackSet[0].push(data);

    }

    public void report(){
        int i = 0;
        for(Stack<T> stack : stackSet){
            i++;
            System.out.printf("Stack %s :: ", i);
            stack.report();
        }
    }
}
