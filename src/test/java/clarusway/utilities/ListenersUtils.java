package clarusway.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersUtils implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + ": testi başladı " );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + ": testi basarılı bir sekilde bitirildi. " );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + ": testi kaldi! " );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + ": testi atlandi!! " );
    }

//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//
//    }
//
//    @Override
//    public void onTestFailedWithTimeout(ITestResult result) {
//
//    }

    @Override
    public void onStart(ITestContext context) {
      //  System.out.println(result.getName() + ": testi başladı " );// KULLANILMAZ
        System.out.println( " testi başladı "+context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println( " testi bitti "+context.getEndDate());
    }
}
