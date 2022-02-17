package com.riyaz.helloworld.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TodoResource {

	@Autowired
	TodoHardcodedService todoHardcodedService;
	
	@GetMapping("/users/{name}/todos")
	public List<Todo> getAllTodos(@PathVariable String name)
	{
		return todoHardcodedService.findAll();
	}
	
	@GetMapping("/users/{name}/todos/{id}")
	public Todo getTodo(@PathVariable String name,@PathVariable long id)
	{
		return todoHardcodedService.findById(id);
	}
	
	@DeleteMapping("/users/{username}/todo/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable long id)
	{
		Todo todo=todoHardcodedService.deleteById(id);
		if(todo !=null)
		{
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable long id,@RequestBody Todo todo)
	{
		Todo updatedTodo= todoHardcodedService.save(todo);
		return new ResponseEntity<Todo>(updatedTodo,HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Todo> saveTodo(@PathVariable String username,@RequestBody Todo todo)
	{
		Todo createdTodo= todoHardcodedService.save(todo);
	URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
