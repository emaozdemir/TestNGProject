package clarusway.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersUtils implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + ": testi başladı " );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + ": testi basarılı bir sekilde bitirildi. " );
        ExtentReportUtils.createTestReport(result.getName(),result.getName()+".test basarılı bir sekilde geçtii");
        ExtentReportUtils.passAndCaptureScreenshot(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + ": testi kaldi! " );
        ExtentReportUtils.createTestReport(result.getName(),result.getName()+".testi fail oldu!");
        ExtentReportUtils.failAndCaptureScreenshot(result.getName());
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
        ExtentReportUtils.flush();
    }

    // Otomatik olarak Başarısız Test Senaryolarını bir kez daha yeniden çalıştırır
// IRetryAnalyzer Yöntemi Uygulanmıştır
// BU yöntem, BAŞARISIZ TEST SENARYOLARINI YENİDEN ÇALIŞTIRMAK İÇİN OTOMATİK OLARAK ÇAĞRILACAKTIR
    private int retryCount = 0;
    private static final int maxRetryCount = 0; // YENİDEN ÇALIŞTIRMA SAYISI
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    // IAnnotationTransformer yöntemi eklenmiştir
// Bu, başarısız test senaryolarını otomatik olarak testng xml dosyalarını kullanarak yeniden çalıştırır
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(ListenersUtils.class);
    }
}
