package com.greenfoxacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Söp on 2016.12.20..
 */
@Controller
@RequestMapping("todo")
public class TodoController {
    TodoService myTodoService = new TodoService();

    @RequestMapping(value={"/list",""})
    public String listTodo(@RequestParam(name="listActive", defaultValue = "false") boolean listActive, Model model){
        model.addAttribute("listActive", listActive);
        model.addAttribute("todos",myTodoService.getTodos());
        return "todo/listTodos";
    }

    @RequestMapping(value="/details/{id}")
    public String showDetails(@PathVariable("id") int id, Model model){
        model.addAttribute("currentTodo", myTodoService.getTodoById(id));
        return "todo/showDetails";
    }
}
