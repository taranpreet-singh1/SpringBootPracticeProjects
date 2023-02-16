package com.taran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController//Means any method within this class that has any annotation like get put etc will be exposed as Rest endpoints
@RequestMapping("api/v1/customers")
public class Main {
    public static void main(String[] args){

        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return List.of();
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ){

    }


    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        CustomerRepository.save(customer);
    }

    public void deleteCustomer(@PathVariable("customerId") Integer id){
        CustomerRepository.deleteById(id);
    }


    @GetMapping("/")
    public GreetResponse greet(){
        GreetResponse response =  new GreetResponse("Hello", List.of("Java", "Golang", "JavaScript"), new Person("Alex",28,30000.0 ));
        return response;
    }

    record Person (String name, int age, double savings){

    }
     record GreetResponse(String greet,
                          List<String> favProgrammingLanguages,
                          Person person
     ){}


    //Below class is same as the above mentioned code
//    class GreetResponse{
//      private final String greet;
//
//
//      GreetResponse(String greet){
//          this.greet = greet;
//      }
//
//      public String getGreet(){
//          return greet;
//      }
//
//      @Override
//      public String toString(){
//          return "GreetResponse{" + "greet='" + greet + '\'' + '}';
//      }
//
//
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(greet);
//        }
//    }
}
