package duoy.cn.eventbustesg;

import junit.framework.Test;

/**
 * Created by Dream on 2016/5/25.
 */
public class TestEvent {

    private String num;

    public TestEvent(String num){
        this.num = num;
    }

    public void setNum(String num){
        this.num = num;
    }

    public String getNum(){
        return num;
    }

}
