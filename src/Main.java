import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//    **To do : 과제 조건**
//        - 컴퓨터는 0과 9 사이의 서로 다른 숫자 3개를 무작위로 뽑습니다. (ex) 123, 759
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        //변수들...
        int randomNum1; //난수 123
        int randomNum2;
        int randomNum3;
        int getNum1; // 입력받은 수
        int getNum2;
        int getNum3;
        int strikeNum = 0, ballNum = 0;
        int gameCnt = 0;// 게임 카운트

//        1. 랜덤 숫자 만들기
        while (true) {
            while (true) {
                randomNum1 = random.nextInt(10);
                randomNum2 = random.nextInt(10);
                randomNum3 = random.nextInt(10);
                if (randomNum1 != randomNum2 && randomNum2 != randomNum3 && randomNum1 != randomNum3) {
                    System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
                    break;
                }
            }

            while (true) {
//        2. 한자리 숫자에 대해 볼, 스크라이크 판단 하는 부분 구현하기
                System.out.println("숫자 3개를 입력하세요 : ");
                String inputNum = sc.next();
                if (inputNum.length() != 3) {
                    System.out.println("숫자 3개를 정확히 입력해주세요! : ");
                    continue;
                }
                getNum1 = Character.getNumericValue(inputNum.charAt(0));
                getNum2 = Character.getNumericValue(inputNum.charAt(1));
                getNum3 = Character.getNumericValue(inputNum.charAt(2));
//                getNum2 = sc.nextInt();
//                getNum3 = sc.nextInt();
                System.out.println("다시한번 생각해보세요!");

                //스트라이크
                //볼
                strikeNum = 0;
                ballNum = 0;

                if (randomNum1 == getNum1) {
                    strikeNum++;
                }
                if (randomNum2 == getNum2) {
                    strikeNum++;
                }
                if (randomNum3 == getNum3) {
                    strikeNum++;
                }
                if (randomNum1 == getNum2 || randomNum1 == getNum3) {
                    ballNum++;
                }
                if (randomNum2 == getNum1 || randomNum2 == getNum3) {
                    ballNum++;
                }
                if (randomNum3 == getNum1 || randomNum3 == getNum2) {
                    ballNum++;
                }
//        3. 볼, 스트라이크를 표현하는 부분 구현하기
                gameCnt++;
                System.out.println("게임 수 : " + gameCnt + " / 결과 : " + strikeNum + "S" + ballNum + "B");
//        4. 게임 종료하는 부분 구현하기
                if (strikeNum == 3) {
                    System.out.println("정답입니다!!");
                    break;
                }
            }
            System.out.println("게임을 종료하시겠습니까? (Y/N)");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("Y")) {
                break;
            }
        }
        sc.close();
    }
}
