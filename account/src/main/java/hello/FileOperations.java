package hello;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class FileOperations {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

   /* @RequestMapping("/gre")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/gr/{name}")
    public Greeting greeting2(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }*/

    private String content;
    @RequestMapping(path = "/files", method = {RequestMethod.POST})
    public String zapis(@RequestParam(value = "lineToSave") String lineToSave) throws IOException{
        content = lineToSave;
        File file = new File("test.txt");
        Writer writer = new FileWriter(file, true);
        writer.write(System.lineSeparator() + lineToSave);
        writer.flush();
        return "zapisano";
    }


    @RequestMapping(path = "/files", method = {RequestMethod.GET})
    public String odczyt () throws IOException {
        File file = new File("test.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String allTXT = "";
        String line ;
        while ((line = reader.readLine())!=null){
            allTXT+=line+System.lineSeparator();
        }
        return allTXT;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");


        try (Writer writer = new FileWriter(file);

             BufferedReader reader = new BufferedReader(new FileReader(file))) {
            writer.write(System.lineSeparator() + "Stringi22");
            writer.flush();
            System.out.println(reader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


}