package edu.escuelaing.arsw.ASE.app;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = { "edu.escuelaing.arsw.ASE.app" })
public class WebSiteController {
    @Resource
    private HttpServletRequest request;

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
    }

    /**
     * Asignacion del nombre
     * 
     * @param nombre nombre a setear
     * 
     * @return String.format("Welcome %s!", name) String con el nombre
     */
    @GetMapping("/setname")
    public String setName(@RequestParam(value = "name", defaultValue = "Anónimo") String name) {
        System.out.println(name);
        request.getSession().setAttribute("name", name);
        return String.format("Welcome %s!", name);
    }

    /**
     * Metodo que muestra el id de la session
     */
    public void sessionManagement() {
        System.out.println(request.getSession(true).getId());
    }

    /**
     * Obtencion del nombre
     * 
     * @return String nombre del usuario
     */
    @GetMapping("/getname")
    public String getName() {
        String username = (String) request.getSession().getAttribute("name");
        return "{\"name\":\"" + username + "\",\n";
    }
}
