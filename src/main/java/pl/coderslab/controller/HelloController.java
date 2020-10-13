package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping(produces = "text/html; charset=UTF-8")
public class HelloController {
    @Value("classpath:Workers.txt")
    Resource resourceFile;

    @GetMapping("/workers")
    public String workersAction(Model model) throws IOException {
        Random random = new Random();
        int number = random.nextInt(31) + 1;
        String numberStr = Integer.toString(number);

        if (number < 10){
            numberStr = "0" + numberStr;
        }

        String finalNumberStr = numberStr;

//        Resource resourceFile = new ClassPathResource("Workers.txt");
//        InputStream input = resource.getInputStream();
        File file = resourceFile.getFile();

        Stream<String> lines = Files.lines(Paths.get(file.getPath()));

        String worker = lines.filter(e -> e.contains(String.valueOf(finalNumberStr)))
                .collect(Collectors.joining());

        if (!worker.isEmpty()){
            model.addAttribute("workerByID", worker + " Random number= " + number);
        } else {
            model.addAttribute("workerByID","Nie ma pracownika z id " + numberStr);
        }

        return "workers";
    }
}
