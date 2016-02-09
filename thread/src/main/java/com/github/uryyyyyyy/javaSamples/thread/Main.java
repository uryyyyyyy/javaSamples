package com.github.uryyyyyyy.javaSamples.thread;

import java.util.concurrent.*;

public class Main {

	public static void main(String args[]) throws ExecutionException, InterruptedException {

		showActiveThread();
		ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		showActiveThread();

		hello(service);
		showActiveThread();

		int res = hello2(service).get();
		System.out.println(res);

		hello3(service);

		showActiveThread();
		service.shutdown();
		showActiveThread();
	}

	private static void showActiveThread() {
		System.out.println("Thread num: " + Thread.activeCount());
	}

	private static void hello3(ScheduledExecutorService service) {
		service.scheduleWithFixedDelay(new Runnable() {
			public void run() {
				System.out.println("Thread:" + Thread.currentThread().getId());
			}
		}, 0, 1, TimeUnit.SECONDS);
		sleep(5000);
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void hello(ScheduledExecutorService service) {
		ScheduledFuture<?> future = service.schedule(new Runnable() {
			public void run() {
				System.out.println("Thread:" + Thread.currentThread().getId());
				sleep(1000);
			}
		}, 1, TimeUnit.SECONDS);
	}

	private static ScheduledFuture<Integer> hello2(ScheduledExecutorService service) {
		return service.schedule(new Callable<Integer>() {
			public Integer call() throws Exception {
				System.out.println("Thread:" + Thread.currentThread().getId());
				return 5;
			}
		}, 1, TimeUnit.SECONDS);
	}
}
