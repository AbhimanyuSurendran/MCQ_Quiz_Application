package abhimanyu.surendran.mcqquizapplication;

public class QuestionActivity {
    String Questions;
    String oA;
    String oB;
    String oC;
    String oD;
    String ans;

    public QuestionActivity(String questions, String oA, String oB, String oC, String oD, String ans) {
        Questions = questions;
        this.oA = oA;
        this.oB = oB;
        this.oC = oC;
        this.oD = oD;
        this.ans = ans;
    }

    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String questions) {
        Questions = questions;
    }

    public String getoA() {
        return oA;
    }

    public void setoA(String oA) {
        this.oA = oA;
    }

    public String getoB() {
        return oB;
    }

    public void setoB(String oB) {
        this.oB = oB;
    }

    public String getOC() {
        return oC;
    }

    public void setOc(String oc) {
        this.oC = oc;
    }

    public String getoD() {
        return oD;
    }

    public void setoD(String oD) {
        this.oD = oD;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
