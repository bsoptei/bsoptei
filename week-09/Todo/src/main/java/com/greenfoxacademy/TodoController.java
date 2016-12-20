package com.greenfoxacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Söp on 2016.12.20..
 */
@Controller
@RequestMapping("todo")
public class TodoController {

    @RequestMapping(value="/")
    public String listTodo(Model model){
        return "";
    }

    @RequestMapping(value="/list")
    public String listTodo2(@RequestParam(name="listActive", defaultValue = "false") boolean listActive, Model model){
        TodoService myTodoService = new TodoService();
        model.addAttribute("listActive", listActive);
        model.addAttribute("todos",myTodoService.getTodos());
        return "todo/listTodos";
    }
}
