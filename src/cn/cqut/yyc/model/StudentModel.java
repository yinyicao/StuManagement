package cn.cqut.yyc.model;

/**
 * @ClassName StudentModel
 * @Description 与数据库中的视图对应
 * @Author yinyicao
 * @DateTime 2019/1/4 10:09
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class StudentModel {
    private String studentId;
    private String studentName;
    private Integer studentAge;
    private String studentGender;
    /**
     * 学院
     */
    private String studentInstitute;
    /**
     * 学院描述
     */
    private String studentInstitureExplain;
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

    public StudentModel() {
        super();
    }


    public StudentModel(String studentId, String studentName, Integer studentAge, String studentGender, String studentInstitute, String studentInstitureExplain, Integer studentEnterScore, String studentPoliticalStatus, String studentHomeplace) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.studentInstitute = studentInstitute;
        this.studentInstitureExplain = studentInstitureExplain;
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

    public String getStudentInstitute() {
        return studentInstitute;
    }

    public void setStudentInstitute(String studentInstitute) {
        this.studentInstitute = studentInstitute;
    }

    public String getStudentInstitureExplain() {
        return studentInstitureExplain;
    }

    public void setStudentInstitureExplain(String studentInstitureExplain) {
        this.studentInstitureExplain = studentInstitureExplain;
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

    @Override
    public String toString() {
        return "StudentModel{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", studentGender='" + studentGender + '\'' +
                ", studentInstitute='" + studentInstitute + '\'' +
                ", studentInstitureExplain='" + studentInstitureExplain + '\'' +
                ", studentEnterScore=" + studentEnterScore +
                ", studentPoliticalStatus='" + studentPoliticalStatus + '\'' +
                ", studentHomeplace='" + studentHomeplace + '\'' +
                '}';
    }
}
