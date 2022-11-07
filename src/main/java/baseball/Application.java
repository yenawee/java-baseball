package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }
}

class Computer {
    List<Integer> pickRandomNumber(){
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3){
            int number = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(number)){
                answer.add(number);
            }
        }
        return answer;
    }
}

class User {
    public static int INPUT_LENGTH = 3;
    public static List<Integer> getInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() > INPUT_LENGTH){
            throw new IllegalArgumentException();
        }
        for (int idx = 0; idx < INPUT_LENGTH; idx++){
            if (input.charAt(idx) < '1' || input.charAt(idx) > '9'){
                throw new IllegalArgumentException();
            }
        }
        List<Integer> inputNum = new ArrayList<>();
        for (int idx = 0; idx < INPUT_LENGTH; idx++){
            inputNum.add(input.charAt(idx) -'0');
        }
        int num1 = inputNum.get(0);
        int num2 = inputNum.get(1);
        int num3 = inputNum.get(2);
        if (num1 == num2 || num2 == num3 || num1 == num3){
            throw new IllegalArgumentException();
        }
        return inputNum;
    }

}

class game {
    public static int ball;
    public static int strike;

    public void strike(List<Integer> input, List<Integer> answer){
        for (int idx = 0; idx < User.INPUT_LENGTH; idx++){
            if (input.get(idx) == answer.get(idx)){
                strike++;
            }
        }
    }

    public void ball(List<Integer> input, List<Integer> answer){
        int idx = 0;
        for (int Number : input){
            if (answer.contains(Number) && answer.indexOf(Number) != idx){
                ball++;
            }
            idx++;
        }
    }

}

class print {
    static void nothing(){
        System.out.println("낫싱");
    }

    static void threeStrike(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static void result(int ball, int strike){
        if (strike == 3) {
            print.threeStrike();
            return ;
        }
        if (ball == 0 && strike == 0){
            print.nothing();
            return ;
        }
        if (ball > 0){
            System.out.print(ball + "볼 ");
        }
        if (strike > 0){
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println();
        return ;
    }
}
