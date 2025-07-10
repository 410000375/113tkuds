
public class StudentGradeSystem {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};

        char[] grades = new char[scores.length];
        int countA = 0, countB = 0, countC = 0, countD = 0;
        int sum = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            sum += score;

            if (score >= 90) {
                grades[i] = 'A';
                countA++;
            } else if (score >= 80) {
                grades[i] = 'B';
                countB++;
            } else if (score >= 70) {
                grades[i] = 'C';
                countC++;
            } else {
                grades[i] = 'D';
                countD++;
            }

            if (score > max) {
                max = score;
                maxIndex = i;
            }
            if (score < min) {
                min = score;
                minIndex = i;
            }
        }

        double average = (double) sum / scores.length;
        int countAboveAverage = 0;
        for (int score : scores) {
            if (score > average) {
                countAboveAverage++;
            }
        }
        double aboveRate = (double) countAboveAverage / scores.length * 100;

        System.out.println("學生成績報告");
        System.out.println("──────────────────────────────────────");
        System.out.printf("全班平均分數: %.2f\n", average);
        System.out.printf("高於平均人數比例: %.2f%%\n", aboveRate);
        System.out.println("最高分: " + max + "（學生編號 " + maxIndex + "）");
        System.out.println("最低分: " + min + "（學生編號 " + minIndex + "）");
        System.out.println("各等級人數：A=" + countA + ", B=" + countB + ", C=" + countC + ", D=" + countD);
        System.out.println("──────────────────────────────────────");
        System.out.printf("%-10s%-10s%-10s\n", "學生編號", "分數", "等級");
        System.out.println("──────────────────────────────────────");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d%-10d%-10c\n", i, scores[i], grades[i]);
        }
        System.out.println("──────────────────────────────────────");
    }
    
}
