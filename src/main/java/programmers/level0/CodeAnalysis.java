package programmers.level0;

public class CodeAnalysis {
    public static void main(String[] args) {
        CodeAnalysis_Solution codeAnalysisSolution = new CodeAnalysis_Solution();
        String result = codeAnalysisSolution.solution("abc1abc1abc");
        System.out.println(result);
    }
}


class CodeAnalysis_Solution {
    private int mode = 0;
    private String[] codeArray;
    public String solution(String code) {
        codeArray = code.split("");
        StringBuilder result = new StringBuilder();
        for(int i=0; i<codeArray.length; i++){
            String codeRaw = codeArray[i];
            if("1".equals(codeRaw)){
                changeMode();
            }else{
                if(isAppend(i)){
                    result.append(codeRaw);
                }
            }
        }
        String answer = result.toString().isBlank() ? "EMPTY" : result.toString();
        return answer;
    }


    private void changeMode(){
        if(mode == 0){
            mode++;
        }else{
            mode--;
        }
    }

    private boolean isOdd(int idx){
        return idx % 2 == 0 ? false : true;
    }
    private boolean isAppend(int idx){
        if(mode == 0 && !isOdd(idx)){
            return true;
        }else if(mode == 1 && isOdd(idx)){
            return true;
        }
        return false;
    }
}