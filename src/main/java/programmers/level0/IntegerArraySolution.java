package programmers.level0;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class IntegerArraySolution {
    public int[][] solution(int n) {
        int[][] answer = init(n);
        answer = setValues(IntArrayCommand.COLUMN_FORWARD, answer, n);
        return answer;
    }

    int[][] init(int n){
        int[][] values = new int[n][n];
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                values[row][col] = 0;
            }
        }
        return values;
    }

    int[][] setValues(IntArrayCommand command, int[][] values, int n){
        int value = 1;
        int max = n * n;
        int currentRow = 0;
        int currentCol = 0;

        while(value <= max){
            System.out.println("value="+value+", row="+currentRow+", col="+currentCol+", command="+command);
            values[currentRow][currentCol] = value;

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
                currentRow += command.getAddRow();
                currentCol += command.getAddCol();
            }
            value++;
        }
        return values;
    }

    void print(int[][] values, int n){
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                System.out.print(values[row][col]+", ");
            }
            System.out.println();
        }
    }
}

enum IntArrayCommand{
    COLUMN_FORWARD(0, 1), //[][+1]
    ROW_FORWARD(1, 0), //[+1][]
    COLUMN_BACK(0, -1), //[][-1]
    ROW_BACK(-1, 0); //[-1][]

    private int row;
    private int col;

    IntArrayCommand(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getAddRow(){
        return this.row;
    }

    public int getAddCol(){
        return this.col;
    }

    public IntArrayCommand next(){
        List<IntArrayCommand> allCommands = Arrays.stream(values()).collect(Collectors.toList());
        int currentIndex = allCommands.indexOf(this);
        if((currentIndex + 1) >= allCommands.size()){
            return allCommands.get(0);
        }else{
            return allCommands.get(currentIndex + 1);
        }
    }
}
