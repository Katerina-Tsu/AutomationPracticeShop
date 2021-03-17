package tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("---------------STARTING TEST %s ---------------");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("---------------FINISHED TEST %%s DURATION: %%ss ---------------" + getExecutionTime(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("---------------FAILED TEST %s DURATION: %ss ---------------" + getExecutionTime(iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(String.format("---------------SKIPPING TEST %s ---------------"));
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }


}
