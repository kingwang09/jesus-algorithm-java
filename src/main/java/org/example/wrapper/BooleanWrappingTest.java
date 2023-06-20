package org.example.wrapper;

public class BooleanWrappingTest {
    public static void main(String[] args) {

        SampleTest sampleTest1 = new SampleTest(false);
        System.out.println("isFollow(var)="+sampleTest1.isFollow+", findIsFollow="+sampleTest1.findIsFollow());
        SampleTest sampleTest2 = new SampleTest(true);
        System.out.println("isFollow(var)="+sampleTest2.isFollow+", findIsFollow="+sampleTest2.findIsFollow());
    }
}

class SampleTest{
    boolean isFollow;
    SampleTest(boolean isFollow){
        this.isFollow = isFollow;
    }

    public Boolean findIsFollow(){
        return this.isFollow;
    }

    public boolean isFollow(){
        return this.isFollow;
    }
}
