package org.example;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setHeader("naliuyume","line");
        response.getWriter().write("<h1>liuyu ai pyj<h1>");
    }
}
