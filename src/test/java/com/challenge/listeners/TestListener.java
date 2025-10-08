package com.challenge.listeners;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class TestListener extends RunListener {
    @Override public void testStarted(Description description) {
        System.out.println("\n-------------------------------");
        System.out.println("🚀 TEST STARTED: " + description.getMethodName());
        System.out.println("-------------------------------");
    }
    @Override public void testFinished(Description description) {
        System.out.println("-------------------------------");
        System.out.println("✅ TEST PASSED: " + description.getMethodName());
        System.out.println("-------------------------------\n");
    }
    @Override public void testFailure(org.junit.runner.notification.Failure failure) {
        System.out.println("-------------------------------");
        System.out.println("❌ TEST FAILED: " + failure.getDescription().getMethodName());
        System.out.println("Reason: " + failure.getMessage());
        System.out.println("-------------------------------\n");
    }
    @Override public void testRunFinished(Result result) {
        System.out.println("\n======================================");
        System.out.println("TOTAL: " + result.getRunCount());
        System.out.println("PASSED: " + (result.getRunCount() - result.getFailureCount()));
        System.out.println("FAILED: " + result.getFailureCount());
        System.out.println("======================================\n");
    }
}
