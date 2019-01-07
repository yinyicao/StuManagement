package cn.cqut.yyc.entity;

/**
 * @ClassName Student
 * @Description TODO
 * @Author yinyicao
 * @DateTime 2019/1/4 9:12
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class Student {


    private String studentId;
    private String studentName;
    private Integer studentAge;
    private String studentGender;
    /**
     * 学院
     */
    private Integer studentInstitute;
    /**
     * 入学成绩
     */
    private Integer studentEnterScore;
    /**
     * 政治面貌
     */
    private String studentPoliticalStatus;
    /**
     * 籍贯
     */
    private String studentHomeplace;

    public Student() {
        super();
    }

    public Student(String studentId, String studentName, Integer studentAge, String studentGender, Integer studentInstitute, Integer studentEnterScore, String studentPoliticalStatus, String studentHomeplace) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.studentInstitute = studentInstitute;
        this.studentEnterScore = studentEnterScore;
        this.studentPoliticalStatus = studentPoliticalStatus;
        this.studentHomeplace = studentHomeplace;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Integer getStudentInstitute() {
        return studentInstitute;
    }

    public void setStudentInstitute(Integer studentInstitute) {
        this.studentInstitute = studentInstitute;
    }

    public Integer getStudentEnterScore() {
        return studentEnterScore;
    }

    public void setStudentEnterScore(Integer studentEnterScore) {
        this.studentEnterScore = studentEnterScore;
    }

    public String getStudentPoliticalStatus() {
        return studentPoliticalStatus;
    }

    public void setStudentPoliticalStatus(String studentPoliticalStatus) {
        this.studentPoliticalStatus = studentPoliticalStatus;
    }

    public String getStudentHomeplace() {
        return studentHomeplace;
    }

    public void setStudentHomeplace(String studentHomeplace) {
        this.studentHomeplace = studentHomeplace;
    }
}
