package programmers.level0;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/181832
public class IntegerArray {
    public static void main(String[] args){
        Answer answer = new Answer(10);
        answer.init();
        answer.call(ArrayCommand.COLUMN_FORWARD);
        answer.print();
    }
}

class Answer{
    int[][] values;
    int n = 0;
    Answer(int n){
        this.n = n;
        this.values = new int[n][n];
    }

    void init(){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                values[row][col] = 0;
            }
        }
    }

    void call(ArrayCommand command){
        int value = 1;
        int max = this.n * this.n;
        int currentRow = 0;
        int currentCol = 0;

        while(value <= max){
            System.out.println("1) value="+value+", row="+currentRow+", col="+currentCol+", command="+command);
            values[currentRow][currentCol] = value;

            //System.out.println("2) value="+value+", row="+currentRow+", col="+currentCol+", command="+command);
            // 인덱스가 벗어나면 다음으로
            if((currentRow + command.getAddRow()) >= n ||
                    (currentCol + command.getAddCol()) >= n ||
                    (currentRow + command.getAddRow()) < 0 ||
                    (currentCol + command.getAddCol()) < 0){
                command = command.next();
                currentRow += command.getAddRow();
                currentCol += command.getAddCol();
            }else if(values[currentRow + command.getAddRow()][currentCol + command.getAddCol()] != 0){
                command = command.next();
                currentRow += command.getAddRow();
                currentCol += command.getAddCol();
            }else{
                //값이 있을 때 예외 처리가 안되서 그런듯
                currentRow += command.getAddRow();
                currentCol += command.getAddCol();
            }
            value++;
        }
    }

    void print(){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                System.out.print(values[row][col]+", ");
            }
            System.out.println();
        }
    }
}

enum ArrayCommand{
    COLUMN_FORWARD(0, 1), //[][+1]
    ROW_FORWARD(1, 0), //[+1][]
    COLUMN_BACK(0, -1), //[][-1]
    ROW_BACK(-1, 0); //[-1][]

    private int row;
    private int col;

    ArrayCommand(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getAddRow(){
        return this.row;
    }

    public int getAddCol(){
        return this.col;
    }

    public ArrayCommand next(){
        List<ArrayCommand> allCommands = Arrays.stream(values()).collect(Collectors.toList());
        int currentIndex = allCommands.indexOf(this);
        if((currentIndex + 1) >= allCommands.size()){
            return allCommands.get(0);
        }else{
            return allCommands.get(currentIndex + 1);
        }
    }
}