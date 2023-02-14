package com.taran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@SpringBootApplication
@RestController //Means any method within this class that has any annotation like get put etc will be exposed as Rest endpoints
public class Main {
    public static void main(String[] args){

        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public GreetResponse greet(){
        return new GreetResponse("Hello");
    }

    //record GreetResponse(String greet){}


    //Below class is same as the above mentioned code
    class GreetResponse{
      private final String greet;

      GreetResponse(String greet){
          this.greet = greet;
      }

      public String getGreet(){
          return greet;
      }

      @Override
      public String toString(){
          return "GreetResponse{" + "greet='" + greet + '\'' + '}';
      }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GreetResponse that = (GreetResponse) o;
            return Objects.equals(greet, that.greet);
        }

        @Override
        public int hashCode() {
            return Objects.hash(greet);
        }
    }
}
