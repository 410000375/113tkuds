

    import java.util.Scanner;

class StudentGradeManager {
    private static final int MAX_STUDENTS = 100;
    private static String[] studentNames = new String[MAX_STUDENTS];
    private static int[][] grades = new int[MAX_STUDENTS][5]; // 假設有5科
    private static String[] subjectNames = {"國文", "英文", "數學", "物理", "化學"};
    private static int studentCount = 0;
    
    /**
     * 新增學生
     */
    static boolean addStudent(String name, int[] studentGrades) {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("錯誤：學生人數已達上限");
            return false;
        }
        
        if (studentGrades.length != subjectNames.length) {
            System.out.printf("錯誤：成績數量不正確，應為 %d 科\n", subjectNames.length);
            return false;
        }
        
        // 驗證成績範圍
        for (int i = 0; i < studentGrades.length; i++) {
            if (studentGrades[i] < 0 || studentGrades[i] > 100) {
                System.out.printf("錯誤：%s 成績 %d 超出有效範圍 [0, 100]\n", 
                                subjectNames[i], studentGrades[i]);
                return false;
            }
        }
        
        studentNames[studentCount] = name;
        System.arraycopy(studentGrades, 0, grades[studentCount], 0, studentGrades.length);
        studentCount++;
        
        System.out.printf("成功新增學生：%s\n", name);
        return true;
    }
    
    /**
     * 計算學生總分和平均分
     */
    static void calculateStudentStats(int studentIndex) {
        if (studentIndex < 0 || studentIndex >= studentCount) {
            System.out.println("錯誤：學生索引無效");
            return;
        }
        
        String name = studentNames[studentIndex];
        int[] studentGrades = grades[studentIndex];
        
        int total = 0;
        for (int grade : studentGrades) {
            total += grade;
        }
        
        double average = (double) total / subjectNames.length;
        
        System.out.printf("\n=== %s 的成績統計 ===\n", name);
        for (int i = 0; i < subjectNames.length; i++) {
            System.out.printf("%-4s：%3d 分\n", subjectNames[i], studentGrades[i]);
        }
        System.out.printf("總分：%d 分\n", total);
        System.out.printf("平均：%.2f 分\n", average);
        System.out.printf("等第：%s\n", getGradeLevel(average));
    }
    
    /**
     * 根據平均分數判定等第
     */
    static String getGradeLevel(double average) {
        if (average >= 90) return "優秀 (A)";
        else if (average >= 80) return "良好 (B)";
        else if (average >= 70) return "尚可 (C)";
        else if (average >= 60) return "及格 (D)";
        else return "不及格 (F)";
    }
    
    /**
     * 計算各科目的統計資訊
     */
    static void calculateSubjectStats() {
        if (studentCount == 0) {
            System.out.println("目前沒有學生資料");
            return;
        }
        
        System.out.println("\n=== 各科統計資訊 ===");
        
        for (int subject = 0; subject < subjectNames.length; subject++) {
            int[] subjectGrades = new int[studentCount];
            
            // 收集該科目的所有成績
            for (int student = 0; student < studentCount; student++) {
                subjectGrades[student] = grades[student][subject];
            }
            
            // 計算統計資料
            int sum = 0;
            int min = subjectGrades[0];
            int max = subjectGrades[0];
            
            for (int grade : subjectGrades) {
                sum += grade;
                if (grade < min) min = grade;
                if (grade > max) max = grade;
            }
            
            double average = (double) sum / studentCount;
            
            // 計算及格率
            int passCount = 0;
            for (int grade : subjectGrades) {
                if (grade >= 60) passCount++;
            }
            double passRate = (double) passCount / studentCount * 100;
            
            System.out.printf("\n%s：\n", subjectNames[subject]);
            System.out.printf("  平均分數：%.2f\n", average);
            System.out.printf("  最高分：%d\n", max);
            System.out.printf("  最低分：%d\n", min);
            System.out.printf("  及格率：%.1f%% (%d/%d)\n", passRate, passCount, studentCount);
        }
    }
    
    /**
     * 找出班級前三名
     */
    static void findTopThreeStudents() {
        if (studentCount == 0) {
            System.out.println("目前沒有學生資料");
            return;
        }
        
        // 計算每個學生的平均分數
        double[] averages = new double[studentCount];
        for (int i = 0; i < studentCount; i++) {
            int sum = 0;
            for (int j = 0; j < subjectNames.length; j++) {
                sum += grades[i][j];
            }
            averages[i] = (double) sum / subjectNames.length;
        }
        
        // 建立索引陣列用於排序
        Integer[] indices = new Integer[studentCount];
        for (int i = 0; i < studentCount; i++) {
            indices[i] = i;
        }
        
        // 使用插入排序按平均分數排序索引
        for (int i = 1; i < indices.length; i++) {
            Integer key = indices[i];
            int j = i - 1;
            
            while (j >= 0 && averages[indices[j]] < averages[key]) {
                indices[j + 1] = indices[j];
                j--;
            }
            indices[j + 1] = key;
        }
        
        System.out.println("\n=== 班級前三名 ===");
        int displayCount = Math.min(3, studentCount);
        
        for (int i = 0; i < displayCount; i++) {
            int studentIndex = indices[i];
            System.out.printf("第 %d 名：%s (平均分數：%.2f)\n", 
                            i + 1, studentNames[studentIndex], averages[studentIndex]);
        }
    }
    
    /**
     * 顯示所有學生列表
     */
    static void listAllStudents() {
        if (studentCount == 0) {
            System.out.println("目前沒有學生資料");
            return;
        }
        
        System.out.println("\n=== 學生列表 ===");
        System.out.printf("%-3s %-10s", "編號", "姓名");
        for (String subject : subjectNames) {
            System.out.printf(" %-4s", subject);
        }
        System.out.println(" 平均");
        System.out.println("------------------------------------------------");
        
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%-3d %-10s", i + 1, studentNames[i]);
            
            int sum = 0;
            for (int j = 0; j < subjectNames.length; j++) {
                System.out.printf(" %-4d", grades[i][j]);
                sum += grades[i][j];
            }
            
            double average = (double) sum / subjectNames.length;
            System.out.printf(" %.2f\n", average);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== 學生成績管理系統 ===");
        System.out.println("功能：管理學生的五科成績（國文、英文、數學、物理、化學）");
        
        // 預先輸入一些測試資料
        addStudent("王小明", new int[]{85, 92, 78, 88, 91});
        addStudent("李小華", new int[]{79, 85, 82, 75, 88});
        addStudent("張小美", new int[]{92, 88, 95, 91, 89});
        addStudent("陳小強", new int[]{67, 72, 69, 78, 75});
        addStudent("林小雅", new int[]{88, 91, 87, 85, 92});
        
        while (true) {
            System.out.println("\n=== 主選單 ===");
            System.out.println("1. 新增學生");
            System.out.println("2. 查看學生成績");
            System.out.println("3. 顯示所有學生");
            System.out.println("4. 各科統計");
            System.out.println("5. 班級前三名");
            System.out.println("0. 離開");
            System.out.print("請選擇功能：");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗換行符
            
            switch (choice) {
                case 1:
                    System.out.print("請輸入學生姓名：");
                    String name = scanner.nextLine();
                    
                    int[] newGrades = new int[subjectNames.length];
                    for (int i = 0; i < subjectNames.length; i++) {
                        System.out.printf("請輸入 %s 成績：", subjectNames[i]);
                        newGrades[i] = scanner.nextInt();
                    }
                    scanner.nextLine(); // 消耗換行符
                    
                    addStudent(name, newGrades);
                    break;
                    
                case 2:
                    if (studentCount == 0) {
                        System.out.println("目前沒有學生資料");
                        break;
                    }
                    listAllStudents();
                    System.out.print("請輸入學生編號：");
                    int studentNum = scanner.nextInt();
                    if (studentNum >= 1 && studentNum <= studentCount) {
                        calculateStudentStats(studentNum - 1);
                    } else {
                        System.out.println("無效的學生編號");
                    }
                    break;
                    
                case 3:
                    listAllStudents();
                    break;
                    
                case 4:
                    calculateSubjectStats();
                    break;
                    
                case 5:
                    findTopThreeStudents();
                    break;
                    
                case 0:
                    System.out.println("感謝使用學生成績管理系統！");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("無效的選項，請重新選擇");
            }
        }
    }
}

