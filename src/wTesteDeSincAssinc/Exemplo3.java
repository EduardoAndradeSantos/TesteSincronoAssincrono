package wTesteDeSincAssinc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exemplo3 {

   private static final ExecutorService pool = Executors.newFixedThreadPool(4);

   public static Callable<String> getData(final int index, final int time) {
       return new Callable<String>() {
           @Override
           public String call() throws Exception {
               Thread.sleep(time);
               System.out.println("TESTE-" + index);
               return "TESTE-" + index;
           }
       };
   }

   public static void main(String[] args) throws InterruptedException,
   ExecutionException {
       System.out.println("Processors = " + Runtime.getRuntime()
       .availableProcessors());
       long start = System.nanoTime();
       Callable<String> c1 = getData(0, 3000);
       Callable<String> c2 = getData(1, 5000);
       Callable<String> c3 = getData(2, 4000);
       Callable<String> c4 = getData(3, 6000);
       Future<String> f1 = pool.submit(c1);
       Future<String> f2 = pool.submit(c2);
       Future<String> f3 = pool.submit(c3);
       Future<String> f4 = pool.submit(c4);
//       System.out.println(f1.get());
//       System.out.println(f2.get());
//       System.out.println(f3.get());
//       System.out.println(f4.get());
       long end = System.nanoTime();
//       System.out.println("Tempo decorrido (segundos) = "
//       + ((end - start)/1.0E9));
       pool.shutdown();
   }
}