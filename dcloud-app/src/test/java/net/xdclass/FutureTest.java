package net.xdclass;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Slf4j
public class FutureTest {



    @Test
    public void testFuture() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            return "小滴课堂-学习海量数据项目大课";
        });

        //轮训获取结果
        while (true){
            if(future.isDone()){
                System.out.println(future.get());
                break;
            }
        }

    }


    @Test
    public void testFuture1() throws ExecutionException, InterruptedException, TimeoutException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
            }

            return "二当家小D";
        });

        System.out.println("future:"+future.get(1,TimeUnit.SECONDS));

    }


    @Test
    public void testFuture3() throws ExecutionException, InterruptedException, TimeoutException {

        //有返回值,默认使用ForkJoinPool.commonPool() 作为它的线程池执行异步代码
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
            System.out.println( Thread.currentThread().getName()+ "执行任务一");
            return "冰冰一,";
        });

        //有返回值,当前任务正常完成以后执行，当前任务的执行的结果会作为下一任务的输入参数
        CompletableFuture<String> future2 = future1.thenApply((element) -> {
            System.out.println("入参："+element);
            System.out.println("执行任务二");
            return "冰冰二";
        });

        System.out.println("future2返回值:" + future2.get(1, TimeUnit.SECONDS));

    }




    @Test
    public void testFuture4() throws ExecutionException, InterruptedException, TimeoutException {

        //有返回值,默认使用ForkJoinPool.commonPool() 作为它的线程池执行异步代码
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
            System.out.println("执行任务一");
            return "冰冰一,";
        });

        //无返回值,当前任务正常完成以后执行,当前任务的执行结果可以作为下一任务的输入参数
        CompletableFuture<Void> future2 = future1.thenAccept((element) -> {
            System.out.println("入参："+element);
            System.out.println("执行任务二");

        });

        System.out.println("future2返回值:" + future2.get());

    }






}
