package com.example.myquiz3;

public class QndA {
    private String que;
    private String ans1;
    private String ans2;
    private String ans3;
    private String corrans;

    public QndA(String que, String ans1, String ans2, String ans3, String corrans)
    {
        this.que = que;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.corrans = corrans;
    }

    public void SetQue()
    {
        this.que = que;
    }

    public String GetQue()
    {
        return que;
    }
    public String GetAns1()
    {
        return ans1;
    }
    public void SetAns1()
    {
        this.ans1 = ans1;
    }
    public String GetAns2()
    {
        return ans2;
    }
    public void SetAns2()
    {
        this.ans2 = ans2;
    }
    public String GetAns3()
    {
        return ans3;
    }
    public void SetAns3()
    {
        this.ans3 = ans3;
    }
    public String GetCorrans()
    {
        return corrans;
    }
    public void SetCorrans()
    {
        this.corrans = corrans;
    }

}
